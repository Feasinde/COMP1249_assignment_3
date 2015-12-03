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
		
		try{												
			 inputStream = new Scanner(new FileReader(fileName));
					inputStream.useLocale(Locale.US);	
					while(inputStream.hasNextLong()){
						CellPhone phone = new CellPhone (inputStream.nextLong(), inputStream.next(), inputStream.nextDouble(),
								inputStream.nextInt());
						list1.addToStart(phone);					
					}
			}		
		catch(IOException e){
				System.out.println("File not found!");
				System.exit(0);
			}
		
		list1.showContents();
		System.out.println();
		
		
		
		System.out.println();
		System.out.println("Is the serial number 3890909 in the list? " + list1.contains(3890909));
		System.out.println("The phone with the serial 3890909 is here: "+ list1.find(3890909));
		System.out.println();
		
		keyboard.close();
	} 
}





