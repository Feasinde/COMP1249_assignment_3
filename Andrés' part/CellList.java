public class CellList{
	private CellNode head;
	private int size;
	
	}
	//default constructor of CellList
	public CellList(){
		head = null;
		size = 0;
	}

	//copy constructor of CellList. Unsure about where head is supposed to point.
	public CellList(CellList cellList){
		this.head = cellList.head;
		this.size = cellList.size;
	}

	public void addToStart(CellPhone cellPhone){
		CellNode newnode = new CellNode(cellPhone, node);
	}

	//begin inner class
	public class CellNode{
		private CellPhone phone;
		private CellNode link;

		//default constructor
		public CellNode(){
			this.phone = null;
			this.link = null;
		}

		//parametrised constructor
		public CellNode(CellPhone phone, CellNode linkValue){
			this.phone = phone.clone(phone.getSerial());
			this.link = linkValue;
		}

		//copy constructor
		public CellNode(CellNode othernode){
			this.phone = othernode.getPhone().clone(otherPhone.getPhone().getSerial());
			this.link = othernode.getLink(); 
		}

		//clone method
		public CellNode clone(){
			CellNode clonednode = new CellNode(this.getPhone(), this.getLink());
			return clonednode;
		}

		//accessors and mutators

		//getPhone returns the pointer of the phone object, not the object itself
		//we have to make sure this is appropriate	
		public CellPhone getPhone(){
			return this.phone;
		}

		public CellNode getLink(){
			return this.link;
		}

		//again should the parameter set the pointer or should it create
		//an entire, identical object?
		public void setPhone(CellPhone phone){
			this.phone = phone;
		}

		public void setLink(CellNode link){
			this.link = link;
		}	
}