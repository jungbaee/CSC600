package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.DoubleSummaryStatistics;

public class GradeAnalyzer {
	
	List<String> aList = new ArrayList<String>();
	List<String> letterGradeList = new ArrayList<String>();
	DoubleSummaryStatistics stats;
	DoubleStream ds;
	private String fileName = "grades.txt";
	private String numberGrade;
	private String letterGrade = "Z";
	private double m = -1;
	private double sum = -1;
	private double variance = 0;
	private double s = -1;
	private double es = -1;
	
	public GradeAnalyzer() {
		
	}
	
	public List<String> getaList() {
		return aList;
	}

	public List<String> getLetterGradeList() {
		return letterGradeList;
	}

	public double getM() {
		return m;
	}

	public double getS() {
		return s;
	}
	
	//a
	public void readFile () {
		File file = new File(fileName);
		aList.clear();
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				aList.add(sc.nextLine());
			}
			ds = aList.stream()
					.mapToDouble((x) -> Double.parseDouble(x));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("The file is " + aList.toString());
	}
	
	//b
	public double calculateMean () {
		m = Math.round(ds.summaryStatistics().getAverage() * 100.0) / 100.0;

		return m;
			
	}
	
	//b
	public double calculateStdDev() {
	
		variance = aList.stream()
				.mapToDouble((x) -> Double.parseDouble(x))
				.map((double x) -> {return Math.pow(x - m, 2);})
				.sum()/(aList.size()-1);
		s = Math.round(Math.sqrt(variance) *100.0) / 100.0;

		return s;
	}
	
	//c
	public void assignGrades () {
		
		for (String numberGrade : aList) {
				es = Double.parseDouble(numberGrade);
			if (es > m + 1.5*s) {
				letterGrade = "A";
			} else if (es >= m+0.5*s && es < m + 1.5*s) {
				letterGrade = "B";
			} else if (es >= m-0.5*s && es < m+0.5*s) {
				letterGrade = "C";
			} else if (es >= m-1.5*s && es <= m-0.5*s) {
				letterGrade = "D";
			} else if (es < m-1.5*s) {
				letterGrade = "F";
			} else {
				letterGrade = "Z";
			}
			
			letterGradeList.add(letterGrade);
		}

	}



	
	
	
	
}
