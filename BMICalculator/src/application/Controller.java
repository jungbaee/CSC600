package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private Label BMICalcLabel;
    @FXML
    private Label BMIMessageLabel;
    @FXML
    private Button calculateBtn;
    @FXML
    private Label heightLabel;
    @FXML
    private TextField heightTF;
    @FXML
    private Label weightLabel;
    @FXML
    private TextField weightTF;
    @FXML
    private Dialog dialogDP;
    
    //Part2(viii)
    @FXML
    void handleCalcBMI(ActionEvent event) throws Exception {
    	BMICalculator bc = new BMICalculator();
    	String heightTFStr = heightTF.getText();
		String weightTFStr = weightTF.getText();
		float height = Float.parseFloat(heightTFStr);
		float weight = Float.parseFloat(weightTFStr);
		bc.setHeight(height);
		bc.setWeight(weight);
		float bmi = bc.calculateBMI();
		
		BMICalcLabel.setText(String.valueOf(bmi));
    	BMIMessageLabel.setText(String.valueOf(bc.getMessage(bmi)));
    	System.out.println("BMI: " + bmi + ", " + String.valueOf(bc.getMessage(bmi)));
    	
    	//Part3(i)
    	if (bmi < 18.5 || bmi > 35.0) {
    		
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Health Advisory Message");
    		alert.setContentText("You need to go see a doctor due to your BMI; you are either seriously underweight or overweight");
    		alert.show();
    		System.out.println("Go see a doctor");
    	}
    	
    }

}

