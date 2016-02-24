package br.com.caelum.controller;

import br.com.caelum.view.ViewCadastro;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TratadorDeEventoCadastro implements EventHandler {
	
	public void handle(Event evento) {
		ViewCadastro view = new ViewCadastro();
		try {
			view.start(view.getStage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
