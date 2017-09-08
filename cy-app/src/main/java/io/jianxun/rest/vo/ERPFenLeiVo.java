package io.jianxun.rest.vo;

import java.util.List;

import com.google.common.collect.Lists;

import io.jianxun.source.domain.ERPFenLei;

public class ERPFenLeiVo {

	private String id;
	private String name;
	private String parentId = "0";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public static List<ERPFenLeiVo> builder(List<ERPFenLei> fenleis) {
		List<ERPFenLeiVo> results = Lists.newArrayList();
		for (ERPFenLei fenlei : fenleis) {
			ERPFenLeiVo vo = new ERPFenLeiVo();
			vo.setId(fenlei.getTid().trim());
			vo.setName(fenlei.getTname().trim());
			if (fenlei.getTfatherid() != null)
				vo.setParentId(fenlei.getTfatherid().trim());
			results.add(vo);
		}
		return results;
	}

}
