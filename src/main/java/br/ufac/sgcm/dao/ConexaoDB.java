package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static ConexaoDB instanciaConexaoDB;
    private Connection conexao;

    private ConexaoDB() {

        String url = "jdbc:mysql://localhost/sgcm";
        String usuario = "root";
        String senha = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static Connection getConexao() {
        if (instanciaConexaoDB == null) {
            instanciaConexaoDB = new ConexaoDB();
        }

        return instanciaConexaoDB.conexao;
    }

}
