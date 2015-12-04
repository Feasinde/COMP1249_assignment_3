//-----------------------------------------------------------------------
//Assignment 3
//Part 1
//Written by: 
//Sviki Gabbay - 27490968
//Andrés Lou 24712374
//Victoria Avgoustis 27529198
//Laura Elena González 27217323	
//
//COMP 249 - Section D
// Driver to for our multiple methods found in the CellList. 
// Here we begin by opening a .txt file with information concerning cell phones and initializing objects of type CellPhone.
// We then initialize the linked list, CellList, with these objects. After displaying the list, we test the various
// methods such as, addToStart(), deleteFromStart(), equals(), clone(), etc.
//-----------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;
import java.util.Locale;

public class CellListUtilisation{
	
	public static void main(String[] args){
		//declare and initialise the name of the file to be read
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
		System.out.println("\n");
		System.out.println("We're going to look up for some serial numbers");
		for (int i = 0;i < 3;i++){
			System.out.println("Please enter a serial number you wish to search: ");
			long serialNum = keyboard.nextLong();
			System.out.println();
			if (list1.contains(serialNum)){
				System.out.println("The phone with the this serial number is at location "+list1.find(serialNum));
			}
			else if (!list1.contains(serialNum)){
				System.out.println("The phone with the serial "+serialNum+" is not on the list.");
			}
		}
		System.out.println();
		System.out.println("Creating two more phone objects");		
		CellPhone phone1 = new CellPhone(12345678, "Nokia", 199.99, 1998);
		CellPhone phone2 = new CellPhone(23456789, "Apple", 999.99, 2014);
		
		System.out.println("list1 is has this many nodes: "+list1.size());

		System.out.println("Beginning clone method test");

		CellList list2 = new CellList(list1); 
		list2.showContents();

		System.out.println("adding a phone to the beginning of list2");
		list2.addToStart(phone1);		

		System.out.println("deleting a phone from index 4");

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





