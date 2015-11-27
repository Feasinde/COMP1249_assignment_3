public class CellList{
	
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

	//find takes a CellPhone serial number and returns the pointer
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


}