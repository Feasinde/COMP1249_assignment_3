public class CellListUtilisation{
	public static void main(String[] args){
		///////////////////////////////////////////////////////////////
		//This is a temporal version of the driver programe wherein I//
		//test the CellList class									 //
		///////////////////////////////////////////////////////////////

		CellPhone phone1 = new CellPhone(12345678, "Samsung", 2015, 399.99);
		CellPhone phone2 = new CellPhone(23456789, "Sony", 2014, 299.99);
		CellPhone phone3 = new CellPhone(34567890, "LG", 2013, 599.99);
		CellPhone phone4 = new CellPhone(45678901, "Apple", 2012, 799.99);

		CellList list1 = new CellList();
		CellList list2 = null;

		System.out.println(list1);

		list1.addToStart(phone1);
		list1.addToStart(phone2);
		list1.addToStart(phone3);
		list1.addToStart(phone4);
		list1.showContents();
		System.out.println("Is the serial number 12342678 in the list? " + list1.contains(12342678));
		System.out.println("The phone with the serial 23456789 is here: "+ list1.find(23456789));
		list2 = new CellList(list1);
		System.out.println();
		list2.showContents();
	} 
}