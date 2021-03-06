package br.ufac.sgcm.controller;

import java.sql.SQLException;
import java.util.List;

import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.model.Profissional;

public class ProfissionalController implements IController<Profissional> {

    private ProfissionalDao dao;

    public ProfissionalController() {
        dao = new ProfissionalDao();
    }

    @Override
    public List<Profissional> getAll() throws SQLException {
        return dao.getAll();
    }

    @Override
    public Profissional getById(Long id) throws SQLException {
        return dao.getById(id);
    }

    @Override
    public List<Profissional> getByAll(String termoBusca) {
        return dao.getByAll(termoBusca);
    }

    @Override
    public int save(Profissional objeto) throws SQLException {
        int registrosAfetados = 0;

        if (objeto.getId() == null) {
            registrosAfetados = dao.insert(objeto);
        } else {
            registrosAfetados = dao.update(objeto);
        }

        return registrosAfetados;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return dao.delete(id);
    }
    
}
