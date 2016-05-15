package cn.com.jrr.common.dao;

import cn.com.jrr.lease.model.PageModel;

public interface PageDao<T> extends BasicDao<T>{
	public PageModel<T> getPage(Integer pageRequest);
}
