package application;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainSceneController {
	@FXML
	private Button addBtn;
	@FXML
	private Button subtractBtn;
	@FXML
	private Button multiplyBtn;
	@FXML
	private Button divideBtn;
	@FXML
	private Label processLabel;
	@FXML
	private Button clearBtn;
	@FXML
	private Button exitBtn;
	@FXML
	private TextField number1TF;
	@FXML
	private TextField number2TF;
	@FXML
	private TextField resultTF;
	private double result;

	// Event Listener on Button[#addBtn].onAction
	@FXML
	public void add(ActionEvent event) {
		String number1TFStr = number1TF.getText();
		String number2TFStr = number2TF.getText();
		double number1 = Double.parseDouble(number1TFStr);
		double number2 = Double.parseDouble(number2TFStr);
		
		result = number1 + number2;
		resultTF.setText(String.valueOf(result));
		processLabel.setText("Adding...");
	}
	// Event Listener on Button[#subtractBtn].onAction
	@FXML
	public void subtract(ActionEvent event) {
		String number1TFStr = number1TF.getText();
		String number2TFStr = number2TF.getText();
		double number1 = Double.parseDouble(number1TFStr);
		double number2 = Double.parseDouble(number2TFStr);
		
		result = number1 - number2;
		resultTF.setText(String.valueOf(result));
		processLabel.setText("Subtracting...");
	}
	// Event Listener on Button[#multiplyBtn].onAction
	@FXML
	public void multiply(ActionEvent event) {
		String number1TFStr = number1TF.getText();
		String number2TFStr = number2TF.getText();
		double number1 = Double.parseDouble(number1TFStr);
		double number2 = Double.parseDouble(number2TFStr);

		result = number1 * number2;
		resultTF.setText(String.valueOf(result));
		processLabel.setText("Multiplying...");
	}
	// Event Listener on Button[#divideBtn].onAction
	@FXML
	public void divide(ActionEvent event) {
		String number1TFStr = number1TF.getText();
		String number2TFStr = number2TF.getText();
		double number1 = Double.parseDouble(number1TFStr);
		double number2 = Double.parseDouble(number2TFStr);

		result = number1 / number2;
		resultTF.setText(String.valueOf(result));
		processLabel.setText("Dividing...");
	}
	// Event Listener on Button[#clearBtn].onAction
	@FXML
	public void clear(ActionEvent event) {
		number1TF.setText("");
		number2TF.setText("");
		resultTF.setText("");
		
	}
	// Event Listener on Button[#exitBtn].onAction
	@FXML
	public void exit(ActionEvent event) {
		Platform.exit();
	}
}
