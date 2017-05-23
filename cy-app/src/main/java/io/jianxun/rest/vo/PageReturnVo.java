package io.jianxun.rest.vo;

import org.apache.http.HttpStatus;
import org.springframework.data.domain.Page;

public class PageReturnVo<T> extends ReturnVo<T> {

	// 总页数
	private long totalPages = 0L;
	// 总记录数
	private long totalElements = 0L;
	// 当前页
	private int number = 0;
	// 记录数/页
	public int size = 20;

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static <T> PageReturnVo<T> ok(T data) {
		PageReturnVo<T> vo = new PageReturnVo<T>();
		vo.setCode(HttpStatus.SC_OK);
		vo.setSuccess(true);
		vo.setData(data);
		return vo;
	}

	public static <T> PageReturnVo<T> builder(Page<T> page) {
		@SuppressWarnings("unchecked")
		PageReturnVo<T> vo = (PageReturnVo<T>) ok(page.getContent());
		vo.setNumber(page.getNumber());
		vo.setSize(page.getSize());
		vo.setTotalElements(page.getTotalElements());
		vo.setTotalPages(page.getTotalPages());
		return vo;
	}

}
