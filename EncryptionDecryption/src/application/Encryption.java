package application;

public class Encryption {

	//String originalString;
	String encrpytedString;
	
	public Encryption() {
		//this.originalString = null;
		this.encrpytedString = null;
		
	}
	
	public Encryption(/*String originalString,*/ String encrpytedString) {
		//this.originalString = originalString;
		this.encrpytedString = encrpytedString;
	}

	/*public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}*/

	public String getEncrpytedString() {
		return encrpytedString;
	}

	public void setEncrpytedString(String encrpytedString) {
		this.encrpytedString = encrpytedString;
	}
	
	
	
}
