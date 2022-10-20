package application;

public class Test {

	public static void main(String[] args) {
		GradeAnalyzer ga = new GradeAnalyzer();
		ga.readFile();
		ga.calculateMean();
		ga.calculateStdDev();
		ga.assignGrades();
		
		System.out.println("\nThere were " + ga.getaList().size() + " exams.\n" +
				"Mean: " + ga.getM() + "\n" +
				"Std. Deviation: " + ga.getS() + "\n\n" +
				"Score" + "\tGrade");
		for (int i = 0; i < ga.getaList().size(); i++) {
			System.out.printf("%s\t%s\n", ga.getaList().get(i), ga.getLetterGradeList().get(i));
		}

	}

}
