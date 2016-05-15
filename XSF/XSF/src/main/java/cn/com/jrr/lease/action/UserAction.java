package cn.com.jrr.lease.action;

import java.io.File;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.jrr.common.utils.DateStyle;
import cn.com.jrr.common.utils.DateUtil;
import cn.com.jrr.common.utils.FileHelper;
import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.model.User;
import cn.com.jrr.lease.service.UserService;


@Controller
public class UserAction extends  ActionSupport implements ModelDriven<User>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	private Integer y_id;
	private Map<String, Object> request;
	private String message;
	private File imageU;
	private String imageUFileName;
	
	
	private Integer currentPage;
	private PageModel<User> pageModel;
	
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/*用户注册*/
	public String add(){
		if(imageU!=null){
			String imageName = FileHelper.upload(imageU, imageUFileName, FileHelper.root);
			user.setU_image(imageName);
		}
		String dateTime=DateUtil.DateToString(new Date(),DateStyle.YYYY_MM_DD_HH_MM_SS);
		user.setU_time(dateTime);
		userService.add(user);
		
		return "addSuccess";
		
	}
	
	/*查询处理(后台)*/
	public String query(){
		if(currentPage==null){
			currentPage=1;
		}
		pageModel=userService.getPage(currentPage, 2);
		request.put("pageModel", pageModel);
		return "querySuccess";
	}
	
	
	
	
	
	
	public User getModel() {
		
		return user;
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
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
	

	public File getImageU() {
		return imageU;
	}

	public void setImageU(File imageU) {
		this.imageU = imageU;
	}

	public Integer getY_id() {
		return y_id;
	}

	public String getImageUFileName() {
		return imageUFileName;
	}

	public void setImageUFileName(String imageUFileName) {
		this.imageUFileName = imageUFileName;
	}

	public void setY_id(Integer y_id) {
		this.y_id = y_id;
	}

	

}
