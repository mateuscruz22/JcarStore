/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcarstore.controllers;

import com.sun.media.jfxmedia.AudioClip;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jcarstore.dao.VendaDAO;
import jcarstore.models.Venda;

/**
 *
 * @author Mateus Araújo Cruz
 */
public class TelaGerenciarVendasController implements Initializable{

    @FXML
    private TableView<Venda> tabela;
    @FXML
    private TableColumn<Venda, Integer> idVendaCol;
    @FXML
    private TableColumn<Venda, String> nomeClienteCol;
    @FXML
    private TableColumn<Venda, String> modeloVeiculoCol;
    @FXML
    private TableColumn<Venda, String> dataVendaCol;
    @FXML
    private TableColumn<Venda, Float> lucroObtidoCol;
    
    public void preencherTabela() {    
        //tabela.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("idVenda"));
//        VendaDAO vendaDAO = new VendaDAO();
//        List<Venda> lista = vendaDAO.getAll();
//        ObservableList<Venda> lst = FXCollections.observableArrayList(lista);
//        tabela.setItems(lst);
    }
    
    public void iniciaTable(){
        idVendaCol.setCellValueFactory(new PropertyValueFactory("idVenda"));
        tabela.setItems(atualizaTable());
    }

    private ObservableList<Venda> atualizaTable() {
        VendaDAO vendaDAO = new VendaDAO();
        return FXCollections.observableArrayList(vendaDAO.getAll());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaTable();
    }
    
}