package com.sysab.client.model;

import com.sysab.client.view.RegisterView;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CaixaDeDialogo {
	
	public static Alert plotTheConfirmAlert(String title, String header, String content) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.setContentText(content);
			return alert;
		}
	
	public static Alert plotTheErrorAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		return alert;
	}
}
