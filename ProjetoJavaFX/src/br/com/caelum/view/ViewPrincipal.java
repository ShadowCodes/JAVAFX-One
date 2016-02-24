package br.com.caelum.view;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewPrincipal extends Application implements EventHandler {
	public static void main(String[] args) {
		launch();
	}
	

	public void start(Stage primaryStage) throws Exception {
		VBox raiz = new VBox();
		raiz.setTranslateX(20);
		raiz.setTranslateY(30);
		
		Label label = new Label("Seja bem vindo " + new ViewLogin().getLoginName());
		
		raiz.getChildren().add(label);
		
		Scene scene = new Scene(raiz, 400, 200);
		primaryStage.setTitle("Acesso ao Sistema");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void handle(Event arg0) {
		
	}
	

}
