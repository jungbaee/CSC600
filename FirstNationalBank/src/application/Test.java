/*package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		MortgageAnalyzer ma = new MortgageAnalyzer();
		boolean isCorrect = true;
		Scanner sc = new Scanner(System.in);

		while (isCorrect) {
			System.out.print("Type the amount of loan: ");
			ma.setLoanAmount(sc.nextDouble());
			System.out.println();
			
			System.out.print("Type the annual interst rate: ");
			ma.setRate(sc.nextDouble());
			System.out.println();
			
			System.out.print("Type the duration of the loan in months:  ");
			ma.setDuration(sc.nextDouble());
			System.out.println();
			
			System.out.print("Would you like to run a verification check? y/n: ");
			String response = sc.next().toLowerCase();
			if (response.equals("y")) {
				ma.isReasonable();
			}
			System.out.println();
			
			isCorrect = ma.correctInput();
		}
		
		ma.calculateMortgageDetails();
		
    }
}*/
