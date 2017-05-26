package io.jianxun.web.business;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.Medicament;
import io.jianxun.extend.service.BusinessException;
import io.jianxun.extend.service.business.MedicamentCategoryService;
import io.jianxun.extend.service.business.MedicamentPredicates;
import io.jianxun.extend.service.business.MedicamentService;
import io.jianxun.source.domain.ERPMedicament;
import io.jianxun.web.dto.CategorySetDto;
import io.jianxun.web.dto.ReturnDto;
import io.jianxun.web.dto.UploadPicReturnDto;
import io.jianxun.web.dto.ValueLabelDto;
import io.jianxun.web.utils.Utils;

@Controller
@RequestMapping("medicament")
public class MedicamentController {
	/**
	 * 分页列表 支持 查询 分页 及 排序
	 */
	@RequestMapping(value = { "/page/" })
	@PreAuthorize("hasAuthority('MEDICAMENTLIST')")
	String page(Model model, @QuerydslPredicate(root = ERPMedicament.class) Predicate predicate,
			@PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam MultiValueMap<String, String> parameters) {
		Page<Medicament> page = medicamentService.getPage(predicate, pageable);
		util.addPageInfo(model, parameters, page);
		util.addSearchInfo(model, parameters);
		return templatePrefix() + Utils.PAGE_TEMPLATE_SUFFIX;
	}

	@GetMapping("category/set/{spid}")
	@PreAuthorize("hasAuthority('MEDICAMENTCATEGORYSET')")
	String categoryForm(@PathVariable("spid") String spid, Model model) {
		ERPMedicament em = medicamentService.getErpMedicament(spid);
		CategorySetDto dto = new CategorySetDto();
		dto.setErpMedicament(em);
		model.addAttribute("dto", dto);
		model.addAttribute("categories", medicamentCategoryService.findActiveAll(new Sort("name")));
		return templatePrefix() + "categorySet";
	}

	@PostMapping("category/set")
	@PreAuthorize("hasAuthority('MEDICAMENTCATEGORYSET')")
	@ResponseBody
	ReturnDto categorySave(CategorySetDto dto) {
		medicamentService.setCategory(dto.getErpMedicament(), dto.getMedicamentCatetory());
		return ReturnDto.ok("药品类别设置成功", false, "medicament-page");
	}

	@GetMapping("/pic/list/{spid}")
	@PreAuthorize("hasAuthority('MEDICAMENTPICLIST')")
	String piclist(@PathVariable("spid") String spid, Model model) {
		Medicament medicament = medicamentService.findActiveOne(MedicamentPredicates.erpSpidPredicate(spid));
		model.addAttribute("medicament", medicament);
		return templatePrefix() + "pics";
	}

	@GetMapping("/pic/{filename:.+}")
	@PreAuthorize("hasAuthority('MEDICAMENTPICLIST')")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@PostMapping("/pic/remove/{picName}/{spid}")
	@PreAuthorize("hasAuthority('MEDICAMENTPICREMOVE')")
	@ResponseBody
	public ReturnDto removePic(@PathVariable("spid") String spid, @PathVariable("picName") String picName) {
		Medicament medicament = medicamentService.findActiveOne(MedicamentPredicates.erpSpidPredicate(spid));
		if (medicament == null)
			throw new BusinessException("无法获取药品信息");
		List<String> pics = medicament.getPics();
		List<String> newPics = Lists.newArrayList();
		for (String pic : pics) {
			if (StringUtils.equalsIgnoreCase(pic, picName))
				continue;
			newPics.add(pic);
		}
		medicament.setPics(newPics);
		medicamentService.save(medicament);
		return ReturnDto.ok("删除图片成功",false,"m-pic-form-new");
	}

	@PostMapping("pic/upload/{spid}")
	@PreAuthorize("hasAuthority('MEDICAMENTPICCREATE')")
	@ResponseBody
	public UploadPicReturnDto uploadPic(@PathVariable("spid") String spid,
			@RequestParam("file") MultipartFile[] files) {
		Medicament medicament = medicamentService.findActiveOne(MedicamentPredicates.erpSpidPredicate(spid));
		if (medicament == null)
			throw new BusinessException("无法获取药品信息");
		List<String> pics = medicament.getPics();
		for (MultipartFile file : files) {
			pics.add(storageService.store("PIC", file));
		}
		medicament.setPics(pics);
		medicamentService.save(medicament);
		return new UploadPicReturnDto(200, "", pics);
	}

	@RequestMapping(value = "/search")
	@ResponseBody
	public List<ValueLabelDto> search(@RequestParam("term") String name, Model model) {
		if (StringUtils.isBlank(name))
			return Lists.newArrayList();
		List<ERPMedicament> ms = medicamentService.getErpMedicaments(name);
		return getDto(ms);

	}
	
	@GetMapping("/detailform/{spid}")
	@PreAuthorize("hasAuthority('MEDICAMENTDETAIL')")
	String showDetail(@PathVariable("spid") String spid, Model model) {
		Medicament medicament = medicamentService.findActiveOne(MedicamentPredicates.erpSpidPredicate(spid));
		if (medicament == null)
			throw new BusinessException("无法获取药品信息");
		model.addAttribute("medicament", medicament);
		return templatePrefix() + "detail";
	}

	private List<ValueLabelDto> getDto(List<ERPMedicament> ms) {
		List<ValueLabelDto> vls = Lists.newArrayList();
		for (ERPMedicament medicament : ms) {
			ValueLabelDto d = new ValueLabelDto();
			d.setLabel(medicament.toString());
			d.setValue(medicament.getId().getSpid());
			vls.add(d);
		}
		return vls;
	}

	private String templatePrefix() {
		return "medicament/";
	}

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MedicamentService medicamentService;
	@Autowired
	private MedicamentCategoryService medicamentCategoryService;
	@Autowired
	private StorageService storageService;

	@Autowired
	private Utils util;

}
