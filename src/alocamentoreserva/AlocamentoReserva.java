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
        main11();
    }
    
    public static void main11(){
        AdministradorDAO administradorDAO = new AdministradorDAO();
        List<Administrador> administradors = administradorDAO.findByUsernameAndPassword("carloshenrique222", "123123qwqw");
        if(administradors.size() == 1){
            System.out.println("Sucesso!");
        } else {
            System.out.println("ERRO!");
        }
    }
    
    public static void main10(){
        Administrador administrador = new Administrador();
        
        administrador.nome = "Carlos Henrique Labatut da Silva";
        administrador.nomeDeUsuario = "carloshenrique222";
        administrador.senha = "123123qwqw";
        
        AdministradorDAO administradorDAO = new AdministradorDAO();
        try {
            administradorDAO.inserir(administrador);
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main9(){
        JanelaPrincipal jp = new JanelaPrincipal();
        jp.setVisible(true);
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
        Professor usuario = new Professor();
        usuario.nome = "Kevin";
        System.out.println(usuario.toString());
        ProfessorDAO usuarioDAO = new ProfessorDAO();
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
        Professor usuario = new Professor();
        usuario.nome = "Juliane";
        ProfessorDAO usuarioDAO = new ProfessorDAO();
        try {
            usuarioDAO.inserir(usuario);
        } catch (ConexaoException ex) {
            Logger.getLogger(AlocamentoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main5(){
        ProfessorDAO usuarioDAO = new ProfessorDAO();
        try {
            List<Professor> usuarios = usuarioDAO.findAll();
            for(Professor usuario : usuarios){
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
