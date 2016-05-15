package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.model.YouHui;


@Service
@Scope("prototype")
public class YouHuiService{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private int res;
	@Autowired
	private PageModel<YouHui> pageModel;
	
	@Transactional
	public boolean add(YouHui t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.insert("cn.com.jrr.lease.model.YouHuiMapper.add", t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public List<YouHui> list() {
		sqlSession=sqlSessionFactory.openSession();
		List<YouHui> youHuis = sqlSession.selectList("cn.com.jrr.lease.model.YouHuiMapper.queryAll");
		sqlSession.commit();
		sqlSession.close();
		return youHuis;
		
	}
	public YouHui get(int code) {
		
		sqlSession=sqlSessionFactory.openSession();
		YouHui youHui = sqlSession.selectOne("cn.com.jrr.lease.model.YouHuiMapper.get",code);
		sqlSession.commit();
		sqlSession.close();
		return youHui;
		
	}
	/*É¾³ý*/
	public boolean delete(Integer code) {
		
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.YouHuiMapper.delete",code);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean update(YouHui t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.YouHuiMapper.save",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
	public PageModel<YouHui> getPage(Integer pageRequest,int pageSize) {
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
		List<YouHui> youHuis = sqlSession.selectList("cn.com.jrr.lease.model.YouHuiMapper.queryPage",pageModel);
		sqlSession.commit();
		sqlSession.close();
		pageModel.setData(youHuis);
		return pageModel;
	}
	
}
