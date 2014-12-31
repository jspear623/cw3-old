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
		testItem("I have inserted one String - 'John' using the normal add (no index). I am now going to print the result of this operation. It should be null.",this.testList.add("John"));	
		testItem("Now getting the item in index 0. It should print John.",testList.get(0));	
		testItem("Adding the number 5 at place 0. It should return null. John should be moved to index 1.",testList.add(0,5));	
		testItem("Now getting item in 0. It should print 5.",testList.get(0));
		testItem("Now getting item in 1. It should print John.",testList.get(1));
		testItem("Now adding an item at index 5 (out of bounds). It should return an OOB failure.",testList.add(5,12));
		testItem("Now attemping to insert NULL. It should return an invalid argument failure.",testList.add(3,null));
		testItem("Adding string 'Birkbeck' at index 1. Should return null.",testList.add(1,"Birkbeck"));
		testItem("Adding boolean 'true' at index 2. Should return null.",testList.add(2,true));
		testItem("Removing head node. Should return 5. Head node should now be Birkbeck.",testList.remove(0));
		testItem("Best way to do that is a get on index 0. It should be Birkbeck.",testList.get(0));
		testItem("Now adding 31.54 at index 2. Should return null.",testList.add(2,31.54));
		testItem("Now attempting to add an item as position -1. It should give an OOB error.",testList.add(-1,"testing"));
		testItem("Now going to print everything in the Linked list one by one by removing them. It should show Birkbeck...",testList.remove(0));
		testItem("...then true...",testList.remove(0));			
		testItem("...and 31.54...",testList.remove(0));
		testItem("...and John...",testList.remove(0));		
		testItem("...and finally an Empty Structure error.",testList.remove(0));
		testItem("Adding string 'Test complete' at index 0. Should return null.",testList.add(0,"Test complete!"));		
		testItem("Getting this string back. Should be 'Test complete!'.",testList.get(0));		
		
		
		

	}
	public void testItem(String outcome, ReturnObject result) {
		System.out.println(outcome);
 		System.out.println(result.getReturnValue());
		System.out.println(" ");
	}
}