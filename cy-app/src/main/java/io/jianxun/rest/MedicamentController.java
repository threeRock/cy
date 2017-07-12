package io.jianxun.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.Medicament;
import io.jianxun.extend.service.business.MedicamentBelongToService;
import io.jianxun.extend.service.business.MedicamentPredicates;
import io.jianxun.extend.service.business.MedicamentService;
import io.jianxun.extend.service.business.StorageService;
import io.jianxun.rest.vo.ERPMedicamentVo;
import io.jianxun.rest.vo.PageReturnVo;
import io.jianxun.rest.vo.PiCiShLVo;
import io.jianxun.source.domain.ERPHwsp;
import io.jianxun.source.domain.ERPMchk;
import io.jianxun.source.domain.ERPMedicament;
import io.jianxun.source.domain.ERPSphwph;
import io.jianxun.source.repository.ERPHwspPredicates;
import io.jianxun.source.repository.ERPHwspRepository;
import io.jianxun.source.repository.ERPMchkPredicates;
import io.jianxun.source.repository.ERPMchkRepository;
import io.jianxun.source.repository.ERPMedicamentRepository;
import io.jianxun.source.repository.ERPSphwphPredicates;
import io.jianxun.source.repository.ERPSphwphRepository;

@RestController
public class MedicamentController extends BaseRestController {

	// 药品列表
	@GetMapping("medics")
	public PageReturnVo<List<ERPMedicamentVo>> getMedicament(
			@PageableDefault(value = 20, sort = { "id.spid" }, direction = Sort.Direction.ASC) Pageable pageable) {
		Page<ERPMedicament> medicaments = medicamentRepository.findAll(pageable);
		List<ERPMedicamentVo> content = ERPMedicamentVo.toVo(medicaments.getContent());
		// 获取图片
		getPic(content);
		// 获取库存
		getStore(content);
		return (PageReturnVo<List<ERPMedicamentVo>>) PageReturnVo.builder(medicaments, content);

	}

	private void getStore(List<ERPMedicamentVo> content) {
		for (ERPMedicamentVo erpMedicament : content) {
			BigDecimal shl = BigDecimal.ZERO;
			Iterable<ERPHwsp> sps = erpHwspRepository
					.findAll(ERPHwspPredicates.erpSpidPredicate(erpMedicament.getId()));
			for (ERPHwsp erpHwsp : sps) {
				if (erpHwsp.getHwshl() != null)
					shl = shl.add(erpHwsp.getHwshl());
			}
			erpMedicament.setHwshl(shl);

			Iterable<ERPSphwph> sphwphs = erpSphwphRepository
					.findAll(ERPSphwphPredicates.erpSpidPredicate(erpMedicament.getId()));
			for (ERPSphwph erpSphwph : sphwphs) {
				PiCiShLVo pisl = new PiCiShLVo(erpSphwph.getPihao2(), erpSphwph.getShl());
				erpMedicament.getPcshls().add(pisl);
			}

		}
	}

	private void getPic(List<ERPMedicamentVo> content) {
		for (ERPMedicamentVo erpMedicament : content) {
			Medicament medicament = medicamentService
					.findActiveOne(MedicamentPredicates.erpSpidPredicate(erpMedicament.getId()));
			if (medicament != null) {
				erpMedicament.setPic(medicament.getMainPic());
				erpMedicament.setPics(medicament.getPics());
			}

		}

	}

	// 热销药列表
	@GetMapping("sellWells")
	public PageReturnVo<List<ERPMedicamentVo>> getSellWells(
			@PageableDefault(value = 20, sort = { "spid" }, direction = Sort.Direction.ASC) Pageable pageable) {
		Page<ERPMedicament> medicaments = medicamentBelongToService.getSellwells(pageable);
		List<ERPMedicamentVo> content = ERPMedicamentVo.toVo(medicaments.getContent());
		getPic(content);
		return (PageReturnVo<List<ERPMedicamentVo>>) PageReturnVo.builder(medicaments, content);
	}

	// 推荐药列表
	@GetMapping("recommends")
	public PageReturnVo<List<ERPMedicamentVo>> getRecommendations(
			@PageableDefault(value = 20, sort = { "spid" }, direction = Sort.Direction.ASC) Pageable pageable) {
		Page<ERPMedicament> medicaments = medicamentBelongToService.getRecommendations(pageable);
		List<ERPMedicamentVo> content = ERPMedicamentVo.toVo(medicaments.getContent());
		getPic(content);
		return (PageReturnVo<List<ERPMedicamentVo>>) PageReturnVo.builder(medicaments, content);
	}

	// 药品查询
	@RequestMapping("medic/search")
	PageReturnVo<List<ERPMedicamentVo>> searchMedicament(
			@QuerydslPredicate(root = ERPMedicament.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "id.spid" }, direction = Sort.Direction.ASC) Pageable pageable) {
		Page<ERPMedicament> medicaments = medicamentRepository.findAll(predicate, pageable);
		List<ERPMedicamentVo> content = ERPMedicamentVo.toVo(medicaments.getContent());
		getPic(content);
		return (PageReturnVo<List<ERPMedicamentVo>>) PageReturnVo.builder(medicaments, content);

	}

	// 客戶列表
	@GetMapping("customs")
	PageReturnVo<ERPMchk> custom(
			@PageableDefault(value = 20, sort = { "dwbh" }, direction = Sort.Direction.ASC) Pageable pageable) {
		return PageReturnVo.builder(mchkRepository.findAll(ERPMchkPredicates.isxsPredicate("是"), pageable));

	}

	// 客户查询
	@RequestMapping("custom/search")
	PageReturnVo<ERPMchk> searchCustom(@QuerydslPredicate(root = ERPMchk.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "dwbh" }, direction = Sort.Direction.ASC) Pageable pageable) {
		predicate = ExpressionUtils.and(ERPMchkPredicates.isxsPredicate("是"), predicate);
		return PageReturnVo.builder(mchkRepository.findAll(predicate, pageable));

	}

	@GetMapping("/pic/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@Autowired
	private ERPMedicamentRepository medicamentRepository;

	@Autowired
	private MedicamentService medicamentService;

	@Autowired
	private ERPMchkRepository mchkRepository;

	@Autowired
	private StorageService storageService;

	@Autowired
	private MedicamentBelongToService medicamentBelongToService;

	@Autowired
	private ERPHwspRepository erpHwspRepository;

	@Autowired
	private ERPSphwphRepository erpSphwphRepository;

}
