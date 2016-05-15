package cn.com.jrr.lease.model;

public class PageImageModel {
	private Integer currentItem;
	private Integer pageSize;
	private Integer i_product;
	public Integer getCurrentItem() {
		return currentItem;
	}
	public void setCurrentItem(Integer currentItem) {
		this.currentItem = currentItem;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getI_product() {
		return i_product;
	}
	public void setI_product(Integer i_product) {
		this.i_product = i_product;
	}
	public PageImageModel(Integer currentItem, Integer pageSize, Integer i_product) {
		super();
		this.currentItem = currentItem;
		this.pageSize = pageSize;
		this.i_product = i_product;
	}
	public PageImageModel() {
		// TODO Auto-generated constructor stub
	}
}
