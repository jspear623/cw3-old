public class ArrayList implements List {
	protected Object[] objList;
	public ArrayList(int length) {
		this.objList = new Object[length];
	}
	
	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		for(int i = 0; i < this.objList.length; i++) {
			if (this.objList != null) {
				return true;
			}
		}
		//if it gets this far then the list is empty
		return false;		
	};

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		int itemCount = 0;
		for(int i = 0; i < this.objList.length; i++) {
			if (this.objList != null) {
				itemCount++;
			}
		}
		return itemCount;
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
	 
	public ReturnObject get(int index) {
		//First check for any errors
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (this.objList.length == 0) {
			result.setError(true);
			result.setErrorDetails(ErrorMessage.EMPTY_STRUCTURE);			
		} else if ((index >= this.objList.length) || (index < 0)) {
			//It's out of bounds
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			// Get the item from the array. Even if it is null.
			result.setItem(objList[index]);
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
		if (this.objList.length == 0) {
			result.setError(true);
			result.setErrorDetails(ErrorMessage.EMPTY_STRUCTURE);			
		} else if ((index >= this.objList.length) || (index < 0)) {
			//It's out of bounds
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			result.setItem(objList[index]);
			reDimList(index);
		}
		//printArr();
		//System.out.println("Length:" + this.objList.length);
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
		//System.out.println("Length:" + this.objList.length);
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (item == null) {
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INVALID_ARGUMENT);
		} else if (((index != 0) && (index >= this.objList.length)) || (index < 0)) {
			//if it is out of bounds and isn't 0
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INDEX_OUT_OF_BOUNDS);						
		} else {
			//If the item is null then there is no need to change the list size. We can just replace the null.
			if (this.objList[index] == null) {
				this.objList[index] = item;
			} else {
				reDimList(index, item);		
			}		
		}
		//printArr();
		return result;
	};

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
			reDimList(this.objList.length, item);
		}
		return result;	
	};
	
	/**
	* Sometimes we are going to need to redim an the list array if we are inserting more objects in it
	* @param index the position in the array that we are insering the item
	* @param item the value to insert into the list
	*/
	protected void reDimList(int index, Object item) {
		Object[] tmpList = new Object[this.objList.length + 1];
		for(int i = 0; i < tmpList.length; i++) {
			if (i < index) {
				tmpList[i] = this.objList[i];
			} else if (i == index) {
				tmpList[i] = item;
			} else {
				tmpList[i] = this.objList[i-1];
			}
		}
		this.objList = tmpList;
	}
	
	/**
	* Sometimes we are going to need to redim an the list array if we are removing an object from it
	* @override
	* @param index the position in the array that we are removing
	*/
	protected void reDimList(int index) {
	
		Object[] tmpList = new Object[this.objList.length - 1];
		for(int i = 0; i < tmpList.length; i++) {
			if (i < index) {
				tmpList[i] = this.objList[i];
			} else if (i >= index) {

				tmpList[i] = this.objList[i+1];
			} 
		}
		this.objList = tmpList;
	}
	
	/**
	* This is just for testing to help visualise the array
	*/
	protected void printArr() {
		for(int i = 0; i < this.objList.length; i++) {
			System.out.println(i + " : " + this.objList[i]);
		}	
	}
	

}