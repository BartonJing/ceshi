package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.model.Product;


@Service
@Scope("prototype")
public class ProductService{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private int res;
	private Product product;
	@Autowired
	private PageModel<Product> pageModel;
	
	
	
	@Transactional
	public boolean add(Product t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.insert("cn.com.jrr.lease.model.ProductMapper.add", t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public List<Product> list() {
		
		sqlSession=sqlSessionFactory.openSession();
		List<Product> products = sqlSession.selectList("cn.com.jrr.lease.model.ProductMapper.queryAll");
		sqlSession.commit();
		sqlSession.close();
		return products;
		
	}
	public boolean delete(Integer code) {
		// TODO Auto-generated method stub
		return false;
	}
	public Product get(Integer code) {
		sqlSession=sqlSessionFactory.openSession();
		product = sqlSession.selectOne("cn.com.jrr.lease.model.ProductMapper.get",code);
		sqlSession.commit();
		sqlSession.close();
		
		return product;
	}
	public boolean update(Product t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.ProductMapper.save",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
	/*更改状态*/
	public boolean updateState(Product t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.ProductMapper.savestate",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
	/*更改价格*/
	public boolean updatePrice(Product t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.ProductMapper.saveprice",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
	public PageModel<Product> getPage(Integer pageRequest,int pageSize) {
		pageModel.setPageSize(pageSize);
		int totalPage=this.list().size();
		if(totalPage%pageSize==0){
			pageModel.setTotalPage(totalPage/pageSize);
		}else{
			pageModel.setTotalPage(totalPage/pageSize+1);
		}
		pageModel.setCurrentPage(pageRequest);
		pageModel.setCurrentItem((pageModel.getCurrentPage()-1)*pageModel.getPageSize());
		sqlSession=sqlSessionFactory.openSession();
		List<Product> products = sqlSession.selectList("cn.com.jrr.lease.model.ProductMapper.queryPage",pageModel);
		sqlSession.commit();
		sqlSession.close();
		pageModel.setData(products);
		return pageModel;
	}
	
	
}
