
package com.restaurant.common;

import java.util.List;

public interface ICommonInterface<T> {
    public int save(T t);
    public int update(T t);
    public int delete(T t);
    public T getByID(int id);
    public List<T>getAll();
}
