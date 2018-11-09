package top.qingrang.dao.impl;

import org.apache.ibatis.session.SqlSession;
import top.qingrang.beans.Student;
import top.qingrang.dao.IStudentDao;
import top.qingrang.utils.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public void insertStudent(Student student) {
		try {
			// 创建 SqlSession 对象
			sqlSession = MyBatisUtils.getSqlSession();
			// 执行相关操作
			sqlSession.insert("insertStudent", student);
			// 提交
			sqlSession.commit();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void insertStudentCacheId(Student student) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.insert("insertStudentCacheId", student);
			sqlSession.commit();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void deleteStudentById(int id) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.delete("deleteStudentById", id);
			sqlSession.commit();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void updateStudent(Student student) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.update("updateStudent", student);
			sqlSession.commit();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public List<Student> selectAllStudents() {
		List<Student> students = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			students = sqlSession.selectList("selectAllStudents");
			//查询不需要 sqlSession.commit();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return students;
	}

	@Override
	public Map<String, Object> selectAllStudentsMap() {
		Map<String, Object> map = new HashMap<>();
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			map = sqlSession.selectMap("selectAllStudents", "name");
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return map;
	}

	@Override
	public Student selectStudentById(int id) {
		Student student = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			student = sqlSession.selectOne("selectStudentById", id);
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return student;
	}

	@Override
	public List<Student> selectStudentsByName(String name) {
		List<Student> students = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			students = sqlSession.selectList("selectStudentsByName", name);
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return students;
	}
}
