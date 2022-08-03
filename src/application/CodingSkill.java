package application;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class CodingSkill extends UIControl{

	@FXML
	private ChoiceBox CodingLanguagePickChoiceBox;
	
	@FXML
	private Label programmingLanguagePickedLabel;
	
	@FXML 
	private Label programmingLanguageLabelLine1;
	@FXML 
	private Label programmingLanguageLabelLine2;
	@FXML 
	private Label programmingLanguageLabelLine3;
	
	private String programmingLanguagePicked;
	
	
	public void programmingLanguagePick(String programmingLanguage) {
		
		programmingLanguagePicked = (String) CodingLanguagePickChoiceBox.getValue();
		
		if (programmingLanguagePicked.equals("Java")) {
			programmingLanguagePickedLabel.setText("You have picked Java");
			programmingLanguageLabelLine1.setText("You need to spend roughly 1700 hours");
			programmingLanguageLabelLine2.setText("on JAVA to achieve mastery.");
			
		}
		else if (programmingLanguagePicked.equals("C")) {
			programmingLanguagePickedLabel.setText("You have picked C");
			programmingLanguageLabelLine1.setText("You need to spend roughly 1700 hours");
			programmingLanguageLabelLine2.setText("on C to achieve mastery.");
			
			
		}
		else if (programmingLanguagePicked.equals("Python")) {
			programmingLanguagePickedLabel.setText("You have picked Python");
			programmingLanguageLabelLine1.setText("You need to spend roughly 1700 hours");
			programmingLanguageLabelLine2.setText("on Python to achieve mastery.");
			
		}
		
}
}