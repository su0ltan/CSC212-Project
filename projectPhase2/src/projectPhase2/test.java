package projectPhase2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Scanner;

import javax.tools.FileObject;

public class test implements Serializable {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub

		visitorInfo person = new visitorInfo();

	        File file = new File("C:\\Users\\Sultan\\data.txt");

	    
	        readFileAndAnalyse(null);

	}

	
	
	public static void readFileAndAnalyse(String f) {

		
		  File file = new File("C:\\Users\\Sultan\\data.txt");
		  if(file.exists()) {
			  try {
				  Scanner sc = new Scanner(file);
				 
				  visitorInfo v = new visitorInfo((visitorInfogit )sc.next());
				  
				  System.out.println(sc.next());
			  }catch(Exception x){
				  System.out.println("File not found");
			  }
		  }
		  
		
			/*
			 * FileInputStream fstream = new FileInputStream(file); ObjectInputStream
			 * ostream = new ObjectInputStream(fstream);
			 * 
			 * visitorInfo v; boolean ok = false;
			 * 
			 * while(!ok){ try { v = new visitorInfo(); v =
			 * (visitorInfo)ostream.readObject();
			 * 
			 * }catch(EOFException e) { ok = true; } }
			 */
		 
		
			
		
	}

}
