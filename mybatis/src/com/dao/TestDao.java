package com.dao;

import java.util.List;

import com.entity.Test;

public interface TestDao {
	public List query();
	public void save(Test t);
	public void del(long id);
	public void update(Test t);
	public Test get(long id);
}
