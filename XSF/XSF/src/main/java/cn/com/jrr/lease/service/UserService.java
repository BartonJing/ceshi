package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.model.User;


@Service
@Scope("prototype")
public class UserService{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private int res;
	@Autowired
	private PageModel<User> pageModel;
	
	@Transactional
	public boolean add(User t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.insert("cn.com.jrr.lease.model.UserMapper.add", t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public List<User> list() {
		sqlSession=sqlSessionFactory.openSession();
		List<User> users = sqlSession.selectList("cn.com.jrr.lease.model.UserMapper.queryAll");
		sqlSession.commit();
		sqlSession.close();
		return users;
		
	}
	public User get(int code) {
		
		sqlSession=sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("cn.com.jrr.lease.model.UserMapper.get",code);
		sqlSession.commit();
		sqlSession.close();
		return user;
		
	}
	/*É¾³ý*/
	public boolean delete(Integer code) {
		
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.UserMapper.delete",code);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean update(User t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.UserMapper.save",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
	public PageModel<User> getPage(Integer pageRequest,int pageSize) {
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
		List<User> users = sqlSession.selectList("cn.com.jrr.lease.model.UserMapper.queryPage",pageModel);
		sqlSession.commit();
		sqlSession.close();
		pageModel.setData(users);
		return pageModel;
	}
	
}
