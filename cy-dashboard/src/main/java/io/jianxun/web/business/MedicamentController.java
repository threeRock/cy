package io.jianxun.web.business;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.Medicament;
import io.jianxun.extend.service.business.MedicamentCategoryService;
import io.jianxun.extend.service.business.MedicamentService;
import io.jianxun.source.domain.ERPMedicament;
import io.jianxun.web.dto.CategorySetDto;
import io.jianxun.web.dto.ReturnDto;
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

	@RequestMapping(value = "/search")
	@ResponseBody
	public List<ValueLabelDto> search(@RequestParam("term") String name, Model model) {
		if (StringUtils.isBlank(name))
			return Lists.newArrayList();
		List<ERPMedicament> ms = medicamentService.getErpMedicaments(name);
		return getDto(ms);

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
	private Utils util;

}
