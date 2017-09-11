package io.jianxun.rest;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.Medicament;
import io.jianxun.extend.service.business.MedicamentBelongToService;
import io.jianxun.extend.service.business.MedicamentPredicates;
import io.jianxun.extend.service.business.MedicamentService;
import io.jianxun.extend.service.business.StorageService;
import io.jianxun.rest.vo.ERPFenLeiVo;
import io.jianxun.rest.vo.ERPMedicamentVo;
import io.jianxun.rest.vo.PageReturnVo;
import io.jianxun.rest.vo.PiCiShLVo;
import io.jianxun.rest.vo.PriceVo;
import io.jianxun.rest.vo.ReturnVo;
import io.jianxun.source.domain.ERPHwsp;
import io.jianxun.source.domain.ERPIpadkc;
import io.jianxun.source.domain.ERPMchk;
import io.jianxun.source.domain.ERPMedicament;
import io.jianxun.source.domain.ERPSpQuyu;
import io.jianxun.source.domain.ERPSphwph;
import io.jianxun.source.repository.ERPFenLeiRepository;
import io.jianxun.source.repository.ERPHwspPredicates;
import io.jianxun.source.repository.ERPHwspRepository;
import io.jianxun.source.repository.ERPIpadkcRepository;
import io.jianxun.source.repository.ERPMchkPredicates;
import io.jianxun.source.repository.ERPMchkRepository;
import io.jianxun.source.repository.ERPMedicamentPredicates;
import io.jianxun.source.repository.ERPMedicamentRepository;
import io.jianxun.source.repository.ERPSpQuyuPredicates;
import io.jianxun.source.repository.ERPSpQuyuRepository;
import io.jianxun.source.repository.ERPSphwphPredicates;
import io.jianxun.source.repository.ERPSphwphRepository;

@RestController
public class MedicamentController extends BaseRestController {

	// 药品列表
	@GetMapping("medics")
	public PageReturnVo<List<ERPMedicamentVo>> getMedicament(
			@PageableDefault(value = 20, sort = { "id.spid" }, direction = Sort.Direction.ASC) Pageable pageable) {
		// Page<ERPMedicament> medicaments =
		// medicamentRepository.findAll(pageable);
		Page<ERPIpadkc> kcPages = ipadkcRepository.findAll(pageable);
		List<ERPMedicament> medicaments = Lists.newArrayList();
		for (ERPIpadkc ip : kcPages) {
			medicaments
					.add(medicamentRepository.findOne(ERPMedicamentPredicates.erpSpidPredicate(ip.getId().getSpid())));
		}
		List<ERPMedicamentVo> content = ERPMedicamentVo.toVo(medicaments);
		// 获取图片
		getPic(content);
		// 获取库存
		getStore(content);
		// 获取价格
		getPrice(content);
		return (PageReturnVo<List<ERPMedicamentVo>>) PageReturnVo.builder(kcPages, content);

	}

	private void getPrice(List<ERPMedicamentVo> content) {
		for (ERPMedicamentVo erpMedicament : content) {
			List<PriceVo> prices = erpMedicament.getPrices();
			BigDecimal pyjg = erpMedicament.getPfpj();
			if (pyjg != null) {
				PriceVo vo = new PriceVo("普药价格", "", pyjg);
				prices.add(vo);
			}
			Iterable<ERPSpQuyu> sps = erpSpQuyuRepository
					.findAll(ERPSpQuyuPredicates.erpSpidPredicate(erpMedicament.getId()));
			for (ERPSpQuyu erpSpQuyu : sps) {
				PriceVo vo = new PriceVo("基药价格", erpSpQuyu.getId().getKhquyu(), erpSpQuyu.getZbjg());
				prices.add(vo);
			}
		}

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
				if (erpSphwph.getShl() != null && BigDecimal.ZERO.compareTo(erpSphwph.getShl()) < 0) {
					PiCiShLVo pisl = new PiCiShLVo(erpSphwph.getPihao2(), erpSphwph.getShl());
					erpMedicament.getPcshls().add(pisl);
				}
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
		// 获取图片
		getPic(content);
		// 获取库存
		getStore(content);
		// 获取价格
		getPrice(content);
		return (PageReturnVo<List<ERPMedicamentVo>>) PageReturnVo.builder(medicaments, content);
	}

	// 推荐药列表
	@GetMapping("recommends")
	public PageReturnVo<List<ERPMedicamentVo>> getRecommendations(
			@PageableDefault(value = 20, sort = { "spid" }, direction = Sort.Direction.ASC) Pageable pageable) {
		Page<ERPMedicament> medicaments = medicamentBelongToService.getRecommendations(pageable);
		List<ERPMedicamentVo> content = ERPMedicamentVo.toVo(medicaments.getContent());
		// 获取图片
		getPic(content);
		// 获取库存
		getStore(content);
		// 获取价格
		getPrice(content);
		return (PageReturnVo<List<ERPMedicamentVo>>) PageReturnVo.builder(medicaments, content);
	}

	// 药品查询
	@RequestMapping("medic/search")
	PageReturnVo<List<ERPMedicamentVo>> searchMedicament(
			@QuerydslPredicate(root = ERPMedicament.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "id.spid" }, direction = Sort.Direction.ASC) Pageable pageable) {
		Page<ERPMedicament> medicaments = medicamentRepository.findAll(predicate, pageable);
		List<ERPMedicamentVo> content = ERPMedicamentVo.toVo(medicaments.getContent());
		// 获取图片
		getPic(content);
		// 获取库存
		getStore(content);
		// 获取价格
		getPrice(content);
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

	// 药品分类查询
	@RequestMapping("category")
	public ReturnVo<List<ERPFenLeiVo>> category() {
		return ReturnVo.ok(ERPFenLeiVo.builder(erpFenLeiRepository.findAll()));
	}

	@RequestMapping("medic/categoryFilter")
	PageReturnVo<List<ERPMedicamentVo>> categoryFilterMedicament(
			@QuerydslPredicate(root = ERPMedicament.class) Predicate predicate, @RequestParam("flid") String flid,
			@PageableDefault(value = 20, sort = { "id.spid" }, direction = Sort.Direction.ASC) Pageable pageable) {
		if (StringUtils.isNotBlank(flid))
			predicate = ExpressionUtils.and(ERPMedicamentPredicates.fenleiPredicate(flid), predicate);
		Page<ERPMedicament> medicaments = medicamentRepository.findAll(predicate, pageable);
		List<ERPMedicamentVo> content = ERPMedicamentVo.toVo(medicaments.getContent());
		// 获取图片
		getPic(content);
		// 获取库存
		getStore(content);
		// 获取价格
		getPrice(content);
		return (PageReturnVo<List<ERPMedicamentVo>>) PageReturnVo.builder(medicaments, content);

	}

	@Autowired
	private ERPMedicamentRepository medicamentRepository;

	@Autowired
	private ERPIpadkcRepository ipadkcRepository;

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

	@Autowired
	private ERPSpQuyuRepository erpSpQuyuRepository;

	@Autowired
	private ERPFenLeiRepository erpFenLeiRepository;

}
