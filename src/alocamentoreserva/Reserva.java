/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alocamentoreserva;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Reserva {
    int id;
    
    Date dataHorarioIni;
    Date dataHorarioFim;
    
    Usuario usuario;
    Ambiente ambiente;

    // TODO: Implementar ambiente
    @Override
    public String toString() {
        String reservaString = "";
        
        reservaString += "Id: " + id + "\n";
        if(dataHorarioIni != null)
            reservaString += "Data-horário inicial: " + dataHorarioIni.toString() + "\n";
        if(dataHorarioFim != null)
            reservaString += "Data-horário final: " + dataHorarioFim.toString() + "\n";
        reservaString += "Usuario: " + "\n";
        reservaString += usuario.toString();
        
        return reservaString;
    }
    
    
}