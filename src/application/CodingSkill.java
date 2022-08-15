
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CodingSkill extends UIControl{
	HBox sOC = new HBox();
	HBox sTC = new HBox();
	HBox sThC = new HBox();
	private int XP;
	private int textValue;
	private double progress=0;
	private int num = 0;
	
	public CodingSkill(CheckBox Box1, CheckBox Box2,CheckBox Box3) {
		super(Box1, Box2, Box3);
	}
	//Overriding // Polymorphism
	public void makeTracker(HBox sOC, HBox sTC, HBox sThC, Label sOL, Label sTL, Label sThL, ProgressBar bO, 
			ProgressBar bT,ProgressBar bTh, Button iO, Button iT, Button iTh, VBox tC, Button r, Button nD, 
			TextField tO, Label mO, TextField tT, Label mT, 
			TextField tTh, Label mTh, HBox bH, Button rCu, HBox lH, Label dC) {
		 int counter=0; // skillNumber
		 for (String element : getPickedList()) {			 
			 
			 if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 0) { //skill One				 
				 sOC.getChildren().addAll(sOL,bO,iO, tO, mO);
				 changeLabel(sOL, element);
				 tC.getChildren().add(sOC);
				 					 
			 }
			 else if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 1) { //skill Two
				 sTC.getChildren().addAll(sTL,bT,iT, tT, mT);
				 changeLabel(sTL, element);
				 tC.getChildren().add(sTC);
			 }
			 else if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 2) { //skillThree
				 sThC.getChildren().addAll(sThL,bTh,iTh, tTh, mTh);
				 changeLabel(sThL, element);
				 tC.getChildren().add(sThC);
			 }
			 counter++;
			
		}	
		 bH.getChildren().addAll(r, nD, rCu);
		 lH.getChildren().add(dC);
		 tC.getChildren().addAll(bH, lH);
		 
	 }
	
	public void calculateXP(String textString, Label message) {
		 XP = 0;
		 boolean ErrorOne = oneError(textString);
		 if(ErrorOne==false && textString != "") {
			 textValue = (int) Double.parseDouble(textString);		// got the textValue from the input button	 	
			 if (textValue ==0) {
				 XP = 200;
				 message.setText("XP lost today: " + XP );
			 }
			 else {
				 XP = (int)(setProgressXP(textValue) * 10000); // a proper XP to show.
				 message.setText("XP earned today: " + XP);
			 }
			 
			 
		 }
		 else {
			 message.setText("Enter valid number without alphabets or decimals that is between 0 and 20.");
		 }
		System.out.print(XP);
	}
	
	public void progressUpdate(ProgressBar bar, Label dayCounter) {			
		num = num+1;
		setDay(num);	//day increments as nextDay button is pressed
		if (textValue==0) {
			progress -= .03; //decrementing progress for not practicing;
			bar.setProgress(progress); // actual XP that is lost.
		}
		else {
			progress += setProgressXP(textValue); // using the textValue for setting progress.
			bar.setProgress(progress); // actual XP that is earned.
		}
		
		
		dayCounter.setText("DAY: "+num);
		
		if (progress>=1) {
			dayCounter.setText("DAY: "+num +"      Basic Learning finished at day "+num);
		}
	}
	

	public int getXP() {
		return XP;
	}
	
	
	
}