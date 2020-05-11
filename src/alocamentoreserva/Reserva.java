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
}