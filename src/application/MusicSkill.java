package application;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MusicSkill extends UIControl{
	
	public MusicSkill(CheckBox Box1, CheckBox Box2,CheckBox Box3) {
		super(Box1,Box2,Box3);
	}
	
	//Overriding // Polymorphism
	public void makeTracker(HBox sOC, HBox sTC, HBox sThC, Label sOL, Label sTL, Label sThL, ProgressBar bO, 
			ProgressBar bT,ProgressBar bTh, Button iO, Button iT, Button iTh, VBox tC, Button r, Button nD) {
			 int counter=0; // skillNumber
			 for (String element : getPickedList()) {			 
				 
			 if((element.equals("guitar") || element.equals("piano") ||  element.equals("drums")) && counter == 0) { //skill One				 
				 sOC.getChildren().addAll(sOL,bO,iO);
				 changeLabel(sOL, element);
				 tC.getChildren().add(sOC);
				 System.out.println("entered");
				 					 
			 }
			 else if((element.equals("guitar") || element.equals("piano") ||  element.equals("drums")) && counter == 1) { //skill Two
				 sTC.getChildren().addAll(sTL,bT,iT);
				 changeLabel(sTL, element);
				 tC.getChildren().add(sTC);
			 }
			 else if((element.equals("guitar") || element.equals("piano") ||  element.equals("drums")) && counter == 2) { //skillThree
				 sThC.getChildren().addAll(sThL,bTh,iTh);
				 changeLabel(sThL, element);
				 tC.getChildren().add(sThC);
			 }
			 counter++;
			
		}	
			 tC.getChildren().addAll(r, nD);
			 
		 }
	 
	 
}