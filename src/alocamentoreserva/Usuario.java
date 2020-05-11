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
public class Usuario {
    int id;
    String nome;

    @Override
    public String toString() {
        String usuarioString = "";
        
        usuarioString += "Id: " + id + "\n";
        usuarioString += "Nome: " + nome + "\n";
        
        return usuarioString;
    }
    
    
}
