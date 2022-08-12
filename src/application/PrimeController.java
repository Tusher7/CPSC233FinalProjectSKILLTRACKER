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
	
	
	
	private ArrayList<String> codingLanguagePickList = new ArrayList<String> ();
	
	  //onAction="#progressIncrement"
	
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
		  changeLabel(musicLabel1, "You need to spend roughly 1500 hours");
		  changeLabel(musicLabel2, "on each instrument to achieve mastery.");
		  changeLabel(musicLabel3, " ");
	  }
	  @FXML
	  public void languagePickResetButton(ActionEvent resetMusic){
		  frenchBox.setSelected(false);
		  englishBox.setSelected(false);
		  arabicBox.setSelected(false);
		  changeLabel(pickLanguage, " ");
		  changeLabel(languageLabelOne, "You need to spend roughly 1000 hours");
		  changeLabel(languageLabelTwo, "on each language to achieve mastery.");
		  changeLabel(languageLabelThree, " ");	  
	  	  
	  }
	  
	  
	  @FXML
	  public void codingPickResetButton(ActionEvent resetMusic){
		  pythonBox.setSelected(false);
		  htmlBox.setSelected(false);
		  javaBox.setSelected(false);
		  changeLabel(codingPick, " ");
		  changeLabel(codingLabelOne, "You need to spend roughly 1700 hours");
		  changeLabel(codingLabelTwo, "on each coding language to achieve mastery.");
		  changeLabel(codingLabelThree, " ");
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
	  } 
	 
	 //Second Scene CheckBox Logics 	  
	  @FXML
	  public void musicSkillPickLogic(ActionEvent MusicEvent) {		
		 var musicView = new UIControl(guitarBox, pianoBox, drumsBox);
		 musicView.PickViewCheckBoxLogic("guitar","piano","drums", 1500); 
		 
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
		 var languageView = new UIControl(frenchBox, englishBox, arabicBox);
		 languageView.PickViewCheckBoxLogic("french","english","arabic", 1000); 
		 
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
		 var codingView = new UIControl(pythonBox, htmlBox, javaBox);
		 codingView.PickViewCheckBoxLogic("python","html","java", 1700); 
		 
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
	 public void secondSceneNextButton(ActionEvent nextEvent) throws IOException {
		 
		 root = FXMLLoader.load(getClass().getResource("SkillTracker.fxml"));
		 applicationStage = (Stage)((Node)nextEvent.getSource()).getScene().getWindow();
		 mainScene = new Scene(root);
		 applicationStage.setScene(mainScene);
		 applicationStage.show();
		 
		 		 
		 if (skillPickedString.equals("Coding")) {
			 System.out.println("entered");
			 var code = new UIControl(); // using codingSkillClass Later
			 String one = code.getPickedList();
			 //codingLanguagePickList = code.getPickedList();
			 System.out.println(one);
			 
		 }
		 
		 
	 }
	 
	 //Skill Tracker Logic start
	 
	 @FXML
	 public void skillTrackerNextDay(ActionEvent nextDayEvent) {
		 
	 }
	
	 private void changeLabel(Label label, String text) { 		 

		 label.setText(text); 

} 
	 
	 
	 }
	 
	 