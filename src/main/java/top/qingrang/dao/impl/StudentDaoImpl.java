package top.qingrang.dao.impl;

import org.apache.ibatis.session.SqlSession;
import top.qingrang.beans.Student;
import top.qingrang.dao.IStudentDao;
import top.qingrang.utils.MyBatisUtils;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;

	@Override
	public void insertStu(Student student) {
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
}
