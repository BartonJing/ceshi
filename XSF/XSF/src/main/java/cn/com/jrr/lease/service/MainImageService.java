package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.jrr.lease.model.PageModel;
import cn.com.jrr.lease.model.MainImage;


@Service
@Scope("prototype")
public class MainImageService{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private int res;
	@Autowired
	private PageModel<MainImage> pageModel;
	
	@Transactional
	public boolean add(MainImage t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.insert("cn.com.jrr.lease.model.MainImageMapper.add", t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public List<MainImage> list() {
		sqlSession=sqlSessionFactory.openSession();
		List<MainImage> mainImages = sqlSession.selectList("cn.com.jrr.lease.model.MainImageMapper.queryAll");
		sqlSession.commit();
		sqlSession.close();
		return mainImages;
		
	}
	public MainImage get(int code) {
		
		sqlSession=sqlSessionFactory.openSession();
		MainImage mainImage = sqlSession.selectOne("cn.com.jrr.lease.model.MainImageMapper.get",code);
		sqlSession.commit();
		sqlSession.close();
		return mainImage;
		
	}
	/*É¾³ý*/
	public boolean delete(Integer code) {
		
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.delete("cn.com.jrr.lease.model.MainImageMapper.delete",code);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean update(MainImage t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.update("cn.com.jrr.lease.model.MainImageMapper.save",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
	public PageModel<MainImage> getPage(Integer pageRequest,int pageSize) {
		pageModel.setPageSize(pageSize);
		int totalPage=this.list().size();
		pageModel.setTotalPage(totalPage);
		pageModel.setCurrentPage(pageRequest);
		pageModel.setCurrentItem((pageModel.getCurrentPage()-1)*pageModel.getPageSize());
		sqlSession=sqlSessionFactory.openSession();
		List<MainImage> mainImages = sqlSession.selectList("cn.com.jrr.lease.model.MainImageMapper.queryPage",pageModel);
		sqlSession.commit();
		sqlSession.close();
		pageModel.setData(mainImages);
		
		return pageModel;
	}
	
}
