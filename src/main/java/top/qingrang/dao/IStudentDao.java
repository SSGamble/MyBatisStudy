package top.qingrang.dao;

import top.qingrang.beans.Student;
import java.util.List;
import java.util.Map;

public interface IStudentDao {
	void insertStudent(Student student);
	void insertStudentCacheId(Student student);

	void deleteStudentById(int id);
	void updateStudent(Student student);

	List<Student> selectAllStudents();
	Map<String, Object> selectAllStudentsMap();

	Student selectStudentById(int id);
	List<Student> selectStudentsByName(String name);
}
