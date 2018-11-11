package top.qingrang.crud.dao;

import top.qingrang.crud.beans.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
	//===========================================================
	//						动态查询
	//===========================================================
	List<Student> selectStudentsByWhere(Student student);
	List<Student> selectStudentsByChoose(Student student);
	List<Student> selectStudentsByForeach(int[] ids);
	List<Student> selectStudentsByForeach2(List<Integer> ids);
	List<Student> selectStudentsByForeach3(List<Student> ids);
	List<Student> selectStudentsBySqlFragment(int[] ids);


	//===========================================================
	//	                        CRUD
	//===========================================================
	void insertStudent(Student student);
	void insertStudentCacheId(Student student);
	//多条件查询
	List<Student> selectStudentsByCondition(Map<String, Object> map);
	List<Student> selectStudentsByCondition2(String name,int age);

	void deleteStudentById(int id);
	void updateStudent(Student student);

	List<Student> selectAllStudents();
	Map<String, Object> selectAllStudentsMap();

	Student selectStudentById(int id);
	List<Student> selectStudentsByName(String name);
}
