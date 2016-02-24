package com.sysab.client.model;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Validacao {
	
	public static void verifyCheckBox(CheckBox first, CheckBox second) {
		if ( !(first.isSelected()) && !(second.isSelected()) ) {
			first.setSelected(true);
		}
	}
	
	public static void verifyOneCheckBox(CheckBox first, CheckBox second) {
		if ( (first.isSelected())) {
			second.setSelected(false);
		}
		
		verifyCheckBox(first, second);
	}
	
	public static void setTextFieldDisable(boolean value, TextField... textField) {
		for (int i = 0; i < textField.length; i++) {
			textField[i].setDisable(value);
		}
	}
	
	public static void setCheckBoxDisable(boolean value, CheckBox... checkBox) {
		for (int i = 0; i < checkBox.length; i++) {
			checkBox[i].setDisable(value);
		}
	}
	
	public static boolean isItNull(TextField... textField) {
		boolean value = false;
		for (int i = 0; i < textField.length; i++) {
			if (textField[i].getText().isEmpty()) {
				value = true;
			}
		}
		return value;
	}
	
	public static boolean isDatePickerNull(DatePicker datePicker) {
		if (datePicker.getValue() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void setTextFieldNull(TextField... textField) {
		for (int i = 0; i < textField.length; i++) {
			textField[i].setText("");
		}
	}
	
}

