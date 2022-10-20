package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
//import javax.xml.bind.JAXB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable {

    @FXML
    private TextField bloodPressureTextField;
    @FXML
    private TextField BMITextField;
    @FXML
    private TextField HDLTextField;
    @FXML
    private TextField LDLTextField;
    @FXML
    private TextField hemoglobinTextField;
    @FXML
    private TextField triglyceridesTextField;
    @FXML
    private Label HDLLabel;
    @FXML
    private Label LDLLabel;
    @FXML
    private Label bloodPressureLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Button saveButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button loadButton;
    @FXML
    private Label HDLchLabel;
    @FXML
    private Label LDLchLabel;
    @FXML
    private Label BPchLabel;
    @FXML
    private Label BMIchLabel;
    @FXML
    private Label hemochLabel;
    @FXML
    private Label TrichLabel;

    
    Alert a = new Alert(AlertType.WARNING);
    static IHAs ihas = new IHAs();
    int i = 0;
    ArrayList<String> list = new ArrayList<String>();

    @FXML
    void saveData (ActionEvent event) {
    	
    	String bloodPressure = bloodPressureTextField.getText();
    	String BMI = BMITextField.getText();
    	String HDL = HDLTextField.getText();
    	String LDL = LDLTextField.getText();
    	String hemoglobin = hemoglobinTextField.getText();
    	String triglycerides = triglyceridesTextField.getText();
    	statusLabel.setText("");

        if (!bloodPressure.isEmpty() && !BMI.isEmpty() && !HDL.isEmpty() && !LDL.isEmpty() && !hemoglobin.isEmpty() && !triglycerides.isEmpty()) {

        	IndividualHealthAssessment iha = new IndividualHealthAssessment(Double.parseDouble(bloodPressure), Double.parseDouble(BMI), Double.parseDouble(HDL),
        			Double.parseDouble(LDL), Double.parseDouble(hemoglobin), Double.parseDouble(triglycerides));

	    	sendWarningMessage(iha);
	    	ihas.getIHAs().add(iha);
	    	saveDataAsXML();

	    	
	    	statusLabel.setText("Data added");
	    	System.out.println(iha.toString());
	    	
        } else {
        	statusLabel.setText("Please fill out all the blanks with numbers");
        }
    }
    
    @FXML 
    void clear (ActionEvent event) {
    	bloodPressureTextField.clear();
    	BMITextField.clear();
    	HDLTextField.clear();
    	LDLTextField.clear();
    	hemoglobinTextField.clear();
    	triglyceridesTextField.clear();
    	BPchLabel.setText("");
    	BMIchLabel.setText("");
    	HDLchLabel.setText("");
    	LDLchLabel.setText("");
    	hemochLabel.setText("");
    	TrichLabel.setText("");
    	statusLabel.setText("Data cleared");
    }
    
    @FXML
    void loadData (ActionEvent event) {
    	String file = "PatientData.txt";
    	
    	FileHandler gfh = new FileHandler(file);
    	
    	if(gfh.canRead() == false) {
    		statusLabel.setText("File cannot be read");
    		return;
    	} else {
    		statusLabel.setText("The file has been read");
    	}
    	
    	gfh.readFile(list);
			bloodPressureTextField.setText(list.get(i++));
			BMITextField.setText(list.get(i++));
			HDLTextField.setText(list.get(i++));
			LDLTextField.setText(list.get(i++));
			hemoglobinTextField.setText(list.get(i++));
			triglyceridesTextField.setText(list.get(i++));
    }
    

    void saveDataAsXML () {

    	try {

	    	JAXBContext jaxbContext = JAXBContext.newInstance(IHAs.class);
	    	
	    	Marshaller marshaller = jaxbContext.createMarshaller();
	    	
	    	File file = new File("IHA.xml");
	    	
	    	marshaller.marshal(ihas, file);
	    	
    	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

    }
    
    void sendWarningMessage(IndividualHealthAssessment iha) {
    	String warningMessage = "";
    	if (iha.getBloodPressure() > 210 || iha.getBloodPressure() <= 50) {
    		warningMessage += "Your blood pressure is not in the normal range\n";
    		a.setContentText(warningMessage);
    	}
    	
    	if (iha.getBMI() > 30 || iha.getBMI() < 18.5) {
    		warningMessage += "Your BMI is not in the normal range\n";
    		a.setContentText(warningMessage);
    	}
    	
    	if (iha.getHDL() < 40) {
    		warningMessage += "Your HDL is too low\n";
    		a.setContentText(warningMessage);
    	}
    	
    	if (iha.getLDL() > 100) {
    		warningMessage += "Your LDL is too high\n";
    		a.setContentText(warningMessage);
    	}
    	
    	if ((iha.getLDL() + iha.getHDL()) > 200) {
    		warningMessage += "Your overall cholesterol is too high\n";
    		a.setContentText(warningMessage);
    	}
    	
    	if (iha.getHemoglobinA1c() < 80 || iha.getHemoglobinA1c() > 340) {
    		warningMessage += "Your hemoglobinA1C is not in the normal range\n";
    		a.setContentText(warningMessage);
    	}
    	
    	if (iha.getTriglycerides() > 250) {
    		warningMessage += "Your triglycerides is not in the normal range\n";
    		a.setContentText(warningMessage);
    	}

    	if (warningMessage != "") {
    		a.show();
    	}
    	
    	BPchLabel.setText(iha.evaluateBloodPressure());
    	BMIchLabel.setText(iha.evaluateBMI());
    	HDLchLabel.setText(iha.evaluateHDL());
    	LDLchLabel.setText(iha.evaluateLDL());
    	hemochLabel.setText(iha.evaluateHemoglobinA1C());
    	TrichLabel.setText(iha.evaluateTriglycerides());
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}

