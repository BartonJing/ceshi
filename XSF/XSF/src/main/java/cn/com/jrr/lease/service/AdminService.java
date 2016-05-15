package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.jrr.lease.model.Admin;
import cn.com.jrr.lease.model.PageModel;


@Service
@Scope("prototype")
public class AdminService/* implements PageDao<Admin>*/{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private int res;
	private Admin admin;
	@Autowired
	private PageModel<Admin> pageModel;
	
	
	public boolean login(Admin t) {
		sqlSession=sqlSessionFactory.openSession();
		admin=sqlSession.selectOne("cn.com.jrr.lease.model.AdminMapper.login", t);
		sqlSession.commit();
		sqlSession.close();
		if(admin!=null){
			return true;
		}else{
			return false;
		}
		
	}
	@Transactional
	public boolean add(Admin t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.insert("cn.com.jrr.lease.model.AdminMapper.add", t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public List<Admin> list() {
		
		sqlSession=sqlSessionFactory.openSession();
		List<Admin> admins = sqlSession.selectList("cn.com.jrr.lease.model.AdminMapper.queryAll");
		sqlSession.commit();
		sqlSession.close();
		return admins;
		
	}
	public boolean delete(Integer code) {
		// TODO Auto-generated method stub
		return false;
	}
	public Admin get(Integer code) {
		sqlSession=sqlSessionFactory.openSession();
		admin = sqlSession.selectOne("cn.com.jrr.lease.model.AdminMapper.get",code);
		sqlSession.commit();
		sqlSession.close();
		
		return admin;
	}
	public boolean update(Admin t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.AdminMapper.save",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
	public PageModel<Admin> getPage(Integer pageRequest,int pageSize) {
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
		List<Admin> admins = sqlSession.selectList("cn.com.jrr.lease.model.AdminMapper.queryPage",pageModel);
		sqlSession.commit();
		sqlSession.close();
		pageModel.setData(admins);
		return pageModel;
	}
	
	
}
