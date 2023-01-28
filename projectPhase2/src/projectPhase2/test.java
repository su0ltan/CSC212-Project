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
	        String path = "C:\\Users\\Sultan\\data.txt";
	        readFileAndAnalyse(path);

	}

	
	
	public static void readFileAndAnalyse(String f) {

		
		  File file = new File(f);
		  
		  if(file.exists()) {
			  try {
				 
				  // to store visitors info 
				  LinkedList<visitorInfo> visitorsObj = new LinkedList<>();
				  
				  // to read the file
				  Scanner sc = new Scanner(file);
				 
				  
				  visitorInfo tmpVistors = null ;
				  String[] arrOfStr = null; ;
				 
				 while(sc.hasNextLine()) {
					
					 /* split function divides the string line according to comma and store the
					   words in the array */
					 arrOfStr = sc.nextLine().split(",");
					 
					 // declaring new object and store the info into it
					 tmpVistors = new visitorInfo();
					 tmpVistors.fname = arrOfStr[0];
					 tmpVistors.Lname = arrOfStr[1];
					 tmpVistors.region = Integer.parseInt(arrOfStr[2]) ;
					 tmpVistors.type = Integer.parseInt(arrOfStr[3]) ;
					 tmpVistors.phoneNum = arrOfStr[4];
				        
				 
				        //for unknown remaining words are the kingdom order we store it into x
				        int[] x = new int[arrOfStr.length - 5];
				   
				        ArrayStack<Integer> kOrder = new ArrayStack<>();
				        for(int i = 5 ; i < arrOfStr.length ;i++)
				        	kOrder.push(Integer.parseInt(arrOfStr[i]));
				     
				        
				        tmpVistors.setOrder(kOrder);
				        visitorsObj.insert(tmpVistors);
				 // d.retrieve().print();     
				       
				 }
				 
				 
				 try {
					 visitorsObj.PrintElement();
				 }catch(NullPointerException n) {
					 System.out.println("null pointet"); 
				 }
				 
			  }
			  catch(Exception x){
				  System.out.println(x.getMessage());
			  }
		  }
	}

}
