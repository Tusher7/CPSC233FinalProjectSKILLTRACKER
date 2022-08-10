
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CodingSkill extends UIControl{
	private Stage applicationStage = new Stage(); 
	private Parent root;
	private Scene mainScene; // Make them parameters of back button
					 

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
	
	 @FXML 
	  public void codingLanguagePickerBackButton(ActionEvent changeScene) throws IOException { 
		  root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
		  mainScene = new Scene(root);
		  applicationStage.setScene(mainScene);
		  applicationStage.show();
	  }
}