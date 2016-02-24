package com.sysab.client.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sysab.client.dao.UsuarioDao;
import com.sysab.client.model.CaixaDeDialogo;
import com.sysab.client.model.Usuario;
import com.sysab.client.model.Validacao;
import com.sysab.client.view.LoginView;
import com.sysab.client.view.PrincipalView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ValidationController implements Initializable  {
	
	@FXML
	private Label lblSysab;
	@FXML
	private Label lblEmail;
	@FXML
	private ComboBox<String> comboEmail;
	@FXML
	private Label lblSenha;
	@FXML
	private PasswordField passSenha;
	@FXML
	private Button btnLogin;
		
	private ObservableList<String> options;
		
	public void initialize(URL arg0, ResourceBundle arg1) {
		UsuarioDao usuarioDao = new UsuarioDao(); //Instância necessitada porque abre uma conexão no banco, e fecha a cada ação
		List<Usuario> arrayDeUsuario = usuarioDao.getListaDeUsuario();

		for (int i = 0; i < arrayDeUsuario.size(); i++) {
			options = FXCollections.observableArrayList(arrayDeUsuario.get(i).getEmail());
		}

		comboEmail.setItems(options);
	}
		
	public boolean realizeTheValidation() {
		UsuarioDao usuarioDao = new UsuarioDao();
		boolean result = usuarioDao.verificaUsuarioExistencia(new Usuario((String) comboEmail.getValue(), passSenha.getText()));

		if ((passSenha.getText().isEmpty())) {
			CaixaDeDialogo.plotTheErrorAlert("Campos vazios", "Erro de Entrada", "Preencha com seu email e senha").showAndWait();
		} else {
			if (result == false) {
				CaixaDeDialogo.plotTheErrorAlert("Login inválido", "Erro de Entrada", "Email e/ou Senha inválidos!").showAndWait();
				Validacao.setTextFieldNull(passSenha);
			} else {
				try {
					Validacao.setTextFieldNull(passSenha);
					LoginView.getStage().close();
					new PrincipalView();
				} catch (Exception e) {
					throw new RuntimeException("Erro na chamada do método à buscar novo arquivo", e);
				}
			}
		}
		return result;
	}


		
}
