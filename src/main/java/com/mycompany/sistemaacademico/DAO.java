package com.mycompany.sistemaacademico;

import java.sql.*;

public class DAO {
    
    public boolean existe (Usuario usuario) throws Exception{
       String sql = "SELECT * FROM admin WHERE usuario = ? AND senha = ?";
       try (Connection conn = ConexaoDB.obtemConexao();
               PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setString(1, usuario.getNome());
           ps.setString(2, usuario.getSenha());
           try (ResultSet rs = ps.executeQuery()){
               return rs.next();
           }
       }
    }
    
    public void inserirpaciente(String cpf, String nome, String email, String telefone, String nascimento){
        //1: Definir o comando SQL
        String sql = "INSERT INTO paciente(CPF, nome, email, telefone, nascimento) VALUES (?,?,?,?,?)";
        //2: Abrir uma conexão
        try (Connection conn = ConexaoDB.obtemConexao();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cpf);
            ps.setString(2, nome);
            ps.setString(3, email);
            ps.setString(4, telefone);
            ps.setString(5, nascimento);
            //5: Executa o comando
            ps.execute();
        }
        catch (SQLException e){
            
        }
    }
    public void atentimento(String cpf, String nome, String diagnostico, String atendimentoData){
        //1: Definir o comando SQL
        String sql = "INSERT INTO paciente(CPF, nome, diagnostico, atendimentoData) VALUES (?,?,?,?)";
        //2: Abrir uma conexão
        try (Connection conn = ConexaoDB.obtemConexao();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, cpf);
            ps.setString(2, nome);
            ps.setString(3, diagnostico);
            ps.setString(4, atendimentoData);
        //5: Executa o comando
            ps.execute();
        }
        catch (SQLException e){
            
        }
    }

    
}

