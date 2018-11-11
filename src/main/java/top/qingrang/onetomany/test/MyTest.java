package top.qingrang.onetomany.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.qingrang.crud.utils.MyBatisUtils;
import top.qingrang.onetomany.beans.Country;
import top.qingrang.onetomany.dao.ICountryDao;

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
	public void testSelectCountryByName() {
		Country country = dao.selectCountryByName("China");
		System.out.println(country);
	}
}
