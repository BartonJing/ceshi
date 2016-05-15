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
import cn.com.jrr.lease.model.YouHui;
import cn.com.jrr.lease.service.YouHuiService;


@Controller
public class YouHuiAction extends  ActionSupport implements ModelDriven<YouHui>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private YouHuiService youHuiService;
	@Autowired
	private YouHui youHui;
	private Integer y_id;
	private Map<String, Object> request;
	private String message;
	private File imageY;
	private String imageYFileName;
	
	
	private Integer currentPage;
	private PageModel<YouHui> pageModel;
	
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/*添加优惠券*/
	public String add(){
		if(imageY!=null){
			String imageName = FileHelper.upload(imageY, imageYFileName, FileHelper.root);
			youHui.setY_image(imageName);
		}
		String dateTime=DateUtil.DateToString(new Date(),DateStyle.YYYY_MM_DD_HH_MM_SS);
		youHui.setY_createtime(dateTime);
		youHui.setY_number2(youHui.getY_number1());
		System.out.println(youHui);
		youHuiService.add(youHui);
		
		return "addSuccess";
		
	}
	
	/*查询处理*/
	public String query(){
		if(currentPage==null){
			currentPage=1;
		}
		pageModel=youHuiService.getPage(currentPage, 2);
		request.put("pageModel", pageModel);
		return "querySuccess";
	}
	/*更改优惠券*/
	public String editor(){
		youHui=youHuiService.get(y_id);
		request.put("youHui", youHui);
		return "editorSuccess";
	}
	/*更改优惠券*/
	public String save(){
		
		String imageName = null;
		if(imageY!=null){
			FileHelper.deleteFile(FileHelper.root+"/"+youHuiService.get(y_id).getY_image());
			imageName = FileHelper.upload(imageY, imageYFileName, FileHelper.root);
		}else{
			imageName=youHuiService.get(y_id).getY_image();
		}
		youHui.setY_image(imageName);
		youHuiService.update(youHui);
		
		return "saveSuccess";
	}
	
	/*删除产品优惠券管理*/
	public String delete(){
		FileHelper.deleteFile(FileHelper.root+"/"+youHuiService.get(y_id).getY_image());
		youHuiService.delete(y_id);
		return "deleteSuccess";
	}
	
	
	public YouHui getModel() {
		
		return youHui;
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
	
	
	public File getImageY() {
		return imageY;
	}

	public void setImageY(File imageY) {
		this.imageY = imageY;
	}

	public String getImageYFileName() {
		return imageYFileName;
	}

	public void setImageYFileName(String imageYFileName) {
		this.imageYFileName = imageYFileName;
	}

	public Integer getY_id() {
		return y_id;
	}

	public void setY_id(Integer y_id) {
		this.y_id = y_id;
	}

	

}
