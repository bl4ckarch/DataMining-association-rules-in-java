package extration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import helper.Helper;


public class Exels {
	
	public static String[][] readXLSXFile() throws IOException
	{
		int verificateurInvoice =0;
		String[][] transaction = new String[100][600];
		int i=0, j=0 ,colonne=0 ;
		String chaine= new String();
		
		InputStream ExcelFileToRead = new FileInputStream("src/Dataset.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell; 
		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == CellType.STRING)
				{
					//System.out.print(cell.getStringCellValue());
					if(verificateurInvoice != 0)
						transaction[i][j] = cell.getStringCellValue();
				}
				else if(cell.getCellType() == CellType.NUMERIC)
				{ 
					if( verificateurInvoice != (int)cell.getNumericCellValue()) {
							verificateurInvoice=(int)cell.getNumericCellValue();
							if(j > colonne)
								colonne = j;
							j=0;
							i++;
							transaction[i][j]=chaine.valueOf(cell.getNumericCellValue());
							j++;
							
						
					}
					else {
						j++;
					}
			}
				else
				{
					System.out.print("Error");
				}
			}
		}
		
		String[][] optransaction = new String[i][colonne+1];
		Helper.affectationMatrice(optransaction, transaction);
		transaction = optransaction;
		
		i=1;
		
		return transaction;
		
		
	}
	
	
	public static LinkedList<LinkedList> readXLSXFileList() throws IOException
	{
		
		int verificateurInvoice =0;
		LinkedList<LinkedList> transactions = new LinkedList<>();
		LinkedList transaction = new LinkedList<>();
		String chaine= new String();
		
		InputStream ExcelFileToRead = new FileInputStream("src/Dataset.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == CellType.STRING)
				{
					//System.out.print(cell.getStringCellValue());
					if(verificateurInvoice != 0)
						transaction.add( cell.getStringCellValue());
				}
				else if(cell.getCellType() == CellType.NUMERIC)
				{
					if( verificateurInvoice != (int)cell.getNumericCellValue()) {
							verificateurInvoice=(int)cell.getNumericCellValue();
							if(! transaction.isEmpty())
								transactions.add((LinkedList) transaction.clone());
							transaction.clear();
							
							transaction.add(chaine.valueOf(cell.getNumericCellValue()));
							
						
					}
					
			}
				else
				{
					System.out.print("Error");
				}
			}
			
		}
		
		return transactions;
		
		
	}
	
	public static Hashtable readXLSXFileHastable() throws IOException {
		int verificateurInvoice =0;
        Hashtable transactions = new Hashtable();
		LinkedList transaction = new LinkedList<>();
		String chaine= new String();
		
		InputStream ExcelFileToRead = new FileInputStream("src/Dataset.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == CellType.STRING)
				{
					//System.out.print(cell.getStringCellValue());
					if(verificateurInvoice != 0)
						transaction.add( cell.getStringCellValue());
				}
				else if(cell.getCellType() == CellType.NUMERIC)
				{
					if( verificateurInvoice != (int)cell.getNumericCellValue()) {
							if(! transaction.isEmpty())
								transactions.put(verificateurInvoice,(LinkedList) transaction.clone());
							verificateurInvoice=(int)cell.getNumericCellValue();
							transaction.clear();
							
							transaction.add(chaine.valueOf(cell.getNumericCellValue()));
							
						
					}
					
			}
				else
				{
					System.out.print("Error");
				}
			}
			
		}
		
		return transactions;
	}
	
	public static void readXLSXFileAndCopyIntoDictionnary() throws IOException {
        int invoiceverif = 0;
        int j = 0;
        int i = 0;
       

        InputStream ExcelFileToRead = new FileInputStream("src/Dataset.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        String[][]Source=readXLSXFile();
        XSSFWorkbook test = new XSSFWorkbook();
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell = null;

        int a = 0, b = 0;
         Hashtable items = new Hashtable();
        Iterator rows = sheet.rowIterator();
        int col = 0, ligne = 0;
        
       
        Hashtable hashtable2d = new Hashtable();
        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();

                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue() != null  ) {
                    Hashtable ht = new Hashtable();
                     
                    ht.put(a, cell.getStringCellValue());
                    a++;
                    if (!items.contains(ht)) 
                    items.put(b, ht.get(b)); b++;
                }
               hashtable2d.putAll(items);
               
            }
        }
        System.out.println("                                                      dictionnaire des items\n\n");
       Hashtable listIemset=new Hashtable();
       a=1000;
        Enumeration e = items.elements();
        
        while (e.hasMoreElements()) {
            System.out.println("                                   "+e.nextElement());
        }
	}
}
