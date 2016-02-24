package br.com.caelum.view;

import br.com.caelum.controller.TratadorDeEventoCadastro;
import br.com.caelum.dao.UsuarioDao;
import br.com.caelum.modelo.Usuario;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewLogin extends Application implements EventHandler {
	public static void main(String[] args) {
		launch(); //Para iniciar minha aplicação JavaFX
	}
	
	TextField txt = new TextField();

	Label lbl = new Label("Login: ");
	
	PasswordField password = new PasswordField();
	Label lblPass = new Label("Senha: ");
	
	Button confirm = new Button("Logar");
	Button exit = new Button("Fechar");
	
	Stage primaryStage = new Stage();
	
	public void start(Stage primaryStage) throws Exception {
		//StackPane raiz = new StackPane(); //Permite adicionar diversos elementos que tenham layout de pilha, organiza um sobre o outro
		
		VBox raiz = new VBox(); //Organiza como se fosse uma lista vertical - VERTICAL BOX GERAL
		raiz.setTranslateX(30); //Espaçamento na Horizontal
		raiz.setTranslateY(20); //Dá um espaçamento em Vertical
		
		Label tituloDoSistema = new Label("Junique System");
		tituloDoSistema.setUnderline(true);
		
		HBox titulo = new HBox(10);
		titulo.getChildren().add(tituloDoSistema);
		
		HBox hLogin = new HBox(10);
		hLogin.setTranslateY(10);
		hLogin.getChildren().addAll(lbl, txt); //Nós precisamos dizer que o lbl (Label) é filho da raiz (StackPane)
		
		
		
		
		HBox hSenha = new HBox(7);
		hSenha.setTranslateY(10);
		hSenha.getChildren().addAll(lblPass, password);
		
		
		
		HBox hConfirm = new HBox(10);
		hConfirm.setTranslateY(15);
		hConfirm.setTranslateX(45);
		hConfirm.getChildren().addAll(confirm, exit);
		
		confirm.setOnAction(this); //Pegando de dentro da classe
		
		exit.setOnAction(new EventHandler() {
			public void handle(Event evento) { //Classe Anônima
				primaryStage.close();
			}
		});
		
		
		HBox hCadastro = new HBox(10);
		Label lblCadastro = new Label("Ainda não é cadastrado?");
		lblCadastro.setUnderline(true);
		hCadastro.getChildren().add(lblCadastro);
		
		HBox hCadastroButton = new HBox(10);
		Button btnCadastro = new Button("Clique aqui!");
		btnCadastro.setOnAction(new TratadorDeEventoCadastro());
		hCadastroButton.getChildren().add(btnCadastro);
		

		VBox vConfirm = new VBox();
		vConfirm.getChildren().add(hConfirm);
		
		VBox vCadastro = new VBox();
		vCadastro.setTranslateX(45);
		vCadastro.setTranslateY(30);
		vCadastro.getChildren().addAll(hCadastro);
		
		VBox vCadastroButton = new VBox();
		vCadastroButton.setTranslateX(65);
		vCadastroButton.setTranslateY(35);
		vCadastroButton.getChildren().add(hCadastroButton);
		
				
		raiz.getChildren().addAll(titulo, hLogin, hSenha, vConfirm, vCadastro, vCadastroButton);
		

		//Criar o cenário
		this.primaryStage = primaryStage;
		Scene scene = new Scene(raiz, 300, 200);
		this.primaryStage.setTitle("Tela de Login"); //Coloca o título na Janela
		this.primaryStage.setScene(scene); //Coloca o cenário (inclui a raiz que vem com ele, e os respectivos tamanhos)
		this.primaryStage.show(); //Para mostrar
	}


	public void handle(Event evento) {
		Usuario usuario = new Usuario(txt.getText(), password.getText());
		boolean answer = new UsuarioDao().existeUsuario(usuario);
		if (answer == true) {
			ViewPrincipal view2 = new ViewPrincipal();
			try {
				view2.start(primaryStage);
			} catch (Exception e) {
				throw new RuntimeException("Impossível iniciar o Sistema", e);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error"); //Título
			alert.setHeaderText("Erro de Login!"); //Tipo de Erro
			alert.setContentText("Login/Senha inválidos!"); //Corpo do Erro
			alert.showAndWait();
		}
	}
	
	public String getLoginName() {
		return txt.getText();
	}

}
