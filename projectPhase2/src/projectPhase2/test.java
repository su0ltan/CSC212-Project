package projectPhase2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.tools.FileObject;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("omer");
	}
	
	public static void readFileAndAnalyse(String f) throws IOException, ClassNotFoundException {
		
		File file = new File(f);
		FileInputStream fstream = new FileInputStream(file);
		ObjectInputStream ostream = new ObjectInputStream(fstream);
		
		visitorInfo v;
		boolean ok = false;
		
		while(!ok) {
			try {
				v = (visitorInfo)ostream.readObject();
				
			}catch(EOFException e) {
				ok = true;
			}
		}
	}

}
