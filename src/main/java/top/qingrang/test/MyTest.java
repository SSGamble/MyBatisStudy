package top.qingrang.test;

import org.junit.Before;
import org.junit.Test;
import top.qingrang.beans.Student;
import top.qingrang.dao.IStudentDao;
import top.qingrang.dao.impl.StudentDaoImpl;

/**
 * Unit test for simple MyTest.
 */
public class MyTest {
	private IStudentDao dao;

	@Before
	public void before() {
		dao = new StudentDaoImpl();
	}

	@Test
	public void testInsertStudent() {
		Student student = new Student("张三", 23, 93.5);
		System.out.println("插入前：student = " + student);
		dao.insertStudent(student);
		System.out.println("插入后：student = " + student);
	}

	@Test
	public void testInsertStudentCacheId() {
		Student student = new Student("张三", 23, 93.5);
		System.out.println("插入前：student = " + student);
		dao.insertStudentCacheId(student);
		System.out.println("插入后：student = " + student);
	}
}
