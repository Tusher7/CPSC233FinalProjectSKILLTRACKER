
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
	
	
	
	public CodingSkill(CheckBox Box1, CheckBox Box2,CheckBox Box3) {
		super(Box1, Box2, Box3);
	}
	//Overriding // Polymorphism
	public void makeTracker(HBox sOC, HBox sTC, HBox sThC, Label sOL, Label sTL, Label sThL, ProgressBar bO, 
			ProgressBar bT,ProgressBar bTh, Label iO, Label iT, Label iTh, VBox tC, Button r, Button nD, 
			TextField tO, Label mO, TextField tT, Label mT, 
			TextField tTh, Label mTh, HBox bH, HBox lH, Label dC) {
		 int counter=0; // skillNumber
		 
		 for (String element : getPickedList()) {			 
			 
			 if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 0) { //skill One	
				 this.sOL = element;
				 sOC.getChildren().addAll(sOL,bO,iO, tO, mO);
				 changeLabel(sOL," "+ element+" ");
				 tC.getChildren().add(sOC);
				 					 
			 }
			 else if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 1) { //skill Two
				 this.sTL=element;
				 sTC.getChildren().addAll(sTL,bT,iT, tT, mT);
				 changeLabel(sTL," "+ element+" ");
				 tC.getChildren().add(sTC);
			 }
			 else if((element.equals("python") || element.equals("html") ||  element.equals("java")) && counter == 2) { //skillThree
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
		if(progressOne <1) {
			
			
			XP = 0;
			
			errorOne = oneError(textStringOne);//checks for error
			if(errorOne==false) {
				textValueOne = (int) Double.parseDouble(textStringOne);		// got the textValue from the input button	 	
				if (textValueOne ==0 && progressOne>0) {
					XP = 200;
					messageOne.setText("XP lost today: " + XP );
				}
				else if(progressOne==0 && textValueOne==0) {
					messageOne.setText("Learning not started. No XP loss or gain.");
				}
				else if(progressOne>=1) {
					messageOne.setText("Learning finished. No XP loss or gain.");
				}
				else {
					XP = (int)(setProgressXP(textValueOne) * 10000); // a proper XP to show.
					messageOne.setText("XP earned today: " + XP);
					 
				}
				 
				 
			 }
			 else{
				 messageOne.setText("Enter valid number without alphabets or decimals that is between 0 and 24.");
			 }
		}
		else {
			textValueOne=0;
			messageOne.setText("Learning is finished");
		}
		
	}
	public void calculateXPTwo(String textStringTwo, Label messageTwo) {
		if (progressTwo<1) {
		
		
		XP = 0;
		
		errorTwo = oneError(textStringTwo);//checks for error
		if(errorTwo==false) {
			textValueTwo = (int) Double.parseDouble(textStringTwo);		// got the textValue from the input button	 	
			if (textValueTwo ==0 && progressTwo>0) {
				XP = 200;
				messageTwo.setText("XP lost today: " + XP );
			}
			else if(progressTwo==0 && textValueTwo==0) {
				messageTwo.setText("Learning not started. No XP loss or gain.");
			}
			else if(progressTwo>=1) {
				messageTwo.setText("Learning finished. No XP loss or gain.");
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
		else {
			textValueTwo=0;
			messageTwo.setText("Learning is finished");
		}
		
	}
	public void calculateXPThree(String textStringThree, Label messageThree) {
		if(progressThree<1) {
		
		
		XP = 0;
		
		errorThree = oneError(textStringThree);//checks for error
		if(errorThree==false ) {
			textValueThree = (int) Double.parseDouble(textStringThree);		// got the textValue from the input button	 	
			if (textValueThree ==0 && progressThree>0) {
				XP = 200;
				messageThree.setText("XP lost today: " + XP );
			}
			else if(progressThree==0 && textValueThree==0) {
				messageThree.setText("Learning not started. No XP loss or gain.");
			}
			else if(progressThree>=1) {
				messageThree.setText("Learning finished. No XP loss or gain.");
			}
			else {
				XP = (int)(setProgressXP(textValueThree) * 10000); // a proper XP to show.
				messageThree.setText("XP earned today: " + XP);
			}			 			 
		}
	 	else {
	 		messageThree.setText("Enter valid number without alphabets or decimals that is between 0 and 24.");
	 	}
		}
		else {
			textValueThree=0;
			messageThree.setText("Learning is finished");
		}
	}


	

	
	public void progressUpdate(ProgressBar barOne, ProgressBar barTwo, ProgressBar barThree, Label dayCounter, String textStringOne, Label messageOne,
			String textStringTwo, Label messageTwo, String textStringThree, Label messageThree) {
		
		if (sOL!=null) {
			calculateXPOne(textStringOne,messageOne);
			
		}
		if  (sTL!=null) {
			calculateXPTwo(textStringTwo,messageTwo);
			
		}
		if  (sThL!=null) {
			calculateXPThree(textStringThree, messageThree);
			
		}
		
		
		if (sOL!=null && sTL!=null && sThL!=null) { // // If a;; three sub-skills are picked by user.
		if((textValueOne + textValueTwo + textValueThree) <=24 && errorOne==false && errorTwo==false && errorThree==false ) {
			
		
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
			
			if (progressOne>=1) {
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				messageOne.setText(" Congratulations! Learning "+sOL+" is finished . No more losing XP. TextField value will be ignored.");
				barOne.setStyle("-fx-accent:red;");
				textValueOne = 0;///
				
			}
			else {
				barOne.setStyle("-fx-accent:blue;");
			}
			if (progressTwo>=1) {
				messageTwo.setText(" Congratulations! Learning "+sTL+" is finished. No more losing XP. TextField value will be ignored.");
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				barTwo.setStyle("-fx-accent:red;");
				textValueTwo = 0; ///
				
			}
			else {
				barTwo.setStyle("-fx-accent:purple;");
			}
			if (progressThree>=1) {
				messageThree.setText(" Congratulations! Learning "+sThL+" is finished. No more losing XP. TextField value will be ignored.");
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				barThree.setStyle("-fx-accent:red;");
				textValueThree=0;///
				
			}
			else {
				barThree.setStyle("-fx-accent:brown;");
			}
			
			if (progressOne>=1 &&  progressTwo>=1 && progressThree>=1) {
				
				dayCounter.setText("DAY: "+day+"   Congratulations! ALL FINISHED AT DAY-->" +day +"."+" (Red means finished learning) ");
			}							
			
			
		}
		else if((textValueOne + textValueTwo + textValueThree)>24){ 					
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
		if((textValueOne + textValueTwo) <=24 && errorOne==false && errorTwo==false) {
			
		
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
			
			if (progressOne>=1) {
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				messageOne.setText(" Congratulations! Learning "+sOL+" is finished . No more losing XP. TextField value will be ignored.");
				barOne.setStyle("-fx-accent:red;");
				textValueOne = 0;///
				
			}
			else {
				barOne.setStyle("-fx-accent:blue;");
			}
			if (progressTwo>=1) {
				messageTwo.setText(" Congratulations! Learning "+sTL+" is finished. No more losing XP. TextField value will be ignored.");
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				barTwo.setStyle("-fx-accent:red;");
				textValueTwo = 0; ///
				
			}
			else {
				barTwo.setStyle("-fx-accent:purple;");
			}			
			
			if (progressOne>=1 &&  progressTwo>=1) {
				
				dayCounter.setText("DAY: "+day+"   Congratulations! ALL FINISHED AT DAY-->" +day +"."+" (Red means finished learning) ");
			}							
			
			
		}
		else if((textValueOne + textValueTwo)>24) { 					
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
		if((textValueOne + textValueTwo + textValueThree) <=24 && errorOne==false && errorTwo==false && errorThree==false ) {
			
		
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
			
			if (progressOne>=1) {
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				messageOne.setText(" Congratulations! Learning "+sOL+" is finished . No more losing XP. TextField value will be ignored.");
				barOne.setStyle("-fx-accent:red;");
				textValueOne = 0;///
				
			}
			else {
				barOne.setStyle("-fx-accent:blue;");
			}
						
			
			if (progressOne>=1) {
				
				dayCounter.setText("DAY: "+day+"   Congratulations! FINISHED AT DAY-->" +day +"."+" (Red means finished learning) ");
			}							
			
			
		}
		else if((textValueOne)>24) { 					
				dayCounter.setText("ERROR! Total time spent on all skills must be less than or equal to 24 hours. Enter values again.");
				if (messageOne!=null) {
					messageOne.setText("");
				}							
			
		}
		
		
	}
	}
	}
	
	
	

	
	
	
	


	

	
