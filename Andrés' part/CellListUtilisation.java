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
		
		//create two empty lists
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		CellList list3;
		Scanner keyboard = new Scanner(System.in);
		
		//declare and initialise the name of the file to be read
		String fileName = null;		
		System.out.println("Please enter the name of the cellphone file: ");		
		fileName = keyboard.next();
		
		//takes different attributes from TXT file and creates cellPhone objects with them. Then takes 
		//objects and places them in our linked list ensuring no duplicate serial numbers are added
		try{												
			 Scanner inputStream = new Scanner(new FileReader(fileName));
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

		System.out.println("\n");
		System.out.println("These are the contents of the file we just read: ");
		list1.showContents();
		System.out.println("We're going to look up for some serial numbers");
		for (int i = 0;i < 3;i++){
			System.out.print("Please enter a serial number you wish to search: ");
			long serialNum = keyboard.nextLong();
			System.out.println();
			if (list1.contains(serialNum)){
				System.out.println("The phone with this serial number is at location "+list1.find(serialNum));
				System.out.println("After "+ list1.getCounter()+" search/es");
			}
			else if (!list1.contains(serialNum)){
				System.out.println("The phone with the serial "+serialNum+" is not on the list.");
				System.out.println("After "+ list1.getCounter()+" search/es");
			}
		}

		System.out.println("\n---------------------------------------------------------------------------\n");

		System.out.println("We're going to create some more phone objects and put them in another list.");
		CellPhone phone1 = new CellPhone(12345678, "Nokia", 199.99, 1998);
		CellPhone phone2 = new CellPhone(23456789, "Apple", 999.99, 2014);
		CellPhone phone3 = new CellPhone(46975564, "Samsung", 399.99, 2006);
		CellPhone phone4 = new CellPhone(71364974, "LG", 299.99, 2012);
		CellPhone phone5 = new CellPhone(98463446, "Sony", 599.99, 2011);
		CellPhone phone6 = new CellPhone(45677467, "Brand X", 0.99, 1923);

		System.out.println("\nAdding the following objects to the top of the list.\n");
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(phone3);
		System.out.println(phone4);
		System.out.println();
		
		list2.addToStart(phone1);
		list2.addToStart(phone2);
		list2.addToStart(phone3);
		list2.addToStart(phone4);

		System.out.println("These are the contents of the list");
		list2.showContents();
		
		System.out.println("\nAdding a phone to position 2. These are now the contents of list2:\n");
		list2.insertAtIndex(phone5, 2);
		list2.showContents();

		System.out.println("\nDeleting the node at position 4. These are now the contents of list2:\n");
		list2.deleteFromIndex(4);
		list2.showContents();

		System.out.println("\nDeleting the first node. These are now the contents of list2:\n");
		list2.deleteFromStart();
		list2.showContents();

		System.out.println("\nReplacing the phone at position 1. These are now the contents of list2:\n");
		list2.replaceAtIndex(phone6, 1);
		list2.showContents();		

		System.out.println("\n---------------------------------------------------------------------------\n");

		System.out.println("Beginning clone method test. We're going to clone the previous list.\n");
		list3 = list2.clone();
		System.out.println("\nThese are the contents of the new list: \n");
		list3.showContents();
		
		System.out.println("\n---------------------------------------------------------------------------\n");

		System.out.println("Beginning the equals method test. We're going to test whether the previous two lists are equal.\n");
		System.out.println("The contents of list2 are the following: ");
		list2.showContents();
		System.out.println("\nThe contents of list3 are the following: ");
		list3.showContents();
		System.out.println();

		if (list2.equals(list3)){
			System.out.println("Barring the difference in serial numbers, the lists are the same.\n");
		}
		else System.out.println("The lists are not the same.");

		System.out.println("Finally, we're going to use an invalid index while calling the replace method.");
		list3.replaceAtIndex(phone1, -9);  //should end program due to incorrect index SPECIAL CASE
		
		
		keyboard.close();
	} 
}


