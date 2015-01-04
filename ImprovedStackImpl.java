public class ImprovedStackImpl implements ImprovedStack{
	LinkedList objList;
	public ImprovedStackImpl() {
		this.objList = new LinkedList();
	}
	
	public boolean isEmpty() {
		return this.objList.isEmpty();
	}
	
	public int size() {
		return this.objList.size();
	}
	
	public void push(Object item) {
		this.objList.add(0,item);
	}
	
	public ReturnObject pop() {
		return this.objList.remove(0);
	}
	
	public ReturnObject top() {
		return this.objList.get(0);
	}
	
	public ImprovedStack reverse() {
		ImprovedStackImpl reverseStack = new ImprovedStackImpl();
		for (int i = 0; i < this.size(); i++) {
			reverseStack.push(this.objList.get(i).getReturnValue());
		}
		return reverseStack;
	}
	
	public void remove(Object item) {
		for (int i = 0; i < this.size(); i++) {
			if (this.objList.get(i).getReturnValue().equals(item)) {
				this.objList.remove(i);
			}
		}
	}	
}