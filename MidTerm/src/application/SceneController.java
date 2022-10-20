package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private Label nameLabel;
    
    @FXML
    private Label statusLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button removeButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button selectButton;

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> originalList = new ArrayList<String>();
    String file = "name.txt";
    FileHandler gfh = new FileHandler(file);
    String message =  "You have selected: \n";
    String nameSelected = "";
    //part i
    
    @FXML
    void load(ActionEvent event) {

    	if(gfh.canRead() == false) {
    		statusLabel.setText("File cannot be read");
    		return;
    	} else {
    		statusLabel.setText("The file has been read");
    	}
    	
    	gfh.readFile(list);
    	for (String name: list) {
    		//part ii
    		comboBox.getItems().add(name);
    		originalList.add(name);
    	}

    }
    
    @FXML
    void add(ActionEvent event) {
    	String name = nameTextField.getText();
    	comboBox.getItems().add(name);
    	
    	if(gfh.canWrite() == false) {
    		statusLabel.setText("The name could not be added");
    		return;
    	} else {
    		list.add(name);
    		gfh.writeFile(list);
        	nameTextField.clear();
        	statusLabel.setText("A name has been added");
    	}	
    	
    }

    @FXML
    void remove(ActionEvent event) {
    	
    	if (comboBox.getSelectionModel().getSelectedIndex() > -1) {
    		String nameToRemove = comboBox.getItems().get(comboBox.getSelectionModel().getSelectedIndex());
    		list.remove(nameToRemove);
	    	gfh.writeFile(list, gfh);
	    	comboBox.getItems().remove(comboBox.getSelectionModel().getSelectedIndex());
	    	statusLabel.setText("An item was removed");
	    	
    	} else {
    		statusLabel.setText("You cannot remove that item");
    	}
    	
    }

    @FXML
    void reset(ActionEvent event) {  	
    	
    	if(gfh.canRead() == false) {
    		statusLabel.setText("Not resetted");
    		return;
    	} else {
    		statusLabel.setText("Resetted");
    	}
    	list.clear();
    	comboBox.getItems().clear();
    	    	
    	for (String name: originalList) {
    		//part ii
    		comboBox.getItems().add(name);
    		list.add(name);
    	}
    	gfh.writeFile(list, gfh);
    	
    }

    @FXML
    void select(ActionEvent event) {
    	Alert a = new Alert(AlertType.INFORMATION);   	
    	
    	nameSelected += comboBox.getItems().get(comboBox.getSelectionModel().getSelectedIndex()) + "\n";
    	a.setContentText(message + nameSelected);
    	a.showAndWait();
    }
    
    @FXML
    void exit(ActionEvent event) {
    	//gfh.writeFile(originalList);
    	Stage stage = (Stage) exitButton.getScene().getWindow(); 
    	stage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
