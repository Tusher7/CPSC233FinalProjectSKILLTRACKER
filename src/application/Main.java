package application;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/MainView.fxml"));
			//VBox codingLPV = loader.load(new FileInputStream("src/application/CodingLanguagePickerView.fxml"));
			//VBox languagePV = loader.load(new FileInputStream("src/application/LanguagePickerView.fxml"));
			//VBox musicalInstrumentPV = loader.load(new FileInputStream("src/application/MusicalInstrumentPickerView.fxml"));
			//VBox skillTrackerBox = loader.load(new FileInputStream("src/application/Skill Tracker.fxml"));
			
			Scene mainScene = new Scene(root,1000,1000);
			//Scene codingScene = new Scene(codingLPV,1000,1000);
			//Scene languageScene = new Scene(languagePV,1000,1000);
			//Scene musicalScene = new Scene(musicalInstrumentPV,1000,1000);
			//Scene trackerScene = new Scene(skillTrackerBox,1000,1000);
			PrimeController controller = (PrimeController)loader.getController();
			
			controller.applicationStage = primaryStage;
			primaryStage.setTitle("Khondaker Samin Rashid's Final Rpoject");
			primaryStage.setScene(mainScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
