package cn.com.jrr.lease.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.model.Product;
import cn.com.jrr.lease.model.ProductImage;
import cn.com.jrr.lease.service.ProductImageService;
import cn.com.jrr.lease.service.ProductService;
import cn.com.jrr.lease.service.ProductTypeService;


@Controller
public class FrontProduct extends  ActionSupport implements ModelDriven<PageModel>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductTypeService productTypeService;
	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private ProductImage productImage;
	private Integer id;
	private Integer i_id;
	private Map<String, Object> request;
	
	
	
	private Integer currentPage;
	@Autowired
	private PageModel<Product> pageModel;
	
	
	/*home界面数据处理*/
	public String query(){
		
		currentPage=pageModel.getCurrentPage();
		System.out.println(currentPage);
		if(currentPage==null){
			currentPage=1;
		}
		pageModel=productService.getPage(currentPage, 5);
		Gson gson=new Gson();
		//创建HttpServletResponse  
        HttpServletResponse response = ServletActionContext.getResponse();  
        //设置编码格式,以及信息类型  及 是否有缓存的设置  
        response.setContentType("application/json;charset=utf-8");  
        //创建PrintWriter 对象 将信息写入到Reponse中  
        PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		response.setContentType("text/json; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
        out.append(gson.toJson(pageModel)); 
        //System.out.println(gson.toJson(pageModel));
        
        out.flush();
        out.close(); 
		return "querySuccess";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PageModel<Product> getModel() {
		
		return pageModel;
	}
	public void setRequest(Map<String, Object> request) {
		this.request=request;
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

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}
}
