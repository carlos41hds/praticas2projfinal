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
    public static Administrador logado;
    
    int id;
    
    String nome;
    String nomeDeUsuario;
    String senha;

    @Override
    public String toString() {
        return nome;
    }
    
    public String toStringFull(){
        String stringReturn = "";
        
        stringReturn += "Nome: " + nome + "\n";
        stringReturn += "Nome de usuário" + nomeDeUsuario + "\n";
        stringReturn += "Senha" + senha + "\n";
        
        return stringReturn;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Administrador administradorClone = new Administrador();
        administradorClone.nome = this.nome;
        administradorClone.nomeDeUsuario = this.nomeDeUsuario;
        administradorClone.senha = this.senha;
        return administradorClone;
    }
}
