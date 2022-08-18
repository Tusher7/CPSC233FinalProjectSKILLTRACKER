
package application;


import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CodingSkill extends UIControl{
		
	private int XP;
	private int textValueOne;
	private double progressOne=0.0;
	
	private int textValueTwo;
	private int textValueThree;
	private double progressTwo=0.0;
	private double progressThree=0.0;
	private int day = 0;
	
	private String sOL;
	private String sTL;
	private String sThL;
	private boolean errorOne;
	private boolean errorTwo;
	private boolean errorThree;
	
	
	/**
	 * Passes arguments to the parent class constructor.
	 * @param Box1 takes the state of the check box and stores it in a field.
	 * @param Box2 takes the state of the check box and stores it in a field.
	 * @param Box3 takes the state of the check box and stores it in a field.
	 */
	public CodingSkill(CheckBox Box1, CheckBox Box2,CheckBox Box3) {
		super(Box1, Box2, Box3);
	}
	/**
	 * This method makes the tracker using the building blocks such HBox, buttons, labels etc
	 * by taking them as arguments polymorphically. The variable names are abbreviated, e.g. skillOneContainer is
	 * sOC, inputOne is iO.
	 * 
	 * @param sOC an HBox that used to build a container for skill one.
	 * @param sTC an HBox that used to build a container for skill two.
	 * @param sThC an HBox that used to build a container for skill three.
	 * @param sOL a Label that is added to sOC.
	 * @param sTL  a Label that is added to sTC.
	 * @param sThL a Label that is added to sThC.
	 * @param bO a ProgressBar that is added to sOC.
	 * @param bT a ProgressBar that is added to sTC.
	 * @param bTh a ProgressBar that is added to sThC.
	 * @param iO a label that is added to sOC.
	 * @param iT a label that is added to sTC.
	 * @param iTh a label that is added to sThC.
	 * @param tC a VBox that contains everything for the tracker scene. 
	 * @param r a button that is added to bH.
	 * @param nD a button that is added to bH.
	 * @param tO a TextField that is added to sOC.
	 * @param mO a Label that is added to sOC.
	 * @param tT a TextField that is added to sTC.
	 * @param mT a Label that is added to sTC.
	 * @param tTh a TextField that is added to sThC.
	 * @param mTh a Label that is added to sThC.
	 * @param bH an HBox that is added to tC.
	 * @param lH an HBox that is added to tC.
	 * @param dC a label that is added to lB.
	 */
	public void makeTracker(HBox sOC, HBox sTC, HBox sThC, Label sOL, Label sTL, Label sThL, ProgressBar bO, 
			ProgressBar bT,ProgressBar bTh, Label iO, Label iT, Label iTh, VBox tC, Button r, Button nD, 
			TextField tO, Label mO, TextField tT, Label mT, 
			TextField tTh, Label mTh, HBox bH, HBox lH, Label dC) {
		int counter=0; // skillNumber. When count=1, its skillOne, when count=2 two skill two and so on.
		 
		for (String element : getPickedList()) {			 
			 
			if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 0) { //skill One. Method difference from parent and child class is because of this line.(Polymorphism)
				this.sOL = element;
				sOC.getChildren().addAll(sOL,bO,iO, tO, mO);
				changeLabel(sOL," "+ element+" ");
				tC.getChildren().add(sOC);
				 					 
			}
			else if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 1) { //skill Two. Method difference from parent and child class is because of this line.(Polymorphism)
				this.sTL=element;
				sTC.getChildren().addAll(sTL,bT,iT, tT, mT);
				changeLabel(sTL," "+ element+" ");
				tC.getChildren().add(sTC);
			}
			else if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 2) { //skillThree. Method difference from parent and child class is because of this line.(Polymorphism)
				 this.sThL=element;
				 sThC.getChildren().addAll(sThL,bTh,iTh, tTh, mTh);
				 changeLabel(sThL, " "+ element+" ");
				 tC.getChildren().add(sThC);
			}
			counter++; // After HBox building for one skill is finished, counter increases and sets everything up for next skill.
			 
		}	
		bH.getChildren().addAll(r, nD);
		lH.getChildren().add(dC);
		tC.getChildren().addAll(bH, lH);
		 
		
		 
	}
	/**
	 * After learning is finished, makes sure the progress bar for that skill stops functioning 
	 * and ignores text field values. (Polymorphism)
	 * @param textStringOne a String gotten from a text field for skill one.
	 * @param messageOne a Label for the skill one.
	 */
	
	public void calculateXPOne(String textStringOne, Label messageOne) {
		if(progressOne <1) {			// if progress is not finished continue earning or losing XP.
			
			XP = 0;
			
			errorOne = oneError(textStringOne);//checks for error
			if(errorOne==false) {
				textValueOne = (int) Double.parseDouble(textStringOne);		// got the textValue from the user input. 	 	
				if (textValueOne ==0 && progressOne>0) { //If some progress was made, but no more practicing is done, lose XP.
					XP = 200; // Difference among other classes is the XP loss.(polymorphism)
					messageOne.setText("XP lost today: " + XP ); 
				}
				else if(progressOne==0 && textValueOne==0) { //If learning not started.
					messageOne.setText("Learning not started. No XP loss or gain.");
				}				
				else {
					XP = (int)(setProgressXP(textValueOne) * 10000); // Difference among other classes is the XP gain.(polymorphism)
					messageOne.setText("XP earned today: " + XP);
					 
				}				 
				 
			}
			else{ // If error in user input.
				messageOne.setText("Enter valid number without alphabets or decimals that is between 0 and 24.");
			}
		}
		else {// If learning finished.
			textValueOne=0;
			messageOne.setText("Learning is finished");
		}
		
	}
	
	/**
	 * After learning is finished, makes sure the progress bar for that skill stops functioning 
	 * and ignores text field values. (Polymorphism)
	 * @param textStringTwo a String gotten from a text field for skill one.
	 * @param messageTwo a Label for the skill one.
	 */
	public void calculateXPTwo(String textStringTwo, Label messageTwo) {
		if (progressTwo<1) {		// if progress is not finished continue earning or losing XP.
		
			XP = 0;
		
			errorTwo = oneError(textStringTwo);//checks for error
			if(errorTwo==false) {
				textValueTwo = (int) Double.parseDouble(textStringTwo);		// got the textValue from the user input. 	 	
				if (textValueTwo ==0 && progressTwo>0) { //If some progress was made, but no more practicing is done, lose XP.
					XP = 200; // Difference among other classes is the XP loss.(polymorphism)
					messageTwo.setText("XP lost today: " + XP );
				}
				else if(progressTwo==0 && textValueTwo==0) { //If learning not started.
					messageTwo.setText("Learning not started. No XP loss or gain.");
				}				
				else {
					XP = (int)(setProgressXP(textValueTwo) * 10000); // Difference among other classes is the XP gain.(polymorphism)
					messageTwo.setText("XP earned today: " + XP);
				}			 			 
			}
			else { // If error in user input.
				messageTwo.setText("Enter valid number without alphabets or decimals that is between 0 and 24.");
			}
		}
		else { // If learning finished.
			textValueTwo=0;
			messageTwo.setText("Learning is finished");
		}
		
	}
	

	/**
	 * After learning is finished, makes sure the progress bar for that skill stops functioning 
	 * and ignores text field values. (Polymorphism)
	 * @param textStringThree a String gotten from a text field for skill one.
	 * @param messageThree a Label for the skill one.
	 */		
	public void calculateXPThree(String textStringThree, Label messageThree) {
		if(progressThree<1) {		// if progress is not finished continue earning or losing XP. 
		
			XP = 0;
		
			errorThree = oneError(textStringThree);//checks for error
			if(errorThree==false ) {
				textValueThree = (int) Double.parseDouble(textStringThree);		// got the textValue from the user input. 	
				if (textValueThree ==0 && progressThree>0) { //If some progress was made, but no more practicing is done, lose XP.
					XP = 200; // Difference among other classes is the XP loss.(polymorphism)
					messageThree.setText("XP lost today: " + XP );
				}
				else if(progressThree==0 && textValueThree==0) { //If learning not started.
					messageThree.setText("Learning not started. No XP loss or gain.");
				}
				
				else {
					XP = (int)(setProgressXP(textValueThree) * 10000);  // Difference among other classes is the XP gain.(polymorphism)
					messageThree.setText("XP earned today: " + XP);
				}			 			 
			}
			else { // If error in user input.
				messageThree.setText("Enter valid number without alphabets or decimals that is between 0 and 24.");
			}
		}
		else { // If learning finished.
			textValueThree=0;
			messageThree.setText("Learning is finished");
		}
	}


	

	/**
	 * Used polymorphically, to update the progress bar by abiding by certain conditions.
	 * @param barOne a ProgressBar parameter to set progress of skill.
	 * @param barTwo a ProgressBar parameter to set progress of skill.
	 * @param barThree a ProgressBar parameter to set progress of skill.
	 * @param dayCounter a label to show day number.
	 * @param textStringOne a String value that is taken from text field.
	 * @param messageOne a Label to show instructions and error messages for a text field.
	 * @param textStringTwo a String value that is taken from text field.
	 * @param messageTwo a Label to show instructions and error messages for a text field.
	 * @param textStringThree a String value that is taken from text field.
	 * @param messageThree a Label to show instructions and error messages for a text field.
	 */	
	public void progressUpdate(ProgressBar barOne, ProgressBar barTwo, ProgressBar barThree, Label dayCounter, String textStringOne, Label messageOne,
			String textStringTwo, Label messageTwo, String textStringThree, Label messageThree) {
		
		if (sOL!=null) { // if the label of skill One is not null, means it exists, so functions can be called on it.
			calculateXPOne(textStringOne,messageOne);
			
		}
		if  (sTL!=null) { // if the label of skill Two is not null, means it exists, so functions can be called on it.
			calculateXPTwo(textStringTwo,messageTwo);
			
		}
		if  (sThL!=null) { // if the label of skill Three is not null, means it exists, so functions can be called on it.
			calculateXPThree(textStringThree, messageThree);
			
		}
		
		
		if (sOL!=null && sTL!=null && sThL!=null) { // // If all three sub-skills are picked by user.
			if((textValueOne + textValueTwo + textValueThree) <=24 && errorOne==false && errorTwo==false && errorThree==false ) { // Makes sure that the sum of the inputs is less than or equal to 24 hours.
					
				if (!(progressOne>=1) || !( progressTwo>=1) || !(progressThree>=1) && textStringOne!="" && textStringTwo!="" && textStringThree!=""  ){ //day will not increase when all learning is finished
					day++;//day increments as nextDay button is pressed
				}
			
				if (textValueOne==0 && progressOne > 0 && progressOne<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" ) {
					progressOne -= .03; //decrementing progress for not practicing;
					barOne.setProgress(progressOne); // actual XP that is lost.
				}
				else {
					if(progressOne < 1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" ) {
						progressOne += setProgressXP(textValueOne); // using the textValue for setting progress.
						barOne.setProgress(progressOne); // actual XP that is earned visually.
					}
				}
				
				if (textValueTwo==0 && progressTwo>0 && progressTwo<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" )  {
					progressTwo -= .03; //decrementing progress for not practicing;
					barTwo.setProgress(progressTwo); // actual XP that is lost.
				}
				else {
					if(progressTwo < 1 && textStringOne!="" && textStringTwo!="" && textStringThree!="") {
						progressTwo += setProgressXP(textValueTwo); // using the textValue for setting progress.
					
						barTwo.setProgress(progressTwo); // actual XP that is earned visually.
					}
				}
				
			
				if (textValueThree==0 && progressThree>0 && progressThree<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" ) {
					progressThree -= .03; //decrementing progress for not practicing;
					barThree.setProgress(progressThree); // actual XP that is lost.
				}
				else {
					if(progressThree < 1 && textStringOne!="" && textStringTwo!="" && textStringThree!="") {
						progressThree += setProgressXP(textValueThree); // using the textValue for setting progress.
						barThree.setProgress(progressThree); // actual XP that is earned visually.
					}
				
				}
			
				dayCounter.setText("DAY: "+day);
			
				if (progressOne>=1) { // If progress is finished.
					dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
					messageOne.setText(" Congratulations! Learning "+sOL+" is finished . No more losing XP. TextField value will be ignored.");
					barOne.setStyle("-fx-accent:red;");
					textValueOne = 0;///
				
				}
				else { // If progress not finished.
					barOne.setStyle("-fx-accent:blue;");
				}
				if (progressTwo>=1) { // If progress is finished.
					messageTwo.setText(" Congratulations! Learning "+sTL+" is finished. No more losing XP. TextField value will be ignored.");
					dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
					barTwo.setStyle("-fx-accent:red;");
					textValueTwo = 0; ///
				
				}
				else { // If progress not finished.
					barTwo.setStyle("-fx-accent:purple;");
				}
				if (progressThree>=1) { // If progress is finished.
					messageThree.setText(" Congratulations! Learning "+sThL+" is finished. No more losing XP. TextField value will be ignored.");
					dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
					barThree.setStyle("-fx-accent:red;");
					textValueThree=0;///
				
				} 
				else { // If progress not finished.
					barThree.setStyle("-fx-accent:brown;");
				}
			
				if (progressOne>=1 &&  progressTwo>=1 && progressThree>=1) { // If all progresses are finished.
				
					dayCounter.setText("DAY: "+day+"   Congratulations! ALL FINISHED AT DAY-->" +day +"."+" (Red means finished learning) ");
				}							
			
			
			}
			else if((textValueOne + textValueTwo + textValueThree)>24){ 	 // Error handling for surpassing 24 hours in a day.				
				dayCounter.setText("ERROR! Total time spent on all skills must be less than or equal to 24 hours. Enter values again.");
				if (messageOne!=null) {
					messageOne.setText("");
				}
				if (messageTwo!=null) {
					messageTwo.setText("");
				}
				if (messageThree!=null) {
					messageThree.setText("");
				}
			
			
			}
		
		
		}
	
		else if (sOL!=null && sTL!=null && sThL==null) { // If two sub-skills are picked by user.
			if((textValueOne + textValueTwo) <=24 && errorOne==false && errorTwo==false) { // Makes sure that the sum of the inputs is less than or equal to 24 hours.
					
				if (!(progressOne>=1) || !( progressTwo>=1) && textStringOne!="" && textStringTwo!="" ){ //day will not increase when all learning is finished
					day++;//day increments as nextDay button is pressed
				}
			
				if (textValueOne==0 && progressOne > 0 && progressOne<1 && textStringOne!="" && textStringTwo!="") {
					progressOne -= .03; //decrementing progress for not practicing;
					barOne.setProgress(progressOne); // actual XP that is lost.
				}
				else {
					if(progressOne < 1 && textStringOne!="" && textStringTwo!="") {
						progressOne += setProgressXP(textValueOne); // using the textValue for setting progress.
						barOne.setProgress(progressOne); // actual XP that is earned visually.
					}
				}
				
				if (textValueTwo==0 && progressTwo>0 && progressTwo<1 && textStringOne!="" && textStringTwo!="")  {
					progressTwo -= .03; //decrementing progress for not practicing;
					barTwo.setProgress(progressTwo); // actual XP that is lost.
				}
				else {
					if(progressTwo < 1 && textStringOne!="" && textStringTwo!="") {
						progressTwo += setProgressXP(textValueTwo); // using the textValue for setting progress.
						
						barTwo.setProgress(progressTwo); // actual XP that is earned visually.
					}
				}
									
			
				dayCounter.setText("DAY: "+day);
			
				if (progressOne>=1) { // If progress is finished.
					dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
					messageOne.setText(" Congratulations! Learning "+sOL+" is finished . No more losing XP. TextField value will be ignored.");
					barOne.setStyle("-fx-accent:red;");
					textValueOne = 0;///
				
				}
				else { // If progress not finished.
					barOne.setStyle("-fx-accent:blue;");
				}
				if (progressTwo>=1) { // If progress is finished.
					messageTwo.setText(" Congratulations! Learning "+sTL+" is finished. No more losing XP. TextField value will be ignored.");
					dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
					barTwo.setStyle("-fx-accent:red;");
					textValueTwo = 0; 
				
				}
				else { // If progress not finished.
					barTwo.setStyle("-fx-accent:purple;");
				}			
				
				if (progressOne>=1 &&  progressTwo>=1) { // If all progresses are finished.
					
					dayCounter.setText("DAY: "+day+"   Congratulations! ALL FINISHED AT DAY-->" +day +"."+" (Red means finished learning) ");
				}							
			
				
			}
			else if((textValueOne + textValueTwo)>24) { 	// Error handling for surpassing 24 hours in a day. 				
				dayCounter.setText("ERROR! Total time spent on all skills must be less than or equal to 24 hours. Enter values again.");
				if (messageOne!=null) {
					messageOne.setText("");
				}
				if (messageTwo!=null) {
					messageTwo.setText("");
				}						
			
			}
		
		
		}
	
		else if (sOL!=null && sTL==null && sThL==null) { // If only 1 sub-skill is picked by user.
			if((textValueOne) <=24 && errorOne==false && errorTwo==false && errorThree==false ) {		 // Makes sure that the sum of the inputs is less than or equal to 24 hours.	
		
				if (!(progressOne>=1) && textStringOne!="" ){ //day will not increase when all learning is finished
					day++;//day increments as nextDay button is pressed
				}
			
				if (textValueOne==0 && progressOne > 0 && progressOne<1 && textStringOne!="" ) {
					progressOne -= .03; //decrementing progress for not practicing;
					barOne.setProgress(progressOne); // actual XP that is lost.
				}
				else {
					if(progressOne < 1 && textStringOne!="") {
						progressOne += setProgressXP(textValueOne); // using the textValue for setting progress.
						barOne.setProgress(progressOne); // actual XP that is earned visually.
					}
				}
							
				
				dayCounter.setText("DAY: "+day);
			
				if (progressOne>=1) { // If progress is finished.
					dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
					messageOne.setText(" Congratulations! Learning "+sOL+" is finished . No more losing XP. TextField value will be ignored.");
					barOne.setStyle("-fx-accent:red;");
					textValueOne = 0;///
				
				}
				else { // If progress not finished.
					barOne.setStyle("-fx-accent:blue;");
				}
						
			
				if (progressOne>=1) { // If progress is finished.
					
					dayCounter.setText("DAY: "+day+"   Congratulations! FINISHED AT DAY-->" +day +"."+" (Red means finished learning) ");
				}							
			
			
			}
			else if((textValueOne)>24) { 		 // Error handling for surpassing 24 hours in a day.			
				dayCounter.setText("ERROR! Total time spent on all skills must be less than or equal to 24 hours. Enter values again.");
				if (messageOne!=null) {
					messageOne.setText("");
				}							
				
		}
		
		
	}
	}
	}
	
	
	

	
	
	
	


	

	
