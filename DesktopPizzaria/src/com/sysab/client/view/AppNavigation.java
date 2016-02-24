package com.sysab.client.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppNavigation extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		new LoginView().start(primaryStage);
	}

	public static void main(String[] args) {
		launch();
	}
	
}



