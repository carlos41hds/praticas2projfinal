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
public class Professor {
    int id;
    String nome;
    String codigoBarras;

    public String toStringFull() {
        String usuarioString = "";
        
        usuarioString += "Id: " + id + "\n";
        usuarioString += "Nome: " + nome + "\n";
        
        return usuarioString;
    }

    @Override
    public String toString() {
        return nome;
    }
}
