/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

/**
 *
 * @author admin
 */
public class Administrador {
    private static Administrador _administrador = null;
    private static Administrador _administradorTemp = null;
    
    int id;
    
    String nome;
    String nomeDeUsuario;
    String senha;
    
    private Administrador(){}
    
    public static Administrador getInstance(){
        if(_administrador == null){
            _administrador = new Administrador();
        }
        
        return _administrador;
    }
    
    public static void setInstance(Administrador administrador){
        _administrador = administrador;
    }
    
    public static Administrador getInstanceTemp(){
        if(_administradorTemp == null){
            _administradorTemp = new Administrador();
        }
        
        return _administradorTemp;
    }
    
    public static void setInstanceTemp(Administrador administradorTemp){
        _administradorTemp = administradorTemp;
    }
}
