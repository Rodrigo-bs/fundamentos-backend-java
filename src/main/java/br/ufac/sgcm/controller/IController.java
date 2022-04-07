package br.ufac.sgcm.controller;

import java.util.List;

public interface IController<T> {
    
    List<T> getAll();
    T getById(Long id);
    List<T> getByAll(String termoBusca);

    int save(T objeto);
    int delete(Long id);

}
