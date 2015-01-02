public class FunctionalLinkedList extends LinkedList implements FunctionalList {
	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
    public ReturnObject head(){
		ReturnObjectImpl result = new ReturnObjectImpl();
		if (this.isEmpty()) {
			//You can't get anything. It's empty
			result.setError(true);
			result.setErrorDetails(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			System.out.println(this.size());
			result.setItem(this.headNode.getItem());
		}
		return result;
		
	};

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
    public FunctionalList rest(){
		FunctionalLinkedList noHead = new FunctionalLinkedList();
		//That's it. All we need to do is to set the head to the previous lists head node -> nextNode and the rest of the structure remains intact.
		//We need to set the length to be one less than the original list's length too
		noHead.headNode = this.headNode.getNextNode();
		noHead.length = this.length - 1;
		return noHead;
	};
}