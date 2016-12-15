package com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.BaseDao;
import com.dao.TestDao;
import com.entity.Test;

public class TestDaoImpl extends BaseDao implements TestDao{

	@Override
	public List query() {
		SqlSession session = super.getSession();
		List list = session.selectList("test.query");
		session.close();
		return list;
	}

	@Override
	public void save(Test t) {
		SqlSession session = super.getSession();
		session.insert("test.save", t);
		session.commit();
		session.close();
	}

	@Override
	public void del(long id) {
		SqlSession session = super.getSession();
		session.delete("test.delete",id);
		session.commit();
		session.close();
	}

	@Override
	public void update(Test t) {
		SqlSession session = super.getSession();
		session.update("test.update", t);
		session.commit();
		session.close();
	}

	@Override
	public Test get(long id) {
		SqlSession session = super.getSession();
		Test t = session.selectOne("test.get",id);
		session.close();
		return t;
	}

}
