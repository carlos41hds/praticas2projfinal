/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

import conexao.ConexaoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AlocamentoReserva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        main8();
    }
    
    public static void main7(){
        ReservaDAO reservaDAO = new ReservaDAO();
        try {
            Reserva reserva = reservaDAO.findLastWithUsuario().get(0);
            System.out.println(reserva);
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main8(){
        Usuario usuario = new Usuario();
        usuario.nome = "Kevin";
        System.out.println(usuario.toString());
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.inserir(usuario);
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            usuario = usuarioDAO.findLast().get(0); // recebe uma lista por isso que tem que pegar o 0
            System.out.println(usuario);
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main1(){
        Usuario usuario = new Usuario();
        usuario.nome = "Juliane";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.inserir(usuario);
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main5(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            List<Usuario> usuarios = usuarioDAO.findAll();
            for(Usuario usuario : usuarios){
                System.out.println(usuario.id);
                System.out.println(usuario.nome);
            }
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main2(){
        Ambiente ambiente = new Ambiente();
        ambiente.codigo = "A30";
        AmbienteDAO ambienteDAO = new AmbienteDAO();
        try {
            ambienteDAO.inserir(ambiente);
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main3(){
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
    
        Reserva reserva = new Reserva();
        
        reserva.dataHorarioIni = dt;
        
        ReservaDAO reservaDAO = new ReservaDAO();
        try {
            reservaDAO.inserir(reserva);
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
