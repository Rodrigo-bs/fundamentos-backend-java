package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Especialidade;

public class EspecialidadeDao implements IDao<Especialidade> {
    
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public EspecialidadeDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Especialidade> getAll() {
        List<Especialidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM especialidade";

        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Especialidade e = new Especialidade();
                e.setId(rs.getLong("id"));
                e.setNome(rs.getString("nome"));

                registros.add(e);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    @Override
    public Especialidade getById(Long id) {
        Especialidade registro = new Especialidade();
        String sql = "SELECT * FROM especialidade WHERE id = ?";

        try {
            ps = conexao.prepareStatement(sql);

            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return registro;
    }

    @Override
    public List<Especialidade> getByAll(String termoBusca) {
        return null;
    }

    @Override
    public int insert(Especialidade objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO especialidade (nome) VALUES (?)";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());

            registrosAfetados = ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }

    @Override
    public int update(Especialidade objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE especialidade SET nome = ? WHERE id = ?";

        try {
            ps =  conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setLong(2, objeto.getId());

            registrosAfetados = ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }

    @Override
    public int delete(Long id) {
        int registrosAfetados = 0;
        String sql = "DELETE especialidade WHERE id = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);

            registrosAfetados = ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }


}
