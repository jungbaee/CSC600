package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Controller {

    @FXML
    private Button addButton;

    @FXML
    private Label array;

    @FXML
    private Button deleteBtton;

    @FXML
    private Button displayContentButton;

    @FXML
    private Button displayTheSizeButton;

    @FXML
    private Label originalArrayLabel;

    @FXML
    private Button searchButton;

    @FXML
    private TextField indexAddTextField;
    
    @FXML
    private TextField indexDeleteTextField;
    
    @FXML
    private TextField numberValueTextField;
    
    @FXML
    private TextField numberSearchTextField;

    @FXML
    private Button sortButton;

    @FXML
    private Label sortedArrayLabel;
    
    @FXML
    private Label sizeLabel;
    
    @FXML
    private Label searchLabel;

    static ArrayList<Integer> arr = new ArrayList<Integer>(20);
    static boolean didInitialize = false;
    
    
    @FXML
    void add(ActionEvent event) {
    	int index = Integer.parseInt(indexAddTextField.getText());
    	int numberValue = Integer.parseInt(numberValueTextField.getText());
    	arr.add(index, numberValue);
    	display();

    }

    @FXML
    void delete(ActionEvent event) {
    	int index = Integer.parseInt(indexDeleteTextField.getText());
    	arr.remove(index);
    	display();
    }

    public void initializeTheArray() {
    	Random rand = new Random(System.currentTimeMillis());
	    for (int i = 0; i < 20; i++) {
	    	arr.add((int)(Math.random()*100));
	    }
	    didInitialize = true;
	   
    }
    
    public void display() {
    	originalArrayLabel.setText(arr.toString());
    }
    
    @FXML
    void displayTheContent(ActionEvent event) {
    	if (!didInitialize)
    		initializeTheArray();
    	display();
    }

    @FXML
    void displayTheSize(ActionEvent event) {
    	int size = arr.size();
    	sizeLabel.setText("The array size is: " + String.valueOf(size));
    }

    @FXML
    void search(ActionEvent event) {
    	int searchValue = Integer.parseInt(numberSearchTextField.getText());
    	int occurence = 0;
    	
    	for (int i = 0; i < arr.size(); i++) {
    		if (arr.get(i) == searchValue) {
    			occurence++;
    		}
    	}
    	searchLabel.setText("It occurs " + String.valueOf(occurence) + " time(s)");
    	
    }

    @FXML
    void sort(ActionEvent event) {
    	ArrayList<Integer> arr2 = new ArrayList<>(arr);
    	Collections.sort(arr2);
    	sortedArrayLabel.setText(arr2.toString());
    }

    
}
