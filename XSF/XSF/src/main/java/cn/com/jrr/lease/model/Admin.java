package cn.com.jrr.lease.model;

import org.springframework.stereotype.Repository;

@Repository
public class Admin {
	private Integer a_id;
	private String a_name;
	private String a_psw;
	private String a_code;
	private String a_image;
	private String a_tele;
	private Integer a_power;
	
	public Admin() {
		
	}

	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_psw() {
		return a_psw;
	}

	public void setA_psw(String a_psw) {
		this.a_psw = a_psw;
	}

	public String getA_code() {
		return a_code;
	}

	public void setA_code(String a_code) {
		this.a_code = a_code;
	}

	public String getA_image() {
		return a_image;
	}

	public void setA_image(String a_image) {
		this.a_image = a_image;
	}

	public String getA_tele() {
		return a_tele;
	}

	public void setA_tele(String a_tele) {
		this.a_tele = a_tele;
	}

	public Integer getA_power() {
		return a_power;
	}

	public void setA_power(Integer a_power) {
		this.a_power = a_power;
	}

	@Override
	public String toString() {
		return "Admin [a_id=" + a_id + ", a_name=" + a_name + ", a_psw=" + a_psw + ", a_code=" + a_code + ", a_image="
				+ a_image + ", a_tele=" + a_tele + ", a_power=" + a_power + "]";
	}

	public Admin(Integer a_id, String a_name, String a_psw, String a_code, String a_image, String a_tele,
			Integer a_power) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_psw = a_psw;
		this.a_code = a_code;
		this.a_image = a_image;
		this.a_tele = a_tele;
		this.a_power = a_power;
	}


}
