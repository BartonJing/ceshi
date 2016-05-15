package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.jrr.lease.model.User;
import cn.com.jrr.lease.model.UserAddress;


@Service
@Scope("prototype")
public class UserAddressService{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private int res;
	@Transactional
	public boolean add(UserAddress t) {
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.insert("cn.com.jrr.lease.model.userAddressMapper.add", t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
	}
	public List<UserAddress> list(int code) {
		sqlSession=sqlSessionFactory.openSession();
		List<UserAddress> userAddresss = sqlSession.selectList("cn.com.jrr.lease.model.userAddressMapper.queryAll",code);
		sqlSession.commit();
		sqlSession.close();
		return userAddresss;
		
	}
	public UserAddress get(int code) {
		
		sqlSession=sqlSessionFactory.openSession();
		UserAddress userAddress = sqlSession.selectOne("cn.com.jrr.lease.model.UserAddressMapper.get",code);
		sqlSession.commit();
		sqlSession.close();
		return userAddress;
		
	}
	/*É¾³ý*/
	public boolean delete(Integer code) {
		
		sqlSession=sqlSessionFactory.openSession();
		res=sqlSession.delete("cn.com.jrr.lease.model.userAddressMapper.delete",code);
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
		res=sqlSession.update("cn.com.jrr.lease.model.userAddressMapper.save",t);
		sqlSession.commit();
		sqlSession.close();
		if(res>0){
			return true;
		}else{
			return false;
		}
		
	}
}
