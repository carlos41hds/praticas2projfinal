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
            sql = "insert into ambiente (codigo, codigo_barras) values (?, ?);";
            
            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, ambiente.codigo);
            stmt.setString(2, ambiente.codigoBarras);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ambiente> findLast() throws conexao.ConexaoException{
        try {
            sql = "select * from ambiente order by id desc limit 1;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
    
    private List<Ambiente> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Ambiente> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new Ambiente();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private void carregarVO(Ambiente dto, ResultSet rs)throws SQLException{
        dto.id = rs.getInt("id");
        dto.codigo = rs.getString("codigo");
        dto.codigoBarras = rs.getString("codigo_barras");
    }

    public List<Ambiente> findByCodigoBarras(String codigoDeBarras) {
        try {
            sql = "select * from ambiente where codigo_barras = ?;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, codigoDeBarras);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } catch (conexao.ConexaoException ex) { 
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
}
