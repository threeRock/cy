package io.jianxun.web.dto;

import java.util.List;

import com.google.common.collect.Lists;

import io.jianxun.extend.domain.business.Depart;

public class DepartTree extends BaseTree {

	private String url = "depart/page";
	private String divid = "#depart-page-layout";

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url + "/" + this.getId();
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the divid
	 */
	public String getDivid() {
		return divid;
	}

	/**
	 * @param divid
	 *            the divid to set
	 */
	public void setDivid(String divid) {
		this.divid = divid;
	}

	public static List<DepartTree> getDepartTree(List<Depart> departs) {
		return convertEntityToDepartTree(departs);
	}

	private static List<DepartTree> convertEntityToDepartTree(List<Depart> list) {
		List<DepartTree> tree = Lists.newArrayList();
		for (Depart depart : list) {
			DepartTree d = new DepartTree();
			d.setId(depart.getId());
			if (depart.getParent() != null)
				d.setpId(depart.getParent().getId());
			d.setName(depart.getName());
			tree.add(d);
		}
		return tree;
	}

}
