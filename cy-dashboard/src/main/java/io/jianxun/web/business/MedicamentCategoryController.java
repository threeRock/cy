package io.jianxun.web.business;

import javax.validation.Valid;

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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.MedicamentCatetory;
import io.jianxun.extend.service.LocaleMessageSourceService;
import io.jianxun.extend.service.business.MedicamentCategoryService;
import io.jianxun.web.business.validator.MedicamentCategoryValidator;
import io.jianxun.web.dto.ReturnDto;
import io.jianxun.web.utils.Utils;

@Controller
@RequestMapping("medicament/category")
public class MedicamentCategoryController {

	@InitBinder("medicamentCategory")
	public void initBinder(WebDataBinder webDataBinder) {
		 webDataBinder.addValidators(medicamentCategoryValidator);

	}

	/**
	 * 分页列表 支持 查询 分页 及 排序
	 */
	@RequestMapping(value = { "/page" })
	@PreAuthorize("hasAuthority('MEDICAMENTCATEGORYLIST')")
	String page(Model model, @QuerydslPredicate(root = MedicamentCatetory.class) Predicate predicate,
			@PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam MultiValueMap<String, String> parameters) {
		Page<MedicamentCatetory> page = medicamentCategoryService.findActivePage(predicate, pageable);
		util.addPageInfo(model, parameters, page);
		util.addSearchInfo(model, parameters);
		return templatePrefix() + Utils.PAGE_TEMPLATE_SUFFIX;
	}

	/**
	 * 新增表单页面
	 */
	@GetMapping("create")
	@PreAuthorize("hasAuthority('MEDICAMENTCATEGORYCREATE')")
	String createForm(@PathVariable("parentId") Long parentId, Model model,
			@RequestParam MultiValueMap<String, String> parameters) {
		model.addAttribute("medicamentCategory", new MedicamentCatetory());
		util.addCreateFormAction(model);
		return templatePrefix() + Utils.SAVE_TEMPLATE_SUFFIX;
	}

	/**
	 * 新增保存
	 * 
	 * @param depart
	 * @param parameters
	 * @return
	 */
	@PostMapping("create")
	@PreAuthorize("hasAuthority('MEDICAMENTCATEGORYCREATE')")
	@ResponseBody
	ReturnDto createSave(@Valid MedicamentCatetory medicamentCategory,
			@RequestParam MultiValueMap<String, String> parameters) {
		this.medicamentCategoryService.save(medicamentCategory);
		return ReturnDto.ok(localeMessageSourceService.getMessage("medicamentCategory.save.success"), true,
				"maintype-page");
	}

	/**
	 * 修改角色表单
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/modify/{id}")
	@PreAuthorize("hasAuthority('MEDICAMENTCATEGORYMODIFY')")
	public String modify(@PathVariable("id") Long id, Model model) {
		MedicamentCatetory medicamentCatetory = medicamentCategoryService.findActiveOne(id);
		model.addAttribute("medicamentCatetory", medicamentCatetory);
		util.addModifyFormAction(model);
		return templatePrefix() + "form";

	}

	/**
	 * 修改角色保存
	 * 
	 * @param entity
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/modify")
	@PreAuthorize("hasAuthority('MEDICAMENTCATEGORYMODIFY')")
	@ResponseBody
	public ReturnDto modifySave(
			@Valid @ModelAttribute(name = "medicamentCatetory") MedicamentCatetory medicamentCatetory, Model model) {
		medicamentCategoryService.save(medicamentCatetory);
		return ReturnDto.ok(localeMessageSourceService.getMessage("medicamentCategory.save.success"), true,
				"maintype-page");
	}

	@PostMapping("remove/{id}")
	@PreAuthorize("hasAuthority('MEDICAMENTCATEGORYREMOVE')")
	@ResponseBody
	public ReturnDto remove(@PathVariable("id") Long id) {
		medicamentCategoryService.delete(id);
		return ReturnDto.ok(localeMessageSourceService.getMessage("medicamentCategory.remove.successd"));
	}

	/**
	 * 验证名称是否重复
	 * 
	 * @param username
	 * @param id
	 * @return
	 */
	@RequestMapping("check/nameunique")
	@ResponseBody
	public String checkNameIsUnique(@RequestParam("name") String name, @RequestParam("id") Long id) {
		if (!this.medicamentCategoryService.validateNameUnique(name, id))
			return localeMessageSourceService.getMessage("medicamentCategory.name.isUsed", new Object[] { name });
		return "";
	}

	@ModelAttribute(name = "medicamentCategory")
	public void getMode(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != null && id != -1L) {
			MedicamentCatetory medicamentCategory = medicamentCategoryService.findActiveOne(id);
			if (medicamentCategory != null)
				model.addAttribute("medicamentCategory", medicamentCategory);
		}
	}

	private String templatePrefix() {
		return "medicament/category/";
	}

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MedicamentCategoryService medicamentCategoryService;
	@Autowired
	private LocaleMessageSourceService localeMessageSourceService;

	@Autowired
	private Utils util;

	@Autowired
	private MedicamentCategoryValidator medicamentCategoryValidator;

}
