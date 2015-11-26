// ---------------------------------------------------------------
// Assignment 3
// Part 1
// Written by: Andrés Lou, Laura Elena Gonzalez, Stevie Gabbay, and Victoria Avgoustis
// For COMP249 Section: D
// ---------------------------------------------------------------

/* 
 * Purpose of this program: 
 * Overall:
 * CellPhone class: Allows for cellphone objects to be created or copied. Methods are created to access or change Cellphone attributes. Phones can be compared through an 'equals' method and the attributes can be viewed in a 'toString' method.
 * CellList class:
 * CellNode class:
 * CellListUtilization class:
 */

package myversion;
public class CellPhone {

	// Variables of the CellPhone class

	long serialNum;
	String brand;
	int year;
	double price;


	// Variable Mutators

	public void setSerialNum(long serialNum){
		serialNum = this.serialNum;
	}

	public void setBrand(String brand){
		brand = this.brand;
	}

	public void setYear(int year){
		year = this.year;
	}

	public void setPrice(double price){
		price = this.price;
	}

	// Variable Accessors

	public long getSerialNum(){
		return this.serialNum;
	}

	public String getBrand(){
		return this.brand;
	}

	public int getYear(){
		return this.year;
	}

	public double getPrice(){
		return this.price;
	}

	// Default Constructor

	public CellPhone(){
		this.serialNum = 0;
		this.brand = null;
		this.year = 0;
		this.price = 0.0;		
	}

	// Parameterized Constructor

	public CellPhone(long serialNum,String brand,int year,double price){
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;			
	}

	// Copy Constructor

	public CellPhone(CellPhone cell, long serialNum){
		this.serialNum = serialNum;
		cell.brand = brand;
		cell.year = year;
		cell.price = price;
	}


	// Clone Method

	public CellPhone clone(long serialNum){
		CellPhone clonedPhone = new CellPhone(serialNum,this.brand,this.year,this.price);
		return clonedPhone;
	}

	// toString Method 

	public String toString(){
		return "\nSerial Number: " + this.serialNum + "\nBrand: " + this.brand + "\nYear: " + this.year + "\nPrice: " + this.price;
	}

	// equals Method

	public boolean equals(CellPhone cell){
		if(this.brand == cell.brand && this.year == cell.year && this.price == cell.price)
			return true;
		else
			return false;
	}
}
