package io.jianxun.source.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 药品基本信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "spkfk")
public class ERPMedicament {

	// 商品id
	@Id
	private String spid;
	// 商品编号
	private String spbh;
	// 商品条码
	private String sptm;
	// 商品资料
	private String spmch;
	
	//商品类别
	private String leibie;
	
	/**
	a.spid as 商品id
,a.spmch  as 商品资料,
a.beactive  as 是否停用,
a.shpchd  as 产地,
a.dw as 单位,
a.shpgg as 商品规格,
a.pizhwh  as 批准文号,
a.jixing as 剂型,
a.leibie  as 商品类别,
a.yongyfl  as 用药分类,
a.is_jkyp  as 是否进口药品,
a.zhilbz  as 质量标准,
a.jiyao as 基药类型,
a.zbjg as 中标金额,
a.zhuzlx as 主治类型,
a.jingylb as 经营类别,
a.khfl  as 考核分类,
a.pfpj  as 批发价,
b.gebjj as 成本单价,
b.pihao as 批号内码隐,
b.pihao2 as 批号,
b.jwh  as 架位号,
b.shl as 数量,
b.sxrq as 有效期,
b.hw as 货位id隐,
c.hwbh as 货位编号隐,
c.huowname as 货位名隐,
''  as 实际数量,
'' as 基药价格
 from  spkfk as a 
 right join sphwph b  on a.spid=b.spid
 left join  huoweizl c on c.hw=b.hw 
 
 
 
 create  view danwei
as
select  dwmch as 单位名,dwbh as  单位编号,ywy as 业务员,jingyfw as 经营范围,shouhdz as 收货地址,jslx as 结算类型,xshlx as 销售类型,khquyu as 客户区域  from mchk where isxs='是'
其中  基药的属性 就是基药类型是否有值

*/

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public String getSpbh() {
		return spbh;
	}

	public void setSpbh(String spbh) {
		this.spbh = spbh;
	}

	public String getSptm() {
		return sptm;
	}

	public void setSptm(String sptm) {
		this.sptm = sptm;
	}

	public String getSpmch() {
		return spmch;
	}

	public void setSpmch(String spmch) {
		this.spmch = spmch;
	}

	public String getLeibie() {
		return leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}
	
	

}
