package Structure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import extration.Exels;
import helper.Helper;

public class Tableau {
	
	public  String[][] tableau ;
	
	public Tableau() throws IOException {
		this.tableau = Exels.readXLSXFile();
	}
		
	public void afficheItems() {

		ArrayList<String> products  = new ArrayList<>();
		
		//récupération des items du tableau 
		for(String sousTab[] : tableau)
		{
		
			
			for(String str : sousTab)
			{
				if(! products.contains(str) && str != null && str != sousTab[0]) {
					products.add(str);
				}
			}
		}

		System.out.println("\n*******************                       liste de nos items*********************\n");
		System.out.println(products.toString()+"\n");
	}
	
	public void AfficheTransaction() {
		System.out.println("\n**********************                                 Ensemble de nos transactions :*************************\n");
		Helper.afficheTab(tableau);
	}
    
			
}
