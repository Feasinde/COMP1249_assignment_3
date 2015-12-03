import java.io.*;
import java.util.Scanner;

public class CellHash {

	private CellList[] hashArr;
	private final int size = 12;
	//Default Constructor//

	public CellHash(){
		hashArr = new CellList[size];
	}
	
	public int computeHashValue(long serialNum){
		int index = (int)serialNum%12;
		return index;	
	}
	
	public void addToHashTable(String cellFile){
		try{
			Scanner inputStream = new Scanner(new FileReader(cellFile));
			while (inputStream.hasNextLong()){
				CellPhone phone = new CellPhone(inputStream.nextLong(),inputStream.next(), inputStream.nextDouble(),
								inputStream.nextInt());
				int location = computeHashValue(phone.getSerialNum());
				
				CellList list = new CellList();
				hashArr[location]= list;
				hashArr[location].addToStart(phone);
						
			}
			inputStream.close();
		}
		catch(IOException e){
			System.out.println("File not found!");
			System.exit(0);
		}
		
	}
	
	
}