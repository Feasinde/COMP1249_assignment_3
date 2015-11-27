public class CellPhone{
	private long serialNum;
	private String brand;
	private int year;
	private double price;

	//default constructor
	public CellPhone(){
		this.serialNum = 0;
		this.brand = null;
		this.year = 0;
		this.price = 0.0;
	}

	//parametrised constructor
	public CellPhone(long serialNum, String brand, int year, double price){
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;	
	}

	//copy constructor
	public CellPhone(CellPhone phone, long serialNum){
		this.serialNum = serialNum;
		this.brand = phone.brand;
		this.year = phone.year;
		this.price = phone.price;		
	}

	//clone method
	public CellPhone clone(long serialNum){
		CellPhone clonedPhone = new CellPhone(serialNum, this.brand, this.year, this.price);
		return clonedPhone;
	}

	//toString method
	public String toString(){
		return "Serial number: "+this.serialNum+", Brand: "+this.brand+", Year: "+this.year+", Price: $"+this.price;
	}

	//equals method
	public boolean equals(CellPhone phone){
		if (this.brand == phone.brand &&
			this.year == phone.year &&
			this.price == phone.price){
			return true;
		}
		return false;
	}

	//accessors and mutators
	public long getSerialNum(){
		return this.serialNum;
	}

	public void setSerialNum(long serialNum){
		this.serialNum = serialNum;
	}

	public String getBrand(){
		return this.brand;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public int getYear(){
		return this.year;
	}

	public void setYear(int year){
		this.year = year;
	}

	public double getPrice(){
		return this.price;
	}

	public void setPrice(double price){
		this.price = price;
	}
}