package top.qingrang.sql_session_cache.dao;

import top.qingrang.sql_session_cache.beans.Country;

public interface ICountryDao {
	void insertCountry(Country country);

	Country selectCountryById(int id);
	Country selectCountryById2(int id);
}
