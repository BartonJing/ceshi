package cn.com.jrr.common.dao;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface BasicDao<T> {
	/*添加*/
	public boolean add(T t);
	/*查询*/
	public List<T> list();
	/*删除*/
	public boolean delete(Integer code);
	/*按id查询*/
	public T get(Integer code);
	/*编辑*/
	public boolean update(T t);
}
