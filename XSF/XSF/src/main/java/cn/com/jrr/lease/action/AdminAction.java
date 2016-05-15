package cn.com.jrr.lease.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.jrr.common.utils.FileHelper;
import cn.com.jrr.lease.model.Admin;
import cn.com.jrr.lease.model.AdminPower;
import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.service.AdminPowerService;
import cn.com.jrr.lease.service.AdminService;


@Controller
public class AdminAction extends  ActionSupport implements ModelDriven<Admin>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	@Autowired
	private AdminPowerService adminPowerService;
	@Autowired
	private Admin admin;
	private Integer id;
	private Map<String, Object> request;
	private String message;
	private File image;
	private String imageFileName;
	private AdminPower adminPower;
	private Integer currentPage;
	private PageModel<Admin> pageModel;
	
	
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	/*登录处理*/
	public String login(){
		if(adminService.login(admin)){
			return "loginSuccess";
		}else{
			this.setMessage("用户名或密码错误，请确认后再登录！");
			return "loginFail";
		}
		
	}
	/*添加处理*/
	public String add(){
		if(image!=null){
			String imageName = FileHelper.upload(image, imageFileName, FileHelper.root);
			admin.setA_image(imageName);
		}
		if(adminService.add(admin)){
			return "addSuccess";
		}else{
			this.setMessage("添加失败！");
			return "addSuccess";
		}
		
	}
	/*查询处理*/
	public String query(){
		if(currentPage==null){
			currentPage=1;
		}
		pageModel=adminService.getPage(currentPage, 2);
		request.put("pageModel", pageModel);
		return "querySuccess";
	}
	/*回显处理*/
	public String editor(){
		
		admin=adminService.get(id);
		System.out.println(admin);
		request.put("admin", admin);
		return "editorSuccess";
	}
	/*保存处理*/
	public String save(){
		String imageName;
		imageName=admin.getA_image();
		if(image!=null){
			FileHelper.deleteFile(FileHelper.root+"/"+imageName);
			imageName = FileHelper.upload(image, imageFileName, FileHelper.root);
		}
		admin.setA_image(imageName);
		adminService.update(admin);
		return "saveSuccess";
	}
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Admin getModel() {
		
		return admin;
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
	
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
