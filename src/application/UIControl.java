package application;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class UIControl {
	private int counterOne=0;
	private int counterTwo=0;
	private int counterThree=0;
	private int hoursSkill = 0;		
	private int hoursSkillCounterOne=0;
	private int hoursSkillCounterTwo=0;
	private int hoursSkillCounterThree=0;
	private  ArrayList<String> pickedList = new ArrayList<String> ();		
	private String textDefault= "You chose: ";	 
	private CheckBox Box1;
	private CheckBox Box2;
	private CheckBox Box3;

	/**
	 * Constructs the object with the fields that make it unique. 	  
	 * @param Box1 takes the state of the check box and stores it in a field.
	 * @param Box2 takes the state of the check box and stores it in a field.
	 * @param Box3 takes the state of the check box and stores it in a field.
	 */
	public UIControl(CheckBox Box1, CheckBox Box2,CheckBox Box3) { 
		this.Box1=Box1;
		this.Box2=Box2;
		this.Box3=Box3;
	}
	/**
	 * empty constructor to imitate default constructor.
	 */
	public UIControl() {
		
	}
	
	/**
	 * Responds to the user clicking on check boxes. Keeps a record of which sub skills the user picked to make the skill tracker.
	 * 
	 * @param one a String to add to pickedList ArrayList to record that the user picked the skill. 
	 * @param two a String to add to pickedList ArrayList to record that the user picked the skill.
	 * @param three a String to add to pickedList ArrayList to record that the user picked the skill.
	 * @param hourIncrement an int that denotes how many hours a user should spend per skill.
	 */
	public void PickViewCheckBoxLogic(String one, String two, String three, int hourIncrement) {
		if (Box1.isSelected()) { // if selected
			counterOne++; // counter increments if box is selected.
		 
			if(counterOne==1) { 
				pickedList.add(one); // if box is selected adds the skill designated to the check box to an array list to keep record.
				textDefault += one+" "; // updates the string for the label.
				hoursSkillCounterOne++; // to make it eligible to be added to total hours.
			  
			if (hoursSkillCounterOne==1) { 
				hoursSkill = getHoursSkill() + hourIncrement; // added to the total hours that need to be spent on the skills.
			}
			if(hoursSkillCounterOne==2) {
				hoursSkillCounterOne=1; // if counter rises to two, it is set to 1.
			}
			  
			  
			}
			if(counterOne==2) {
				counterOne=1; // if counter rises to two, it is set to 1.
			  
			}
		}
		else { // if unselected or not in a selected state.
			if (listHasElement(one)) { 
				pickedList.remove(one); // if list has the skill on record, it'll be removed.
			}
			textRemove(textDefault, one);
		  
			
			if(counterOne==1) { // if the hours were added to total hours for the skill, it will be subtracted.
				hoursSkill = getHoursSkill() - hourIncrement;
				counterOne--; // to keep proof of subtraction.
				hoursSkillCounterOne--; // to keep proof of subtraction.
			}
		}

	 
	  
		if (Box2.isSelected()) { // if selected
			counterTwo++; // counter increments if box is selected.
		  
			if(counterTwo==1) {
				pickedList.add(two); // if box is selected adds the skill designated to the check box to an array list to keep record.
				textDefault+= two+" "; // updates the string for the label.				
				hoursSkillCounterTwo++; // to make it eligible to be added to total hours.
			  
				if (hoursSkillCounterTwo==1) {
					hoursSkill = getHoursSkill() + hourIncrement; // added to the total hours that need to be spent on the skills.
				}
				if(hoursSkillCounterTwo==2) {
					hoursSkillCounterTwo=1;  // if counter rises to two, it is set to 1.
				}
			}
			if(counterTwo==2) { 
			  counterTwo=1; // if counter rises to two, it is set to 1.
			}
		}
		else { // if unselected or not in a selected state.
			if(listHasElement(two)) {
				pickedList.remove(two); // if list has the skill on record, it'll be removed.
			}
			textRemove(textDefault, two);
		  
			if (counterTwo==1) { // if the hours were added to total hours for the skill, it will be subtracted.
				hoursSkill = getHoursSkill() - hourIncrement;
				counterTwo--; // to keep proof of subtraction.
				hoursSkillCounterTwo--; // to keep proof of subtraction.
			}
		}
	  
	  
		if (Box3.isSelected()) { // if selected
			counterThree++; // counter increments if box is selected.
			 
			if (counterThree==1) {
				pickedList.add(three); // if box is selected adds the skill designated to the check box to an array list to keep record.
				textDefault+= three+" "; // updates the string for the label.
				hoursSkillCounterThree++; // to make it eligible to be added to total hours.
			  
				if (hoursSkillCounterThree==1) {
					hoursSkill = getHoursSkill() + hourIncrement; // added to the total hours that need to be spent on the skills.
				}
				if(hoursSkillCounterThree==2) {
					hoursSkillCounterThree=1; // if counter rises to two, it is set to 1.
				}
				
			
			}
			if(counterThree==2) {
				counterThree=1; // if counter rises to two, it is set to 1.
			}
		}
		else { // if unselected or not in a selected state.
			if(listHasElement(three)) {
				pickedList.remove(three); // if list has the skill on record, it'll be removed.
			}
			textRemove(textDefault, three);
		  
			if(counterThree==1) { // if the hours were added to total hours for the skill, it will be subtracted.
				hoursSkill = getHoursSkill() - hourIncrement;
				counterThree--; // to keep proof of subtraction.
				hoursSkillCounterThree--; // to keep proof of subtraction.
			}
		}
	
	  
	
	}
	
	
	/**
	 * This method makes the tracker using the building blocks such HBox, buttons, labels etc
	 * by taking them as arguments. The variable names are abbreviated, e.g. skillOneContainer is
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
			TextField tO, Label mO, TextField tT, Label mT,TextField tTh, Label mTh, HBox bH, HBox lH, Label dC ) {
	
		
		int counter=0; // skillNumber
		for (String element : pickedList) {			 
			 
			Object firstSkill = null;
			Object secondSkill = null;
			Object thirdSkill = null;
			if((element.equals(firstSkill) || element.equals(secondSkill) ||  element.equals(thirdSkill)) && counter == 0) { //skill One				 
				sOC.getChildren().addAll(sOL,bO,iO, tO, mO);
				changeLabel(sOL, element);
				tC.getChildren().add(sOC);
				 					 
			}
			else if((element.equals(firstSkill) || element.equals(secondSkill) ||  element.equals(thirdSkill)) && counter == 1) { //skill Two
				sTC.getChildren().addAll(sTL,bT,iT,tT, mT);
				changeLabel(sTL, element);
				tC.getChildren().add(sTC);
			}
			else if((element.equals(firstSkill) || element.equals(secondSkill) ||  element.equals(thirdSkill)) && counter == 2) { //skillThree
				sThC.getChildren().addAll(sThL,bTh,iTh,tTh, mTh);
				changeLabel(sThL, element);
				tC.getChildren().add(sThC);
			 }	
			counter++;
			
		}	
		 bH.getChildren().addAll(r, nD);
		 lH.getChildren().add(dC);
		 tC.getChildren().addAll(bH, lH);
		 
		 
	}
	/**
	 * gets the textDefault String value.
	 * @return the textDefault value.
	 */
	public String getTextDefault() {
		return textDefault;
	}

	/**
	 * acceses the hoursSkill int value.
	 * @return int called hoursSkill.
	 */
	public int getHoursSkill() {
		return hoursSkill;
	}
	
	/**
	 * Creates a new object of pickedList and returns it.
	 * @return returns an array list called pickedList as a new object to avoid privacy leak.
	 */
	public ArrayList<String> getPickedList(){
		
		return new ArrayList<String> (pickedList);
	}
	

	 /**
	  * This method just sets texts to labels.
	  * 
	  * @param label a Label object that holds the label the user wants to edit.
	  * @param text the text the user wants to edit the label with.
	  */
	public void changeLabel(Label label, String text) { 		 
		
		label.setText(text); 

	} 
	
	/**
	 * clears all info of an UIControl object.
	 */
	public void clearAllInfo() {
		counterOne=0;
		counterTwo=0;
		counterThree=0;
		hoursSkill = 0;
				
		hoursSkillCounterOne=0;
		hoursSkillCounterTwo=0;
		hoursSkillCounterThree=0;
		pickedList = null;
				
		textDefault= "You chose: ";
		
		Box1.setSelected(false);
		Box2.setSelected(false);
		Box3.setSelected(false);
		 
	}
	
	/**
	 * Used in the child classes polymorphically.
	 * @param textStringOne a String gotten from a text field for skill one.
	 * @param message a Label for the skill one.
	 */
	public void calculateXPOne(String textStringOne, Label messageOne) {	
		//Used in the child classes polymorphically.
	}
	
	
	/**
	 * Used in the child classes polymorphically.
	 * @param textStringTwo a String gotten from a text field for skill two.
	 * @param message a Label for the skill two.
	 */
	public void calculateXPTwo(String textStringTwo, Label messageTwo) {	
		//Used in the child classes polymorphically.
	}
	
	
	/**
	 * Used in the child classes polymorphically.
	 * @param textStringThree a String gotten from a text field for skill three.
	 * @param message a Label for the skill three.
	 */
	public void calculateXPThree(String textStringThree, Label messageThree) {	
		//Used in the child classes polymorphically.
	}
	
	/**
	 * Converts text value given by user to XP points.
	 * @param textValue takes the text value that the user provides as hours and converts it to XP points.
	 * @return a double value as XP point for Progress Bar to use.
	 */
	public double setProgressXP(int textValue) {				
		//polymorphism call in other child classes. this one purely used by codingSkill class
		return (textValue/250.0);
	}

	
	/**
	 * Checks if a string from the text field is appropriate or not.
	 * @param textString a String gotten from a text field.
	 * @return return if the text is appropriate or not.
	 */	
	public boolean oneError(String textString) {
		boolean error=false;		
		
		for(char c : textString.toCharArray()){  		
			
			if (!Character.isDigit(c) || (c=='.')) {
				error = true;    			
			}
    		
		}
		if(error==false && textString!="")	{	
  			
			int textValue = (int) Double.parseDouble(textString);
			if (textValue < 0 || textValue >25) {
				error=true;
			}
			else {
				error = false;   
			}  
    	  	}
		if(textString=="") {
			error=true;
		}
		
    	return error;
    	
	}
	
	/**
	 * Used polymorphically by child classes to update the Progress Bar.
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
		//Used polymorphically by child classes.
	}
	
	/**
	 * clears the array list which keeps the the record of which sub skills the user picked.
	 */
	public void clearPickedList() {
		pickedList.clear();
	}

	/**
	 * Removes selected word from a sentence.
	 * 
	 * @param sentence the sentence that is intended to be edited.
	 * @param toRemove the work that is intended to be removed.
	 */
	private void textRemove(String sentence, String toRemove) {
		int counter =0;
		int desiredIndex=0;
		char[] array = sentence.toCharArray();
		for(Character i : array) {
			int iIndex = sentence.indexOf(i);
			 
			if(i.equals(toRemove.charAt(counter))) {
				int iIndexPrevious = iIndex-1;
				char c = (sentence.charAt(iIndexPrevious));
				if(c == ' ') {
					desiredIndex = sentence.indexOf(i);
					sentence = sentence.replaceAll(" "+ toRemove, ""); //deleted a whitespace to make sure no whitespace is left behind when a word is removed.
					textDefault = sentence;
				}			  			
				 
			}
		}
	}
	
	/**
	 * Checks if the list has a specific element.
	 * @param element a String that used to check if it itself exists in an array list.
	 * @return returns a boolean to denote if the string exists in the array list or not.s
	 */
	private boolean listHasElement(String element) {
		boolean value=false;
		 
		for(String i: pickedList) {
			if (i.equals(element)) {
				value =true;
			}
			else {
				return false;
			}		 
			
		}
		return value;
	}
	

		
	}
	
	

	
	

	



