package top.qingrang.test;

import org.junit.Before;
import org.junit.Test;
import top.qingrang.beans.Student;
import top.qingrang.dao.IStudentDao;
import top.qingrang.dao.impl.StudentDaoImpl;
import java.util.List;
import java.util.Map;

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

	@Test
	public void testDeleteStudentById() {
		dao.deleteStudentById(12);
	}

	@Test
	public void testUpdateStudent() {
		Student student = new Student("张三", 25, 93.5);
		student.setId(15);
		dao.updateStudent(student);
	}

	@Test
	public void testSelectAllStudents() {
		List<Student> students = dao.selectAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectAllStudentsMap() {
		//输出最后一个符合条件的记录
		Map<String, Object> map = dao.selectAllStudentsMap();
		System.out.println(map.get("张三"));
	}

	@Test
	public void testSelectStudentById() {
		Student student = dao.selectStudentById(3);
		System.out.println(student);
	}

	@Test
	public void testSelectStudentsByName() {
		List<Student> students = dao.selectStudentsByName("张");
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
