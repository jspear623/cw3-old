public class TestStackImpl{
	ReturnObject result;
	public TestStackImpl() {
		//Constructor
		this.result = new ReturnObjectImpl();
	}
	
	public static void main(String[] args) {
		TestStackImpl tester = new TestStackImpl();
		tester.launch();

	}
	
	public void launch() {
		System.out.println("I have created a TestStackImpl. Going to run a series of tests with different types of lists as the structure.\n");
		this.runTests();

	}
	
	public void runTests(){
		ArrayList testListArray = new ArrayList(0);
		StackImpl stackArray = new StackImpl(testListArray);
		System.out.println("*************\nThe first StackImpl is using an ArrayList as a data structure.\n**************"); 
		testStack(stackArray);
		System.out.println("*************\nThe second StackImpl is using an LinkedList as a data structure.\n**************"); 		
		LinkedList testListLinked = new LinkedList();
		StackImpl stackList = new StackImpl(testListLinked);
		testStack(stackList);
	}

	public void testStack(StackImpl testStack) {
		System.out.println("I'm adding the string John. There is no result of the operation. It's void.\n");
		testStack.push("John");
		testItem("We can see if it is there though. Let's get the item from the top of the stack. Should be John.",testStack.top());
		System.out.println("Now adding a few more items. 31, true, 'testing'.\n");
		testStack.push(31);
		testStack.push(true);
		testStack.push("testing");
		testItem("Let's get the top item on the stack without removing it. Should be testing.",testStack.top());
		testItem("Now let's pop that item. Should be testing again.",testStack.pop());
		testItem("Let's pop the next item. Should be boolean true.",testStack.pop());
		testItem("Let's get the next item with top function. Should be int 31.",testStack.top());
		testItem("Let's pop it. Should be int 31.",testStack.pop());		
		testItem("Let's pop the final item. Should be 'John'.",testStack.pop());				
		testItem("It's now empty. A pop should return an error.",testStack.pop());				
		testItem("So should a top.",testStack.top());				
		testStack.push("Test complete");			
		testItem("Just added a final string to the empty stack and am now trying to pop it.",testStack.pop());					
		
	
	}	
	public void testItem(String outcome, ReturnObject result) {
		System.out.println(outcome);
 		System.out.println(result.getReturnValue());
		System.out.println(" ");
	}
}