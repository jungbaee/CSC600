package application;

import java.lang.Math;

public class MortgageAnalyzer {

	private double loanAmount = 0;
	private double rate = 0;
	private double duration = 0;
	private double monthlyPayment = 0;
	private double totalInterest = 0;
	boolean isRateCorrect = true;
	boolean isDurationCorrect = true;
	boolean isLoanAmountCorrect = true;
	
	
	public void setLoanAmount (double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public double getLoanAmount( ) {
		return this.loanAmount;
	}
	
	public void setRate (double rate) {
		this.rate = rate;
	}
	
	public double getRate () {
		return this.rate;
	}
	
	public void setDuration (double duration) {
		this.duration = duration;
	}
	
	public double getDuration () {
		return this.duration;
	}
	
	public double getMonthlyPayment() {
		return this.monthlyPayment;
	}
	
	public double getTotalInterest() {
		return this.totalInterest;
	}
	
	public boolean getIsRateCorrect () {
		return this.isRateCorrect;
	}
	
	public boolean getIsDuratoinCorrect () {
		return this.isDurationCorrect;
	}
	
	public boolean getIsloanAmountCorrect () {
		return this.isLoanAmountCorrect;
	}
		
	public boolean isReasonable () {
		/* 0 <= loanAmount < 3,000,000
		   0 <= rate < 17
		   0 <= duration < 601
		*/
		
		if (loanAmount > 0 && loanAmount < 3000000 
				&& rate > 0 && rate < 17 
				&& duration > 0 && duration < 601) {
			System.out.println("Yes, your inputs are reasonable");
			return true;
		} else {	
			System.out.println("No, your inputs are NOT reasonable");
			return false;
		}
	}
	
	public boolean correctInput () {
		boolean keepRunning = false;
		
		
		if (loanAmount < 0 || loanAmount > 3000000 ) {
			System.out.println("Your loan amount cannot be negative or more than $3M");
			keepRunning = true;
			this.isLoanAmountCorrect = false;
		} else {
			this.isLoanAmountCorrect = true;
		}
		
		
		if (rate < 0 || rate > 17) {
			System.out.println("Your loan rate must be between 0% and 17%");
			keepRunning = true;
			this.isRateCorrect = false;
		} else {
			this.isRateCorrect = true;
		}
		
		
		if (duration < 0 || duration > 601) {
			System.out.println("Your loan duration is out of our range");
			keepRunning = true;
			this.isDurationCorrect = false;
		} else {
			this.isDurationCorrect = true;
		}
		
		if (keepRunning == false) {
			System.out.println("All your inputs are correct");
		} else {
			System.out.println("Try Again!\n");
		}
		
		return keepRunning;
			
	}
	
	public void calculateMortgageDetails() {
		//(p*r*(1+r)^n)/((1+r)^n - 1)
		
		monthlyPayment = (loanAmount*(rate*0.01/12)*Math.pow(1+rate*0.01/12, duration))/(Math.pow(1+rate*0.01/12, duration)-1);
		totalInterest = duration*monthlyPayment-loanAmount;
		

		System.out.println("Monthly payment - $" + Math.round(monthlyPayment*100.00)/100.00);
		System.out.println("Total interst paid -$" + Math.round(totalInterest*100.00)/100.00);
		
	}
}
