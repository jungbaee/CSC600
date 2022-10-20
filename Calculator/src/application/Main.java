package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));		
			
			primaryStage.setScene(new Scene(root, 700, 700));
			primaryStage.setTitle(STYLESHEET_CASPIAN);
			primaryStage.show();
	}


}
