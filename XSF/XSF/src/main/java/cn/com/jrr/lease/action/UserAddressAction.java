package cn.com.jrr.lease.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.jrr.lease.model.UserAddress;
import cn.com.jrr.lease.service.UserAddressService;


@Controller
public class UserAddressAction extends  ActionSupport implements ModelDriven<UserAddress>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private UserAddress userAddress;
	private Integer a_id;
	private Integer a_user;
	
	private Map<String, Object> request;
	private String message;
	
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/*用户地址添加*/
	public String add(){
		
		return "addSuccess";
		
	}
	
	/*查询处理(后台)*/
	public String query(){
		List<UserAddress> userAddress=userAddressService.list(a_user);
		request.put("userAddress", userAddress);
		return "querySuccess";
	}
	
	public UserAddress getModel() {
		
		return userAddress;
	}
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
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

}
