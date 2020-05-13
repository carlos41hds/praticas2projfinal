/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

import conexao.ConexaoException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class AdministradorDAO {
    String sql;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    Administrador dto;
    
    Administrador usuarioResultado;
    List<Administrador> usuarioResultados;
    
    public void inserir(Administrador administrador) throws conexao.ConexaoException{
        try {
            sql = "insert into administrador (nome, nome_de_usuario, senha_hash) values (?, ?, ?);";
            
            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, administrador.nome);
            stmt.setString(2, administrador.nomeDeUsuario);
            
            try {
                MessageDigest m = MessageDigest.getInstance("MD5");
                byte message[] = m.digest(administrador.senha.getBytes("UTF-8"));
                String messageDString = new String(message, "UTF-8");
                System.out.println(messageDString);
                stmt.setString(3, messageDString);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Administrador> findByUsernameAndPassword(String nomeDeUsuario, String senha){
        try {
            sql = "select * from administrador where nome_de_usuario = ? and senha_hash = ? order by id;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setString(1, nomeDeUsuario);
            
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte message[] = m.digest(senha.getBytes("UTF-8"));
            String messageDString = new String(message, "UTF-8");
            System.out.println(messageDString);
            
            stmt.setString(2, messageDString);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } catch (ConexaoException ex) { 
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    
    public List<Administrador> findAll() throws conexao.ConexaoException{
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
    
    public List<Administrador> findLast() throws conexao.ConexaoException{
        try {
            sql = "select * from usuario order by id desc limit 1;";

            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        } 
        
        return null;
    }
    
    private List<Administrador> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Administrador> resultList = new ArrayList<>();
        while (rs.next()) {
            dto = new Administrador();
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
    
    private void carregarVO(Administrador dto, ResultSet rs)throws SQLException{
        dto.id = rs.getInt("id");
        dto.nome = rs.getString("nome");
//        dto.nomeDeUsuario = rs.getString("nome_de_usuario");
//        dto.senha = rs.getString("senha_hash");
    }

    // será que precisa desses 2 parametros?
    void alterar(Administrador administradorLogado, Administrador administradorClone) {
        try {
            sql = "update administrador set nome = ?, senha_hash = ?, nome_de_usuario = ? where id = ?;";
            
            stmt = conexao.Conexao.getCon().prepareStatement(sql);
            
            stmt.setInt(4, administradorLogado.id);
            
            stmt.setString(1, administradorClone.nome);
            stmt.setString(3, administradorClone.nomeDeUsuario);
            
            try {
                MessageDigest m = MessageDigest.getInstance("MD5");
                byte message[] = m.digest(administradorClone.senha.getBytes("UTF-8"));
                String messageDString = new String(message, "UTF-8");
                System.out.println(messageDString);
                stmt.setString(2, messageDString);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConexaoException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
