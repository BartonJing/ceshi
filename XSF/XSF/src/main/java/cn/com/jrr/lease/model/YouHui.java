package cn.com.jrr.lease.model;

import org.springframework.stereotype.Repository;

@Repository
public class YouHui {
	private Integer y_id;
	private String y_discript;
	private float y_price;
	public Integer getY_number1() {
		return y_number1;
	}
	public void setY_number1(Integer y_number1) {
		this.y_number1 = y_number1;
	}
	public Integer getY_number2() {
		return y_number2;
	}
	public void setY_number2(Integer y_number2) {
		this.y_number2 = y_number2;
	}
	private Integer y_number1;
	private Integer y_number2;
	private String y_image;
	private String y_createtime;
	private String y_starttime;
	private String y_endtime;
	private String y_name;
	private String y_state;
	
	public Integer getY_id() {
		return y_id;
	}
	public void setY_id(Integer y_id) {
		this.y_id = y_id;
	}
	public String getY_discript() {
		return y_discript;
	}
	public void setY_discript(String y_discript) {
		this.y_discript = y_discript;
	}
	public float getY_price() {
		return y_price;
	}
	public void setY_price(float y_price) {
		this.y_price = y_price;
	}
	
	public String getY_image() {
		return y_image;
	}
	public void setY_image(String y_image) {
		this.y_image = y_image;
	}
	public String getY_createtime() {
		return y_createtime;
	}
	public void setY_createtime(String y_createtime) {
		this.y_createtime = y_createtime;
	}
	public String getY_starttime() {
		return y_starttime;
	}
	public void setY_starttime(String y_starttime) {
		this.y_starttime = y_starttime;
	}
	public String getY_endtime() {
		return y_endtime;
	}
	public void setY_endtime(String y_endtime) {
		this.y_endtime = y_endtime;
	}
	public YouHui() {
		// TODO Auto-generated constructor stub
	}
	public String getY_name() {
		return y_name;
	}
	public void setY_name(String y_name) {
		this.y_name = y_name;
	}
	public String getY_state() {
		return y_state;
	}
	public void setY_state(String y_state) {
		this.y_state = y_state;
	}
	@Override
	public String toString() {
		return "YouHui [y_id=" + y_id + ", y_discript=" + y_discript + ", y_price=" + y_price + ", y_number1="
				+ y_number1 + ", y_number2=" + y_number2 + ", y_image=" + y_image + ", y_createtime=" + y_createtime
				+ ", y_starttime=" + y_starttime + ", y_endtime=" + y_endtime + ", y_name=" + y_name + ", y_state="
				+ y_state + "]";
	}
	public YouHui(Integer y_id, String y_discript, float y_price, Integer y_number1, Integer y_number2, String y_image,
			String y_createtime, String y_starttime, String y_endtime, String y_name, String y_state) {
		super();
		this.y_id = y_id;
		this.y_discript = y_discript;
		this.y_price = y_price;
		this.y_number1 = y_number1;
		this.y_number2 = y_number2;
		this.y_image = y_image;
		this.y_createtime = y_createtime;
		this.y_starttime = y_starttime;
		this.y_endtime = y_endtime;
		this.y_name = y_name;
		this.y_state = y_state;
	}
	
}
