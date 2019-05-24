/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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

        Cliente cliente = new Cliente();
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
        
        //LIST ALL
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes = dao.getAll();
        for (Cliente c : listaClientes) {
            System.out.println(c.getNomeCliente());
        }

        //UPDATE
        /*ClienteDAO dao = new ClienteDAO();
        Cliente updateCliente = dao.getObjectById(68);
        updateCliente.setNomeCliente("Novo Nome");
        
        if (dao.update(updateCliente)) {
            label.setText("Atualizado com sucesso!");
        } else {
            label.setText("Não foi possível atualizar!");
        }*/

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
