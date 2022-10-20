package application;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandler {

	//Part1.ii
	private Scanner fileReader;
	private Formatter fileWriter;
	
	//part1.iii
	private String fileName;
		
	//Part1.i
	public FileHandler(String fileName) {
		this.fileName = fileName;
	}
	
	//part1.iv
	public boolean canRead() {
		boolean isSuccess = false;
		
		try {
			fileReader = new Scanner (Paths.get(fileName));
			isSuccess = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
		
	}
	
	//part1.iv
	public boolean canWrite() {
		boolean isSuccess = false;
		
		try {
			fileWriter = new Formatter(fileName);
			isSuccess = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	//part1.v
	public boolean writeFile (ArrayList<String> list) {
		boolean isSuccess = false;
		
		if (fileWriter == null || list == null) {
			return isSuccess;
		}
		
		try {
			for (String decryptedString: list) {
				fileWriter.format("%s%n" , decryptedString);
			}
			fileWriter.close();
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isSuccess;
		}
		
		return isSuccess;
	}
	
	public boolean readFile(ArrayList<String> list) {
		boolean isSuccess = false;
		
		if (fileReader == null || list == null) {
			return isSuccess;
		}
		
		String grade;
		try {
			while(fileReader.hasNext()) {
				grade = fileReader.next();
				list.add(grade);
			}
			fileReader.close();			
			
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			return isSuccess;
		}
		
		return isSuccess;
		
	}
	
	public static void writeTexts(ArrayList<String> writeList, FileHandler fh) {
		fh.canWrite();
		fh.writeFile(writeList);
		
	}
	
	public static void readTexts(ArrayList<String> readList, FileHandler fh) {
		fh.canRead();
		fh.readFile(readList);
		
	}	
	
}
