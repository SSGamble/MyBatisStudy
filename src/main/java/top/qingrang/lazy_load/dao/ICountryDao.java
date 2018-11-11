package top.qingrang.lazy_load.dao;

import top.qingrang.lazy_load.beans.Country;

public interface ICountryDao {
	Country selectCountryById(int cid);
}
