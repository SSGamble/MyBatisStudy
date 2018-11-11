package top.qingrang.many2many.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.qingrang.many2many.beans.Student;
import top.qingrang.many2many.dao.IStudentDao;
import top.qingrang.many2many.utils.MyBatisUtils;

public class MyTest {
	private IStudentDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	
	@Test
	public void test01() {
		Student student = dao.selectStudentById(1);
		System.out.println(student);
	}
	
}






























