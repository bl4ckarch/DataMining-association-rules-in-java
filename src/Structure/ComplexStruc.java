package Structure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import com.graphbuilder.struc.LinkedList;

public class ComplexStruc {

	
	private Hashtable transHash ;
	private Hashtable itemsHash ;
	
	public ComplexStruc() throws IOException {
		transHash = extration.Exels.readXLSXFileHastable();
	}
	
	
	public void afficheTransaction() throws IOException {
		
		 int i=1;
		 Enumeration e = transHash.elements();
		 while(e.hasMoreElements())
		 {
			 System.out.println("Transaction"+" : "+e.nextElement()+"\n");
		 }
		 
	}
	
	public void afficheItems() throws IOException {
		
		extration.Exels.readXLSXFileAndCopyIntoDictionnary();
		
	}
		
	

}
