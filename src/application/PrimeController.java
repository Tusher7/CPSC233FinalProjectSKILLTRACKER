package application;  

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EventObject;

import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox; 
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
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
	@FXML
	private HBox mainViewButtonsHBox;	 
	private Button nextButtonMainView = new Button("Next >");	   
	private String skillPickedString;    
	@FXML
	private Button LanguagePickerBackButton;	   	   
	@FXML 
	private Label pickMusic;	  
	private String defaultText = "";
	private int nextButtonCounter = 0;	 		 
	@FXML
	private CheckBox guitarBox; 
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
	@FXML
	private CheckBox pythonBox;
	@FXML
	private CheckBox htmlBox;
	@FXML
	private CheckBox javaBox;
	@FXML
	private Label codingPick;
	@FXML
	private Label codingLabelOne;
	@FXML
	private Label codingLabelTwo;
	@FXML
	private Label codingLabelThree;	 
	@FXML
	private Label  mainViewLabelZero;
	@FXML
	private Label skillOne = new Label();
	@FXML
	private Label skillThree = new Label();
	@FXML
	private Label skillTwo= new Label();	
	private UIControl codingView;
	private UIControl languageView;
	private UIControl musicView;	
	@FXML
	private HBox skillOneHBox;
	@FXML
	private HBox skillTwoHBox;
	@FXML
	private HBox skillThreeHBox;			
	private ArrayList<String> codingLanguagePickList = new ArrayList<String> (); //these are needed.
	private ArrayList<String> LanguagePickList;
	private ArrayList<String> musicPickList;
	private int restartCounter = 0;
	
	
	
	
	 /**
	  * The "Confirm" button in the mainView.fxml will select and finalize the skill the user picked. 
	  * Its also creates a new button called "Next" which will let the user move forward.
	  * 
	  * @param pickSkill an ActionEvent parameter that takes in the event of the confirm button being clicked in the MainView.
	  */
	@FXML 
	public void confrimButton(ActionEvent pickSkill) { 
		String skillChose =  skillChooseChoiceBox.getValue();	
		
		if (skillChose!=null) { // To make sure a skill is picked. Records the skills that are picked.
		  defaultText=""; 
			  
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
			  
		  if (nextButtonCounter ==0) { // next button is added when a skill is confirmed.
		  mainViewButtonsHBox.getChildren().add(nextButtonMainView);
		  nextButtonCounter++; // the counter is set to one, so that another button is NOT added when confirm button is clicked again.
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
		  else { // prompted to pick a skill if nothing is picked.
			  changeLabel(mainViewLabelZero, "Please pick a skill");
		  }
		 
	 } 
	//resetButtons
	
	/**
	 * Reset button undoes everything that the user did in the MainView.
	 * 
	 * @param resetMain an ActionEvent parameter that takes in the event of the reset button being clicked in MainView.
	 */		
	@FXML 
	public void resetButtonMain(ActionEvent resetMain) { 
		skillPickedString = ""; 
		changeLabel(skillPickedLabel, ""); 
		nextButtonCounter = 0; // counter set to zero so that the next button can be added to the scene again.
		mainViewButtonsHBox.getChildren().remove(nextButtonMainView);		
		changeLabel(mainViewLabelZero, "");
		  
		  
	  } 
	/**
	 * Reset button does everything the user did in MusicalInstrumentPickerView.
	 * 
	 * @param resetMusic an ActionEvent parameter takes that in the event of the reset button being clicked in MusicalInstrumentPickerView.
	 */	
	@FXML
	public void resetButtonMusicPick(ActionEvent resetMusic){
		guitarBox.setSelected(false);
		pianoBox.setSelected(false);
		drumsBox.setSelected(false);
		changeLabel(pickMusic, " ");
		changeLabel(musicLabel1, "You need to spend roughly 230 hours");
		changeLabel(musicLabel2, "on each instrument to achieve mastery.");
		changeLabel(musicLabel3, " ");
		if(musicView!=null) {  // To error Handle the reset button. musicView doesn't have an address to anywhere, no need to call a function from it.
			musicView.clearPickedList();
		}
	}
	
	
	
	/**
	 * Reset button does everything the user did in LanguagePickerView.
	 * 
	 * @param resetLanguage an ActionEvent parameter takes that in the event of the reset button being clicked in LanguagePickerView.
	 */
	public void languagePickResetButton(ActionEvent resetLanguage){
		frenchBox.setSelected(false);
		englishBox.setSelected(false);
		arabicBox.setSelected(false);
		changeLabel(pickLanguage, " ");
		changeLabel(languageLabelOne, "You need to spend roughly 300 hours");
		changeLabel(languageLabelTwo, "on each language to achieve basic understanding.");
		changeLabel(languageLabelThree, " ");	 
		if(languageView!=null) { // To error Handle the reset button. languageView doesn't have an address to anywhere, no need to call a function from it.
			languageView.clearPickedList();
		}
	}
	  
	/**
	 * Reset button does everything the user did in CodingLanguagePickerView.
	 * 
	 * @param resetCode an ActionEvent parameter takes that in the event of the reset button being clicked in CodingLanguagePickerView.
	 */
	@FXML
	public void codingPickResetButton(ActionEvent resetCode){
		pythonBox.setSelected(false);
		htmlBox.setSelected(false);
		javaBox.setSelected(false);
		changeLabel(codingPick, " ");
		changeLabel(codingLabelOne, "You need to spend roughly 250 hours");
		changeLabel(codingLabelTwo, "on each coding language to achieve basic knowledge.");
		changeLabel(codingLabelThree, " ");
		if (codingView!=null) { // To error Handle the reset button. codingView doesn't have an address to anywhere, no need to call a function from it.
			codingView.clearPickedList();
		}
	}
		  	  
	//resetButtonsEnd  
	  /**
	   * Loads the second scene according to the skill the user picked in MainView.
	   * 
	   * @param changeScene an ActionEvent parameter that takes in the event of the next button being clicked in MainView.
	   * @throws IOException when FXMLLoader loads improper data.
	   */
	  
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
	  
	  
	  /**
	   * Undoes everything the user did up until the second scene and everything restarts.
	   * 
	   * @param changeScene an ActionEvent parameter that takes in the event when back button is clicked in the second scenes.
	   * @throws IOException when FXMLLoader loads improper data.
	   */
	  @FXML
	  public void pickerViewBackButton(ActionEvent changeScene) throws IOException { 
		  
		  
		  root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
		  mainScene = new Scene(root);
		  
		  applicationStage.setScene(mainScene);
		  applicationStage.show();
		  	  
		  
		  if (codingView!=null) {  // To error handle Null Pointer.
			  codingView.clearPickedList();
		  }
		  if (musicView!=null) {  // To error handle Null Pointer.
			  musicView.clearPickedList();
		  }
		  if (languageView!=null) {  // To error handle Null Pointer.
			  languageView.clearPickedList();
		  }
		  
		  
		 
	  } 
	  
	 
	 
	 //Second Scene CheckBox Logics start
	  /**
	   * Responds to a checkBox being clicked in MusicalInstrumentPickerView with labels.
	   * Keeps record of which check boxes were clicked.
	   * 
	   * @param MusicEvent an ActionEvent parameter that takes in the event when any check box
	   * in the MusicalInstrumentPickerView is clicked.
	   */
	  @FXML
	  public void musicSkillPickLogic(ActionEvent MusicEvent) {		
		 musicView = new MusicSkill(guitarBox, pianoBox, drumsBox); // an object created with the state of the check boxes.
		 musicView.PickViewCheckBoxLogic("guitar","piano","drums", 230); // records the fact that the check box was clicked and records which skill was clicked. If un-clicked, removes it from record.
		 
		 String textDefaultMusic = musicView.getTextDefault(); // gets the updated info.
		 int hoursMusic = musicView.getHoursSkill(); // gets updated info.
		 
		 String textDefaultMusicThree="So a total of " + hoursMusic + " hours"; // updates the label with new info.
		 changeLabel(pickMusic, textDefaultMusic);	// updates label. 
		 changeLabel(musicLabel3, textDefaultMusicThree); // updates label.
		 
		 skillPickedString=""; // clears 
		 skillPickedString="Musical"; // records that music skill was picked.
		 
		 textDefaultMusicThree=""; // clears variable to be able to use it in the future.
		 
   }
	  /**
	   * Responds to a checkBox being clicked in LanguagePickerView with labels.
	   * Keeps record of which check boxes were clicked.
	   * 
	   * @param LanguageEvent an ActionEvent parameter that takes in the event when any check box
	   * in the LanguagePickerView is clicked.
	   */
	  @FXML
	  public void LanguageSkillPickLogic(ActionEvent LanguageEvent) {		
		 languageView = new LanguageSkill(frenchBox, englishBox, arabicBox); // an object created with the state of the check boxes.
		 languageView.PickViewCheckBoxLogic("french","english","arabic", 300);  // records the fact that the check box was clicked and records which skill was clicked. If un-clicked, removes it from record.
		 
		 String textDefaultLanguage = languageView.getTextDefault(); // gets the updated info.
		 int hoursLanguage = languageView.getHoursSkill(); // gets updated info.
		 
		 String textDefaultLanguageThree="So a total of " + hoursLanguage + " hours"; // updates the label with new info.
		 changeLabel(pickLanguage, textDefaultLanguage); // updates label.		 
		 changeLabel(languageLabelThree, textDefaultLanguageThree); // updates label.
		 
		 skillPickedString=""; // clears 
		 skillPickedString="Language"; // records that language skill was picked.
		 
		 textDefaultLanguageThree=""; // clears variable to be able to use it in the future.
	  }
	  
	  /**
	   * Responds to a check box being clicked in CodingLanguagePickerView with labels.
	   * Keeps record of which check boxes were clicked.
	   * 
	   * @param codingEvent an ActionEvent parameter that takes in the event when any check box
	   * in the CodingLanguagePickerView is clicked.
	   */
	  @FXML
	  public void CodingSkillPickLogic(ActionEvent codingEvent) {		
		 codingView = new CodingSkill(pythonBox, htmlBox, javaBox); // an object created with the state of the check boxes.
		 codingView.PickViewCheckBoxLogic("python","html","java", 250); // records the fact that the check box was clicked and records which skill was clicked. If un-clicked, removes it from record.
		 
		 String textDefaultCode = codingView.getTextDefault(); // gets the updated info.
		 int hoursCode = codingView.getHoursSkill(); // gets the updated info.
		 
		 String textDefaultCodingThree="So a total of " + hoursCode + " hours";  // updates the label with new info.
		 changeLabel(codingPick, textDefaultCode);	//updates label  
		 changeLabel(codingLabelThree, textDefaultCodingThree); //updates label
		 
		 
		 skillPickedString=""; // clears 
		 skillPickedString="Coding"; // records that coding skill was picked.
		 	 		 		 		  
		 textDefaultCodingThree=""; // clears variable to be able to use it in the future.
	  }	  	  
	  //Second Scene CheckBox Logics end
	  
	 /**
	  * Creates HBoxes, VBoxes, buttons and all the necessary building blocks are created and their functions
	  * are stated. Lastly, a skill tracker scene is created using those building blocks.
	  * 
	  * @param nextEventSecondScene an ActionEvent parameter which takes in the event when 
	  * next button in CodingLanguagePickerView is clicked.
	  */
	  @FXML
	public void codePickNextButton(ActionEvent nextEventSecondScene) {	
		  restartCounter=0; // counter set to 0 for future use.
		  if (pythonBox.isSelected() || htmlBox.isSelected() || javaBox.isSelected()) { // At least one box must be selected.
			  codingLanguagePickList = codingView.getPickedList(); //Getting the list
		 
			  VBox trackerContainer = new VBox();  // From this point onward, building blocks for the skill tracker is being created.
			  Label topLabel = new Label(" CODING SKILL TRACKER ");
		 
			  HBox skillOneContainer = new HBox();			 
			  Label skillOneLabel = new Label();
			  ProgressBar barOne = new ProgressBar();		 
				 
			  TextField textOne = new TextField();
			  Label inputOne = new Label(" Enter Hours Practiced ");		
			  Label messageOne = new Label();
		 
		 		 		 		 
		 
			  HBox skillTwoContainer = new HBox();
			  Label skillTwoLabel = new Label();
			  ProgressBar barTwo = new ProgressBar();
		 
			  Label inputTwo = new Label(" Enter Hours Practiced ");
			  TextField textTwo = new TextField();		 	
			  Label messageTwo = new Label();
		 
		 
			  HBox skillThreeContainer = new HBox();
			  Label skillThreeLabel = new Label();
			  ProgressBar barThree = new ProgressBar();
		 
			  Label inputThree = new Label(" Enter Hours Practiced ");		
			  TextField textThree = new TextField();		 	
			  Label messageThree = new Label();
		 
		 
			  HBox buttonsHBox = new HBox();
		 
			  Button restart = new Button("Restart EVERYTHING");			
			  restart.setOnAction(restartEvent -> {
				  try {
				
					  skillTrackerRestart(nextEventSecondScene);	
					  codingView.clearAllInfo();
				
				
				  } catch (IOException e) {			
					  System.out.println("Restart Button not working");
					  e.printStackTrace();
				  }
			  });	
			  Label dayCounter = new Label();
			  Button nextDay = new Button("Next Day");
			  nextDay.setOnAction(nextDayEvent -> codingView.progressUpdate(barOne, barTwo, barThree, dayCounter, 
					  textOne.getText(), messageOne, textTwo.getText(), messageTwo,
					  textThree.getText(), messageThree)); 
		
		 
			  HBox labelsHBox = new HBox();	
		
		 		 		 
		 
		 
			  Scene trackerScene = new Scene(trackerContainer);
		 
			  applicationStage.setScene(trackerScene);
			  applicationStage.setTitle("CODING SKILL TRACKER");
			  applicationStage.show();	
		 	 
			  trackerContainer.getChildren().add(topLabel);
		 
			  codingView.makeTracker(skillOneContainer,skillTwoContainer, //creates the tracker scene.
					  skillThreeContainer,skillOneLabel,skillTwoLabel, 
					  skillThreeLabel, barOne,barTwo, barThree, inputOne,
					  inputTwo, inputThree, trackerContainer, restart, nextDay,
					  textOne, messageOne, textTwo, messageTwo, textThree, messageThree,
					  buttonsHBox,labelsHBox, dayCounter);
		  }
		  else { // If no box is selected the user is prompted to select.
			  changeLabel(codingPick, "Please check a Box to pick a skill.");
		  }
			 
		 
	  }
			 	 	 		   	    	 
    	 
    /**
	  * Creates HBoxes, VBoxes, buttons and all the necessary building blocks are created and their functions
	  * are stated. Lastly, a skill tracker scene is created using those building blocks.
	  * 
	  * @param nextEventSecondScene an ActionEvent parameter which takes in the event when 
	  * next button in LanguagePickerView is clicked.
	  */
    	
	  @FXML
	  public void languagePickNextButtonPress(ActionEvent nextEventSecondScene){	
		  restartCounter=0; // counter set to 0 for future use.
		  if(frenchBox.isSelected() || englishBox.isSelected() || arabicBox.isSelected()) { // At least one box must be selected.
			  LanguagePickList = languageView.getPickedList(); //Getting the list
		 
			  VBox trackerContainer = new VBox();  // From this point onward, building blocks for the skill tracker is being created.
			  Label topLabel = new Label("LANGUAGE SKILL TRACKER");
		 
			  HBox skillOneContainer = new HBox();			 
			  Label skillOneLabel = new Label();
			  ProgressBar barOne = new ProgressBar();
		 
			  TextField textOne = new TextField();
			  Label inputOne = new Label(" Enter Hours Practiced ");		
			  Label messageOne = new Label();
		 						 
		 
			  HBox skillTwoContainer = new HBox();
			  Label skillTwoLabel = new Label();
			  ProgressBar barTwo = new ProgressBar();
		 
			  Label inputTwo = new Label(" Enter Hours Practiced ");
			  TextField textTwo = new TextField();		 	
			  Label messageTwo = new Label();
				 
		 
			  HBox skillThreeContainer = new HBox();
			  Label skillThreeLabel = new Label();
			  ProgressBar barThree = new ProgressBar();
		 
			  Label inputThree = new Label(" Enter Hours Practiced ");		
			  TextField textThree = new TextField();		 	
			  Label messageThree = new Label();
		  	 
		 
			  HBox buttonsHBox = new HBox();
		 
			  Button restart = new Button("Restart EVERYTHING");			
			  restart.setOnAction(restartEvent -> {
				  try {
					  skillTrackerRestart(nextEventSecondScene);		
					  languageView.clearAllInfo();
				  } catch (IOException e) {			
					  System.out.println("Restart Button not working");
					  e.printStackTrace();
				  }
			  });	
			  Label dayCounter = new Label();
			  Button nextDay = new Button("Next Day");
			  nextDay.setOnAction(nextDayEvent -> languageView.progressUpdate(barOne, barTwo, barThree, 
					  dayCounter, textOne.getText(), messageOne, textTwo.getText(), messageTwo,
					  textThree.getText(), messageThree));
		 
		 
		 
			  HBox labelsHBox = new HBox();	
		 
		 		 		 			 			 			 			 
			  Scene trackerScene = new Scene(trackerContainer);
		 
			  applicationStage.setScene(trackerScene);
			  applicationStage.show();	
			  applicationStage.setTitle("LANGUAGE SKILL TRACKER");
		 
			  trackerContainer.getChildren().add(topLabel);
		 
			  languageView.makeTracker(skillOneContainer,skillTwoContainer,   // creates the tracker scene.
					  skillThreeContainer,skillOneLabel,skillTwoLabel, 
					  skillThreeLabel, barOne,barTwo, barThree, inputOne,
					  inputTwo, inputThree, trackerContainer, restart, nextDay,
					  textOne, messageOne, textTwo, messageTwo, textThree, messageThree,
					  buttonsHBox,labelsHBox, dayCounter);
		  }
		 else { // If no box is selected the user is prompted to select.
				changeLabel(pickLanguage, "Please check a Box to pick a skill."); // Error handling for the Next button
			}
		 
	 }
	
	
	/**
	  * Creates HBoxes, VBoxes, buttons and all the necessary building blocks are created and their functions
	  * are stated. Lastly, a skill tracker scene is created using those building blocks.
	  * 
	  * @param nextEventSecondScene an ActionEvent parameter which takes in the event when 
	  * next button in MusicalInstrumentPickerView is clicked.
	  */
	  @FXML
	  public void musicPickNextButtonPress(ActionEvent nextEventSecondScene) {	
		  restartCounter=0; // counter set to 0 for future use.
		  if(guitarBox.isSelected() || pianoBox.isSelected() || drumsBox.isSelected()) { //At least one box must be selected.
			  musicPickList = musicView.getPickedList(); //Getting the list
		 
			  VBox trackerContainer = new VBox();      // From this point onward, building blocks for the skill tracker is being created.
			  Label topLabel = new Label("MUSIC SKILL TRACKER");
		 
			  HBox skillOneContainer = new HBox();			 
			  Label skillOneLabel = new Label();
			  ProgressBar barOne = new ProgressBar();
		 
	
		 
			  TextField textOne = new TextField();
			  Label inputOne = new Label(" Enter Hours Practiced ");		
			  Label messageOne = new Label();
		 		 				 
		 
			  HBox skillTwoContainer = new HBox();
			  Label skillTwoLabel = new Label();
			  ProgressBar barTwo = new ProgressBar();
		 
			  Label inputTwo = new Label(" Enter Hours Practiced ");
			  TextField textTwo = new TextField();		 	
			  Label messageTwo = new Label();
		  
		 		 
			  HBox skillThreeContainer = new HBox();
			  Label skillThreeLabel = new Label();
			  ProgressBar barThree = new ProgressBar();
		 
			  Label inputThree = new Label(" Enter Hours Practiced ");		
			  TextField textThree = new TextField();		 	
			  Label messageThree = new Label();
		 	
		 
			  HBox buttonsHBox = new HBox();
			  
			  Button restart = new Button("Restart EVERYTHING");		
		 
			  restart.setOnAction(restartEvent ->  {
				  try {
				
					  skillTrackerRestart(nextEventSecondScene);	
					  musicView.clearAllInfo();
				
				 
				
				  } catch (IOException e) {			
					  System.out.println("Restart Button not working");
					  e.printStackTrace();
				  }
			  });	
			  Label dayCounter = new Label();
			  Button nextDay = new Button("Next Day");
			  nextDay.setOnAction(nextDayEvent -> musicView.progressUpdate(barOne, barTwo, barThree, dayCounter, 
					  textOne.getText(), messageOne, textTwo.getText(), messageTwo,
					  textThree.getText(), messageThree));
		 
	
			  HBox labelsHBox = new HBox();			 
		 		 		 			 			 			 			 
			  Scene trackerScene = new Scene(trackerContainer);
			  applicationStage.setScene(trackerScene);
			  applicationStage.show();	
			  applicationStage.setTitle("MUSIC SKILL TRACKER");
		 
			  trackerContainer.getChildren().add(topLabel);
		 
			  musicView.makeTracker(skillOneContainer,skillTwoContainer,  // creates the tracker scene.
					  skillThreeContainer,skillOneLabel,skillTwoLabel, 
					  skillThreeLabel, barOne,barTwo, barThree, inputOne,
					  inputTwo, inputThree, trackerContainer, restart, nextDay,
					  textOne, messageOne, textTwo, messageTwo, textThree, messageThree,
					  buttonsHBox,labelsHBox, dayCounter);
		  }
		  else { // If no box is selected the user is prompted to select.
			  changeLabel(pickMusic, "Please check a Box to pick a skill.");
		  }
		 
		 
	 }
		 
		
	 
	 /**
	  * This method just sets texts to labels.
	  * 
	  * @param label a Label object that holds the label the user wants to edit.
	  * @param text the text the user wants to edit the label with.
	  */
	
	 private void changeLabel(Label label, String text) { 		 
		 
		 label.setText(text); 

} 
	 
	 
	 /**
	  * This undoes everything the user did during the application use
	  * the whole time and restarts everything by giving a fresh start.
	  * 
	  * @param restart takes in the event when the restart button is clicked in
	  * the skill tracker scenes.
	  * @throws IOException when FXMLLoader loads the wrong data.
	  */
	 private void skillTrackerRestart(ActionEvent restart) throws IOException {
		 
		 if (restartCounter == 0) { // if restart button is not clicked yet, the functions can be allowed to happen.
			 root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
			 applicationStage = (Stage)((Node)restart.getSource()).getScene().getWindow();
			 mainScene = new Scene(root);
			  
			 applicationStage.setScene(mainScene);
			 applicationStage.show();
			  
			 
			 if (codingView!=null) {
				 codingView.clearPickedList();
			 }
			 if (musicView!=null) {
				 musicView.clearPickedList();
			 }
			 if (languageView!=null) {
				 languageView.clearPickedList();
			 }
	  }
		 if (restartCounter==0) { // to make sure counter never becomes greater than 1.
			 restartCounter++; // incrementing counter to denote restart button was clicked.
		 }
	 }
	 	
	 
	 
	 }
	 
	 