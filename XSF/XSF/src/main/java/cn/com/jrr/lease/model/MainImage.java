package cn.com.jrr.lease.model;

import org.springframework.stereotype.Repository;

@Repository
public class MainImage {
	private Integer i_id;
	private String i_image;
	public Integer getI_id() {
		return i_id;
	}
	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}
	public String getI_image() {
		return i_image;
	}
	public void setI_image(String i_image) {
		this.i_image = i_image;
	}
	@Override
	public String toString() {
		return "ProductImage [i_id=" + i_id + ", i_image=" + i_image + "]";
	}
	public MainImage(Integer i_id, String i_image) {
		super();
		this.i_id = i_id;
		this.i_image = i_image;
	}
	public MainImage() {
		// TODO Auto-generated constructor stub
	}
}
