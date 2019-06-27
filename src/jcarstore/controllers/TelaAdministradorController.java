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
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class TelaAdministradorController implements Initializable {

    @FXML
    private AnchorPane pnlListarVendas;
    @FXML
    private Button btnGerenciarVendas;
    @FXML
    private Button btnGerenciarVeiculos;
    /**
     * Initializes the controller class.
     */

    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    private void showListarVendas(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/jcarstore/views/tela_gerenciar_vendas.fxml"));

        AnchorPane pnl = (AnchorPane) loader.load();

        AnchorPane.setTopAnchor(pnl, 0.0);
        AnchorPane.setLeftAnchor(pnl, 0.0);
        AnchorPane.setRightAnchor(pnl, 0.0);
        AnchorPane.setBottomAnchor(pnl, 0.0);

        pnlListarVendas.getChildren().setAll(pnl);

    }

    @FXML
    private void btnGerenciarVendasClick(ActionEvent event) throws IOException {
        this.showListarVendas(event);
    }
}