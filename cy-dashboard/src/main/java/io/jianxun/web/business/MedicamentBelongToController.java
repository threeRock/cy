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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.BelongTo;
import io.jianxun.extend.domain.business.MedicamentBelongTo;
import io.jianxun.extend.service.business.MedicamentBelongToPredicates;
import io.jianxun.extend.service.business.MedicamentBelongToService;
import io.jianxun.web.dto.ReturnDto;
import io.jianxun.web.utils.Utils;

@Controller
@RequestMapping("medicament/")
public class MedicamentBelongToController {

	@RequestMapping(value = { "hotsail/page" })
	@PreAuthorize("hasAuthority('MEDICAMENT_HOTSAILLIST')")
	String hotsailPage(Model model, @QuerydslPredicate(root = MedicamentBelongTo.class) Predicate predicate,
			@PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam MultiValueMap<String, String> parameters) {
		Page<MedicamentBelongTo> page = medicamentBelongToService.findActivePage(ExpressionUtils
				.and(MedicamentBelongToPredicates.belongToPredicate(BelongTo.HOTSAIL.getName()), predicate), pageable);
		util.addPageInfo(model, parameters, page);
		util.addSearchInfo(model, parameters);
		return templatePrefix() + "hotsail/" + Utils.PAGE_TEMPLATE_SUFFIX;
	}

	/**
	 * 设置页面
	 */
	@GetMapping("hotsail/create")
	@PreAuthorize("hasAuthority('MEDICAMENT_HOTSAILCREATE')")
	String hotsailCreateForm(Model model, @RequestParam MultiValueMap<String, String> parameters) {
		model.addAttribute("dto", new MedicamentBelongTo());
		return templatePrefix() + "hotsail/" + Utils.SAVE_TEMPLATE_SUFFIX;
	}

	/**
	 * 新增保存
	 * 
	 * @param depart
	 * @param parameters
	 * @return
	 */
	@PostMapping("hotsail/create")
	@PreAuthorize("hasAuthority('MEDICAMENT_CATEGORYCREATE')")
	@ResponseBody
	ReturnDto hotsailCreateSave(@Valid MedicamentBelongTo medicamentBelongTo,
			@RequestParam MultiValueMap<String, String> parameters) {
		this.medicamentBelongToService.hotsail(medicamentBelongTo);
		return ReturnDto.ok("热销药品添加成功", false, "medicamenthotsail-page");
	}

	@RequestMapping(value = { "recommend/page" })
	@PreAuthorize("hasAuthority('MEDICAMENT_RECOMMENDATIONLIST')")
	String recommendationPage(Model model, @QuerydslPredicate(root = MedicamentBelongTo.class) Predicate predicate,
			@PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam MultiValueMap<String, String> parameters) {
		Page<MedicamentBelongTo> page = medicamentBelongToService.findActivePage(ExpressionUtils
				.and(MedicamentBelongToPredicates.belongToPredicate(BelongTo.RECOMMENDATION.getName()), predicate),
				pageable);
		util.addPageInfo(model, parameters, page);
		util.addSearchInfo(model, parameters);
		return templatePrefix() + "recommendation/" + Utils.PAGE_TEMPLATE_SUFFIX;
	}

	/**
	 * 设置页面
	 */
	@GetMapping("recommend/create")
	@PreAuthorize("hasAuthority('MEDICAMENT_RECOMMENDATIONCREATE')")
	String recommendationCreateForm(Model model, @RequestParam MultiValueMap<String, String> parameters) {
		model.addAttribute("dto", new MedicamentBelongTo());
		return templatePrefix() + "recommendation/" + Utils.SAVE_TEMPLATE_SUFFIX;
	}

	/**
	 * 新增保存
	 * 
	 * @param depart
	 * @param parameters
	 * @return
	 */
	@PostMapping("recommend/create")
	@PreAuthorize("hasAuthority('MEDICAMENT_RECOMMENDATIONCREATE')")
	@ResponseBody
	ReturnDto recommendationCreateSave(@Valid MedicamentBelongTo medicamentBelongTo,
			@RequestParam MultiValueMap<String, String> parameters) {
		this.medicamentBelongToService.recommendation(medicamentBelongTo);
		return ReturnDto.ok("推荐药品添加成功", false, "medicamentrecommend-page");
	}

	@PostMapping({ "remove/{id}", "recommend/{id}" })
	@PreAuthorize("hasAnyAuthority('MEDICAMENT_HOTSAILREMOVE','MEDICAMENT_RECOMMENDATIONREMOVE')")
	@ResponseBody
	public ReturnDto remove(@PathVariable("id") Long id) {
		medicamentBelongToService.delete(id);
		return ReturnDto.ok("取消成功!");
	}

	private String templatePrefix() {
		return "medicament/";
	}

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MedicamentBelongToService medicamentBelongToService;

	@Autowired
	private Utils util;

}
