module IndividualHealthAssessmentProgram {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.xml.bind;
	requires com.sun.xml.bind;
	
	opens application to javafx.graphics, javafx.fxml,java.xml.bind;
}
