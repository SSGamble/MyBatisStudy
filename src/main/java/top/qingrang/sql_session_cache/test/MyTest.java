package top.qingrang.sql_session_cache.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;
import top.qingrang.sql_session_cache.beans.Country;
import top.qingrang.sql_session_cache.dao.ICountryDao;
import top.qingrang.sql_session_cache.utils.MyBatisUtils;

public class MyTest {
	private ICountryDao dao;
	private SqlSession sqlSession;

	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}

	// 证明二级缓存是存在的
	// 开启内置的二级缓存步骤：
	// 1）对实体进行序列化
	// 2）在映射文件中添加 <cache/> 标签
	@Test
	public void test01() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(ICountryDao.class);
		Country country = dao.selectCountryById(1);
		System.out.println(country);

		//关闭 sqlSession，一级缓存会刷新
		sqlSession.close();

		//二级缓存会伴随整个生命周期
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(ICountryDao.class);
		Country country2 = dao.selectCountryById(1);
		System.out.println(country2);
	}

	// 本例说明以下几点内容：
	// 1.增删改同样也会清空二级缓存
	// 2.对于二级缓存的清空，实质上是对所查找 key 对应的 value 置为 null，而并非将 <key，value> 对，即 Entry 对象删除
	// 3.从 DB 中进行 select 查询的条件是：
	//   1)缓存中根本就不存在这个 key
	//   2)缓存中存在该 key 所对应的 Entry 对象，但其 value 为 null
	@Test
	public void test02() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(ICountryDao.class);
		Country country = dao.selectCountryById(1);
		System.out.println(country);

		sqlSession.close();

		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(ICountryDao.class);

		dao.insertCountry(new Country("Japan"));

		Country country2 = dao.selectCountryById(1);
		System.out.println(country2);
	}

	@Test
	public void test03() {
		String path = System.getProperty("java.io.tmpdir");
		System.out.println(path);
	}

}






























