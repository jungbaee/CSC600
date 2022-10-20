package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label TotalInterestLabel;

    @FXML
    private Label amountOfLoanLabel;

    @FXML
    private TextField amountOfLoanTextField;

    @FXML
    private Label annualInterestRateLabel;

    @FXML
    private Button displayButton;

    @FXML
    private Label durationLabel;

    @FXML
    private TextField durationTextField;

    @FXML
    private TextField interestRateTextField;

    @FXML
    private Label monthlyPaymentLabel;

    @FXML
    private Label monthlyPaymentLabelValue;

    @FXML
    private Label totalInterestPaidLabelValue;

    @FXML
    private Label verificationLabel;

    @FXML
    private Button verifyButton;

    @FXML
    private Label warningLabel;

    MortgageAnalyzer ma = new MortgageAnalyzer();
    
    @FXML
    void displayMyLoanInfo(ActionEvent event) {
    	ma.setLoanAmount(Double.parseDouble(amountOfLoanTextField.getText()));
    	ma.setRate(Double.parseDouble(interestRateTextField.getText()));
    	ma.setDuration(Double.parseDouble(durationTextField.getText()));

    	if (!ma.correctInput()) {
    		ma.calculateMortgageDetails();
    		monthlyPaymentLabelValue.setText("$" + String.valueOf(Math.round(ma.getMonthlyPayment()*100.00)/100.00));
    		totalInterestPaidLabelValue.setText("$" + String.valueOf(Math.round(ma.getTotalInterest()*100.00)/100.00));
    		durationTextField.setStyle(null);
    		interestRateTextField.setStyle(null);
    		amountOfLoanTextField.setStyle(null);
    	} else {
    		warningLabel.setText("Unable to compute the data!");
    		monthlyPaymentLabelValue.setText("");
    		totalInterestPaidLabelValue.setText("");
    		warningLabel.setText("Wrong");

    		if (!ma.getIsDuratoinCorrect()) {
    			durationTextField.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
    			warningLabel.setText(warningLabel.getText() + " duration");
    		} else {
    			durationTextField.setStyle(null);
    		}
    		if (!ma.getIsRateCorrect()) {
    			interestRateTextField.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
    			warningLabel.setText(warningLabel.getText() + " rate");
    		} else {
    			interestRateTextField.setStyle(null);
    		}
    		
    		if (!ma.getIsloanAmountCorrect()) {
    			amountOfLoanTextField.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");;
    			warningLabel.setText(warningLabel.getText() + " loan amount");
    		} else {
    			amountOfLoanTextField.setStyle(null);
    		}
    	}
    }

    @FXML
    void verifyMyInputs(ActionEvent event) {

    	ma.setLoanAmount(Double.parseDouble(amountOfLoanTextField.getText()));
    	ma.setRate(Double.parseDouble(interestRateTextField.getText()));
    	ma.setDuration(Double.parseDouble(durationTextField.getText()));
    	
    	if(!ma.correctInput()) {
    		warningLabel.setText("Yes, your inputs are reasonable");
    		durationTextField.setStyle(null);
    		interestRateTextField.setStyle(null);
    		amountOfLoanTextField.setStyle(null);
    	} else {
    		warningLabel.setText("Try again with reasonable inputs");
    		
    		if (!ma.getIsDuratoinCorrect()) {
    			durationTextField.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
    		} else {
    			durationTextField.setStyle(null);
    		}
    		
    		if (!ma.getIsRateCorrect()) {
    			interestRateTextField.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");
    		} else {
    			interestRateTextField.setStyle(null);
    		}
    		
    		if (!ma.getIsloanAmountCorrect()) {
    			amountOfLoanTextField.setStyle("-fx-text-box-border: #B22222; -fx-focus-color: #B22222;");;
    		} else {
    			amountOfLoanTextField.setStyle(null);
    		}
    		

    	}
    	
    	
    }

}
