package helper;

import java.util.LinkedList;
import java.util.Scanner;

public class Helper {
	
	public static Scanner c = new Scanner(System.in);
	
	public static void afficheTab(String[] tab ) {
		for(String str : tab) {
			 
			if(str != null) {
				System.out.print(str +" | ");
			}
		}
	}
	
	
	
	public static void afficheTab(String[][] tab) {
		
		int i=1;
		
		for(String[] soutab: tab) {
			//if(soutab[0] != null) {
				System.out.print("Transaction n° "+i+"  ID  : "+soutab[0]+" : ");
				
				for(String str : soutab) {
				 
					if( str != soutab[0] && str != null) {
						System.out.print(str +" | ");
					}
				}
				System.out.println("\n");
				i++;
			}
		
		//}
	}
	
	public static  void affectationMatrice(String[][] A, String[][] B) {
		
		int i=0,j=0;
		for(i=0; i< A.length; i++) {
			j=0;
			for(j=0; j < A[0].length; j++) {
				A[i][j] = B[i+1][j];
			}
		}

	}
	
	//Affichage des éléments d'une table
	public static void afficheTableau(int[][] tab)
	{
		int i=0,j=0,n=tab.length,b=tab[0].length;
		for(i=0;i<=n-1;i++)
		{
			for(j=0;j<=b-1;j++)
				System.out.print(tab[i][j]+"  ");
			System.out.print("\n");
		}
		System.out.println();
	}
	
	public static void afficheTableau(byte[][] tab)
	{
		int i=0,j=0,n=tab.length,b=tab[0].length;
		for(i=0;i<=n-1;i++)
		{
			for(j=0;j<=b-1;j++)
				System.out.print(tab[i][j]+"  ");
			System.out.print("\n");
		}
		System.out.println();
	}
	public static void afficheItemsetFrequent1(LinkedList candidat) { 
		
			
			System.out.print("itemset fréquent : ");
			for(int i=0; i<candidat.size(); i++) {
				System.out.print(candidat.get(i)+" | ");

		}
		System.out.println();
	}
	
	public static void afficheItemsetFrequent(LinkedList<LinkedList> candidat,String mot) { 
	
		for(LinkedList list : candidat) {
			
			System.out.print(mot+" : ");
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i)+" | ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}