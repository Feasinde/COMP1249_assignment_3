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
// This class contains a couple of methods and a constructor that will allow 
// us to create a Hash table/Array of linked list. We realize here that by creating 
// an array of linked list, it is a more efficient was of searching through
// these linked list by classifying them by their serial numbers with the MOD 
// calculation. Above each method the will be a brief description on what the method 
// does and how.
//---------------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class CellHash {

	private CellList[] hashArr;
	private final int size = 12;
	//Default Constructor//

	public CellHash(){
		hashArr = new CellList[size];
	}
	// Takes serial number from an object and calculates where it will be placed in out hashArray
	// by calculating the MOD 12 of the serial number so that we get a index from 0-11
	
	public int computeHashValue(long serialNum){
		int index = (int)serialNum%12;
		return index;	
	}
	// The addToHashTable method, takes a text file, reads it and initializes cellPhone objects 
	// that will then be placed in a linked list (provided it isn't a duplicated serial number)
	// and is then placed in an index of the array. The index location is provided by the 
	// computeHashValue method above.
	
	public void addToHashTable(String cellFile){
		try{
		//Goes through Cell_Info.txt file and initializes a cellPhone object to be placed in a list//	
			Scanner inputStream = new Scanner(new FileReader(cellFile));
			while (inputStream.hasNextLong()){
				long serialNum = inputStream.nextLong();
				CellPhone phone = new CellPhone(serialNum,inputStream.next(), inputStream.nextDouble(),
								inputStream.nextInt());
		//Takes the object's serial number and with the computeHashValue method, determines where in the array it will be placed//	
				int location = computeHashValue(phone.getSerialNum());				
		
		//Ensures if at location there isn't already a list, if there isn't, will create one//		
				if(hashArr[location]==null){
					CellList list = new CellList();
					hashArr[location]= list;
				}
		//Ensures the serial number isn't a duplicate within the array's location, if it isn't will then place at 1st Node//		
				if (!(hashArr[location].contains(serialNum)))
					hashArr[location].addToStart(phone);						
			}
			
			inputStream.close();
		}
		// If the file read isn't found will terminate program
		catch(IOException e){
			System.out.println("File not found!");
			System.exit(0);
		}		
	}
	// DisplayHashContents() method goes throught the newly created array of linked list
	// and with the help of the showContents method, prints out each cellList found in each
	// array index (if any).
	
	public void displayHashContents(){
		int i =0;
		
		System.out.println("Here are some contents of the Hash Table: ");
		System.out.println("========================================== \n");
		
		for (i=0; i<size; i++){
			System.out.println("List at index "+i+" has the following information: ");
			if (!(hashArr[i]==null))
				hashArr[i].showContents();
			else 
				System.out.println("List is empty: Nothing to display.");
		
			System.out.println("\n");
		}
		System.out.println();
	}
	// findCell() method takes in a serial number and verifies whether it is found in a linked list
	// found in the HashArray. As opposed to going through every single array index, it will only
	// go through the index provided by the computeHashValue() method for a quicker and more effiecient
	// search as shown via the counter. 
	
	public void  findCell(long serialNum){			
		int location = computeHashValue(serialNum); 		
		System.out.println(hashArr[location].contains(serialNum));
	}
	
}