package com.sysab.client.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import com.sysab.client.dao.PessoaDao;
import com.sysab.client.model.CaixaDeDialogo;
import com.sysab.client.model.Pessoa;
import com.sysab.client.model.Validacao;
import com.sysab.client.view.RegisterView;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.NumberTextField;
import javafx.scene.control.TextField;
import javafx.scene.control.WordTextField;


public class RegisterController {
	
	@FXML
	private Label lblCadastro;
	@FXML
	private CheckBox checkPessoaFisica;
	@FXML
	private CheckBox checkPessoaJuridica;
	@FXML
	private Label lblNome;
	@FXML
	private WordTextField txtNome;
	@FXML
	private Label lblCpf;
	@FXML
	private NumberTextField txtCpf;
	@FXML
	private Label lblRg;
	@FXML
	private NumberTextField txtRg;
	@FXML
	private Label lblRazaoSocial;
	@FXML
	private TextField txtRazaoSocial;
	@FXML
	private Label lblFantasia;
	@FXML
	private CheckBox checkTrue;
	@FXML
	private CheckBox checkFalse;
	@FXML
	private TextField txtFantasia;
	@FXML
	private Label lblCnpj;
	@FXML
	private NumberTextField txtCnpj;
	@FXML
	private Label lblLogradouro;
	@FXML
	private TextField txtLogradouro;
	@FXML
	private Label lblNumero;
	@FXML
	private NumberTextField txtNumero;
	@FXML
	private Label lblComplemento;
	@FXML
	private TextField txtComplemento;
	@FXML
	private Label lblBairro;
	@FXML
	private TextField txtBairro;
	@FXML
	private Label lblCep;
	@FXML
	private NumberTextField txtCep;
	@FXML
	private Label lblTelefone;
	@FXML
	private NumberTextField txtTelefone;
	@FXML
	private Label lblCelular;
	@FXML
	private NumberTextField txtCelular;
	@FXML
	private Label lblEmail;
	@FXML
	private TextField txtEmail;
	@FXML
	private CheckBox checkMasculino;
	@FXML
	private CheckBox checkFeminino;
	@FXML
	private Label lblDataDeNascimento;
	@FXML
	private DatePicker datePickerDataDeNascimento;
	@FXML
	private Label lblDataCadastro;
	@FXML
	private DatePicker datePickerDataCadastro;
	@FXML
	private Label lblFidelidade;
	@FXML
	private TextField txtFidelidade;
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnCancelar;
	
	
	public void verifyFieldsPrimaryOfPessoa() {
		Validacao.verifyOneCheckBox(checkPessoaFisica, checkPessoaJuridica);
		Validacao.setTextFieldDisable(false, txtNome, txtCpf, txtRg);
		Validacao.setTextFieldDisable(true, txtRazaoSocial, txtCnpj);
		Validacao.setCheckBoxDisable(true, checkTrue, checkFalse);
		Validacao.setCheckBoxDisable(false, checkMasculino, checkFeminino);
		Validacao.verifyOneCheckBox(checkMasculino, checkFeminino);
		datePickerDataDeNascimento.setDisable(false);
		Validacao.setTextFieldNull(txtRazaoSocial, txtCnpj, txtFantasia);
	}
	
	public void verifyFieldsSecondaryOfPessoa() {
		Validacao.verifyOneCheckBox(checkPessoaJuridica, checkPessoaFisica);
		Validacao.setTextFieldDisable(false, txtRazaoSocial, txtCnpj);
		Validacao.setTextFieldDisable(true, txtNome, txtCpf, txtRg);
		Validacao.setCheckBoxDisable(true, checkMasculino, checkFeminino);
		Validacao.setCheckBoxDisable(false, checkTrue, checkFalse);
		datePickerDataDeNascimento.setDisable(true);
		datePickerDataDeNascimento.setValue(null);
		Validacao.setTextFieldNull(txtNome, txtCpf, txtRg);
	}
	
	public void verifyFieldsPrimaryOfGenero() {
		Validacao.verifyOneCheckBox(checkMasculino, checkFeminino);
	}
	
	public void verifyFieldsSecondaryOfGenero() {
		Validacao.verifyOneCheckBox(checkFeminino, checkMasculino);
	}
	
	public void verifyFieldsPrimaryOfBool() {
		Validacao.verifyOneCheckBox(checkTrue, checkFalse);
		Validacao.setTextFieldDisable(false, txtFantasia);
	}
	
	public void verifyFieldsSecondaryOfBool() {
		Validacao.verifyOneCheckBox(checkFalse, checkTrue);
		Validacao.setTextFieldDisable(true, txtFantasia);
	}	
		
	public String getCheckPessoa() {
		if (checkPessoaJuridica.isSelected()) {
			return "juridica";
		} else {
			return "fisica";
		}
	}
	
	public String getCheckGenero() {
		if (checkFeminino.isSelected()) {
			return "feminino";
		} else {
			return "masculino";
		}
	}
	
	public void realizeTheRegistration() {
		Calendar cal = null;
		Calendar calendar = cal.getInstance();
		Calendar calendar2 = cal.getInstance();
		
		Pessoa pessoa = new Pessoa(getCheckPessoa(), txtNome.getText(), txtCpf.getText(), txtRg.getText(),
				txtRazaoSocial.getText(), txtFantasia.getText(), txtCnpj.getText(), txtLogradouro.getText(),
				txtNumero.getText(), txtComplemento.getText(), txtBairro.getText(), txtCep.getText(),
				txtTelefone.getText(), txtCelular.getText(), txtEmail.getText(), getCheckGenero(), calendar, calendar2);
		
		PessoaDao pessoaDao = new PessoaDao();
		
		if (!(Validacao.isDatePickerNull(datePickerDataCadastro))) {
			calendar2.setTime(convertToDate(datePickerDataCadastro));
		}
		
		
		if (getCheckPessoa() == "fisica") {
			if (!(Validacao.isDatePickerNull(datePickerDataDeNascimento))) {
				calendar.setTime(convertToDate(datePickerDataDeNascimento));
			}
			
			if (!(Validacao.isItNull(txtNome, txtCpf, txtRg, txtTelefone, txtLogradouro, txtNumero)
					&& !(datePickerDataDeNascimento == null) && !(datePickerDataCadastro == null))) {
				pessoaDao.adicionaPessoa(pessoa);
				CaixaDeDialogo.plotTheConfirmAlert("Cadastro de Pessoa Física", "Realizado com sucesso!", 
						"O cadastro de clientes (pessoa física) foi realizado com sucesso!").showAndWait();
				RegisterView.getStage().close();
			} else {
				CaixaDeDialogo.plotTheErrorAlert("Erro na tentativa de Cadastro", "Campos nulos",
						"Existem campos obrigatórios que necessitam de preenchimento: "
						+ "Nome, CPF, RG, Telefone, Logradouro, Número, Data de Nascimento, Data de Cadastro.").showAndWait();
			}
		} else {
			if (getCheckPessoa() == "juridica") {
				
				if (!(Validacao.isItNull(txtRazaoSocial, txtCnpj, txtTelefone, txtLogradouro, txtNumero)) && !(datePickerDataCadastro == null)) {
					pessoaDao.adicionaPessoa(pessoa);
					CaixaDeDialogo.plotTheConfirmAlert("Cadastro de Pessoa Jurídica", "Realizado com sucesso!", 
							"O cadastro de clientes (pessoa jurídica) foi realizado com sucesso!").showAndWait();
					RegisterView.getStage().close();
				} else {
					CaixaDeDialogo.plotTheErrorAlert("Erro na tentativa de Cadastro", "Campos nulos",
							"Existem campos obrigatórios que necessitam de preenchimento: "
									+ "Razão Social, Cnpj, Telefone, Logradouro, Número, Data de Cadastro.").showAndWait();
				}
				
			}
		}
	}
	
	public Date convertToDate(DatePicker datePicker) {
		LocalDate localDate = datePicker.getValue(); //DatePicker getValue retorna um Local Date
		Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant(); //Linha a ser explicada
		Date date = Date.from(instant); //Converte instant para date
		return date;
	}
					
}
	
	
	

	

	
	
