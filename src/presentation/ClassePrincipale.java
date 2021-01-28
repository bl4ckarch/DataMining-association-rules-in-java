package presentation;

import java.io.IOException;
import java.util.Scanner;

import Structure.ComplexStruc;
import Structure.ListeChainee;
import Structure.Tableau;
import regleAssociation.CalculRegle;

public class ClassePrincipale {
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		CalculRegle rule = new CalculRegle();
		Tableau tab = new Tableau();
		ListeChainee liste = new ListeChainee();
		ComplexStruc htable = new  ComplexStruc();
		char choix = 0 ;
		
		System.out.println("***********************************************************************************************************************************************************");
		System.out.println("*                                                    UNIVERSITE DE YAOUNDE I / DEPARTEMENT D'INFORMATIQUE                                                 *");
		System.out.println("*                                                                TRAVAUX PRATIQUE INFO2033                                                                 *");
		System.out.println("*                                                                  REGLES D'ASSOCIATION                                                                   *");
		System.out.println("*                                                                         GROUPE 17                                                                       *");
		System.out.println("***********************************************************************************************************************************************************");
		
		do {
			char choix1 =0, recommence=0; 
			do {
				
				System.out.println("\n                                         Veuillez saisir le chiffre correspondant à   ce que voulez vous faire !\n\n"
						+ "                                                      1)Structuration des donnees\n"
						+ "                                                      2)Calculs des règles d'association");
				choix1=sc.nextLine().charAt(0);
			}while(choix1 != '1'  && choix1 != '2');
			do {
				if(choix1 == '1') {
					
					char choix11 =0;
					do {
						System.out.println("\n                                        Veuillez saisir le chiffre correspondant Ã   ce que voulez vous faire !\n\n"
								+ "                                                      1)Tableaux\n"
								+ "                                                      2)Listes chainées \n"
								+ "                                                      3)Tables de hashage\n"
								+ "                                                      0)Précédent\n");
						choix11=sc.nextLine().charAt(0);
						
					}while(choix11 != '1' && choix11 != '2' && choix11 != '3' && choix11 != '0');
					
					if(choix11 == '0')
						break;
					switch(choix11) {
					case '1':
						char recommence111=0;
						do {
							char choix111=0;
							do {
								
								System.out.println("\n                                         Bien vous avez choisis les tableaux; Que voulez vous faire !?\n\n"
										+ "                                                      1)Afficher le tableau  des items\n"
										+ "                                                      2)Afficher le tableau des transactions\n");
								choix111=sc.nextLine().charAt(0);
								
							}while(choix111 != '1' && choix111 != '2');
							
							if(choix111 == '1') {
								tab.afficheItems();
								System.out.println("                                          Voulez vous essayez d'afficher le tableau des transactions?[O/N]");
							}
							else {
								tab.AfficheTransaction();
								System.out.println("                                          Voulez vous essayez d'afficher le tableau des items?[O/N]");
							}
							recommence = sc.nextLine().toUpperCase().charAt(0);
						}while(recommence == 'O');
						break;
					case '2':
						char recommence112=0;
						do {
							char choix111=0;
							do {
								
								System.out.println("\n                                       Bien vous avez choisis les listes chainÃ©es; Que voulez vous faire !?\n\n"
										+ "                                                      1)Afficher la liste des items\n"
										+ "                                                      2)Afficher la liste des transactions\n");
								choix111=sc.nextLine().charAt(0);
								
							}while(choix111 != '1' && choix111 != '2');
							
							if(choix111 == '1') {
								liste.afficheItems();
								System.out.println("                                          Voulez vous essayez d'afficher la liste des transactions?[O/N]");
							}
							else {
								liste.afficheTransactions();
								System.out.println("                                          Voulez vous essayez d'afficher la liste des items?[O/N]");
							}
							recommence = sc.nextLine().toUpperCase().charAt(0);
						}while(recommence == 'O');
						break;
					
						
					case '3':
						char recommence113=0;
						do {
							char choix111=0;
							do {
								
								System.out.println("\n                                 Bien vous avez choisis les Tables de hashage; Que voulez vous faire !?\n\n"
										+ "                                                      1)Afficher la liste des items\n"
										+ "                                                      2)Afficher les transactions\n");
								choix111=sc.nextLine().charAt(0);
								
							}while(choix111 != '1' && choix111 != '2');
							
							if(choix111 == '1') {
								htable.afficheItems();
								System.out.println("                                   Voulez vous essayez d'afficher le tableau des transactions?[O/N]");
							}
							else {
								htable.afficheTransaction();
								System.out.println("                                   Voulez vous essayez d'afficher le tableau des items?[O/N]");
							}
							
							recommence = sc.nextLine().toUpperCase().charAt(0);
						}while(recommence == 'O');
						break;
						
						
					}
					
				}
				else {
					recommence =rule.rulesGenerator();
				}
			}while(recommence == 'O' );
			
		}while(choix != '1'  || choix != '2');
		
		System.out.println("                                                     MERCI POUR VOTRE ATTENTION C'Ã‰TAIT TOUT                       ");
	}

}
