package br.ufac.sgcm.controller;

import java.sql.SQLException;
import java.util.List;

public interface IController<T> {
    
    List<T> getAll() throws SQLException;
    T getById(Long id) throws SQLException;
    List<T> getByAll(String termoBusca);

    int save(T objeto) throws SQLException;
    int delete(Long id) throws SQLException;

}
