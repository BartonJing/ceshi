package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.jrr.lease.model.PageImageModel;
import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.model.ProductImage;


@Service
@Scope("prototype")
public class ProductImageService{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private int res;
	@Autowired
	private PageModel<ProductImage> pageModel;
	
	@Transactional
	public boolean add(ProductImage t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.insert("cn.com.jrr.lease.model.ProductImageMapper.add", t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public List<ProductImage> list(int code) {
		
		sqlSession=sqlSessionFactory.openSession();
		List<ProductImage> productImages = sqlSession.selectList("cn.com.jrr.lease.model.ProductImageMapper.queryAll",code);
		sqlSession.commit();
		sqlSession.close();
		return productImages;
		
	}
	public ProductImage get(int code) {
		
		sqlSession=sqlSessionFactory.openSession();
		ProductImage productImage = sqlSession.selectOne("cn.com.jrr.lease.model.ProductImageMapper.get",code);
		sqlSession.commit();
		sqlSession.close();
		return productImage;
		
	}
	/*É¾³ý*/
	public boolean delete(Integer code) {
		
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.delete("cn.com.jrr.lease.model.ProductImageMapper.delete",code);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean update(ProductImage t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.ProductImageMapper.save",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
	public PageModel<ProductImage> getPage(Integer pageRequest,int pageSize,int id) {
		pageModel.setPageSize(pageSize);
		int totalPage=this.list(id).size();
		pageModel.setTotalPage(totalPage);
		pageModel.setCurrentPage(pageRequest);
		pageModel.setCurrentItem((pageModel.getCurrentPage()-1)*pageModel.getPageSize());
		sqlSession=sqlSessionFactory.openSession();
		List<ProductImage> productImages = sqlSession.selectList("cn.com.jrr.lease.model.ProductImageMapper.queryPage",new PageImageModel((pageModel.getCurrentPage()-1)*pageModel.getPageSize(),pageSize,id));
		sqlSession.commit();
		sqlSession.close();
		pageModel.setData(productImages);
		
		return pageModel;
	}
	
}
