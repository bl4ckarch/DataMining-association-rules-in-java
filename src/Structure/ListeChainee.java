package Structure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import extration.Exels;


public class ListeChainee {
	
	private LinkedList<LinkedList> itemset;
	
	
	public ListeChainee() throws IOException {
		this.itemset=Exels.readXLSXFileList();
	}

	
	public void afficheItems() {
		
		LinkedList<String> items = new LinkedList<>();
		System.out.println("******liste des items********\n");
		
		for(LinkedList transaction : itemset)
        {

	        for(int i= 1; i< transaction.size(); i++)
	        {
	            if ( ! items.contains(transaction.get(i)))
	            	  items.add((String) transaction.get(i));  
	        }
        }
		System.out.println(items);
	}
	
	public void afficheTransactions() {
		System.out.println("\n********Liste des transaction***************\n");
		int i=1;
		
		for(LinkedList tab: itemset) {
			System.out.print("Transaction n° "+i+" : [");
			
			for(int j = 1; j< tab.size(); j++) {
					System.out.print(tab.get(j)+"  , ");
			}
			
			System.out.println("]\n");
			i++;
		}
	}
}


