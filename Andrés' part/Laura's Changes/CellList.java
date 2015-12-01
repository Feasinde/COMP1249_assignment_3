import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.LinkedList;

public class CellList{
	
	//////////////////////////
	//BEGIN INNER NODE CLASS//
	//////////////////////////
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

		//Assignment requires the following two methods. Not really sure what's the point.
		public CellNode(CellNode cellNode){
			phone = cellNode.phone.clone(cellNode.phone.getSerialNum());
			link = cellNode.link;
		}

		public CellNode clone(){
			return new CellNode(this.phone.clone(this.phone.getSerialNum()), this.link);
		}
		
		//ADDED ACCESSORS AND MUTATORS - LG //
		
		public void setPhone(CellPhone newPhone){
			this.phone = newPhone;
		}
		public void setLink(CellNode newLink){
			this.link = newLink;
		}
		public CellPhone getPhone(){
			return phone;
		}
		public CellNode getLink(){
			return link;
		}

	}
	////////////////////////
	//END INNER NODE CLASS//
	////////////////////////

	////////////////////////
	//BEGIN ITERATOR CLASS//
	////////////////////////
	public class CellListIterator{
		private CellNode position;
		private CellNode previous;

		public CellListIterator(){
			position = head;
			previous = null;
		}

		public void restart(){
			position = head;
			previous = null;
		}

		public CellPhone next(){
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			CellPhone toReturn = position.phone;
			previous = position;
			position = position.link;
			return toReturn;
		}

		public boolean hasNext(){
			return (position != null);
		}

		public CellPhone peek(){
			if (!hasNext()){
				throw new IllegalStateException();
			}
			return position.phone;
		}
	}
	//////////////////////
	//END ITERATOR CLASS//
	//////////////////////

	private CellNode head;
	private int size;

	//default constructor

	public CellList(){
		head = null;
		size = 0;   //set size to 0 - LG//
	}

	//TO DO: copy constructor of CellList

	//addToStart() adds a CellPhone object at the beginning of the list
	public void addToStart(CellPhone cellPhone){	
		head = new CellNode(cellPhone, head);
		size++;
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
	
	//InsertAtIndex method: takes a given position and adds an object at that point using iterators//
	public void insertAtIndex(CellPhone cellPhone, int index){
		try{
			if (index < 0 || index > (this.size()-1)){
				throw new NullPointerException();
			}
			else if (index == 0)
				this.addToStart(cellPhone);
			else{
				CellListIterator iterator = new CellListIterator();
				int count = 0;
				while(count < index){
					iterator.next();
					count++;
				}
				CellNode temp = new CellNode(cellPhone, iterator.position);
				iterator.previous.link = temp;			
			}
			size++;
		}
		catch (Exception e){
			System.out.println("Invalid Index! Terminating Program.");
			System.exit(0);	
		}
	}
	public void deleteFromIndex(int index){
		try{	
			if (index < 0 || index > (this.size()-1)){
				throw new NullPointerException();
			}
			else if(index == 0)
				this.deleteFromStart();
			else{
				CellListIterator iterator = new CellListIterator();
				int count = 0;
				while(count < index){
					iterator.next();
					count++;
				}
				iterator.previous.link = iterator.position.link;
				iterator.position = iterator.position.link;
			}	
			size--;	
		}
		catch (Exception e){
			System.out.println("Invalid Index! Terminating Program.");
			System.exit(0);	
		}
		
	}
								
	//deleteFromStart() deletes the head node and returns true if the list
	//contains at least one node. Returns false if the list is empty.   
	public void deleteFromStart(){
		if (head != null)
			head = head.link;			//Assignment doesn't require us to state if true or not just wants us to remove it - LG//
		else
			throw new NullPointerException("List is empty");


	}

	public void ReplaceAtIndex(CellPhone cellPhone, int index){
		try{
			if (index < 0 || index > (this.size()-1))
				throw new NullPointerException();
							
			else if (index == 0)			
				head =  new CellNode(cellPhone, head);
			else{
				CellListIterator iterator = new CellListIterator();
				int count = 0;
				while(count < index){
					iterator.next();
					count++;
				}
				iterator.position.phone = cellPhone;
				iterator.previous.link = iterator.position;
			}
		}
		catch (Exception e){
			System.out.println("Invalid Index! Terminating Program.");
			System.exit(0);	
		}		
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

	//TO DO: clone() method
}