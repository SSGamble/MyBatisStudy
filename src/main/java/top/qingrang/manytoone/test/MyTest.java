package top.qingrang.manytoone.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.qingrang.crud.utils.MyBatisUtils;
import top.qingrang.manytoone.beans.Minister;
import top.qingrang.manytoone.dao.IMinisterDao;

public class MyTest {
	private IMinisterDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IMinisterDao.class);
	}

	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}

	@Test
	public void selectMinisterById() {
		Minister minister = dao.selectMinisterById(2);
		System.out.println(minister);
	}
}
