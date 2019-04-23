package com.qdu.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    void insert(T t);
    void update(T t);
    void delete(Serializable id);
    T getOneById(Serializable id);
    T getOneByName(Serializable name);

    List<T> getListByQuery(String hql,Object... params);
}
