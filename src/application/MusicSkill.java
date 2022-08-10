package application;  

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;  
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox; 
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;   
import javafx.stage.Stage;   
import javafx.scene.control.CheckBox;  


public class PrimeController extends UIControl{ 	 

	private Stage applicationStage = new Stage(); 
	private Parent root;
	private Scene mainScene;
					 

	 @FXML 
    private ChoiceBox<String> skillChooseChoiceBox; 	  

	 @FXML 
	  private Label skillPickedLabel = new Label(); 
	  
	 
	    //private ArrayList<String> skillPickedList = new ArrayList<String> (); 
	 @FXML
	 private HBox mainViewButtonsHBox;
	 
	 private Button nextButtonMainView = new Button("Next >");
	    
	  private String skillPickedString ; 
    
	   @FXML
	   private Button LanguagePickerBackButton;
	   
	   @FXML
	   private CheckBox guitarBox;
	   @FXML 
	   private Label pickMusic;
	  
	 private String defaultText = "";
	 private int nextButtonCounter = 0;
	 String textDefaultMusic= "You chose: ";
	 String textDefaultMusicThree="So, a total of ";
	 
	 
	 private  ArrayList<String> instrumentPickedList = new ArrayList<String> ();
	 @FXML 
	private CheckBox pianoBox;
	 @FXML
	private CheckBox drumsBox;
	 @FXML
	 private Label musicLabel1;
	 @FXML
	 private Label musicLabel2;
	 @FXML
	private Label musicLabel3 ;
	 
	 private int guitarCounter=0;
	  private int pianoCounter=0;
	  private int drumsCounter=0;
	  
	  private int hoursMusic = 0;
	
	  

	// private void changeLabel(Label label, String text) { 

		 

			// label.setText(text); 

	//}
	 
	  
	  @FXML 
	 public void confrimButton(ActionEvent pickSkill) { 
		  defaultText=""; 
		  String skillChose =  skillChooseChoiceBox.getValue(); 
		  if (skillChose.equals("Coding")) { 
			  skillPickedString = ""; 
			  defaultText+="Coding"; 
			  changeLabel(skillPickedLabel,defaultText);		   
			  skillPickedString = "Coding"; 
			   } 
		  else if(skillChose.equals("Language Learning")) { 
			  skillPickedString = ""; 
			  defaultText+="Language Learning"; 
			  changeLabel(skillPickedLabel,defaultText);
			  skillPickedString="Language"; 			  
		  } 
		  else if (skillChose.equals("Musical Instruments")) {
			  skillPickedString = ""; 
			  defaultText += "Musical Instruments"; 
			  changeLabel(skillPickedLabel,defaultText); 
			  skillPickedString = "Musical";			  		  	   
			  }
		  
		  if (nextButtonCounter ==0) {
		  mainViewButtonsHBox.getChildren().add(nextButtonMainView);
		  nextButtonCounter++;
		  }
		  nextButtonMainView.setOnAction(nextEvent -> {
			try {
				mainViewNextButton(nextEvent);
			} catch (IOException e) {
				System.out.println("Button not working");
				e.printStackTrace();
			}
		});
		 
	 } 
//resetButtons
	  @FXML 
	  public void resetButtonMain(ActionEvent resetMain) { 
		  skillPickedString = ""; 
		  changeLabel(skillPickedLabel, ""); 
		  nextButtonCounter = 0;
		  mainViewButtonsHBox.getChildren().remove(nextButtonMainView);		  
		  
	  } 
	   
	  @FXML
	  public void resetButtonMusicPick(ActionEvent resetMusic){
		  guitarBox.setSelected(false);
		  pianoBox.setSelected(false);
		  drumsBox.setSelected(false);
		  changeLabel(pickMusic, " ");
		  changeLabel(musicLabel1, ".................................... ");
		  changeLabel(musicLabel2, ".................................... ");
		  changeLabel(musicLabel3, ".................................... ");
	  }
	//resetButtonsEnd  
	  @FXML
	  public void mainViewNextButton(ActionEvent changeScene) throws IOException  {
		  if((skillPickedString.equals("Coding"))) {
			  root = FXMLLoader.load(getClass().getResource("CodingLanguagePickerView.fxml"));
			  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
			  mainScene = new Scene(root);
			  applicationStage.setScene(mainScene);
			  applicationStage.show();
	  }
		  else if((skillPickedString.equals("Language"))) {
			  root = FXMLLoader.load(getClass().getResource("LanguagePickerView.fxml"));
			  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
			  mainScene = new Scene(root);
			  applicationStage.setScene(mainScene);
			  applicationStage.show();
	  }
		  else if((skillPickedString).equals("Musical")) {
			  root = FXMLLoader.load(getClass().getResource("MusicalInstrumentPickerView.fxml"));
			  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
			  mainScene = new Scene(root);
			  applicationStage.setScene(mainScene);
			  applicationStage.show();
	  }
	  }
	  
	  // BackBttons Start
	  @FXML
	  public void MusicalPickerBackButton(ActionEvent changeScene) throws IOException { 
		  root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
		  mainScene = new Scene(root);
		  applicationStage.setScene(mainScene);
		  applicationStage.show();
	  } 

	  //BackButtonS End
	  
	  
	  
	  @FXML
	  public void musicSkillViewLogic() {	  	  
		  
		  if (guitarBox.isSelected()) {
			  guitarCounter++;
			  if(guitarCounter==1) {
				  instrumentPickedList.add("guitar");
				  textDefaultMusic+= " guitar";
				  hoursMusic+=1500;
				  textDefaultMusicThree+= hoursMusic + " hours";
				  
			  }
		  }
		  else {
			  if (musicListHasElement("guitar")) {
				  instrumentPickedList.remove("guitar");
			  }
			  textRemove(textDefaultMusic, "guitar");
			  textRemove(textDefaultMusicThree, hoursMusic + "hours");
			 
			  if(guitarCounter==1) {
				  hoursMusic-=1500;
				  guitarCounter--;
			  }
		  }
	 
		 
		  
		  if (pianoBox.isSelected()) {
			  pianoCounter++;
			  if(pianoCounter==1) {
				  instrumentPickedList.add("piano");
				  textDefaultMusic+= " piano";
				  hoursMusic+=1500;
				  textDefaultMusicThree+= hoursMusic + " hours";
			  }
		  }
		  else {
			  if(musicListHasElement("piano")) {
				  instrumentPickedList.remove("piano");
			  }
			  textRemove(textDefaultMusic, "piano");
			  textRemove(textDefaultMusicThree, hoursMusic + "hours");
			  if (pianoCounter==1) {
				  hoursMusic-=1500;
				  pianoCounter--;
			  }
		  }
		  
		  
		  if (drumsBox.isSelected()) {
			  drumsCounter++;
			  if (drumsCounter==1) {
				  instrumentPickedList.add("drums");
				  textDefaultMusic+= " drums";
				  hoursMusic+=1500;
				  textDefaultMusicThree+= hoursMusic + " hours";
				
			  }
		  }
		  else {
			  if(musicListHasElement("drums")) {
				  instrumentPickedList.remove("drums");
			  }
			  textRemove(textDefaultMusic, "drums");
			  textRemove(textDefaultMusicThree, hoursMusic + "hours");
			  if(drumsCounter==1) {
				  hoursMusic-=1500;
				  drumsCounter--;
			  }
		  }
		  
		  
	  }
	  
	  @FXML
	  public void musicSkillDoneButton(ActionEvent event) {
		 changeLabel(pickMusic, textDefaultMusic);
		 changeLabel(musicLabel3, textDefaultMusicThree);
		  
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
					 sentence = sentence.replaceAll(toRemove, "");
					 textDefaultMusic = sentence;
				 }			  			
				 
				 }
			 }
	 }
	 
	 private boolean musicListHasElement(String element) {
		 boolean value=false;
		 
		 for(String i: instrumentPickedList) {
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
	 
	 