package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MusicSkill {
	private Stage applicationStage = new Stage(); 
	private Parent root;
	private Scene mainScene; // Make them parameters of back button
	
	
	public MusicSkill(Stage applicationStage, Parent root) {
		this.applicationStage = applicationStage;
		this.root = root;
		this.mainScene = new Scene(root);
	}
	 
	 
}