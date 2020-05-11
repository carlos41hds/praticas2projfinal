/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class UsuarioDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Usuario dto;
    
    Usuario usuarioResultado;
    List<Usuario> usuarioResultados;
    
    public void inserir(Usuario usuario) throws conexao.ConexaoException{
        try {
            sql = "insert into usuario (nome) values (?);";
            
            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, usuario.nome);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
