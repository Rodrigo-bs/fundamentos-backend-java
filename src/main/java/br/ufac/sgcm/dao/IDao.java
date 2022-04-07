package br.ufac.sgcm.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    
    List<T> getAll() throws SQLException;
    T getById(Long id) throws SQLException;
    List<T> getByAll(String termoBusca);

    int insert(T objeto) throws SQLException;
    int update(T objeto) throws SQLException;
    int delete(Long id) throws SQLException;
}
