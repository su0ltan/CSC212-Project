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
				 
				  int maxK = 0;
				  // to store visitors info 
				  LinkedList<visitorInfo> visitorsObj = new LinkedList<>();
				  LinkedList<visitorInfo> vips = new LinkedList<>();
				  LinkedList<visitorInfo> regularVisitors = new LinkedList<>();
				  
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
				        
				 
					 if(maxK < tmpVistors.region)
						 maxK = tmpVistors.region;
						 
				        
				   
				        ArrayStack<Integer> kOrder = new ArrayStack<>();
				        for(int i = 5 ; i < arrOfStr.length ;i++)
				        	kOrder.push(Integer.parseInt(arrOfStr[i]));
				     
				        
				        tmpVistors.setOrder(kOrder);
				         
				       addTypeForsVisitors(tmpVistors  , regularVisitors, vips);
				        
				        searchRegion(tmpVistors.region);
				        visitorsObj.insert(tmpVistors);
				   
				       
				 }
				 //vips.PrintElement();
				 
				 ThemeParkADT<visitorInfo>xx = new ThemeParkADT<>();
				 xx.setVisitors(visitorsObj);
				 xx.setMaxK(maxK);
				//xx.searchVisitor("Ameer");
					
				 xx.rgnCount();
				 
			  }
			  catch(Exception x){
				  System.out.println(x.getMessage());
			  }
		  }
	}
	
	
	 
	public static void addTypeForsVisitors(visitorInfo tmp , LinkedList<visitorInfo> regularVisitors , LinkedList<visitorInfo> vips ){
		 if(tmp.type == 1)
	        	vips.insert(tmp);
		 else
			 regularVisitors.insert(tmp);
		 
	}
	public static void searchRegion(int r) {
	
		//if(r)
	}

}
