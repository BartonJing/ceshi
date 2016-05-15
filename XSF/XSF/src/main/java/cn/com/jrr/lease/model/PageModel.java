package cn.com.jrr.lease.model;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class PageModel<T> {

	
	private String sql;
	private List<T> data;
	private Integer pageSize;
	private Integer totalPage;
 	private Integer currentPage;
 	private Integer currentItem;
 	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentItem() {
		return currentItem;
	}
	public void setCurrentItem(Integer currentItem) {
		this.currentItem = currentItem;
	}
}
