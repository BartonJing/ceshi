package cn.com.jrr.lease.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class User {
	private Integer u_id;
	private String u_code;
	private String u_password;
	private String u_tele;
	private String u_time;
	private Integer u_state;
	private String u_image;
	private List<UserAddress> userAddresss;
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_code() {
		return u_code;
	}
	public void setU_code(String u_code) {
		this.u_code = u_code;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_tele() {
		return u_tele;
	}
	public void setU_tele(String u_tele) {
		this.u_tele = u_tele;
	}
	public String getU_time() {
		return u_time;
	}
	public void setU_time(String u_time) {
		this.u_time = u_time;
	}
	public Integer getU_state() {
		return u_state;
	}
	public void setU_state(Integer u_state) {
		this.u_state = u_state;
	}
	
	public User(Integer u_id, String u_code, String u_password, String u_tele, String u_time, Integer u_state,
			String u_image, List<UserAddress> userAddresss) {
		super();
		this.u_id = u_id;
		this.u_code = u_code;
		this.u_password = u_password;
		this.u_tele = u_tele;
		this.u_time = u_time;
		this.u_state = u_state;
		this.u_image = u_image;
		this.userAddresss = userAddresss;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_code=" + u_code + ", u_password=" + u_password + ", u_tele=" + u_tele
				+ ", u_time=" + u_time + ", u_state=" + u_state + ", u_image=" + u_image + ", userAddresss="
				+ userAddresss + "]";
	}
	public List<UserAddress> getUserAddresss() {
		return userAddresss;
	}
	public void setUserAddresss(List<UserAddress> userAddresss) {
		this.userAddresss = userAddresss;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getU_image() {
		return u_image;
	}
	public void setU_image(String u_image) {
		this.u_image = u_image;
	}
}
