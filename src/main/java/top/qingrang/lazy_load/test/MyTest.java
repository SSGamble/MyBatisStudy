package top.qingrang.lazy_load.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.qingrang.lazy_load.beans.Country;
import top.qingrang.lazy_load.beans.Minister;
import top.qingrang.lazy_load.dao.ICountryDao;
import top.qingrang.many2many.utils.MyBatisUtils;

import java.util.Set;


public class MyTest {
	private ICountryDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(ICountryDao.class);
	}
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	
	@Test
	public void test01() {
		Country country = dao.selectCountryById(1);
		System.out.println("---- 深度延迟加载（X）：查询 country ---");
		System.out.println(country.getCname());
		System.out.println("---- 深度延迟加载（X）：访问主加载对象 ---");
		Set<Minister> ministers = country.getMinisters();
		System.out.println("Total：" + ministers.size());
		System.out.println("---- 深度延迟加载（√）：访问主加载对象 ---");
	}
	
}






























