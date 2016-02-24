package br.com.caelum.view;

import br.com.caelum.dao.UsuarioDao;
import br.com.caelum.modelo.Usuario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewCadastro extends Application implements EventHandler<ActionEvent> {

	public static void main(String[] args) {
		launch();
	}
	
	Stage primaryStage = new Stage();
	Label lblTitulo = new Label("Cadastro de Usuários");
	Label lblNome = new Label("Nome: ");
	TextField txtNome = new TextField();
	Label lblEmail = new Label("Email: ");
	TextField txtEmail = new TextField();
	Label lblTelefone = new Label("Telefone: ");
	TextField txtTelefone = new TextField();
	Label lblCpf = new Label("CPF: ");
	TextField txtCpf = new TextField();
	Label lblRG = new Label("RG: ");
	TextField txtRG = new TextField();
	Label lblLogin = new Label("Login: ");
	TextField txtLogin = new TextField();
	Label lblSenha = new Label("Senha: ");
	PasswordField txtSenha = new PasswordField();
	Label lblSenhaConfirm = new Label("Confirma senha: ");
	PasswordField txtSenhaConfirm = new PasswordField();
	Button btnCadastroConfirm = new Button("Confirmar");
	Button btnCadastroFechar = new Button("Fechar");
	
	public void start(Stage palco) throws Exception {
			VBox raiz = new VBox();
			raiz.setTranslateX(20);
			raiz.setTranslateY(30);
			
			HBox hTitulo = new HBox();
			lblTitulo.setUnderline(true);
			hTitulo.getChildren().addAll(lblTitulo);
			
			HBox hNome = new HBox(10); //spacing in parenthesis
			hNome.getChildren().addAll(lblNome, txtNome);
			
			HBox hEmail = new HBox(10);
			hEmail.getChildren().addAll(lblEmail, txtEmail);
			
			HBox hTelefone = new HBox(10);
			hTelefone.getChildren().addAll(lblTelefone, txtTelefone);
			
			HBox hCpf = new HBox(10);
			hCpf.getChildren().addAll(lblCpf, txtCpf);
			
			HBox hRG = new HBox(10);
			hRG.getChildren().addAll(lblRG, txtRG);
			
			HBox hLogin = new HBox(10);
			hLogin.getChildren().addAll(lblLogin, txtLogin);
			
			HBox hSenha = new HBox(10);
			hSenha.getChildren().addAll(lblSenha, txtSenha);
			
			HBox hSenhaConfirm = new HBox(10);
			hSenhaConfirm.getChildren().addAll(lblSenhaConfirm, txtSenhaConfirm);
			
			HBox hCadastroConfirm = new HBox(10);			
			btnCadastroConfirm.setOnAction(this);
			btnCadastroFechar.setOnAction(new EventHandler() {


				public void handle(Event evento) {
					primaryStage.close();
				}
				
			});
			
			hCadastroConfirm.getChildren().addAll(btnCadastroConfirm, btnCadastroFechar);
			
			
			VBox vTitulo = new VBox(10);
			vTitulo.setTranslateX(10);
			vTitulo.setTranslateY(10);
			vTitulo.getChildren().add(hTitulo);
			
			VBox vNome = new VBox(10);
			vNome.setTranslateX(48);
			vNome.setTranslateY(20);
			vNome.getChildren().add(hNome);
			
			VBox vEmail = new VBox(10);
			vEmail.setTranslateX(51);
			vEmail.setTranslateY(30);
			vEmail.getChildren().add(hEmail);
			
			VBox vTelefone = new VBox(10);
			vTelefone.setTranslateX(35);
			vTelefone.setTranslateY(40);
			vTelefone.getChildren().add(hTelefone);
			
			VBox vCpf = new VBox(10);
			vCpf.setTranslateX(60);
			vCpf.setTranslateY(50);
			vCpf.getChildren().add(hCpf);
			
			VBox vRG = new VBox(10);
			vRG.setTranslateX(65);
			vRG.setTranslateY(60);
			vRG.getChildren().add(hRG);
			
			VBox vLogin = new VBox(10);
			vLogin.setTranslateX(51);
			vLogin.setTranslateY(70);
			vLogin.getChildren().add(hLogin);
			
			VBox vSenha = new VBox(10);
			vSenha.setTranslateX(49);
			vSenha.setTranslateY(80);
			vSenha.getChildren().add(hSenha);
			
			VBox vSenhaConfirm= new VBox(10);
			vSenhaConfirm.setTranslateY(90);
			vSenhaConfirm.getChildren().add(hSenhaConfirm);
			
			VBox vCadastroConfirm = new VBox(10);
			vCadastroConfirm.setTranslateX(70);
			vCadastroConfirm.setTranslateY(110);
			vCadastroConfirm.getChildren().add(hCadastroConfirm);
			
			raiz.getChildren().addAll(vTitulo, vNome, vEmail, vTelefone, vCpf, vRG, vLogin, vSenha, vSenhaConfirm, vCadastroConfirm);
			
			//Cenário
			this.primaryStage = palco;
			Scene scene = new Scene(raiz, 300, 400);
			primaryStage.setTitle("Tela de Cadastro");
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public Stage getStage() {
		return primaryStage;
	}
	
	public void handle(ActionEvent evento) {
		Usuario usuario = new Usuario(txtNome.getText(), txtEmail.getText(), txtTelefone.getText(), txtCpf.getText(), 
				txtRG.getText(), txtLogin.getText(), txtSenha.getText());
		
		UsuarioDao usuarioDao = new UsuarioDao();
		

		
			if (usuarioDao.cadastraUsuario(usuario) == true) {
				Alert alerta = new Alert(AlertType.CONFIRMATION);
				alerta.setTitle("Cadastro");
				alerta.setHeaderText("Sucesso");
				alerta.setContentText("O cadastro foi realizado com sucesso!");
				alerta.showAndWait();
				if (!alerta.isShowing()) {
					primaryStage.close();
				}
			}
		

		
	}


	
}
