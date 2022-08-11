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


public class PrimeController{ 	 

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
	 
	 @FXML 
	 private CheckBox frenchBox;
	 
	 @FXML 
	 private CheckBox englishBox;
	 
	 @FXML 
	 private CheckBox arabicBox;
	 
	 
	 @FXML
	 private Label pickLanguage;	 
	 @FXML
	 private Label languageLabelOne;
	 @FXML
	 private Label languageLabelTwo;
	 @FXML
	 private Label languageLabelThree;
	

	  

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
		  changeLabel(musicLabel1, "You need to spend roughly 1500 hours");
		  changeLabel(musicLabel2, "on each instrument to achieve mastery.");
		  changeLabel(musicLabel3, " ");
	  }
	  @FXML
	  public void languagePickResetButton(ActionEvent resetMusic){
		  guitarBox.setSelected(false);
		  pianoBox.setSelected(false);
		  drumsBox.setSelected(false);
		  changeLabel(pickLanguage, " ");
		  changeLabel(languageLabelOne, "You need to spend roughly 1500 hours");
		  changeLabel(languageLabelTwo, "on each instrument to achieve mastery.");
		  changeLabel(languageLabelThree, " ");
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
	  public void musicalPickerBackButton(ActionEvent changeScene) throws IOException { 
		  root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
		  mainScene = new Scene(root);
		  applicationStage.setScene(mainScene);
		  applicationStage.show();
	  } 
	  
	  @FXML
	  public void languagePickerBackButton(ActionEvent changeScene) throws IOException { 
		  root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
		  mainScene = new Scene(root);
		  applicationStage.setScene(mainScene);
		  applicationStage.show();
	  } 
	  
	  

	  //BackButtonS End
	  
	  
	 //instrument picking Logic 
	  /**
	  public void musicSkillViewLogic() {	  	  
		  
		  if (guitarBox.isSelected()) {
			  guitarCounter++; // 2nd time onwards always 2
			 
			  if(guitarCounter==1) {
				  instrumentPickedList.add("guitar");
				  textDefaultMusic += "guitar ";
				  hoursMusicCounterGuitar++;
				  
				  if (hoursMusicCounterGuitar==1) {
					  hoursMusic+=1500;
				  }
				  if(hoursMusicCounterGuitar==2) {
					  hoursMusicCounterGuitar=1;
				  }
				  
				  
			  }
			  if(guitarCounter==2) {
				  guitarCounter=1; // 2nd time onwards always becomes 1 in the end
				  
			  }
		  }
		  else {
			  if (musicListHasElement("guitar")) {
				  instrumentPickedList.remove("guitar");
			  }
			  textRemove(textDefaultMusic, "guitar");
			  
			 
			  if(guitarCounter==1) {
				  hoursMusic-=1500;
				  guitarCounter--;
				  hoursMusicCounterGuitar--;
			  }
		  }
	 
		 
		  
		  if (pianoBox.isSelected()) {
			  pianoCounter++;
			  
			  if(pianoCounter==1) {
				  instrumentPickedList.add("piano");
				  textDefaultMusic+= "piano ";
				  
				  hoursMusicCounterPiano++;
				  
				  if (hoursMusicCounterPiano==1) {
					  hoursMusic+=1500;
				  }
				  if(hoursMusicCounterPiano==2) {
					  hoursMusicCounterPiano=1;
				  }
			  }
			  if(pianoCounter==2) {
				  pianoCounter=1;
			  }
		  }
		  else {
			  if(musicListHasElement("piano")) {
				  instrumentPickedList.remove("piano");
			  }
			  textRemove(textDefaultMusic, "piano");
			  
			  if (pianoCounter==1) {
				  hoursMusic-=1500;
				  pianoCounter--;
				  hoursMusicCounterPiano--;
			  }
		  }
		  
		  
		  if (drumsBox.isSelected()) {
			  drumsCounter++;
			  
			  if (drumsCounter==1) {
				  instrumentPickedList.add("drums");
				  textDefaultMusic+= "drums ";
				  hoursMusicCounterDrums++;
				  
				  if (hoursMusicCounterDrums==1) {
					  hoursMusic+=1500;
				  }
				  if(hoursMusicCounterDrums==2) {
					  hoursMusicCounterDrums=1;
				  }
				  
				
			  }
			  if(drumsCounter==2) {
				  drumsCounter=1;
			  }
		  }
		  else {
			  if(musicListHasElement("drums")) {
				  instrumentPickedList.remove("drums");
			  }
			  textRemove(textDefaultMusic, "drums");
			  
			  if(drumsCounter==1) {
				  hoursMusic-=1500;
				  drumsCounter--;
				  hoursMusicCounterDrums--;
			  }
		  }
		  
		  
	  }
	**/
	  
	  
	  @FXML
	  public void musicSkillPickLogic(ActionEvent MusicEvent) {		
		 var musicView = new UIControl(guitarBox, pianoBox, drumsBox);
		 musicView.PickViewCheckBoxLogic("guitar","piano","drums", 1500); 
		 
		 String textDefaultMusic = musicView.getTextDefault();
		 int hoursMusic = musicView.getHoursSkill();
		 
		 String textDefaultMusicThree="So a total of " + hoursMusic + " hours";
		 changeLabel(pickMusic, textDefaultMusic);		 
		 changeLabel(musicLabel3, textDefaultMusicThree);
		 
		 textDefaultMusicThree="";
	  }
	  
	  @FXML
	  public void LanguageSkillPickLogic(ActionEvent LanguageEvent) {		
		 var LanguageView = new UIControl(frenchBox, englishBox, arabicBox);
		 LanguageView.PickViewCheckBoxLogic("french","english","arabic", 1000); 
		 
		 String textDefaultLanguage = LanguageView.getTextDefault();
		 int hoursLanguage = LanguageView.getHoursSkill();
		 
		 String textDefaultLanguageThree="So a total of " + hoursLanguage + " hours";
		 changeLabel(pickLanguage, textDefaultLanguage);		 
		 changeLabel(languageLabelThree, textDefaultLanguageThree);
		 
		 textDefaultLanguageThree="";
	  }
	  
	  //instrument picking logic ends
	  
	  //Language picking Logic Starts
	/**  
	  @FXML
	  public void LanguageSkillViewLogic() {	  	  
		  
		  if (frenchBox.isSelected()) {
			  frenchCounter++; // 2nd time onwards always 2
			 
			  if(frenchCounter==1) {
				  LanguagePickedList.add("french");
				  textDefaultLanguage += "french ";
				  hoursLanguageCounterFrench++;
				  
				  if (hoursLanguageCounterFrench==1) {
					  hoursLanguage+=1500;
				  }
				  if(hoursLanguageCounterFrench==2) {
					  hoursLanguageCounterFrench=1;
				  }
				  
				  
			  }
			  if(frenchCounter==2) {
				  frenchCounter=1; // 2nd time onwards always becomes 1 in the end
				  
			  }
		  }
		  else {
			  if (musicListHasElement("guitar")) {
				  instrumentPickedList.remove("guitar");
			  }
			  textRemove(textDefaultMusic, "guitar");
			  
			 
			  if(guitarCounter==1) {
				  hoursMusic-=1500;
				  guitarCounter--;
				  hoursMusicCounterGuitar--;
			  }
		  }
	 
		 
		  
		  if (pianoBox.isSelected()) {
			  pianoCounter++;
			  
			  if(pianoCounter==1) {
				  instrumentPickedList.add("piano");
				  textDefaultMusic+= "piano ";
				  
				  hoursMusicCounterPiano++;
				  
				  if (hoursMusicCounterPiano==1) {
					  hoursMusic+=1500;
				  }
				  if(hoursMusicCounterPiano==2) {
					  hoursMusicCounterPiano=1;
				  }
			  }
			  if(pianoCounter==2) {
				  pianoCounter=1;
			  }
		  }
		  else {
			  if(musicListHasElement("piano")) {
				  instrumentPickedList.remove("piano");
			  }
			  textRemove(textDefaultMusic, "piano");
			  
			  if (pianoCounter==1) {
				  hoursMusic-=1500;
				  pianoCounter--;
				  hoursMusicCounterPiano--;
			  }
		  }
		  
		  
		  if (drumsBox.isSelected()) {
			  drumsCounter++;
			  
			  if (drumsCounter==1) {
				  instrumentPickedList.add("drums");
				  textDefaultMusic+= "drums ";
				  hoursMusicCounterDrums++;
				  
				  if (hoursMusicCounterDrums==1) {
					  hoursMusic+=1500;
				  }
				  if(hoursMusicCounterDrums==2) {
					  hoursMusicCounterDrums=1;
				  }
				  
				
			  }
			  if(drumsCounter==2) {
				  drumsCounter=1;
			  }
		  }
		  else {
			  if(musicListHasElement("drums")) {
				  instrumentPickedList.remove("drums");
			  }
			  textRemove(textDefaultMusic, "drums");
			  
			  if(drumsCounter==1) {
				  hoursMusic-=1500;
				  drumsCounter--;
				  hoursMusicCounterDrums--;
			  }
		  }
		  
		  
	  }
	  //Language Picking logic ends
	 
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
					 textDefaultMusic = sentence;
				 }			  			
				 
				 }
			 }
	 }
	 **/
	
	 private void changeLabel(Label label, String text) { 		 

		 label.setText(text); 

} 
	 
	 
	 }
	 
	 