
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
	private String textStringOne;
	private String textStringTwo;
	private String textStringThree;
	private int inputButtonCounterOne=0; //
	private int inputButtonCounterTwo=0;//
	private int inputButtonCounterThree=0;//
	private Label messageOne;
	private Label messageTwo;
	private Label messageThree;
	private String sOL;
	private String sTL;
	private String sThL;
	private boolean ErrorOne;
	private boolean ErrorTwo;
	private boolean ErrorThree;
	private int inputRequired;
	
	public CodingSkill(CheckBox Box1, CheckBox Box2,CheckBox Box3) {
		super(Box1, Box2, Box3);
	}
	//Overriding // Polymorphism
	public void makeTracker(HBox sOC, HBox sTC, HBox sThC, Label sOL, Label sTL, Label sThL, ProgressBar bO, 
			ProgressBar bT,ProgressBar bTh, Button iO, Button iT, Button iTh, VBox tC, Button r, Button nD, 
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
			this.messageOne=messageOne;
			inputButtonCounterOne++;
			XP = 0;
			this.textStringOne = textStringOne;
			ErrorOne = oneError(textStringOne);//checks for error
			if(ErrorOne==false && textStringOne != "") {
				textValueOne = (int) Double.parseDouble(textStringOne);		// got the textValue from the input button	 	
				if (textValueOne ==0 && progressOne!=0) {
					XP = 200;
					messageOne.setText("XP lost today: " + XP );
				}
				else if(progressOne==0) {
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
			 else {
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
		this.messageTwo=messageTwo;
		inputButtonCounterTwo++;
		XP = 0;
		this.textStringTwo= textStringTwo;
		ErrorTwo = oneError(textStringTwo);//checks for error
		if(ErrorTwo==false && textStringTwo != "") {
			textValueTwo = (int) Double.parseDouble(textStringTwo);		// got the textValue from the input button	 	
			if (textValueTwo ==0 && progressTwo!=0) {
				XP = 200;
				messageTwo.setText("XP lost today: " + XP );
			}
			else if(progressTwo==0) {
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
		this.messageThree=messageThree;
		inputButtonCounterThree++;
		XP = 0;
		this.textStringThree=textStringThree;
		ErrorThree = oneError(textStringThree);//checks for error
		if(ErrorThree==false && textStringThree != "") {
			textValueThree = (int) Double.parseDouble(textStringThree);		// got the textValue from the input button	 	
			if (textValueThree ==0 && progressThree!=0) {
				XP = 200;
				messageThree.setText("XP lost today: " + XP );
			}
			else if(progressThree==0 ) {
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
	
	public void progressUpdate(ProgressBar barOne, ProgressBar barTwo, ProgressBar barThree, Label dayCounter) {
		inputRequired = (inputButtonCounterOne + inputButtonCounterTwo + inputButtonCounterThree);
		
		if((textValueOne + textValueTwo + textValueThree) <=24 && inputRequired>=3) {
			
		
			if (!(progressOne>=1) && !( progressTwo>=1) && !(progressThree>=1) && textStringOne!="" && textStringTwo!="" && textStringThree!=""  && ErrorOne==false && ErrorTwo==false && ErrorThree==false ){ //day will not increase when all learning is finished
				day++;//day increments as nextDay button is pressed
			}
			
			if (textValueOne==0 && progressOne > 0 && progressOne<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false ) {
				progressOne -= .03; //decrementing progress for not practicing;
				barOne.setProgress(progressOne); // actual XP that is lost.
			}
			else {
				if(progressOne < 1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false) {
					progressOne += setProgressXP(textValueOne); // using the textValue for setting progress.
					barOne.setProgress(progressOne); // actual XP that is earned visually.
				}
			}
				
			if (textValueTwo==0 && progressTwo>0 && progressTwo<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false)  {
				progressTwo -= .03; //decrementing progress for not practicing;
				barTwo.setProgress(progressTwo); // actual XP that is lost.
			}
			else {
				if(progressTwo < 1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false) {
					progressTwo += setProgressXP(textValueTwo); // using the textValue for setting progress.
					
					barTwo.setProgress(progressTwo); // actual XP that is earned visually.
				}
			}
				
			
			if (textValueThree==0 && progressThree>0 && progressThree<1 && textStringOne!="" && textStringTwo!="" && textStringThree!="" && ErrorOne==false && ErrorTwo==false && ErrorThree==false) {
				progressThree -= .03; //decrementing progress for not practicing;
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
				textValueOne = 0;///
				inputRequired--;
			}
			else {
				barOne.setStyle("-fx-accent:blue;");
			}
			if (progressTwo>=1) {
				messageTwo.setText(" Congratulations! Learning "+sTL+" is finished. No more losing XP");
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				barTwo.setStyle("-fx-accent:red;");
				textValueTwo = 0; ///
				inputRequired--;
			}
			else {
				barTwo.setStyle("-fx-accent:purple;");
			}
			if (progressThree>=1) {
				messageThree.setText(" Congratulations! Learning "+sThL+" is finished. No more losing XP");
				dayCounter.setText("DAY: "+day +"     Red means finished learning"); //
				barThree.setStyle("-fx-accent:red;");
				textValueThree=0;///
				inputRequired--;
			}
			else {
				barThree.setStyle("-fx-accent:brown;");
			}
			
			if (progressOne>=1 &&  progressTwo>=1 && progressThree>=1) {
				
				dayCounter.setText("DAY: "+day+"   Congratulations! ALL FINISHED AT DAY-->" +day +"."+" (Red means finished learning) ");
			}							
			
			
		}
		else { 
			if (inputRequired<3) {
			dayCounter.setText("Enter the values and Press INPUT on all three skills for TODAY. ");
			if (messageOne!=null && progressOne<1) {
				messageOne.setText("Enter the values again and press input button.");
			}
			if (messageTwo!=null && progressTwo <1) {
				messageTwo.setText("Enter the values again and press input button.");
			}
			if (messageThree!=null &&progressThree<1) {
				messageThree.setText("Enter the values again and press input button.");
			}
								
			}
			if((textValueOne + textValueTwo + textValueThree) >24) {
				dayCounter.setText("ERROR! Total time spent on all skills must be less than 24 hours. Input aall three values again.");
				if (messageOne!=null) {
					messageOne.setText("Enter the values again and press input button.");
				}
				if (messageTwo!=null) {
					messageTwo.setText("Enter the values again and press input button.");
				}
				if (messageThree!=null) {
					messageThree.setText("Enter the values again and press input button.");
				}
			}
			
		}
		inputButtonCounterOne=0; /// reseting input button counters to 0 so that they have to clicked again before they move on to the next day.
		inputButtonCounterTwo=0; ///
		inputButtonCounterThree=0; ///
		
	}
	
	
	

	
	
	
}