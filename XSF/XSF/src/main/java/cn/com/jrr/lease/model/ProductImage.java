package cn.com.jrr.lease.model;

import org.springframework.stereotype.Repository;

@Repository
public class ProductImage {
	private Integer i_id;
	private Integer i_product;
	private String i_image;
	public Integer getI_id() {
		return i_id;
	}
	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}
	public Integer getI_product() {
		return i_product;
	}
	public void setI_product(Integer i_product) {
		this.i_product = i_product;
	}
	public String getI_image() {
		return i_image;
	}
	public void setI_image(String i_image) {
		this.i_image = i_image;
	}
	@Override
	public String toString() {
		return "ProductImage [i_id=" + i_id + ", i_product=" + i_product + ", i_image=" + i_image + "]";
	}
	public ProductImage(Integer i_id, Integer i_product, String i_image) {
		super();
		this.i_id = i_id;
		this.i_product = i_product;
		this.i_image = i_image;
	}
	public ProductImage() {
		// TODO Auto-generated constructor stub
	}
}
