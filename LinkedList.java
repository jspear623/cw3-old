public class LinkedList implements List {
	int length;
	ListNode headNode;
	public LinkedList() {
		this.length = 0;
		this.headNode = null;
	}
	private class ListNode {
		int index;
		Object item;
		ListNode nextNode;
		public ListNode(int index, Object item) {
			this.nextNode = null;
			this.item = item;
			this.index = index;
		}
		
		/**
			This sets the value of the next Node in the linked list
			@param node The listnode that we will point to
		*/
		public void setNextNode(ListNode node) {
			this.nextNode = node;
		}
		
		public ListNode getNextNode() {
			return this.nextNode;
		}
		
		public Object getItem() {
			return this.item;
		}
		
		public int getIndex() {
			return this.index;
		}
		
		public void setIndex(int index){
			this.index = index;
		}
		
	}
	
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	};

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		return this.length;
	};

	/**
	 * Returns the elements at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index){
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (this.isEmpty()) {
			//You can't get anything. It's empty8
			result.setError(true);
			result.setErrorDetails(ErrorMessage.EMPTY_STRUCTURE);				
		}else if ((this.length < index) || (index < 0)) {
			//It's out of bounds
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INDEX_OUT_OF_BOUNDS);		
		}else {
			ListNode tempNode = headNode;
			while (tempNode.getIndex() < index) {
				tempNode = tempNode.getNextNode();
			}
			result.setItem(tempNode.getItem());
		}	
		
		return result;		
	};

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (this.headNode == null) {
			//You can't remove anything. It's empty
			result.setError(true);
			result.setErrorDetails(ErrorMessage.EMPTY_STRUCTURE);				
		} else if ((this.length < index) || (index < 0)) {
			//It's out of bounds
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INDEX_OUT_OF_BOUNDS);		
		} else {
			if (index == 0) {
				//You are removing the headNode
				result.setItem(this.headNode.getItem());
				this.headNode = this.headNode.getNextNode();
			} else {
				ListNode tempNode = headNode;
				//Loop until you find the node before the position you want to remove
				while (tempNode.getIndex() < (index - 1)) {
					tempNode = tempNode.getNextNode();
				}
				result.setItem(tempNode.getNextNode().getItem());
				tempNode.setNextNode(tempNode.getNextNode().getNextNode());		
				
			}
			//remove last item
			this.length--;
			//Now adjust the indexes
			adjustIndexes(index);					
		}
		return result;
	};


	/**
	* Moves all the indexes of the nodes up or down 1 from the specified index point
	* @param index The index point which we are adjusting from
	* @param up Whether you are moving them up or down
	*/
	private void adjustIndexes(int index) {
		ListNode tempNode = headNode;
		//Loop until you find the node before the position you want to insert it
		int i = 0;
		while (tempNode != null) {
			if (i >= index) {
				tempNode.setIndex(i);
			}
			tempNode = tempNode.getNextNode();
			i++;
		}
	}
	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(Object item) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (item == null) {
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INVALID_ARGUMENT);
		} else {
			int index = 0;
			if (this.headNode == null) {
				this.headNode = new ListNode(index, item);
			} else {
				ListNode tempNode = headNode;
				do {
					tempNode = tempNode.getNextNode();
					index++;
				} while (tempNode.getNextNode() != null);
				ListNode newNode = new ListNode(index, item);
				tempNode.setNextNode(newNode);
				
			}
			//Add 1 to the length field					
			this.length++;
		}
		return result;
	};

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(int index, Object item) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (item == null) {
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INVALID_ARGUMENT);
		} else if ((index > this.length) || (index < 0)) {
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INDEX_OUT_OF_BOUNDS);			
		} else {
			if (this.headNode == null) {
				this.headNode = new ListNode(index, item);
			} else {
				ListNode tempNode = headNode;
				//Loop until you find the node before the position you want to insert it
				while (tempNode.getIndex() < (index - 1)) {
					tempNode = tempNode.getNextNode();
				}
				//tempNode is node before the position you want to insert
				ListNode newNode = new ListNode(index, item);
				if (index > 0 ) {
					//Now set the New Node (the one being inserted) next node to the tempNode's next node
					newNode.setNextNode(tempNode.getNextNode());
					//And set the tempNodes position to
					tempNode.setNextNode(newNode);
				} else {
					newNode.setNextNode(tempNode);
					headNode = newNode;
				}
				//Now adjust the indexes
				adjustIndexes(index);

				
			}
			//Add 1 to the length field			
			this.length++;
		}
		//printList();		
		return result;
	};	
	
    public void printList() {
		//For testing purposes only
        ListNode current = this.headNode;
        while (current != null) {
            System.out.println("Index: " + current.getIndex() + " :  "+current.getItem());
            current = current.getNextNode();
        }
    }	
}