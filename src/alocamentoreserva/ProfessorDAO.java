/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

import conexao.ConexaoException;
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
public class ProfessorDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Professor dto;
    
    Professor usuarioResultado;
    List<Professor> usuarioResultados;
    
    public void inserir(Professor professor) throws conexao.ConexaoException{
        try {
            sql = "insert into professor (nome, codigo_barras) values (?, ?);";
            
            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, professor.nome);
            stmt.setString(2, professor.codigoBarras);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Professor> findAll() throws conexao.ConexaoException{
        try {
            sql = "select * from professor order by id;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
    
    public List<Professor> findLast() throws conexao.ConexaoException{
        try {
            sql = "select * from professor order by id desc limit 1;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
    
    private List<Professor> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Professor> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new Professor();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }
    
    private Professor carregarResultadoSimples(ResultSet rs) throws SQLException{
        if (rs.next()) {
            dto = new Cliente();
            carregarVO(dto, rs);
            
            return dto;
        }else{
            return null;
        }
    }
    
    private void carregarVO(Professor dto, ResultSet rs)throws SQLException{
        dto.id = rs.getInt("id");
        dto.nome = rs.getString("nome");
    }

    public List<Professor> findByCodigoBarras(String codigoDeBarras) {
        try {
            sql = "select * from professor where codigo_barras = ?;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, codigoDeBarras);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } catch (ConexaoException ex) { 
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
