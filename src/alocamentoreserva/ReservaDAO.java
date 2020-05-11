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
public class ReservaDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Reserva dto;
    
    Reserva usuarioResultado;
    List<Reserva> usuarioResultados;
    
    public void inserir(Reserva reserva) throws conexao.ConexaoException{
        try {
            sql = "insert into reserva (data_horario_ini) values (?);";
            
            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String dataHorarioIniString = sdf.format(reserva.dataHorarioIni);
            
            stmt.setString(1, dataHorarioIniString);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
