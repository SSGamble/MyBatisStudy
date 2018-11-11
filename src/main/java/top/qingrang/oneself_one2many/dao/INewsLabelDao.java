package top.qingrang.oneself_one2many.dao;

import top.qingrang.oneself_one2many.beans.NewsLabel;

import java.util.List;


public interface INewsLabelDao {
	List<NewsLabel> selectChildrenByParent(int pid);
}
