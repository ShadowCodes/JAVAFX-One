package javafx.scene.control;

public class WordTextField extends TextField {
	
	public void replaceText(int start, int end, String string) {
		if (string.matches("[a-zA-Z]") || string.matches("[ ]")|| string.isEmpty()) {
			super.replaceText(start, end, string);
		}
	}
	
	public void replaceSelection(String string) {
		super.replaceSelection(string);
	}
}
