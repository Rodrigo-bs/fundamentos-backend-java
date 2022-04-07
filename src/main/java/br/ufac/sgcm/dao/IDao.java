package br.ufac.sgcm.dao;

import java.util.List;

public interface IDao<T> {
    
    List<T> getAll();
    T getById(Long id);
    List<T> getByAll(String termoBusca);

    int insert(T objeto);
    int update(T objeto);
    int delete(Long id);
}
