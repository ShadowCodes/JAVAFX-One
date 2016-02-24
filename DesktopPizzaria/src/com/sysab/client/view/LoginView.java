package com.sysab.client.view;

import java.net.URL;

import org.omg.Messaging.SyncScopeHelper;

import com.sysab.client.controller.ValidationController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginView extends Application {
	private static Stage stage;
	
	public void start(Stage stage) throws Exception {
		URL arquivoFXML = getClass().getResource("./login.fxml"); //Pega o FXML
		Parent parent = (Parent) FXMLLoader.load(arquivoFXML); //Carregamos o FXML com o loader, damos a certeza de que retorna um Parent
		Scene scene = new Scene(parent); //O parent é a nossa raiz, nós o lançamos no construtor para criar uma scene
		this.stage = stage;
		this.stage.setScene(scene); //No palco nós criamos uma scene ao setá-la
		this.stage.setResizable(false);
		this.stage.setTitle("Sysab Systems");
		this.stage.show();
	}
		
	public static Stage getStage() {
		return stage;
	}
		
}
