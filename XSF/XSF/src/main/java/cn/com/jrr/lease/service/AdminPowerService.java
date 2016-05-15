package cn.com.jrr.lease.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.com.jrr.lease.model.AdminPower;

@Service
@Scope("prototype")
public class AdminPowerService/* implements PageDao<Admin> */ {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;

	/* 查询管理员权限 */
	public List<AdminPower> list() {
		sqlSession = sqlSessionFactory.openSession();
		List<AdminPower> AdminPowers = sqlSession.selectList("cn.com.jrr.lease.model.AdminPowerMapper.query");
		sqlSession.commit();
		sqlSession.close();
		return AdminPowers;
	}

}
