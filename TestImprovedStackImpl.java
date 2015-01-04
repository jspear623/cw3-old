public class TestImprovedStackImpl {
	ImprovedStack testStack;
	ReturnObject result;
	public TestImprovedStackImpl() {
		//Constructor
		this.testStack = new ImprovedStackImpl();
		this.result = new ReturnObjectImpl();
	}
	
	public static void main(String[] args) {
		TestImprovedStackImpl tester = new TestImprovedStackImpl();
		tester.launch();

	}
	public void launch() {
		System.out.println("I have created a new ImprovedStackImpl which is empty.\n");
		System.out.println("First I'm going to fill it up....");
		fillStack();
		System.out.println("Then empty it out....");		
		emptyStack(this.testStack);	
		System.out.println("Now I'm going to fill it up again and reverse it....");
		ImprovedStack reverseStack = this.testStack.reverse();	
		emptyStack(reverseStack);

		
		//	testItem("I am now going to return the head node using the head function. This should be John.",this.testList.head());	
	}
	
	private void fillStack() {
		this.testStack.push("Test complete");		
		this.testStack.push(36);		
		this.testStack.push(37);
		this.testStack.push("thirty eight");
		this.testStack.push(true);
		this.testStack.push(36);		
	
	}
	
	private void emptyStack(ImprovedStack stack) {
		for(int i = 0; i <= stack.size(); i++) {
			System.out.println("Popping the next item which is " + stack.pop().getReturnValue());
		}
	}

}