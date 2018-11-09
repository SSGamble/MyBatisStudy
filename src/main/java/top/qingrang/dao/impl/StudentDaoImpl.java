package top.qingrang.dao.impl;

import org.apache.ibatis.session.SqlSession;
import top.qingrang.beans.Student;
import top.qingrang.dao.IStudentDao;
import top.qingrang.utils.MyBatisUtils;
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

	}

	@Override
	public void updateStudent(Student student) {

	}

	@Override
	public List<Student> selectAllStudents() {
		return null;
	}

	@Override
	public Map<String, Object> selectAllStudentsMap() {
		return null;
	}

	@Override
	public Student selectStudentById(int id) {
		return null;
	}

	@Override
	public List<Student> selectStudentsByName(String name) {
		return null;
	}
}
