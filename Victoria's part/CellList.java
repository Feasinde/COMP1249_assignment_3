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

public class CellList {

	private CellList head;
	private int size;

	// Default Constructor
	public CellList(){
		head = null;
		size=0;
	}

	// Parameterized Constructor
	public CellList(CellList head,int size){
		this.head = head;
		this.size = size;
	}

	// Copy Constructor
	public CellList(CellList copiedList){
		this.head = copiedList.head;
		this.size = copiedList.size;
	}



	public class CellNode {

		private CellPhone cell;
		private CellNode link;

		// Default Constructor
		public CellNode(){
			this.cell = null;
			this.link = null;
		}

		// Parameterized Constructor

		public CellNode(CellPhone cell, CellNode link){
			this.cell = cell.clone(cell.getSerialNum());
			this.link = link;

		}


		// Copy Constructor

		public CellNode(CellNode copy){
			this.cell = copy.getCell().clone(copy.getCell().getSerialNum());
			this.link = copy.getLink(); 

		}

		// Clone Method

		public CellNode clone(){
			CellNode clonedNode = new CellNode(this.cell,this.link);
			return clonedNode;
		}

		// Accessors

		public CellPhone getCell(){
			return this.cell;
		}

		public CellNode getLink(){
			return this.link;
		}

	}


}
