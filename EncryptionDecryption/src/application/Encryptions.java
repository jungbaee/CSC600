package application;
//Maintains a List<Encrpytion>
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "encryptions")
//@XmlAccessorType (XmlAccessType.FIELD)
public class Encryptions {
	
	@XmlElement(name = "encryption")
	private List<Encryption> e = new ArrayList<Encryption>();
	
	public List<Encryption> getEncryptions() {
		return e;
	}
	
	public void setEncryptions (List<Encryption> e) {
		this.e = e;
	}
	
	@Override
	public String toString() {

		return ("e: " + this.getEncryptions());
	}

}