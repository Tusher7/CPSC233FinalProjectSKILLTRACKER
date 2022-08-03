package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.Scene;


import javafx.stage.Stage;

import javafx.scene.control.CheckBox;

public class PrimeController extends UIControl{
	
	public Stage applicationStage;
	
	 @FXML
    private ChoiceBox<String> skillChooseChoiceBox;
	 
	 @FXML
	  private Label skillPicked = new Label();
	 
	 @FXML
	    private ArrayList<String> skillPickedList = new ArrayList<String> (); ;
	 
	 @FXML
	 private CheckBox codingCheck;
	 @FXML
	 private CheckBox languageCheck;
	 @FXML
	 private CheckBox musicCheck;
	 
	 private String defaultText = "";
	 
	  @FXML
	 public void skillPickedCoding(ActionEvent pickSkillCode) {
		  defaultText+="Coding";
		  skillPickedList.add("coding");
		  skillPicked.setText(defaultText);	  			 																	 	 
	 }
	  
	  public void skillPickedLanguage(ActionEvent pickSkillLanguage) {
		  defaultText+="Language Learning";
		  skillPickedList.add("language");
		  skillPicked.setText(defaultText);	  			 																	 	 
	 }
	  
		 		 		 	 		 
	 
	 
	 void changeLabel(Label label, String text) {
	
		 label.setText(text);
}
}

