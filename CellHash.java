import java.io.*;
import java.util.Scanner;

public class CellHash {

	private CellList[] hashArr;
	private final int size = 12;
	//Default Constructor//

	public CellHash(){
		hashArr = new CellList[size];
	}
	//Takes serial number from an object and calculates where it will be placed in out hashArray//
	public int computeHashValue(long serialNum){
		int index = (int)serialNum%12;
		return index;	
	}
	
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
				if(!(hashArr[location].contains(serialNum))) 
					hashArr[location].addToStart(phone);						
			}
			
			inputStream.close();
		}
		catch(IOException e){
			System.out.println("File not found!");
			System.exit(0);
		}		
	}
	
	public void displayHashContents(){
		int i =0;
		
		System.out.println("Here are some contents of the Hash Table: ");
		System.out.println("========================================== \n");
		
		for(i=0; i<size; i++){
			System.out.println("List at index "+i+" has the following information: ");
			if(!(hashArr[i]==null))
				hashArr[i].showContents();
			else 
				System.out.println("List is empty: Nothing to display.");
			System.out.println("\n");
		}
		System.out.println();
	}
	
	//DIDNT INCL. BIGO() YET, don't want it to go through all array indices since with the (serialNum mod 12) calculation
	//it would only be in one array index. I dont get why it's not giving me an aswer.......
	public boolean findCell(long serialNum){			
		int location = computeHashValue(serialNum); 
			if (hashArr[location].contains(serialNum))
				return true;
			else
				return false;
			}
	
}