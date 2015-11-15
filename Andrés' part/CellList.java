public class CellList{
	
	//begin inner class
	public class CellNode{
		private CellPhone phone;
		private CellNode node;

		//default constructor
		public CellNode(){
			this.phone = null;
			this.node = null;
		}

		//parametrised constructor
		public CellNode(CellPhone phone, CellNode node){
			this.phone = phone.clone(phone.getSerial());
			this.phone = node;
		}

		//copy constructor
		public CellNode(CellNode otherNode){
			this.phone = otherNode.getPhone().clone(otherPhone.getPhone().getSerial());
			this.node = otherNode.getNode(); 
		}

		//clone method
		public CellNode clone(){
			CellNode clonedNode = new CellNode(this.getPhone(), this.getNode());
			return clonedNode;
		}

		//accessors and mutators

		//getPhone returns the pointer of the phone object, not the object itself
		//we have to make sure this is appropriate	
		public CellPhone getPhone(){
			return this.phone;
		}

		public CellNode getNode(){
			return this.node;
		}

		//again should the parameter set the pointer or should it create
		//an entire, identical object?
		public void setPhone(CellPhone phone){
			this.phone = phone;
		}

		public void setNode(CellNode node){
			this.node = node;
		}
	}
}