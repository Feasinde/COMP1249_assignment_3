public class CellList implements PubliclyCloneable{
	
	/////////////////////
	//BEGIN INNER CLASS//
	/////////////////////
	public class CellNode{
		private CellPhone phone;
		private CellNode link;

		public CellNode(){
			phone = null;
			link = null;
		}

		public CellNode(CellPhone phone, CellNode link){
			this.phone = phone;
			this.link = link;
		}

		//TO DO: copy constructor and clone methods
	}
	///////////////////
	//END INNER CLASS//
	///////////////////
	
	private CellNode head;
	private int size;

	//default constructor

	public CellList(){
		head = null;
	}

	//TO DO: copy constructor of CellList

	//addToStart() adds a CellPhone object at the beginning of the list
	public void addToStart(CellPhone cellPhone){	
		head = new CellNode(cellPhone, head);
	}

	//size() returns the number of nodes in the list
	public int size(){
		int count = 0;
		CellNode position = head;

		while (position != null){
			count++;
			position = position.link;
		}

		return count;
	}

	//deleteFromStart() deletes the head node and returns true if the list
	//contains at least one node. Returns false if the list is empty.
	public boolean deleteFromStart(){
		if (head != null){
			head = head.link;
			return true;
		}

		return false;
	}

	//find() takes a CellPhone serial number and returns the pointer
	//of the node that matches it. Returns null if the serial is not
	//found
	public CellNode find(long serial){
		CellNode position = head;
		long serialAtPostion;
		while (position != null){
			serialAtPostion = position.phone.getSerialNum();
			if (serialAtPostion == serial){
				return position;
			}
			position = position.link;
		}
		return null;
	}

	//contains() takes a CellPhone serial number and returns true
	//if the number matches a CellPhone object that belongs in a
	//CellNode
	public boolean contains(long serial){
		return find(serial) != null;
	}

	//showContents() outputs the contents of the list
	public void showContents(){
		CellNode position = head;
		while (position != null){
			System.out.print("["+position.phone+"] ---> ");
			position = position.link;
		}
	}

	//clone() method returns a deep copy of the linked list
	public CellList clone(){
		try{
			CellList copy = (CellList)super.clone();
			if (head == null){
				copy.head = null;
			}
			else{
				copy.head = copyOf(head);
			}
			return copy;
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}

	//shameless rip-off of the method described in the book.
	//Returns a deep copy of the node.
	public CellNode copyOf(CellNode otherHead){
		CellNode position = otherHead; 	//moves down other's list
		CellNode newHead;				//will point to the head of the copy list
		CellNode end = null;			//positioned at the end of the growing list

		//Create the first node
		newHead = new CellNode((position.phone).clone(), null);
		while (position != null){
			//copy the node at position to the end of the new list
			end.link = new CellNode((position.phone).clone(), null);
			end = end.link;
			position = position.link;
		}

		return newHead;
	}
}