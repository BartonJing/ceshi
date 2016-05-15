package cn.com.jrr.lease.model;

import org.springframework.stereotype.Repository;

@Repository
public class AdminPower {
	private Integer id;
	private String type;
	
	
	public AdminPower() {
		
	}


	@Override
	public String toString() {
		return "AdminPower [id=" + id + ", type=" + type + "]";
	}


	public AdminPower(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	

}
