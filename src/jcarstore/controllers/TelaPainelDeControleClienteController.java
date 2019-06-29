/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import jcarstore.models.Session;

/**
 * FXML Controller class
 *
 * @author Luiz
 */
public class TelaPainelDeControleClienteController implements Initializable {

    @FXML
    private Button btnListarVeiculos;
    @FXML
    private Button btnAlteraDados;
    @FXML
    private AnchorPane anchorPane;
    private Text txtBemVindo;
    @FXML
    private Label lblMensagemEntrada;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblMensagemEntrada.setText("Bem Vindo ao JcarStore, " + Session.getSessionCliente().getNomeCliente());
    }    

    @FXML
    private void show_listaVeliculo(ActionEvent event) throws IOException {
       
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/jcarstore/views/lista_de_compras.fxml"));
        AnchorPane pn1 = (AnchorPane)loader.load();
        AnchorPane.setBottomAnchor(pn1, 0.0);
        AnchorPane.setLeftAnchor(pn1, 0.0);
        AnchorPane.setRightAnchor(pn1, 0.0);
        AnchorPane.setTopAnchor(pn1, 0.0);
        
        anchorPane.getChildren().setAll(pn1);
        
    }

    @FXML
    private void show_alteraDados(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/jcarstore/views/alterar_dados_cliente.fxml"));
        AnchorPane pn1 = (AnchorPane)loader.load();
        AnchorPane.setBottomAnchor(pn1, 0.0);
        AnchorPane.setLeftAnchor(pn1, 0.0);
        AnchorPane.setRightAnchor(pn1, 0.0);
        AnchorPane.setTopAnchor(pn1, 0.0);
        
        anchorPane.getChildren().setAll(pn1);
    }

    
    
}
