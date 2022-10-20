package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Button analyzeButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;
    GradeAnalyzer ga = new GradeAnalyzer();

    @FXML
    void analyzeGrades(ActionEvent event) {
    	vBox.getChildren().clear();
    	ga.readFile();
		ga.calculateMean();
		ga.calculateStdDev();
		ga.assignGrades();
    	vBox.getChildren().add( new Text ("There were " + ga.getaList().size() + " exams.\n" +
				"Mean: " + ga.getM() + "\n" +
				"Std. Deviation: " + ga.getS() + "\n\n" +
				"Score" + "\tGrade"));

    	for (int i = 0; i < ga.getaList().size(); i++) {
    		vBox.getChildren().add( 
    				new Text(ga.getaList().get(i) + "\t\t" + ga.getLetterGradeList().get(i))
    		);
    	}	

    }

}
