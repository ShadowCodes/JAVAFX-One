package javafx.scene.control;

public class NumberTextField extends TextField {
	
	public void replaceText(int i, int il, String string) {
		if (string.matches("[0-9]") || string.isEmpty()) {
			super.replaceText(i, il, string);
		}
	}
	
	public void replaceSelection(String string) {
		super.replaceSelection(string);
	}

}
