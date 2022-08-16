package application;


import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LanguageSkill extends UIControl{
	
	
	
	
	private int XP;
	private int textValueOne;
	private double progressOne=0.0;
	
	private int textValueTwo;
	private int textValueThree;
	private double progressTwo=0.0;
	private double progressThree=0.0;
	private int day = 0;
	private String textStringOne;
	private String textStringTwo;
	private String textStringThree;
	private int inputButtonCounter=0;
	private Label messageOne;
	private Label messageTwo;
	private Label messageThree;
	private String sOL;
	private String sTL;
	private String sThL;
	private boolean ErrorOne;
	private boolean ErrorTwo;
	private boolean ErrorThree;
	
	
	public LanguageSkill(CheckBox Box1, CheckBox Box2,CheckBox Box3) {
		super(Box1, Box2, Box3);
	}
	
	//Overriding // Polymorphism
	public void makeTracker(HBox sOC, HBox sTC, HBox sThC, Label sOL, Label sTL, Label sThL, ProgressBar bO, 
			ProgressBar bT,ProgressBar bTh, Button iO, Button iT, Button iTh, VBox tC, Button r, Button nD, 
			TextField tO, Label mO, TextField tT, Label mT, 
			TextField tTh, Label mTh, HBox bH, HBox lH, Label dC) {
		 int counter=0; // skillNumber
		 for (String element : getPickedList()) {			 
			 
		 if((element.equals("french") || element.equals("english") ||  element.equals("arabic")) && counter == 0) { //skill One				 
			 this.sOL = element;
			 sOC.getChildren().addAll(sOL,bO,iO, tO, mO);
			 changeLabel(sOL," "+ element+" ");
			 tC.getChildren().add(sOC);
			 
			 					 
		 }
		 else if((element.equals("french") || element.equals("english") ||  element.equals("arabic")) && counter == 1) { //skill Two
			 this.sTL=element;
			 sTC.getChildren().addAll(sTL,bT,iT, tT, mT);
			 changeLabel(sTL," "+ element+" ");
			 tC.getChildren().add(sTC);
		 }
		 else if((element.equals("french") || element.equals("english") ||  element.equals("arabic")) && counter == 2) { //skillThree
			 this.sThL=element;
			 sThC.getChildren().addAll(sThL,bTh,iTh, tTh, mTh);
			 changeLabel(sThL, " "+ element+" ");
			 tC.getChildren().add(sThC);
		 }
		 counter++;
		
	}	
		 
		 bH.getChildren().addAll(r, nD);
		 lH.getChildren().add(dC);
		 tC.getChildren().addAll(bH, lH);
	 }
	
	public void calculateXPOne(String textStringOne, Label messageOne) {
		this.messageOne=messageOne;
		inputButtonCounter++;
		 XP = 0;
		 this.textStringOne = textStringOne;
		 ErrorOne = oneError(textStringOne);//checks for error
		 if(ErrorOne==false && textStringOne != "") {
			 textValueOne = (int) Double.parseDouble(textStringOne);		// got the textValue from the input button	 	
			 if (textValueOne ==0) {
				 XP = 300;  // XP loss different
				 messageOne.setText("XP lost today: " + XP );
			 }
			 else {
				 XP = (int)(setProgressXP(textValueOne) * 10000); // a proper XP to show.
				 messageOne.setText("XP earned today: " + XP);
				 
			 }
			 
			 
		 }
		 else {
			 messageOne.setText("Enter valid number without alphabets or decimals that is between 0 and 24.");
		 }
		 
	}
	public void calculateXPTwo(String textStringTwo, Label messageTwo) {
		this.messageTwo=messageTwo;
		inputButtonCounter++;
		 XP = 0;
		 this.textStringTwo= textStringTwo;
		 ErrorTwo = oneError(textStringTwo);//checks for error
		 if(ErrorTwo==false && textStringTwo != "") {
			 textValueTwo = (int) Double.parseDouble(textStringTwo);		// got the textValue from the input button	 	
			 if (textValueTwo ==0) {
				 XP = 300; // XP loss different.
				 messageTwo.setText("XP lost today: " + XP );
			 }
			 else {
				 XP = (int)(setProgressXP(textValueTwo) * 10000); // a proper XP to show.
				 messageTwo.setText("XP earned today: " + XP);
			 }			 			 
		 }
		 else {
			 messageTwo.setText("Enter valid number without alphabets or decimals that is between 0 and 24.");
		 }
		
	}
	
	public void calculateXPThree(String textStringThree, Label messageThree) {
		this.messageThree=messageThree;
		inputButtonCounter++;
		 XP = 0;
		 this.textStringThree=textStringThree;
		 ErrorThree = oneError(textStringThree);//checks for error
		 if(ErrorThree==false && textStringThree != "") {
			 textValueThree = (int) Double.parseDouble(textStringThree);		// got the textValue from the input button	 	
			 if (textValueThree ==0) {
				 XP = 300; // XP Loss different.
				 messageThree.setText("XP lost today: " + XP );
			 }
			 else {
				 XP = (int)(setProgressXP(textValueThree) * 10000); // a proper XP to show.
				 messageThree.setText("XP earned today: " + XP);
			 }			 			 
		 }
	}
	public void progressUpdate(ProgressBar barOne, ProgressBar barTwo, ProgressBar barThree, Label dayCounter) {	
		
		if(inputButtonCounter>0 && (textValueOne + textValueTwo + textValueThree) <=24) {
			
		
			if (!(progressOne>=1) && !( progressTwo>=1) && !(progressThree>=1) && textStringOne!="" && textStringTwo!="" && textStringThree!=""  && ErrorOne==false && ErrorTwo==false && ErrorThree==false ){ //day will not increase when all learning is finished
				day++;//day increments as nextDay button is pressed
			}
			
			if (textValueOne==0 && progressOne > 0 && progressOne<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false ) {
				progressOne -= .035; //decrementing progress for not practicing;
				barOne.setProgress(progressOne); // actual XP that is lost.
			}
			else {
				if(progressOne < 1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false) {
					progressOne += setProgressXP(textValueOne); // using the textValue for setting progress.
					barOne.setProgress(progressOne); // actual XP that is earned visually.
				}
			}
				
			if (textValueTwo==0 && progressTwo>0 && progressTwo<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false)  {
				progressTwo -= .035; //decrementing progress for not practicing;
				barTwo.setProgress(progressTwo); // actual XP that is lost.
			}
			else {
				if(progressTwo < 1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false) {
					progressTwo += setProgressXP(textValueTwo); // using the textValue for setting progress.
					
					barTwo.setProgress(progressTwo); // actual XP that is earned visually.
				}
			}
				
			
			if (textValueThree==0 && progressThree>0 && progressThree<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false) {
				progressThree -= .035; //decrementing progress for not practicing;
				barThree.setProgress(progressThree); // actual XP that is lost.
			}
			else {
				if(progressThree < 1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false) {
					progressThree += setProgressXP(textValueThree); // using the textValue for setting progress.
					barThree.setProgress(progressThree); // actual XP that is earned visually.
				}
				
			}
			
			dayCounter.setText("DAY: "+day);
			
			if (progressOne>=1) {
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				messageOne.setText(" Congratulations! Learning "+sOL+" is finished . No more losing XP");
				barOne.setStyle("-fx-accent:red;");
			}
			else {
				barOne.setStyle("-fx-accent:blue;");
			}
			if (progressTwo>=1) {
				messageTwo.setText(" Congratulations! Learning "+sTL+" is finished. No more losing XP");
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				barTwo.setStyle("-fx-accent:red;");
			}
			else {
				barTwo.setStyle("-fx-accent:purple;");
			}
			if (progressThree>=1) {
				messageThree.setText(" Congratulations! Learning "+sThL+" is finished. No more losing XP");
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				barThree.setStyle("-fx-accent:red;");
			}
			else {
				barThree.setStyle("-fx-accent:brown;");
			}
			
			if (progressOne>=1 &&  progressTwo>=1 && progressThree>=1) {
				
				dayCounter.setText("DAY: "+day+"   Congratulations! ALL FINISHED AT DAY-->" +day +"."+" (Red means finished learning) ");
			}
			
		}
		else { 
			if (inputButtonCounter==0) {
			dayCounter.setText("Input a value first ");
			}
			if((textValueOne + textValueTwo + textValueThree) >24) {
				dayCounter.setText("Total time spent on all skills must be less than 24 hours");
			}
			
		}
}
public double setProgressXP(int textValue) {				
	
	return (textValue/300.0);
}
}

