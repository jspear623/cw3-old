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
		System.out.println("The first StackImpl is using an ArrayList as a data structure. I'm adding the string John. There is no result of the operation. It's void.");
		stackArray.push("John");
		testItem("We can see if it is there though. Let's get the item from the top of the stack. Should be John.",stackArray.top());		
	}
	
	public void testItem(String outcome, ReturnObject result) {
		System.out.println(outcome);
 		System.out.println(result.getReturnValue());
		System.out.println(" ");
	}
}