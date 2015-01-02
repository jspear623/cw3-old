public class StackImpl extends AbstractStack {

	public StackImpl(List internalList) {
		//Want to pass through the list. Could be either type. Both should work.
		super(internalList);
	}
	/**
	 * Returns true if the stack is empty, false otherwise. 
	 * 
	 * @return true if the stack is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		if (this.internalList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	};

	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return the number of items currently in the stack
	 */
	public int size() {
		return this.internalList.size();
	};

	/**
	 * Adds an element at the top of the stack. 
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		//Always add the item. Either as the head or the first item in the array.
		this.internalList.add(0,item);
	};

	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top() {
		//Should already be a return object impl. Errors will be checked within there.
		return this.internalList.get(0);
	};

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed frmo the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		return this.internalList.remove(0);
	};

}