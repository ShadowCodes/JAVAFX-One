package com.sysab.client.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterView extends Application {
	private static Stage stage;


	public RegisterView() {
		try {
			Stage stage = new Stage();
			start(stage);
		} catch (Exception e) {
			throw new RuntimeException("Impossível inicializar o Stage", e);
		}
	}

	public void start(Stage stage) throws Exception {
		URL arquivoFXML = getClass().getResource("./register.fxml"); //Informo o lugar do meu FXML
		Parent parent = (Parent) FXMLLoader.load(arquivoFXML); //Carrego o meu FXML
		Scene scene = new Scene(parent);
		this.stage = stage;
		this.stage.setTitle("Cadastro");
		this.stage.setResizable(false);
		this.stage.setScene(scene);
		this.stage.show();
	}
	
	public static Stage getStage() {
		return stage;
	}
	
}
