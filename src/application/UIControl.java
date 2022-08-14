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
	
	private HBox sOC;
	private HBox sTC;
	private HBox sThC;
		 
	public UIControl(CheckBox Box1, CheckBox Box2,CheckBox Box3) {
		this.Box1=Box1;
		this.Box2=Box2;
		this.Box3=Box3;
	}
	
	public UIControl() {
		
	}
		
		
	public void PickViewCheckBoxLogic(String one, String two, String three, int hourIncrement) {
		if (Box1.isSelected()) {
			counterOne++; // 2nd time onwards always 2
		 
			if(counterOne==1) {
			pickedList.add(one);
			textDefault += one+" ";
			hoursSkillCounterOne++;
			  
			if (hoursSkillCounterOne==1) {
				hoursSkill = getHoursSkill() + hourIncrement;
			}
			if(hoursSkillCounterOne==2) {
				hoursSkillCounterOne=1;
			}
			  
			  
		}
			if(counterOne==2) {
				counterOne=1; // 2nd time onwards always becomes 1 in the end
			  
			}
		}
	  else {
		  if (listHasElement(one)) {
			  pickedList.remove(one);
		  }
		  textRemove(textDefault, one);
		  
		 
		  if(counterOne==1) {
			  hoursSkill = getHoursSkill() - hourIncrement;
			  counterOne--;
			  hoursSkillCounterOne--;
		  }
	  }

	 
	  
	  if (Box2.isSelected()) {
		  counterTwo++;
		  
		  if(counterTwo==1) {
			  pickedList.add(two);
			  textDefault+= two+" ";
			  
			  hoursSkillCounterTwo++;
			  
		  if (hoursSkillCounterTwo==1) {
			  hoursSkill = getHoursSkill() + hourIncrement;
		  }
		  if(hoursSkillCounterTwo==2) {
				  hoursSkillCounterTwo=1;
		  }
		  }
		  if(counterTwo==2) {
			  counterTwo=1;
		  }
	  }
	  else {
		  if(listHasElement(two)) {
			  pickedList.remove(two);
		  }
		  textRemove(textDefault, two);
		  
		  if (counterTwo==1) {
			  hoursSkill = getHoursSkill() - hourIncrement;
			  counterTwo--;
			  hoursSkillCounterTwo--;
		  }
	  }
	  
	  
	  if (Box3.isSelected()) {
		  counterThree++;
		  
		  if (counterThree==1) {
			  pickedList.add(three);
			  textDefault+= three+" ";
			  hoursSkillCounterThree++;
			  
			  if (hoursSkillCounterThree==1) {
				  hoursSkill = getHoursSkill() + hourIncrement;
			  }
			  if(hoursSkillCounterThree==2) {
				  hoursSkillCounterThree=1;
			  }
			  
			
		  }
		  if(counterThree==2) {
			  counterThree=1;
		  }
	  }
	  else {
		  if(listHasElement(three)) {
			  pickedList.remove(three);
		  }
		  textRemove(textDefault, three);
		  
		  if(counterThree==1) {
			  hoursSkill = getHoursSkill() - hourIncrement;
			  counterThree--;
			  hoursSkillCounterThree--;
		  }
	  }
	
	  
	
}
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
					 sentence = sentence.replaceAll(" "+ toRemove, ""); //added a whitespace to make sure no whitespace is left behind when a word is removed.
					 textDefault = sentence;
				 }			  			
				 
				 }
			 }
	 }
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
	
		 
	public void makeTracker(HBox sOC, HBox sTC, HBox sThC, Label sOL, Label sTL, Label sThL, ProgressBar bO, 
			ProgressBar bT,ProgressBar bTh, Button iO, Button iT, Button iTh, VBox tC, Button r, Button nD, 
			TextField tO, Label mO, TextField tT, Label mT,TextField tTh, Label mTh ) {
		this.sOC=sOC;
		this.sTC=sTC;
		this.sThC=sThC;
		
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
		 tC.getChildren().addAll(r, nD);
		 
		 
	 }
	 public String getTextDefault() {
		 return textDefault;
	 }

	 public int getHoursSkill() {
		return hoursSkill;
	}
	
	 public ArrayList<String> getPickedList(){
		 
		 return new ArrayList<String> (pickedList);
	 }
	 public void changeLabel(Label label, String text) { 		 
		 
		 label.setText(text); 

} 
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
	

	public void calculateXP(String textOneString, Label messageOne) {	
		
	}
	public boolean oneError(String textOneString) {
		boolean Error=false;		
        	
    	for(char c : textOneString.toCharArray()){  		
   		
    		if (!Character.isDigit(c) || (c=='.')) {
    			Error = true;    			
    		}
    		else {
    			Error = false;
    		}
    	}
    	return Error;
		
	}

	

}

