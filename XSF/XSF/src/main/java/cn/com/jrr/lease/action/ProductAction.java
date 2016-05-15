package cn.com.jrr.lease.action;

import java.io.File;
import java.util.Date;
import java.util.List;
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
import cn.com.jrr.lease.model.PorductType;
import cn.com.jrr.lease.model.Product;
import cn.com.jrr.lease.model.ProductImage;
import cn.com.jrr.lease.service.ProductImageService;
import cn.com.jrr.lease.service.ProductService;
import cn.com.jrr.lease.service.ProductTypeService;


@Controller
public class ProductAction extends  ActionSupport implements ModelDriven<Product>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductService productService;
	@Autowired
	private Product product;
	@Autowired
	private ProductTypeService productTypeService;
	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private ProductImage productImage;
	private Integer id;
	private Integer i_id;
	private Map<String, Object> request;
	private String message;
	private File imageP;
	private String imagePFileName;
	
	
	private Integer currentPage;
	private PageModel<Product> pageModel;
	
	
	
	@Override
	public String execute() throws Exception {
		List<PorductType> porductTypes=productTypeService.list();
		request.put("porductTypes", porductTypes);
		return SUCCESS;
	}
	
	/*添加新产品*/
	public String addNew(){
		String dateTime=DateUtil.DateToString(new Date(),DateStyle.YYYY_MM_DD_HH_MM_SS);
		product.setP_time1(dateTime);
		product.setP_time2(dateTime);
		product.setP_number2(product.getP_number1());
		String code=String.valueOf(new Date().getTime())+String.valueOf((int)Math.random()*10000);
		product.setP_code(code);
		
		if(productService.add(product)){
			this.setMessage("添加成功！");
		}
		return "addSuccess";
		
	}
	
	/*查询处理*/
	public String query(){
		if(currentPage==null){
			currentPage=1;
		}
		pageModel=productService.getPage(currentPage, 2);
		request.put("pageModel", pageModel);
		return "querySuccess";
	}
	/*打开增加已有库存*/
	public String openOld(){
		List<PorductType> porductTypes=productTypeService.list();
		request.put("porductTypes", porductTypes);
		product=productService.get(id);
		request.put("product", product);
		return "openSuccess";
	}
	/*添加已有库存*/
	public String addOld(){
		int oldNumber=productService.get(id).getP_number1();
		String dateTime=DateUtil.DateToString(new Date(),DateStyle.YYYY_MM_DD_HH_MM_SS);
		product.setP_time2(dateTime);
		int newPor=product.getP_number1();
		int oldPor=product.getP_number2();
		product.setP_number2(newPor+oldPor);
		product.setP_number1(oldNumber+newPor);
		
		if(productService.update(product)){
			this.setMessage("添加成功！");
		}
		return "addSuccess";
		
	}
	/*前台推送*/
	public String push(){
		product.setP_id(id);
		if("已推送".equals(productService.get(id).getP_state())){
			product.setP_state("未推送");
		}else{
			product.setP_state("已推送");
		}
		productService.updateState(product);
		return "pushSuccess";
	}
	/*查看详情*/
	public String editorAll(){
		List<PorductType> porductTypes=productTypeService.list();
		for(PorductType p:porductTypes){
			if(p.getT_id()==id){
				request.put("porductType", p.getT_type());
			}
		}
		
		product=productService.get(id);
		request.put("product", product);
		return "editorSuccess";
	}
	
	/*产品价格回显*/
	public String showPrice(){
		product=productService.get(id);
		request.put("product", product);
		return "editorSuccess";
	}
	/*产品价格保存*/
	public String savePrice(){
		product.setP_id(id);;
		productService.updatePrice(product);
		return "saveSuccess";
	}
	
	
	/*打开产品图片添加*/
	public String openImage(){
		return "imageSuccess";
	}
	/*添加产品图片添加*/
	public String addImage(){
		if(imageP!=null){
			String imageName = FileHelper.upload(imageP, imagePFileName, FileHelper.root);
			productImage.setI_image(imageName);
			productImage.setI_product(id);
		}
		productImageService.add(productImage);
		return "addSuccess";
	}
	/*打开产品图片管理*/
	public String openImageMana(){
		if(currentPage==null){
			currentPage=1;
		}
		PageModel<ProductImage> imgPageModel=productImageService.getPage(currentPage, 1, id);
		request.put("imgPageModel", imgPageModel);
		return "imageSuccess";
	}
	/*保存产品图片管理*/
	public String editorImageMana(){
		String imageName = null;
		if(imageP!=null){
			FileHelper.deleteFile(FileHelper.root+"/"+productImageService.get(i_id).getI_image());
			imageName = FileHelper.upload(imageP, imagePFileName, FileHelper.root);
			productImage.setI_image(imageName);
		}else{
			productImage.setI_image(productImageService.get(i_id).getI_image());
		}
		productImage.setI_id(i_id);
		productImageService.update(productImage);
		
		return "imageSuccess";
	}
	
	/*删除产品图片管理*/
	public String deleteImageMana(){
		FileHelper.deleteFile(FileHelper.root+"/"+productImageService.get(i_id).getI_image());
		productImageService.delete(i_id);
		return "imageSuccess";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getModel() {
		
		return product;
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
	public File getImageP() {
		return imageP;
	}

	public void setImageP(File imageP) {
		this.imageP = imageP;
	}

	public String getImagePFileName() {
		return imagePFileName;
	}

	public void setImagePFileName(String imagePFileName) {
		this.imagePFileName = imagePFileName;
	}

	public Integer getI_id() {
		return i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}
}
