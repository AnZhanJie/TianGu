package com.test;

import java.util.List;

import com.dao.TestDao;
import com.dao.impl.TestDaoImpl;
import com.entity.Test;

public class Main1 {
	public static void main(String[] args) {
		Main1 m = new Main1();
		m.test5();
	}

	public void test1() {
		TestDao dao = new TestDaoImpl();
		List<Test> list = dao.query();
		for (Test t : list) {
			System.out.println("ID:" + t.getId() + "--NAME:" + t.getName());
		}
	}

	public void test2() {
		TestDao dao = new TestDaoImpl();
		Test t = dao.get(1);
		System.out.println("ID:" + t.getId() + "--NAME:" + t.getName());
	}
	
	public void test3(){
		TestDao dao = new TestDaoImpl();
		Test t = new Test();
		t.setAddress("河北邯郸");
		t.setGender("男");
		t.setName("XXX");
		dao.save(t);
	}
	
	public void test4(){
		TestDao dao = new TestDaoImpl();
		Test t = dao.get(1);
		t.setAddress("河北邯郸");
		t.setGender("男");
		t.setName("XOX");
		dao.update(t);
	}
	
	public void test5(){
		TestDao dao = new TestDaoImpl();
		dao.del(1);
	}
}
