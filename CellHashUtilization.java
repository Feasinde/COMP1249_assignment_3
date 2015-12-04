//--------------------------------------------------------------------------------
//Assignment 3
//Part 2
//Written by: 
//Sviki Gabbay - 27490968
//Andrés Lou 24712374
//Victoria Avgoustis 27529198
//Laura Elena González 27217323	
//
//COMP 249 - Section D
// This is our driver class for our CellHash class. Here we read a file and  
// initialize cellPhone objects to be placed in a linked list that are then placed 
// in a HashArray. 
//---------------------------------------------------------------------------------

import java.util.Scanner;

public class CellHashUtilization {

	public static void main(String[] args) {
		
	// Prompt user for the file they wish to be used//
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of the cellphone file: ");		
		String fileName = keyboard.next();
		
	// Create our HashArray of linked list followed by initializing it.
		CellHash hashArr = new CellHash();
		hashArr.addToHashTable(fileName);
		
	// Display the HAshArray	
		hashArr.displayHashContents();
		
	// Prompt User for a serial number that will be used to see if it
	// exists in the linked list.	
		System.out.println("Please enter a serial you wish to search: ");
		long newSerial = keyboard.nextLong();
	
	// We search through the linked list for the serial number.	
	// We also display how many searches it took and when compared to the other find method,
	// it's clear to see this approach is faster and more efficient.
		hashArr.findCell(newSerial);
		
		keyboard.close();
	}

}
