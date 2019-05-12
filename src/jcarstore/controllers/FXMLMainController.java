/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import jcarstore.dao.AdministradorDAO;
import jcarstore.dao.ClienteDAO;
import jcarstore.dao.VeiculoDAO;
import jcarstore.models.Administrador;
import jcarstore.models.Cliente;
import jcarstore.models.Veiculo;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class FXMLMainController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {

        /*Cliente cliente = new Cliente();
        cliente.setCpfCliente(123456);
        cliente.setNomeCliente("Nome Teste");
        Calendar data = new GregorianCalendar();
        data.set(Calendar.YEAR, 1983);
        data.set(Calendar.MONTH, 02);
        data.set(Calendar.DAY_OF_MONTH, 22);
        cliente.setNascimentoCliente(data.getTime());
        cliente.setFotoCliente("caminho/foto.jpg");
        cliente.setEnderecoCliente("Rua Cliente, 41");
        cliente.setEmailCliente("nome.teste@gmail.com");
        cliente.setSenhaCliente("**********");

        Cliente retornoCliente = null;
        ClienteDAO dao = new ClienteDAO();
        retornoCliente = dao.salvar(cliente);
        
        
        Administrador administrador = new Administrador();
        administrador.setNomeAdministrador("SeuCuca");
        administrador.setEmailAdministrador("seucuca@seucukeheu.com");
        administrador.setSenhaAdministrador("cuca");
        

        Administrador retornoAdministrador = null;
        AdministradorDAO dao = new AdministradorDAO();
        retornoAdministrador = dao.salvar(administrador);*/
        
        Veiculo veiculo = new Veiculo();
        veiculo.setModeloVeiculo("Fusca");
        veiculo.setPrecoCusto(8000);
        veiculo.setPrecoVenda(14000);
        
        VeiculoDAO dao = new VeiculoDAO();
        dao.salvar(veiculo);
        
        System.out.println("Registro atualizado com sucesso!");
        label.setText("Registro atualizado com sucesso!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
