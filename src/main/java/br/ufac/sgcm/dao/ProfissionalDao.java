package br.ufac.sgcm.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.spi.RegisterableService;

import br.ufac.sgcm.model.Profissional;

public class ProfissionalDao implements IDao<Profissional> {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    private EspecialidadeDao especialidadeDao;
    private UnidadeDao unidadeDao;

    public ProfissionalDao() {
        conexao = ConexaoDB.getConexao();
        especialidadeDao = new EspecialidadeDao();
        unidadeDao = new UnidadeDao();
    }

    @Override
    public List<Profissional> getAll() {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional";

        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setRegistroConselho(rs.getString("registro_conselho"));
                registro.setEspecialidade(especialidadeDao.getById(rs.getLong("especialidade_id")));
                registro.setUnidade(unidadeDao.getById(rs.getLong("unidade_id")));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));

                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    @Override
    public Profissional getById(Long id) {
        Profissional registro = new Profissional();
        String sql = "SELECT * FROM profissional WHERE id = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setRegistroConselho(rs.getString("registro_conselho"));
                registro.setEspecialidade(especialidadeDao.getById(rs.getLong("especialidade_id")));
                registro.setUnidade(unidadeDao.getById(rs.getLong("unidade_id")));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return registro;
    }

    @Override
    public List<Profissional> getByAll(String termoBusca) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO profissional (nome, registro_conselho, especialidade_id, unidade_id, telefone, email) VALUES (?,?,?,?,?,?)";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getRegistroConselho());
            ps.setLong(3, objeto.getEspecialidade().getId());
            ps.setLong(4, objeto.getUnidade().getId());
            ps.setString(5, objeto.getTelefone());
            ps.setString(6, objeto.getEmail());
            
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }

    @Override
    public int update(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE profissional SET nome = ?, registro_conselho = ?, especialidade_id = ?, unidade_id = ?, telefone = ?, email = ? WHERE id = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getRegistroConselho());
            ps.setLong(3, objeto.getEspecialidade().getId());
            ps.setLong(4, objeto.getUnidade().getId());
            ps.setString(5, objeto.getTelefone());
            ps.setString(6, objeto.getEmail());
            ps.setLong(7, objeto.getId());

            registrosAfetados = ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }

    @Override
    public int delete(Long id) {
        int registrosAfetados = 0;
        String sql = "DELETE profissional WHERE id = ?";

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
