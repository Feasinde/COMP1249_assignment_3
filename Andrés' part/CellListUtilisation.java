import java.io.*;
import java.util.Scanner;
import java.util.Locale;

public class CellListUtilisation{
	
	public static void main(String[] args){
		///////////////////////////////////////////////////////////////
		//This is a temporal version of the driver program wherein I //
		//test the CellList class									 //
		///////////////////////////////////////////////////////////////

		String fileName = null;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of the cellphone file: ");		
		fileName = keyboard.next();
		
		CellList list1 = new CellList();
		
		Scanner inputStream =  null;
		
		//takes different attributes from TXT file and creates cellPhone objects with them. Then takes 
		//objects and places them in our linked list ensuring no duplicate serial numbers are added
		try{												
			 inputStream = new Scanner(new FileReader(fileName));
					inputStream.useLocale(Locale.US);	
					while(inputStream.hasNextLong()){
						long serialNum = inputStream.nextLong();
						CellPhone phone = new CellPhone (serialNum, inputStream.next(), inputStream.nextDouble(),
								inputStream.nextInt());
						if(!(list1.contains(serialNum))) 	//goes through linked list for any serial number duplicates
							list1.addToStart(phone);					
					}
					inputStream.close();
			}		
		catch(IOException e){
				System.out.println("File not found!");
				System.exit(0);
			}
		
		list1.showContents();
		System.out.println();
		
		System.out.println("Please enter a serial number you wish to search: ");
		long serialNum = keyboard.nextLong();
				
		System.out.println();
		System.out.println("Is the serial number "+serialNum+" in the list? " + list1.contains(serialNum));
		System.out.println("The phone with the serial "+serialNum+" is here: "+ list1.find(serialNum));
		System.out.println();
				
		CellPhone phone1 = new CellPhone(12345678, "Nokia", 199.99, 1998);
		CellPhone phone2 = new CellPhone(23456789, "Apple", 999.99, 2014);
		
		CellList list2 = new CellList(list1); //Clone method
		list2.showContents();		
		list2.addToStart(phone1);		
		list2.deleteFromIndex(4);
		list2.deleteFromStart();
		list2.equals(list1);
		list2.showContents();
		
		CellList list3 = list1.clone();
		list3.showContents();
		list1.equals(list3);
		list3.ReplaceAtIndex(phone1, 8);
		list3.insertAtIndex(phone2, 3);
		
		list3.ReplaceAtIndex(phone1, -9);  //should end program due to incorrect index
		
		keyboard.close();
	} 
}





