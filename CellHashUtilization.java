import java.util.Scanner;

public class CellHashUtilization {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of the cellphone file: ");		
		String fileName = keyboard.next();
		
		CellHash hashArr = new CellHash();
		hashArr.addToHashTable(fileName);
		
		hashArr.displayHashContents();
		//computeHashValue(phone1.getSerialNum());

		System.out.println("Please enter a serial you wish to search: ");
		long newSerial = keyboard.nextLong();
		
		hashArr.findCell(newSerial);
		keyboard.close();
	}

}
