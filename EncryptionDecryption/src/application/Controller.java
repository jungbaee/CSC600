package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller implements Initializable{

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> encrpytedList = new ArrayList<String>();
    ArrayList<String> unmarshaledList = new ArrayList<String>();
    ArrayList<String> decrpytedList = new ArrayList<String>();
    //int i = 0;
    final String secretKey = "ssshhhhhhhhhhh!!!!";
    @FXML
    private Button loadButton;
    @FXML
    private Button decryptButton;
    @FXML
    private Button encryptButton;
    @FXML
    private TextField encryptFileNameTextField;
    @FXML
    private TextField decryptFileNameTextField;
    @FXML
    private Label statusLabel;
    Encryptions encryptions = new Encryptions();
    Decryptions decryptions = new Decryptions();

    @FXML
    void decrypt(ActionEvent event) {
    	decrpytedList.clear();
    	unmarshal(decryptFileNameTextField.getText());
    	Iterator i = unmarshaledList.iterator();
    	
    	try {
    		
    		while (i.hasNext()) {
    			String originalString = (String) i.next();
    			String decryptedString = AES.decrypt(originalString, secretKey);
    			decrpytedList.add(decryptedString);
    		}
    			
    		statusLabel.setText("Data decrypted");
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	System.out.println("Unmarshalled List: " + unmarshaledList.toString());
    	System.out.println("Decrypted List: " + decrpytedList.toString());
    	
    	FileHandler gfh = new FileHandler("Decryption.txt");
    	System.out.print(gfh.canWrite());
    	gfh.writeFile(decrpytedList);

    	
 
    }
    	
    @FXML
    void encrypt(ActionEvent event) {
    	Iterator i = list.iterator();
    	encrpytedList.clear();
    	try {
    		while (i.hasNext()) {
    			
    			String originalString = (String) i.next();
    			String encryptedString = (String) AES.encrypt(originalString, secretKey);
    			Encryption e = new Encryption(/*orignalString,*/ encryptedString);
    			encryptions.getEncryptions().add(e);
    			encrpytedList.add(encryptedString);
    		}
    		saveDataAsXML();
    		System.out.println("Encrypted List: " + encrpytedList.toString());
    		statusLabel.setText("Data encrypted");

    	} catch (Exception e) {
    		e.printStackTrace();
    	}    	
    }
    
	@FXML
    void loadData (ActionEvent event) {

    	FileHandler gfh = new FileHandler(encryptFileNameTextField.getText());
    	if(gfh.canRead() == false) {
    		statusLabel.setText("File cannot be read");
    		return;
    	} else {
    		statusLabel.setText("The file has been read");
    	}
    	list.clear();
    	gfh.readFile(list);
    	System.out.println("Data to be encrypted: " + list.toString());
    }
	
    public void saveDataAsXML () {

    	try {

	    	JAXBContext jaxbContext = JAXBContext.newInstance(Encryptions.class);
	    	Marshaller marshaller = jaxbContext.createMarshaller();
	    	File file = new File("encryption.xml");
	    	marshaller.marshal(encryptions, file);	    	
    	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

    }
    
    public void unmarshal(String fileName) {

    	unmarshaledList.clear();
        JAXBContext jaxbContext;
        try (BufferedReader input = 
        		Files.newBufferedReader(Paths.get(fileName))) {
          Encryptions encryptions = JAXB.unmarshal(input,  Encryptions.class);
          
          
          for (Encryption encryption : encryptions.getEncryptions()) {
        	  unmarshaledList.add(encryption.getEncrpytedString());
          }

        }
        catch (IOException e) {
          e.printStackTrace();
        }
}
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		encryptFileNameTextField.setText("Encryption.txt");
		decryptFileNameTextField.setText("encryption.xml");
		// TODO Auto-generated method stub
		
	}

}
