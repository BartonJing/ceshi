package cn.com.jrr.lease.model;

import org.springframework.stereotype.Repository;

@Repository
public class Product {
	private Integer p_id;
	private String p_code;
	private String p_name;
	private double p_price1;
	private double p_price2;
	private double p_price3;
	private Integer p_number1;
	private Integer p_number2;
	private String p_time1;
	private String p_time2;
	private Integer p_type;
	private String p_discript;
	private String p_state;
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public double getP_price1() {
		return p_price1;
	}
	public void setP_price1(double p_price1) {
		this.p_price1 = p_price1;
	}
	public double getP_price2() {
		return p_price2;
	}
	public void setP_price2(double p_price2) {
		this.p_price2 = p_price2;
	}
	public double getP_price3() {
		return p_price3;
	}
	public void setP_price3(double p_price3) {
		this.p_price3 = p_price3;
	}
	
	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_code=" + p_code + ", p_name=" + p_name + ", p_price1=" + p_price1
				+ ", p_price2=" + p_price2 + ", p_price3=" + p_price3 + ", p_number1=" + p_number1 + ", p_number2="
				+ p_number2 + ", p_time1=" + p_time1 + ", p_time2=" + p_time2 + ", p_type=" + p_type + ", p_discript="
				+ p_discript + ", p_state=" + p_state + "]";
	}
	public Integer getP_number1() {
		return p_number1;
	}
	public void setP_number1(Integer p_number1) {
		this.p_number1 = p_number1;
	}
	public Integer getP_number2() {
		return p_number2;
	}
	public void setP_number2(Integer p_number2) {
		this.p_number2 = p_number2;
	}
	public Product(Integer p_id, String p_code, String p_name, double p_price1, double p_price2, double p_price3,
			Integer p_number1, Integer p_number2, String p_time1, String p_time2, Integer p_type, String p_discript,
			String p_state) {
		super();
		this.p_id = p_id;
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_price1 = p_price1;
		this.p_price2 = p_price2;
		this.p_price3 = p_price3;
		this.p_number1 = p_number1;
		this.p_number2 = p_number2;
		this.p_time1 = p_time1;
		this.p_time2 = p_time2;
		this.p_type = p_type;
		this.p_discript = p_discript;
		this.p_state = p_state;
	}
	public String getP_time1() {
		return p_time1;
	}
	public void setP_time1(String p_time1) {
		this.p_time1 = p_time1;
	}
	public String getP_time2() {
		return p_time2;
	}
	public void setP_time2(String p_time2) {
		this.p_time2 = p_time2;
	}
	public Integer getP_type() {
		return p_type;
	}
	public void setP_type(Integer p_type) {
		this.p_type = p_type;
	}
	public String getP_discript() {
		return p_discript;
	}
	public void setP_discript(String p_discript) {
		this.p_discript = p_discript;
	}
	public String getP_state() {
		return p_state;
	}
	public void setP_state(String p_state) {
		this.p_state = p_state;
	}
	
	public Product() {
		
	}
	
	
}
