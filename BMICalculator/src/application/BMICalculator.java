package application;


//Part A(i)
public class BMICalculator {
	
	//Part A(ii)
	private float weight;
	private float height;
	private float bmi;
	
	//Part A(iii)
	private String serious = "Seriously underweight";
	private String under =  "Underweight";
	private String normal = "Normal weight";
	private String over = "Overweight";
	private String obese = "Obese";
	

	//Part A(i)
	public BMICalculator() {
		this.height = 1;
		this.weight = -1;
	}
	
	//Part A(iv)
	public float getHeight() {
		return this.height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getWeight() {
		return this.weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	//Part A(v)
	public float calculateBMI () {
		this.bmi = this.weight/(this.height*this.height);
		return this.bmi;
	}
	
	public String getMessage (float bmi) {
		String message = "";
		
		if (bmi < 18.0) {
			message = serious;
		} else if (bmi > 18.0 && bmi < 18.5) {
			message = under;
		} else if (bmi > 18.5 && bmi < 24.9) {
			message = normal;
		} else if (bmi > 25 && bmi < 29.9) {
			message = over;
		} else if (bmi > 30 && bmi < 39.9) {
			message = obese;
		} else {
			message = "Invalid";
		}
		
		return message;
	}
}
