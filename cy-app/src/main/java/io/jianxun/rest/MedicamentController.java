package io.jianxun.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.service.business.MedicamentBelongToService;
import io.jianxun.rest.vo.PageReturnVo;
import io.jianxun.source.domain.ERPMedicament;
import io.jianxun.source.repository.ERPMedicamentRepository;

@RestController
public class MedicamentController extends BaseRestController {

	// 药品列表
	@GetMapping("medics")
	public PageReturnVo<ERPMedicament> getMedicament(
			@PageableDefault(value = 20, sort = { "id.spid" }, direction = Sort.Direction.DESC) Pageable pageable) {
		return PageReturnVo.builder(medicamentRepository.findAll(pageable));

	}

	// 热销药列表
	@GetMapping("sellWells")
	public PageReturnVo<ERPMedicament> getSellWells(
			@PageableDefault(value = 20, sort = { "spid" }, direction = Sort.Direction.DESC) Pageable pageable) {
		return PageReturnVo.builder(medicamentBelongToService.getSellwells(pageable));
	}

	// 推荐药列表
	@GetMapping("recommends")
	public PageReturnVo<ERPMedicament> getRecommendations(
			@PageableDefault(value = 20, sort = { "spid" }, direction = Sort.Direction.DESC) Pageable pageable) {
		return PageReturnVo.builder(medicamentBelongToService.getRecommendations(pageable));
	}

	@RequestMapping("medics/search")
	PageReturnVo<ERPMedicament> searchMedicament(@QuerydslPredicate(root = ERPMedicament.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "id.spid" }, direction = Sort.Direction.DESC) Pageable pageable) {
		return PageReturnVo.builder(medicamentRepository.findAll(predicate,pageable));

	}

	@Autowired
	private ERPMedicamentRepository medicamentRepository;

	@Autowired
	private MedicamentBelongToService medicamentBelongToService;

}
