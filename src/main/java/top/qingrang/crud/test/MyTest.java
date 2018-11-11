package top.qingrang.crud.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.qingrang.crud.beans.Student;
import top.qingrang.crud.dao.IStudentDao;
import top.qingrang.crud.utils.MyBatisUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple MyTest.
 */
public class MyTest {
	private IStudentDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		//调用 SqlSession 的 getMapper()方法，即可获取指定接口的实现类对象。
		dao = sqlSession.getMapper(IStudentDao.class);//该方法的参数为指定 Dao 接口类的 class 值。
	}

	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectStudentsByWhere() {
		Student stu = new Student("张", 23, 0);	//指定两个条件
		// Student stu = new Student("", 23, 0);	//指定一个条件
		// Student stu = new Student("", 0, 0);	//不指定条件

		List<Student> students = dao.selectStudentsByWhere(stu);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectStudentsByChoose() {
		// Student stu = new Student("张", 23, 0);
		// Student stu = new Student("", 23, 0);
		Student stu = new Student("", 0, 0);

		List<Student> students = dao.selectStudentsByChoose(stu);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectStudentsByForeach() {
		int[] ids = {1, 3, 4};
		List<Student> students = dao.selectStudentsByForeach(ids);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectStudentsByForeach2() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(3);

		List<Student> students = dao.selectStudentsByForeach2(ids);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectStudentsByForeach3() {
		Student stu1 = new Student();
		stu1.setId(1);
		Student stu2 = new Student();
		stu2.setId(3);

		List<Student> stus = new ArrayList<>();
		stus.add(stu1);
		stus.add(stu2);

		List<Student> students = dao.selectStudentsByForeach3(stus);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectStudentsBySqlFragment() {
		int[] ids = {1, 3, 4};
		List<Student> students = dao.selectStudentsBySqlFragment(ids);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectStudentsByCondition() {
		Student stu = new Student("田七", 27, 95);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nameCon", "张");
		map.put("ageCon", 23);
		map.put("stu", stu);	//放入了学生对象

		List<Student> students = dao.selectStudentsByCondition(map);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectStudentsByCondition2() {
		//参数直接对应 mapper 中的索引号
		List<Student> students = dao.selectStudentsByCondition2("张",25);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testInsertStudent() {
		Student student = new Student("张三", 23, 93.5);
		System.out.println("插入前：student = " + student);
		dao.insertStudent(student);
		sqlSession.commit();
		System.out.println("插入后：student = " + student);
	}

	@Test
	public void testInsertStudentCacheId() {
		Student student = new Student("张三", 23, 93.5);
		System.out.println("插入前：student = " + student);
		dao.insertStudentCacheId(student);
		sqlSession.commit();
		System.out.println("插入后：student = " + student);
	}

	@Test
	public void testDeleteStudentById() {
		dao.deleteStudentById(12);
		sqlSession.commit();
	}

	@Test
	public void testUpdateStudent() {
		Student student = new Student("张三", 25, 93.5);
		student.setId(15);
		dao.updateStudent(student);
		sqlSession.commit();
	}

	@Test
	public void testSelectAllStudents() {
		List<Student> students = dao.selectAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
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
