package io.jianxun.source.domain;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 药品基本信息
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "spkfk")
public class ERPMedicament {

	// 商品id
	@EmbeddedId
	private ERPMedicamentKey id;
	private String spbh;
	// 商品资料
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
	// 药品价格
	private BigDecimal pfpj;

	// 分类名称
	private String padfl;

	// 分类id
	private String padflid;
	
	//助记码
	private String zjm;

	/**
	 * @return the id
	 */
	public ERPMedicamentKey getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ERPMedicamentKey id) {
		this.id = id;
	}

	public String getSpbh() {
		return spbh;
	}

	public void setSpbh(String spbh) {
		this.spbh = spbh;
	}

	/**
	 * @return the spmch
	 */
	public String getSpmch() {
		return spmch;
	}

	/**
	 * @param spmch
	 *            the spmch to set
	 */
	public void setSpmch(String spmch) {
		this.spmch = spmch;
	}

	/**
	 * @return the beactive
	 */
	public String getBeactive() {
		return beactive;
	}

	/**
	 * @param beactive
	 *            the beactive to set
	 */
	public void setBeactive(String beactive) {
		this.beactive = beactive;
	}

	/**
	 * @return the shpchd
	 */
	public String getShpchd() {
		return shpchd;
	}

	/**
	 * @param shpchd
	 *            the shpchd to set
	 */
	public void setShpchd(String shpchd) {
		this.shpchd = shpchd;
	}

	/**
	 * @return the dw
	 */
	public String getDw() {
		return dw;
	}

	/**
	 * @param dw
	 *            the dw to set
	 */
	public void setDw(String dw) {
		this.dw = dw;
	}

	/**
	 * @return the shpgg
	 */
	public String getShpgg() {
		return shpgg;
	}

	/**
	 * @param shpgg
	 *            the shpgg to set
	 */
	public void setShpgg(String shpgg) {
		this.shpgg = shpgg;
	}

	/**
	 * @return the pizhwh
	 */
	public String getPizhwh() {
		return pizhwh;
	}

	/**
	 * @param pizhwh
	 *            the pizhwh to set
	 */
	public void setPizhwh(String pizhwh) {
		this.pizhwh = pizhwh;
	}

	/**
	 * @return the jixing
	 */
	public String getJixing() {
		return jixing;
	}

	/**
	 * @param jixing
	 *            the jixing to set
	 */
	public void setJixing(String jixing) {
		this.jixing = jixing;
	}

	/**
	 * @return the leibie
	 */
	public String getLeibie() {
		return leibie;
	}

	/**
	 * @param leibie
	 *            the leibie to set
	 */
	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

	/**
	 * @return the yongyfl
	 */
	public String getYongyfl() {
		return yongyfl;
	}

	/**
	 * @param yongyfl
	 *            the yongyfl to set
	 */
	public void setYongyfl(String yongyfl) {
		this.yongyfl = yongyfl;
	}

	/**
	 * @return the is_jkyp
	 */
	public String getIs_jkyp() {
		return is_jkyp;
	}

	/**
	 * @param is_jkyp
	 *            the is_jkyp to set
	 */
	public void setIs_jkyp(String is_jkyp) {
		this.is_jkyp = is_jkyp;
	}

	/**
	 * @return the zhilbz
	 */
	public String getZhilbz() {
		return zhilbz;
	}

	/**
	 * @param zhilbz
	 *            the zhilbz to set
	 */
	public void setZhilbz(String zhilbz) {
		this.zhilbz = zhilbz;
	}

	/**
	 * @return the jiyao
	 */
	public String getJiyao() {
		return jiyao;
	}

	/**
	 * @param jiyao
	 *            the jiyao to set
	 */
	public void setJiyao(String jiyao) {
		this.jiyao = jiyao;
	}

	/**
	 * @return the zbjg
	 */
	public String getZbjg() {
		return zbjg;
	}

	/**
	 * @param zbjg
	 *            the zbjg to set
	 */
	public void setZbjg(String zbjg) {
		this.zbjg = zbjg;
	}

	/**
	 * @return the zhuzlx
	 */
	public String getZhuzlx() {
		return zhuzlx;
	}

	/**
	 * @param zhuzlx
	 *            the zhuzlx to set
	 */
	public void setZhuzlx(String zhuzlx) {
		this.zhuzlx = zhuzlx;
	}

	/**
	 * @return the jingylb
	 */
	public String getJingylb() {
		return jingylb;
	}

	/**
	 * @param jingylb
	 *            the jingylb to set
	 */
	public void setJingylb(String jingylb) {
		this.jingylb = jingylb;
	}

	/**
	 * @return the khfl
	 */
	public String getKhfl() {
		return khfl;
	}

	/**
	 * @param khfl
	 *            the khfl to set
	 */
	public void setKhfl(String khfl) {
		this.khfl = khfl;
	}

	/**
	 * @return the pfpj
	 */
	public BigDecimal getPfpj() {
		return pfpj;
	}

	/**
	 * @param pfpj
	 *            the pfpj to set
	 */
	public void setPfpj(BigDecimal pfpj) {
		this.pfpj = pfpj;
	}

	public String getPadflid() {
		return padflid;
	}

	public void setPadflid(String padflid) {
		this.padflid = padflid;
	}

	public String getPadfl() {
		return padfl;
	}

	public void setPadfl(String padfl) {
		this.padfl = padfl;
	}

	public String getZjm() {
		return zjm;
	}

	public void setZjm(String zjm) {
		this.zjm = zjm;
	}

	@Override
	public String toString() {
		return "药品信息 [药品名称=" + spmch + "]";
	}

	/**
	 * a.yongyfl as 用药分类, a.is_jkyp as 是否进口药品, a.zhilbz as 质量标准, a.jiyao as
	 * 基药类型, a.zbjg as 中标金额, a.zhuzlx as 主治类型, a.jingylb as 经营类别, a.khfl as
	 * 考核分类, a.pfpj as 批发价, b.gebjj as 成本单价, b.pihao as 批号内码隐, b.pihao2 as 批号,
	 * b.jwh as 架位号, b.shl as 数量, b.sxrq as 有效期, b.hw as 货位id隐, c.hwbh as 货位编号隐,
	 * c.huowname as 货位名隐, '' as 实际数量, '' as 基药价格 from spkfk as a right join
	 * sphwph b on a.spid=b.spid left join huoweizl c on c.hw=b.hw
	 * 
	 * 
	 * 
	 * create view danwei as select dwmch as 单位名,dwbh as 单位编号,ywy as 业务员,jingyfw
	 * as 经营范围,shouhdz as 收货地址,jslx as 结算类型,xshlx as 销售类型,khquyu as 客户区域 from
	 * mchk where isxs='是' 其中 基药的属性 就是基药类型是否有值
	 * 
	 */

}
