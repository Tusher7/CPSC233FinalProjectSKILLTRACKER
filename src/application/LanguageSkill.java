package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LanguageSkill extends UIControl{
	
	public LanguageSkill(CheckBox Box1, CheckBox Box2,CheckBox Box3) {
		super(Box1, Box2, Box3);
	}
	
	//Overriding // Polymorphism
	public void makeTracker(HBox sOC, HBox sTC, HBox sThC, Label sOL, Label sTL, Label sThL, ProgressBar bO, 
			ProgressBar bT,ProgressBar bTh, Button iO, Button iT, Button iTh, VBox tC, Button r, Button nD, 
			TextField tO, Label mO, TextField tT, Label mT,TextField tTh, Label mTh ) {
		 int counter=0; // skillNumber
		 for (String element : getPickedList()) {			 
			 
		 if((element.equals("french") || element.equals("english") ||  element.equals("arabic")) && counter == 0) { //skill One				 
			 sOC.getChildren().addAll(sOL,bO,iO, tO, mO);
			 changeLabel(sOL, element);
			 tC.getChildren().add(sOC);
			 
			 					 
		 }
		 else if((element.equals("french") || element.equals("english") ||  element.equals("arabic")) && counter == 1) { //skill Two
			 sTC.getChildren().addAll(sTL,bT,iT, tT, mT);
			 changeLabel(sTL, element);
			 tC.getChildren().add(sTC);
		 }
		 else if((element.equals("french") || element.equals("english") ||  element.equals("arabic")) && counter == 2) { //skillThree
			 sThC.getChildren().addAll(sThL,bTh,iTh, tTh, mTh);
			 changeLabel(sThL, element);
			 tC.getChildren().add(sThC);
		 }
		 counter++;
		
	}	
		 tC.getChildren().addAll(r, nD);
		 
	 }
	
	public void calculateXP(String textOneString, Label messageOne) {
		int XP = 0;
		 boolean ErrorOne = oneError(textOneString);
		 if(ErrorOne==false && textOneString != "") {
			 int textOneValue = (int) Double.parseDouble(textOneString);
			 messageOne.setText("XP earned: 5");
			 
		 }
		 else {
			 messageOne.setText("Enter valid value");
		 }
		System.out.print(XP);
	}
}
