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
	
	
	
	
	 
	@FXML 
	public void confrimButton(ActionEvent pickSkill) { 
		String skillChose =  skillChooseChoiceBox.getValue();	
		
		if (skillChose!=null) {
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
		  else {
			  changeLabel(mainViewLabelZero, "Please pick a skill");
		  }
		 
	 } 
//resetButtons
	  @FXML 
	  public void resetButtonMain(ActionEvent resetMain) { 
		  skillPickedString = ""; 
		  changeLabel(skillPickedLabel, ""); 
		  nextButtonCounter = 0;
		  mainViewButtonsHBox.getChildren().remove(nextButtonMainView);		
		  changeLabel(mainViewLabelZero, "");
		  
		  
	  } 
	   
	  @FXML
	  public void resetButtonMusicPick(ActionEvent resetMusic){
		  guitarBox.setSelected(false);
		  pianoBox.setSelected(false);
		  drumsBox.setSelected(false);
		  changeLabel(pickMusic, " ");
		  changeLabel(musicLabel1, "You need to spend roughly 230 hours");
		  changeLabel(musicLabel2, "on each instrument to achieve mastery.");
		  changeLabel(musicLabel3, " ");
		  musicView.clearPickedList();
	  }
	  @FXML
	  public void languagePickResetButton(ActionEvent resetMusic){
		  frenchBox.setSelected(false);
		  englishBox.setSelected(false);
		  arabicBox.setSelected(false);
		  changeLabel(pickLanguage, " ");
		  changeLabel(languageLabelOne, "You need to spend roughly 300 hours");
		  changeLabel(languageLabelTwo, "on each language to achieve basic understanding.");
		  changeLabel(languageLabelThree, " ");	 
		  languageView.clearPickedList();
	  	  
	  }
	  
	  
	  @FXML
	  public void codingPickResetButton(ActionEvent resetMusic){
		  pythonBox.setSelected(false);
		  htmlBox.setSelected(false);
		  javaBox.setSelected(false);
		  changeLabel(codingPick, " ");
		  changeLabel(codingLabelOne, "You need to spend roughly 250 hours");
		  changeLabel(codingLabelTwo, "on each coding language to achieve basic knowledge.");
		  changeLabel(codingLabelThree, " ");
		  codingView.clearPickedList();
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
	  
	  // BackBtton
	  
	  @FXML
	  public void pickerViewBackButton(ActionEvent changeScene) throws IOException { 
		  root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		  applicationStage = (Stage)((Node)changeScene.getSource()).getScene().getWindow();
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
	 
	 
	 //Second Scene CheckBox Logics 	  
	  @FXML
	  public void musicSkillPickLogic(ActionEvent MusicEvent) {		
		 musicView = new MusicSkill(guitarBox, pianoBox, drumsBox);
		 musicView.PickViewCheckBoxLogic("guitar","piano","drums", 230); 
		 
		 String textDefaultMusic = musicView.getTextDefault();
		 int hoursMusic = musicView.getHoursSkill();
		 
		 String textDefaultMusicThree="So a total of " + hoursMusic + " hours";
		 changeLabel(pickMusic, textDefaultMusic);		 
		 changeLabel(musicLabel3, textDefaultMusicThree);
		 
		 skillPickedString="";
		 skillPickedString="Musical";
		 
		 textDefaultMusicThree="";
		 
   }
	  
	  @FXML
	  public void LanguageSkillPickLogic(ActionEvent LanguageEvent) {		
		 languageView = new LanguageSkill(frenchBox, englishBox, arabicBox);
		 languageView.PickViewCheckBoxLogic("french","english","arabic", 300); 
		 
		 String textDefaultLanguage = languageView.getTextDefault();
		 int hoursLanguage = languageView.getHoursSkill();
		 
		 String textDefaultLanguageThree="So a total of " + hoursLanguage + " hours";
		 changeLabel(pickLanguage, textDefaultLanguage);		 
		 changeLabel(languageLabelThree, textDefaultLanguageThree);
		 
		 skillPickedString="";
		 skillPickedString="Language";
		 
		 textDefaultLanguageThree="";
	  }
	  
	  @FXML
	  public void CodingSkillPickLogic(ActionEvent codingEvent) {		
		 codingView = new CodingSkill(pythonBox, htmlBox, javaBox);
		 codingView.PickViewCheckBoxLogic("python","html","java", 250); 
		 
		 String textDefaultCode = codingView.getTextDefault();
		 int hoursCode = codingView.getHoursSkill();
		 
		 String textDefaultCodingThree="So a total of " + hoursCode + " hours";
		 changeLabel(codingPick, textDefaultCode);		 
		 changeLabel(codingLabelThree, textDefaultCodingThree);
		 
		 
		 skillPickedString="";
		 skillPickedString="Coding"; //skillPickedString was becoming null here.
		 
		 
		 		 		 
		 textDefaultCodingThree="";
	  }	  	  
	  //Second Scene CheckBox Logics end
	  
	 
	@FXML
	 public void codePickNextButton(ActionEvent nextEventSecondScene) throws IOException {	
		if (pythonBox.isSelected() || htmlBox.isSelected() || javaBox.isSelected()) {
		 codingLanguagePickList = codingView.getPickedList(); //Getting the list
		 
		 
		 VBox trackerContainer = new VBox();
		 Label topLabel = new Label(" CODING SKILL TRACKER ");
		 
		 HBox skillOneContainer = new HBox();			 
		 Label skillOneLabel = new Label();
		 ProgressBar barOne = new ProgressBar();		 
				 
		 TextField textOne = new TextField();
		 Button inputOne = new Button("INPUT Hours Practiced");		
		 Label messageOne = new Label();
		 inputOne.setOnAction(oneEvent-> codingView.calculateXPOne(textOne.getText(), messageOne)); 
		 		 		 		 
		 
		 HBox skillTwoContainer = new HBox();
		 Label skillTwoLabel = new Label();
		 ProgressBar barTwo = new ProgressBar();
		 
		 Button inputTwo = new Button("INPUT Hours Practiced");
		 TextField textTwo = new TextField();		 	
		 Label messageTwo = new Label();
		 inputTwo.setOnAction(oneEvent-> codingView.calculateXPTwo(textTwo.getText(), messageTwo)); 
		 
		 HBox skillThreeContainer = new HBox();
		 Label skillThreeLabel = new Label();
		 ProgressBar barThree = new ProgressBar();
		 
		 Button inputThree = new Button("INPUT Hours Practiced");		
		 TextField textThree = new TextField();		 	
		 Label messageThree = new Label();
		 inputThree.setOnAction(oneEvent-> codingView.calculateXPThree(textThree.getText(), messageThree)); 
		 
		 HBox buttonsHBox = new HBox();
		 
		 Button restart = new Button("Restart EVERYTHING");			
		 restart.setOnAction(restartEvent -> {
			try {
				pickerViewBackButton(nextEventSecondScene);	
				codingView.clearAllInfo();
				
			} catch (IOException e) {			
				System.out.println("Restart Button not working");
				e.printStackTrace();
			}
		 });	
		 Label dayCounter = new Label();
		 Button nextDay = new Button("Next Day");
		 nextDay.setOnAction(nextDayEvent -> codingView.progressUpdate(barOne, barTwo, barThree, dayCounter)); 
		
		 
		 HBox labelsHBox = new HBox();	
		 Label nextDayErrorLabel = new Label();
		 		 		 
		 
		 
		 Scene trackerScene = new Scene(trackerContainer);
		 
		 applicationStage.setScene(trackerScene);
		 applicationStage.setTitle("CODING SKILL TRACKER");
		 applicationStage.show();	
		 
		 
		 trackerContainer.getChildren().add(topLabel);
		 
		 codingView.makeTracker(skillOneContainer,skillTwoContainer, 
				 skillThreeContainer,skillOneLabel,skillTwoLabel, 
				 skillThreeLabel, barOne,barTwo, barThree, inputOne,
				 inputTwo, inputThree, trackerContainer, restart, nextDay,
				 textOne, messageOne, textTwo, messageTwo, textThree, messageThree,
				 buttonsHBox,labelsHBox, dayCounter);
		}
		else {
			changeLabel(codingPick, "Please check a Box to pick a skill.");
		}
			 
		 
	 }
			 	 	 		   	    	 
    	 
    	
    	
	@FXML
	 public void languagePickNextButtonPress(ActionEvent nextEventSecondScene) throws IOException {	
		
		if(frenchBox.isSelected() || englishBox.isSelected() || arabicBox.isSelected()) {
		 LanguagePickList = languageView.getPickedList(); //Getting the list
		 
		 VBox trackerContainer = new VBox();
		 Label topLabel = new Label("LANGUAGE SKILL TRACKER");
		 
		 HBox skillOneContainer = new HBox();			 
		 Label skillOneLabel = new Label();
		 ProgressBar barOne = new ProgressBar();
		 
		 TextField textOne = new TextField();
		 Button inputOne = new Button("INPUT Hours Practiced");		
		 Label messageOne = new Label();
		 inputOne.setOnAction(oneEvent-> languageView.calculateXPOne(textOne.getText(), messageOne)); 						 
		 
		 HBox skillTwoContainer = new HBox();
		 Label skillTwoLabel = new Label();
		 ProgressBar barTwo = new ProgressBar();
		 
		 Button inputTwo = new Button("INPUT Hours Practiced");
		 TextField textTwo = new TextField();		 	
		 Label messageTwo = new Label();
		 inputTwo.setOnAction(oneEvent-> languageView.calculateXPTwo(textTwo.getText(), messageTwo)); 		 
		 
		 HBox skillThreeContainer = new HBox();
		 Label skillThreeLabel = new Label();
		 ProgressBar barThree = new ProgressBar();
		 
		 Button inputThree = new Button("INPUT Hours Practiced");		
		 TextField textThree = new TextField();		 	
		 Label messageThree = new Label();
		 inputThree.setOnAction(oneEvent-> languageView.calculateXPThree(textThree.getText(), messageThree)); 	 
		 
		 HBox buttonsHBox = new HBox();
		 
		 Button restart = new Button("Restart EVERYTHING");			
		 restart.setOnAction(restartEvent -> {
			try {
				pickerViewBackButton(nextEventSecondScene);		
				languageView.clearAllInfo();
			} catch (IOException e) {			
				System.out.println("Restart Button not working");
				e.printStackTrace();
			}
		 });	
		 Label dayCounter = new Label();
		 Button nextDay = new Button("Next Day");
		 nextDay.setOnAction(nextDayEvent -> languageView.progressUpdate(barOne, barTwo, barThree, dayCounter));
		 
		 
		 
		 HBox labelsHBox = new HBox();	
		 Label nextDayErrorLabel = new Label();
		 		 		 			 			 			 			 
		 Scene trackerScene = new Scene(trackerContainer);
		 
		 applicationStage.setScene(trackerScene);
		 applicationStage.show();	
		 applicationStage.setTitle("LANGUAGE SKILL TRACKER");
		 
		 trackerContainer.getChildren().add(topLabel);
		 
		languageView.makeTracker(skillOneContainer,skillTwoContainer, 
				 skillThreeContainer,skillOneLabel,skillTwoLabel, 
				 skillThreeLabel, barOne,barTwo, barThree, inputOne,
				 inputTwo, inputThree, trackerContainer, restart, nextDay,
				 textOne, messageOne, textTwo, messageTwo, textThree, messageThree,
				 buttonsHBox,labelsHBox, dayCounter);
		}
		 else {
				changeLabel(pickLanguage, "Please check a Box to pick a skill.");
			}
		 
	 }
	 @FXML
	 public void musicPickNextButtonPress(ActionEvent nextEventSecondScene) throws IOException {	
		 
		 if(guitarBox.isSelected() || pianoBox.isSelected() || drumsBox.isSelected()) {
		 musicPickList = musicView.getPickedList(); //Getting the list
		 
		 VBox trackerContainer = new VBox();
		 Label topLabel = new Label("MUSIC SKILL TRACKER");
		 
		 HBox skillOneContainer = new HBox();			 
		 Label skillOneLabel = new Label();
		 ProgressBar barOne = new ProgressBar();
		 
	
		 
		 TextField textOne = new TextField();
		 Button inputOne = new Button("INPUT Hours Practiced");		
		 Label messageOne = new Label();
		 inputOne.setOnAction(oneEvent-> musicView.calculateXPOne(textOne.getText(), messageOne)); 		 				 
		 
		 HBox skillTwoContainer = new HBox();
		 Label skillTwoLabel = new Label();
		 ProgressBar barTwo = new ProgressBar();
		 
		 Button inputTwo = new Button("INPUT Hours Practiced");
		 TextField textTwo = new TextField();		 	
		 Label messageTwo = new Label();
		 inputTwo.setOnAction(oneEvent-> musicView.calculateXPTwo(textTwo.getText(), messageTwo));		 
		 		 
		 HBox skillThreeContainer = new HBox();
		 Label skillThreeLabel = new Label();
		 ProgressBar barThree = new ProgressBar();
		 
		 Button inputThree = new Button("INPUT Hours Practiced");		
		 TextField textThree = new TextField();		 	
		 Label messageThree = new Label();
		 inputThree.setOnAction(oneEvent-> musicView.calculateXPThree(textThree.getText(), messageThree)); 	
		 
		 HBox buttonsHBox = new HBox();
		 
		 Button restart = new Button("Restart EVERYTHING");			
		 restart.setOnAction(restartEvent -> {
			try {
				pickerViewBackButton(nextEventSecondScene);	
				musicView.clearAllInfo();
				
			} catch (IOException e) {			
				System.out.println("Restart Button not working");
				e.printStackTrace();
			}
		 });	
		 Label dayCounter = new Label();
		 Button nextDay = new Button("Next Day");
		 nextDay.setOnAction(nextDayEvent -> musicView.progressUpdate(barOne, barTwo, barThree, dayCounter));
		 
	
		 HBox labelsHBox = new HBox();	
		 Label nextDayErrorLabel = new Label();
		 		 		 			 			 			 			 
		 Scene trackerScene = new Scene(trackerContainer);
		 applicationStage.setScene(trackerScene);
		 applicationStage.show();	
		 applicationStage.setTitle("MUSIC SKILL TRACKER");
		 
		 trackerContainer.getChildren().add(topLabel);
		 
		musicView.makeTracker(skillOneContainer,skillTwoContainer, 
				 skillThreeContainer,skillOneLabel,skillTwoLabel, 
				 skillThreeLabel, barOne,barTwo, barThree, inputOne,
				 inputTwo, inputThree, trackerContainer, restart, nextDay,
				 textOne, messageOne, textTwo, messageTwo, textThree, messageThree,
				 buttonsHBox,labelsHBox, dayCounter);
		 }
		 else {
				changeLabel(pickMusic, "Please check a Box to pick a skill.");
			}
		 
		 
	 }
		 
		
	 
	 
	
	 private void changeLabel(Label label, String text) { 		 
		 
		 label.setText(text); 

} 
	
	 
	 
	 }
	 
	 