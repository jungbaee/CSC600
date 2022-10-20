package application;
//Maintains a List<IndividualHealthAssessment>
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "individualHealthAssessments")
//@XmlAccessorType (XmlAccessType.FIELD)
public class IHAs
{
  @XmlElement(name = "individualHealthAssessment")
  private List<IndividualHealthAssessment> ihas = new ArrayList<IndividualHealthAssessment>();
 
  public List<IndividualHealthAssessment> getIHAs() {
    return ihas;
  }
 
  public void setIHAsIHAsz(List<IndividualHealthAssessment> ihass) {
    this.ihas = ihas;
  }
  
	 @Override
	 public String toString() {
	        return ("IHA: " + this.getIHAs());
	 }
}