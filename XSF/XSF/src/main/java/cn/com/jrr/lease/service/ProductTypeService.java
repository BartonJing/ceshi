package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import cn.com.jrr.lease.model.PorductType;


@Service
@Scope("prototype")
public class ProductTypeService{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	/*@Transactional
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
	}*/
	public List<PorductType> list() {
		
		sqlSession=sqlSessionFactory.openSession();
		List<PorductType> porductTypes = sqlSession.selectList("cn.com.jrr.lease.model.ProductTypeMapper.queryAll");
		sqlSession.commit();
		sqlSession.close();
		return porductTypes;
		
	}
	
}
