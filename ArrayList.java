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
	 * Does the error checking on the index. Checks whether it is in the range and whether the item in the place is null (if the request is a get)
	 * @param index The position in the array that we are trying to access
	 * @param result A returnObject that is passed in to the method so we can use the same returnObject when passing through serveral checks
	 * @param get A boolean that defines whether this is request to get an item from the array or set it. If get = true then we are interested if that item is empty.
	 * @return a returnObject that will contain any errors that occur because of the index
	 */
	private ReturnObjectImpl indexCheck(int index, ReturnObjectImpl result, boolean get) {
		if ((index >= this.objList.length) || (index < 0)) {
			//It's out of bounds
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.objList[index] == null) {
			if (get == true) {
				//There is nothing there! Only useful if this is a get rather than a set
				result.setError(true);
				result.setErrorDetails(ErrorMessage.EMPTY_STRUCTURE);
			}
		}
		return result;
	}
	/**
	 * Does the error checking on the input item. Checks whether it is null
	 * @param item The item that is about to be put in the array
	 * @param result A returnObject that is passed in to the method so we can use the same returnObject when passing through serveral checks
	 * @return a returnObject that will contain any errors that occur because of the item
	 */	
	private ReturnObjectImpl objectCheck(Object item, ReturnObjectImpl result) {
		if (item == null) {
			result.setError(true);
			result.setErrorDetails(ErrorMessage.INVALID_ARGUMENT);
		}
		return result;
	}
	
	/** 
	*	Checks whether an item is out of bounds of the array
	*	Saves us writing this out a few times
	*	Used for gets of data
	*	@param index The position in the array that we are trying to access
	*  	@return a ReturnObject with or without errors	
	*/	
	
	private ReturnObjectImpl errorCheck(int index, boolean get) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		result = indexCheck(index,result,get);
		return result;
	}

	private ReturnObjectImpl errorCheck(int index, Object item, boolean get) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		result = indexCheck(index,result,get);
		result = objectCheck(item,result);
		return result;
	}	
	
	private ReturnObjectImpl errorCheck(Object item) {
		ReturnObjectImpl result = new ReturnObjectImpl();
		result = objectCheck(item,result);
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
		ReturnObjectImpl result = errorCheck(index,true);
		if (result.hasError() == false) {
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
		//this.printArr();
		ReturnObjectImpl result = errorCheck(index, true);
		if (result.hasError() == false) {
			result.setItem(objList[index]);
			reDimList(index);
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
		ReturnObjectImpl result = errorCheck(index,item, false);
		if (result.hasError() == false) {
			if (this.objList[index] == null) {
				this.objList[index] = item;
			} else {
				reDimList(index, item);		
			}
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
		ReturnObjectImpl result = errorCheck(item);
		reDimList(this.objList.length, item);
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