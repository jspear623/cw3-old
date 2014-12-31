public class FunctionalArrayList extends ArrayList implements FunctionalList {

	public FunctionalArrayList(int length) {
		super(length);
	}
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
		if (this.objList.length == 0) {
			//You can't get the head. It's empty
			result.setError(true);
			result.setErrorDetails(ErrorMessage.EMPTY_STRUCTURE);	
		} else {
			result.setItem(objList[0]);
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
		FunctionalArrayList noHead = new FunctionalArrayList(this.objList.length -1);
		for (int i = 1; i < this.objList.length; i++) {
			noHead.objList[i-1] = this.objList[i];
		}
		return noHead;
	};
}