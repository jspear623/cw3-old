public class TestLinkedList {
	LinkedList testList;
	ReturnObject result;
	public TestLinkedList() {
		//Constructor
		this.testList = new LinkedList();
		this.result = new ReturnObjectImpl();
	}
	
	public static void main(String[] args) {
		TestLinkedList tester = new TestLinkedList();
		tester.launch();

	}
	public void launch() {
		System.out.println("I have created a new LinkedList which is empty.\n");
		testItem("I have inserted one String - 'John' in the index 0. I am now going to print the result of this operation. It should be null.",this.testList.add(0,"John"));	
		testItem("Now getting the item in index 0. It should print John.",testList.get(0));	
		testItem("Adding the number 5 at place 0. It should return null. John should be moved to index 1.",testList.add(0,5));	
		testItem("Now getting item in 0. It should print 5.",testList.get(0));
		testItem("Now getting item in 1. It should print John.",testList.get(1));
		testItem("Now adding an item out of bounds. It should return an OOB failure.",testList.add(5,12));
		testItem("Now attemping to insert NULL. It should return an invalid argument failure.",testList.add(3,null));			
		

	}
	public void testItem(String outcome, ReturnObject result) {
		System.out.println(outcome);
 		System.out.println(result.getReturnValue());
		System.out.println(" ");
	}
}