package io.jianxun.rest.vo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;

import io.jianxun.source.domain.ERPMedicament;

public class ERPMedicamentVo {

	private String id;

	private String spmch;
	// 是否停用
	private String beactive;
	// 产地
	private String shpchd;

	// 单位
	private String dw;

	// 商品规格
	private String shpgg;

	// 批准文号
	private String pizhwh;

	// 剂型
	private String jixing;

	// 商品类别
	private String leibie;

	// 用药分类
	private String yongyfl;

	// 是否进口药
	private String is_jkyp;

	// 质量标准
	private String zhilbz;

	// 基药类型
	private String jiyao;

	// 中标金额
	private String zbjg;
	// 主治类型
	private String zhuzlx;

	// 经营类别
	private String jingylb;

	// 考核分类
	private String khfl;

	// pfpj
	private BigDecimal pfpj;

	// 图片
	private String pic;

	// 图片列表
	private List<String> pics;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpmch() {
		return spmch;
	}

	public void setSpmch(String spmch) {
		this.spmch = spmch;
	}

	public String getBeactive() {
		return beactive;
	}

	public void setBeactive(String beactive) {
		this.beactive = beactive;
	}

	public String getShpchd() {
		return shpchd;
	}

	public void setShpchd(String shpchd) {
		this.shpchd = shpchd;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getShpgg() {
		return shpgg;
	}

	public void setShpgg(String shpgg) {
		this.shpgg = shpgg;
	}

	public String getPizhwh() {
		return pizhwh;
	}

	public void setPizhwh(String pizhwh) {
		this.pizhwh = pizhwh;
	}

	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	public String getLeibie() {
		return leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

	public String getYongyfl() {
		return yongyfl;
	}

	public void setYongyfl(String yongyfl) {
		this.yongyfl = yongyfl;
	}

	public String getIs_jkyp() {
		return is_jkyp;
	}

	public void setIs_jkyp(String is_jkyp) {
		this.is_jkyp = is_jkyp;
	}

	public String getZhilbz() {
		return zhilbz;
	}

	public void setZhilbz(String zhilbz) {
		this.zhilbz = zhilbz;
	}

	public String getJiyao() {
		return jiyao;
	}

	public void setJiyao(String jiyao) {
		this.jiyao = jiyao;
	}

	public String getZbjg() {
		return zbjg;
	}

	public void setZbjg(String zbjg) {
		this.zbjg = zbjg;
	}

	public String getZhuzlx() {
		return zhuzlx;
	}

	public void setZhuzlx(String zhuzlx) {
		this.zhuzlx = zhuzlx;
	}

	public String getJingylb() {
		return jingylb;
	}

	public void setJingylb(String jingylb) {
		this.jingylb = jingylb;
	}

	public String getKhfl() {
		return khfl;
	}

	public void setKhfl(String khfl) {
		this.khfl = khfl;
	}

	public BigDecimal getPfpj() {
		return pfpj;
	}

	public void setPfpj(BigDecimal pfpj) {
		this.pfpj = pfpj;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public List<String> getPics() {
		return pics;
	}

	public void setPics(List<String> pics) {
		this.pics = pics;
	}

	public static ERPMedicamentVo toVo(ERPMedicament medicament) {
		ERPMedicamentVo vo = new ERPMedicamentVo();
		BeanUtils.copyProperties(medicament, vo);
		vo.setId(medicament.getId().getSpid());
		return vo;
	}

	public static List<ERPMedicamentVo> toVo(List<ERPMedicament> medicaments) {
		List<ERPMedicamentVo> result = Lists.newArrayList();
		for (ERPMedicament medicament : medicaments) {
			result.add(toVo(medicament));
		}
		return result;
	}

}
