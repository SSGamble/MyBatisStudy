package top.qingrang.manytoone.dao;

import top.qingrang.manytoone.beans.Minister;

public interface IMinisterDao {
	Minister selectMinisterById(int mid);
}
