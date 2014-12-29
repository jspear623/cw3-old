public class ArrayList implements List {
	private Object[] objList;
	public ArrayList(int length) {
		this.objList = new Object[length];
	}
	
	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty(
		for(int i = 0; i < this.objList.length; i++) {
			if (this.objList != null) {
				return true;
			}
		}
		//if it get's this far then the list is empty
		return false;		
	);

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size(
		int itemCount = 0;
		for(int i = 0; i < this.objList.length; i++) {
			if (this.objList != null) {
				itemCount++;
			}
		}
		return itemCount;
	);
	/** 
	*	Checks whether an item is out of bounds of the array
	*	Saves us writing this out a few times
	*	@param index The position in the array that we are trying to access
	*  	@return a ReturnObject with or without errors	
	*/
	private ReturnObject errorCheck(int index) {
		ReturnObject result = new ReturnObjectImpl();
		if ((index > this.objList.length) || (index < 0)) {
			//It's out of bounds
			result.setError = true;
			result.setErrorDetails((ErrorMessage) INDEX_OUT_OF_BOUNDS);
		} else if (index = null) {
			//The argument is null - we need to stop that
			result.setError = true;
			result.setErrorDetails((ErrorMessage) INVALID_ARGUMENT);
		} else if (this.objList(index) == null) {
			//There is nothing there!
			result.setError = true;
			result.setErrorDetails((ErrorMessage) EMPTY_STRUCTURE);
		}
		return result;
	}
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
		ReturnObject result = errorCheck(index);
		if (result.hasError == false) {
			//Get the item from the array
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
		ReturnObject result = errorCheck(index);
		if (result.hasError == false) {
			result.setItem(objList[index]);
			objList[index] = null;
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
		ReturnObject result = errorCheck(index);
		if (this.objList[index] == null) {
			this.objList[index] = item;
		} else {
			reDimList(index, item);		
		}
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
		ReturnObject result = errorCheck(index);
		reDimList(this.objList.length, item);
		return result;	
	};
	/**
	* Sometimes we are going to need to redim an the list array if we are inserting more objects in it
	* @param item the value to insert into the list
	*/
	private void reDimList(int index, Object item) {
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
	//To remove an item
	private void reDimList(int index) {
		Object[] tmpList = new Object[this.objList.length - 1];
		for(int i = 0; i < tmpList.length; i++) {
			if (i < index) {
				tmpList[i] = this.objList[i];
			} else if (i > index) {
				tmpList[i-1] = this.objList[i];
			} 
		}
		this.objList = tmpList;
	}	
	

}