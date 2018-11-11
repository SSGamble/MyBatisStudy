package top.qingrang.many2many.dao;

import top.qingrang.many2many.beans.Student;

public interface IStudentDao {
	Student selectStudentById(int sid);
}
