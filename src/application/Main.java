package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
			
			Scene mainScene = new Scene(root,500,350);
									
			primaryStage.setTitle("Khondaker and Favour's Final Rpoject");
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
