package cn.com.jrr.lease.action;

import java.io.File;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.jrr.common.utils.FileHelper;
import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.model.MainImage;
import cn.com.jrr.lease.service.MainImageService;


@Controller
public class MainImageAction extends  ActionSupport implements ModelDriven<MainImage>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MainImageService mainImageService;
	@Autowired
	private MainImage mainImage;
	private Integer i_id;
	private Map<String, Object> request;
	private String message;
	private File imageM;
	private String imageMFileName;
	
	
	private Integer currentPage;
	private PageModel<MainImage> pageModel;
	
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/*添加图片*/
	public String add(){
		if(imageM!=null){
			String imageName = FileHelper.upload(imageM, imageMFileName, FileHelper.root);
			mainImage.setI_image(imageName);
		}
		mainImageService.add(mainImage);
		
		return "addSuccess";
		
	}
	
	/*查询处理*/
	public String query(){
		if(currentPage==null){
			currentPage=1;
		}
		pageModel=mainImageService.getPage(currentPage, 1);
		request.put("pageModel", pageModel);
		return "querySuccess";
	}
	
	/*更改图片*/
	public String save(){
		String imageName = null;
		if(imageM!=null){
			FileHelper.deleteFile(FileHelper.root+"/"+mainImageService.get(i_id).getI_image());
			imageName = FileHelper.upload(imageM, imageMFileName, FileHelper.root);
			mainImage.setI_image(imageName);
		}else{
			mainImage.setI_image(mainImageService.get(i_id).getI_image());
		}
		mainImage.setI_id(i_id);
		mainImageService.update(mainImage);
		
		return "saveSuccess";
	}
	
	/*删除产品图片管理*/
	public String delete(){
		FileHelper.deleteFile(FileHelper.root+"/"+mainImageService.get(i_id).getI_image());
		mainImageService.delete(i_id);
		return "deleteSuccess";
	}
	
	
	public MainImage getModel() {
		
		return mainImage;
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
	
	public Integer getI_id() {
		return i_id;
	}

	public File getImageM() {
		return imageM;
	}

	public void setImageM(File imageM) {
		this.imageM = imageM;
	}

	public String getImageMFileName() {
		return imageMFileName;
	}

	public void setImageMFileName(String imageMFileName) {
		this.imageMFileName = imageMFileName;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}
}
