package cn.com.jrr.lease.model;

import org.springframework.stereotype.Repository;

@Repository
public class PorductType {
	private Integer t_id;
	private String t_type;
	public Integer getT_id() {
		return t_id;
	}
	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
	public String getT_type() {
		return t_type;
	}
	public void setT_type(String t_type) {
		this.t_type = t_type;
	}
	public PorductType(Integer t_id, String t_type) {
		super();
		this.t_id = t_id;
		this.t_type = t_type;
	}
	@Override
	public String toString() {
		return "PorductType [t_id=" + t_id + ", t_type=" + t_type + "]";
	}
	public PorductType() {
		super();
	}
	
}
