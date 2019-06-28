/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.models;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class Session {
    
    private static Cliente sessionCliente;

    public static Cliente getSessionCliente() {
        return sessionCliente;
    }

    public static void setSessionCliente(Cliente sessionCliente) {
        Session.sessionCliente = sessionCliente;
    }
    
    
}
