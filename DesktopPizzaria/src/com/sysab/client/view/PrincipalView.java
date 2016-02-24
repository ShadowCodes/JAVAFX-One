package com.sysab.client.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalView extends Application {
	private static Stage stage;
	
	public PrincipalView() {
		try {
			Stage stage = new Stage();
			start(stage);
		} catch (Exception e) {
			throw new RuntimeException("Impossível realizar inicialização do stage", e);
		}
	}

	public void start(Stage stage) throws Exception {
		URL arquivoFXML = getClass().getResource("./principal.fxml");
		Parent parent = (Parent) FXMLLoader.load(arquivoFXML);
		Scene scene = new Scene(parent);
		this.stage = stage;
		this.stage.setTitle("Main View");
		this.stage.setScene(scene);
		this.stage.setMaximized(true);
		this.stage.show();
	}
	
	public static Stage getStage() {
		return stage;
	}
	
}
