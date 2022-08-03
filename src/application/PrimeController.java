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
	  private Label skillPickedLabel = new Label();
	 
	 @FXML
	    private ArrayList<String> skillPickedList = new ArrayList<String> (); ;	 
	 
	 private String defaultText = "";
	 
	  @FXML
	 public void confrimButton(ActionEvent pickSkill) {
		  defaultText="";
		  String skillChose =  skillChooseChoiceBox.getValue();
		  if (skillChose.equals("Coding")) {
			  defaultText+="Coding";
			  changeLabel(skillPickedLabel,defaultText);		  
			  skillPickedList.add("Coding");
			  
		  }
		  else if(skillChose.equals("Language Learning")) {
			  defaultText+="Language Learning";
			  changeLabel(skillPickedLabel,defaultText);
			  skillPickedList.add("Language");
			  
		  }
		  else if (skillChose.equals("Musical Instruments")) {
			  defaultText += "Musical Instruments";
			  changeLabel(skillPickedLabel,defaultText);
			  skillPickedList.add("Musical");
			  
		  }		  	  		  		  		  
	 }
	  @FXML
	  public void resetButton(ActionEvent resetMain) {
		  skillPickedList.clear();
		  changeLabel(skillPickedLabel, "");
	  }
	 
		  		 		 	 		 
	 
	 
	 void changeLabel(Label label, String text) {
	
		 label.setText(text);
}
}

