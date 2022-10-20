package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private Label GPALabel;

    @FXML
    private Button OkBtn;

    @FXML
    private Button calculateBtn;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField fileNameTF;

    @FXML
    private Button readGradesBtn;

    @FXML
    private Label readingLabel;
    
    ArrayList<String> list = new ArrayList<String>();
    FileHandler fh;

    @FXML
    void handleCalcGPA(ActionEvent event) {
    	String grade = (String)comboBox.getValue();
 	
    	if(grade == "" | grade == null) {
    		readingLabel.setText("Select a grade");
    		return;
    	}
    	
    	String gpa = "UNSET";
    	if (grade.equals("A")) {
    		gpa = "4.0";
    	} else if (grade.equals("A-")) {
    		gpa = "3.7";
    	} else if (grade.equals("B+")) {
    		gpa = "3.3";
    	} else if (grade.equals("B")) {
    		gpa = "3.0";
    	} else if (grade.equals("B-")) {
    		gpa = "2.7";
    	} else if (grade.equals("C+")) {
    		gpa = "2.3";
    	} else if (grade.equals("C")) {
    		gpa = "2.0";
    	} else if (grade.equals("C-")) {
    		gpa = "1.7";
    	} else if (grade.equals("D")) {
    		gpa = "1.0";
    	} else {
    		gpa = "0.0";
    	}
     		
    	GPALabel.setText("GPA is: " + gpa);
    	
    }
   
    

    @FXML
    void handleOKPressed(ActionEvent event) {
    	Stage stage = (Stage) OkBtn.getScene().getWindow(); 
    	stage.close();
    }

    @FXML
    void handleReadGrades(ActionEvent event) {
    	readingLabel.setText("");
    	String file = fileNameTF.getText();
    	
    	FileHandler gfh = new FileHandler(file);
    	
    	if(gfh.canRead() == false) {
    		readingLabel.setText("File cannot be read");
    		return;
    	} else {
    		readingLabel.setText("The file has been read");
    	}
    	
    	gfh.readFile(list);
    	for (String s: list) {
    		comboBox.getItems().add(s);
    	}
    	
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
