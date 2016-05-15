package cn.com.jrr.lease.model;

import org.springframework.stereotype.Repository;

@Repository
public class UserAddress {
	private Integer a_id;
	private Integer a_user;
	private String a_address;
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	public Integer getA_user() {
		return a_user;
	}
	public void setA_user(Integer a_user) {
		this.a_user = a_user;
	}
	public String getA_address() {
		return a_address;
	}
	public void setA_address(String a_address) {
		this.a_address = a_address;
	}
	public UserAddress(Integer a_id, Integer a_user, String a_address) {
		super();
		this.a_id = a_id;
		this.a_user = a_user;
		this.a_address = a_address;
	}
	@Override
	public String toString() {
		return "UserAddress [a_id=" + a_id + ", a_user=" + a_user + ", a_address=" + a_address + "]";
	}
	public UserAddress() {
		// TODO Auto-generated constructor stub
	}
}
