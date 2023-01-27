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

	    
	        //readFileAndAnalyse(null);
	        readFileAndAnalyse("");

	}

	static void s() {
		String str = "Sara,AlAli,1,1,0544444444,4,3,2,1";
        String[] arrOfStr = str.split("," );
        visitorInfo v = new visitorInfo();
        
        v.fname = arrOfStr[0];
        v.Lname = arrOfStr[1];
        v.region = Integer.parseInt(arrOfStr[2]) ;
        v.type = Integer.parseInt(arrOfStr[3]) ;
        v.phoneNum = arrOfStr[4];
        v.print();
      //  for (String a : arrOfStr)
        	
          
	}
	
	
	public static void readFileAndAnalyse(String f) {

		
		  File file = new File("C:\\Users\\Sultan\\data.txt");
		  if(file.exists()) {
			  try {
				  LinkedList<visitorInfo> d = new LinkedList<>();
				  Scanner sc = new Scanner(file);
				 // String str =sc.nextLine();
				  visitorInfo v = null ;
				  String[] arrOfStr = null; ;
				 
				 while(sc.hasNextLine()) {
					
					 arrOfStr = sc.nextLine().split("," );
					 
					 v = new visitorInfo();
					   v.fname = arrOfStr[0];
				        v.Lname = arrOfStr[1];
				        v.region = Integer.parseInt(arrOfStr[2]) ;
				        v.type = Integer.parseInt(arrOfStr[3]) ;
				        v.phoneNum = arrOfStr[4];
				        
				 
				        int[] x = new int[arrOfStr.length - 5];
				        
				        for(int i = 5 ; i < arrOfStr.length ;i++)
				        	x[i - 5] = Integer.parseInt(arrOfStr[i]);
				     
				        v.addToArrayStack(x);
				        d.insert(v);
				        d.retrieve().print();
				    
				        
				       //v.print();
				        


				     
				     //   for(int c = 0 ; c < x.length ;c++)
				        //	System.out.println(" dd: "+x[c]);
				        
				        
				       
				       
				 }
			     	
				
				
			  }catch(Exception x){
				  System.out.println(x.getMessage());
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
