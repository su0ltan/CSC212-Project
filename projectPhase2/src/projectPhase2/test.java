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

	        

	    
	        
	      
		
		//declaring the file path and call the function
	       // String path = "C:\\Users\\Sultan\\data.txt";
	        //readFileAndAnalyse(path);

		String path = "data.txt";
		ThemeParkADT<visitorInfo> x = new ThemeParkADT<>();
		System.out.println(x.maxK);		
	}

	
	

}
