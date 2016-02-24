package com.sysab.client.controller;

import com.sysab.client.view.LoginView;
import com.sysab.client.view.PrincipalView;
import com.sysab.client.view.RegisterView;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class PrincipalController {
	
	@FXML
	private MenuItem cadastroCliente;
	@FXML
	private MenuItem cadastroPedido;
	@FXML
	private MenuItem cadastroSabor;
	@FXML
	private MenuItem editaCliente;
	@FXML
	private MenuItem editaPedido;
	@FXML
	private MenuItem excluiCadastro;
	@FXML
	private MenuItem excluiPedido;
	@FXML
	private MenuItem buscaCliente;
	@FXML
	private MenuItem buscaPedido;
	@FXML
	private MenuItem buscaSabor;
	@FXML
	private MenuItem pedidoPendente;	
	@FXML
	private MenuItem cadastroUsuario;
	@FXML
	private MenuItem newPromo;
	@FXML
	private MenuItem info;
	@FXML
	private MenuItem logoff;
	@FXML
	private MenuItem exitSystem;
	
	public void redirecionaParaTelaDeCadastro() {
		new RegisterView();
	}
	
	public void efetuaLogoff() {
		PrincipalView.getStage().close();
		LoginView.getStage().show();
	}
	
	public void encerraSistema() {
		System.exit(0);
	}
	
}
