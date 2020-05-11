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
public class AmbienteDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Ambiente dto;
    
    Ambiente usuarioResultado;
    List<Ambiente> usuarioResultados;
    
    public void inserir(Ambiente ambiente) throws conexao.ConexaoException{
        try {
            sql = "insert into ambiente (codigo) values (?);";
            
            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, ambiente.codigo);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
