package application;

import java.util.ArrayList;

import javafx.scene.control.CheckBox;


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
	 public String getTextDefault() {
		 return textDefault;
	 }


	 public int getHoursSkill() {
		return hoursSkill;
	}
	
	 public String getPickedList(){
		 System.out.println(pickedList.size()); 
		 return pickedList.get(0);
	 }

}

