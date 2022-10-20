package application;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IndividualHealthAssessment {

	private double bloodPressure;
	private double BMI;
	private double HDL;
	private double LDL; 
	private double hemoglobinA1c;
	private double triglycerides;

	public IndividualHealthAssessment() {
		this(-1.0,-1.0,-1.0,-1.0,-1.0,-1.0);
	}
	
	public IndividualHealthAssessment(double bloodPressure, double BMI, double HDL, double LDL , double hemoglobinA1c, double triglycerides) {
		this.bloodPressure = bloodPressure;
		this.BMI = BMI;
		this.HDL = HDL;
		this.LDL = LDL;
		this.hemoglobinA1c = hemoglobinA1c;
		this.triglycerides = triglycerides; 
	}
	
	public double getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public double getBMI() {
		return BMI;
	}
	public void setBMI(double bMI) {
		BMI = bMI;
	}
	public double getHDL() {
		return HDL;
	}
	public void setHDL(double hDL) {
		HDL = hDL;
	}
	public double getLDL() {
		return LDL;
	}
	public void setLDL(double lDL) {
		LDL = lDL;
	}
	public double getHemoglobinA1c() {
		return hemoglobinA1c;
	}
	public void setHemoglobinA1c(double hemoglobinA1c) {
		this.hemoglobinA1c = hemoglobinA1c;
	}
	public double getTriglycerides() {
		return triglycerides;
	}
	public void setTriglycerides(double triglycerides) {
		this.triglycerides = triglycerides;
	}
	
	
	public String evaluateBloodPressure () {
		if (this.bloodPressure > 210) {
			//System.out.println("Very severe");
			return "Very severe";
		} else if (this.bloodPressure >= 180) {
			return "Severe";
		} else if (this.bloodPressure >= 160) {
			return "Moderate";
		} else if (this.bloodPressure >=140) {
			return "Mild";
		} else if (this.bloodPressure >= 90) {
			return "Normal";
		} else if (this.bloodPressure >= 50) {
			return "Low";
		} else {
			return "Very Low";
		}
	}
	
	public String evaluateBMI () {
		if (this.BMI > 30) {
			return "Obese";
		} else if (this.BMI >= 25.0) {
			return "Overweight";
		} else if (this.BMI >= 18.5) {
			return "Normal";
		} else {
			return "Underweight";
		}
	}
	
	
	public String evaluateHemoglobinA1C () {
		if (this.hemoglobinA1c > 370 || this.hemoglobinA1c < 80) {
			return "Out of range";
		}else if (this.hemoglobinA1c >= 340) {
			return "Out of control";
		} else if (this.hemoglobinA1c >= 310) {
			return "Poor";
		} else if (this.hemoglobinA1c >= 270) {
			return "Marginal";
		} else if (this.hemoglobinA1c >= 180) {
			return "Good";
		} else {
			return "Excellent";
		}
	}
	
	public String evaluateHDL() {
		return (this.HDL > 40) ? "Optimal" : "Not Optimal";
	}
	
	public String evaluateLDL() {
		return (this.LDL < 100) ? "Optimal" : "Not Optimal";
	}
	
	public String evaluateTotalCholestrerol () {
		return (this.LDL + this.HDL) < 300 ? "Excellent" : "Not Excellent";
	}
	
	public String evaluateTriglycerides () {
		return this.triglycerides < 250 ? "Optimal": "Not Optimal";
	}
	
	 @Override
	 public String toString() {
	        return ("BP:"+ this.getBloodPressure()+
	                    " BMI: "+ this.getBMI() +
	                    " HDL: "+ this.getHDL() +
	                    " LDL: " + this.getLDL() +
	                    " Hemo: "+ this.getHemoglobinA1c() +
	                    " Tri: " + this.getTriglycerides() + "\n");
	 }
	
}
