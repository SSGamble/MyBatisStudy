package top.qingrang.crud.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis 工具类
 */
public class MyBatisUtils {

	private static SqlSessionFactory sqlSessionFactory;

	/**
	 * 得到 SqlSession 对象
	 */
	public static SqlSession getSqlSession() {
		try {
			// 1.加载主配置文件
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			if (sqlSessionFactory == null) {
				// 2.创建 SqlSessionFactory 对象
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			}
			// 3.返回 SqlSession 对象
			return sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
