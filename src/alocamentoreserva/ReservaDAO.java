/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
            //sql = "insert into reserva (data_horario_ini) values (?);";
            sql = "insert into reserva (data_horario_ini, usuario_id) values (?, ?);";
            
            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String dataHorarioIniString = sdf.format(reserva.dataHorarioIni);
            
            stmt.setString(1, dataHorarioIniString);
            
            stmt.setInt(2, reserva.usuario.id);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Professor> findAll() throws conexao.ConexaoException{
        try {
            sql = "select * from usuario order by id;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
    
    public List<Reserva> findLastWithUsuario() throws conexao.ConexaoException{
        try {
            sql = "select reserva.id, reserva.data_horario_ini, reserva.data_horario_fim, usuario.id, usuario.nome"
                + " from reserva inner join usuario on reserva.id = usuario.id order by reserva.id desc limit 1;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
    
    private List<Reserva> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Reserva> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new Reserva();
            carregarVOWithUsuario(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private void carregarVO(Professor dto, ResultSet rs)throws SQLException{
        dto.id = rs.getInt("id");
        dto.nome = rs.getString("nome");
    }
    
    private void carregarVOWithUsuario(Reserva dto, ResultSet rs)throws SQLException{
        dto.id = rs.getInt("reserva.id");
        Date dataUtil = new java.util.Date(rs.getDate("reserva.data_horario_ini").getTime());
        dto.dataHorarioIni = dataUtil;
        dto.usuario = new Professor();
        dto.usuario.id = rs.getInt("usuario.id");
        dto.usuario.nome = rs.getString("usuario.nome");
    }
}
