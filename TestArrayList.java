public class TestArrayList {
	ArrayList testList;
	ReturnObject result;
	public TestArrayList() {
		//Constructor
		this.testList = new ArrayList(3);
		this.result = new ReturnObjectImpl();
	}
	
	public static void main(String[] args) {
		TestArrayList tester = new TestArrayList();
		tester.launch();

	}
	
	public void launch() {
		System.out.println("I have created a new arrayList with a maximum index of 3. It is currently empty.\n");
		this.runTests();

	}
	
	public void runTests(){
		testItem("I have inserted one String - 'John' in the index 0. I am now going to print the result of this operation. It should be null.",this.testList.add(0,"John"));	
		testItem("Now getting the item in index 0. It should print John.",testList.get(0));	
		testItem("Now getting the item in index 1. Nothing there but the space does exist. It should show null.",testList.get(1));	
		testItem("Adding the number 5 at place 0. It should return null. John should be moved to index 1.",testList.add(0,5));	
		testItem("Now getting item in 0. It should print 5.",testList.get(0));	
		testItem("Now getting item in 1. It should print John.",testList.get(1));
		testItem("Now adding an item out of bounds. It should return an OOB failure.",testList.add(5,12));
		testItem("Now attemping to insert NULL. It should return an invalid argument failure.",testList.add(3,null));
		testItem("Adding string 'Birkbeck' at index 2.",testList.add(2,"Birkbeck"));
		testItem("Adding boolean 'true' at index 3",testList.add(3,true));		
		testItem("Removing item at index 2. Should return the string Birkbeck and true should move to position 2 - with the array resizing to one smaller..",testList.remove(2));
		testItem("Removing item at index 2. Should return the boolean true and the array should resize to a maximum index of 1.",testList.remove(2));
		testItem("Best way to check that is to attempt to try to add something at index 2. Should get an OOB error.",testList.add(2,"Testing"));	
		testItem("Now I'm going to try adding an item on to the end using the add without index function. It should return null if there have been no errors.",testList.add("Testing"));
		testItem("Another item, a double 31.24. It should return null if there have been no errors.",testList.add(31.24));	
		testItem("Now going to print everything in the array one by one by removing them. It should show 5...",testList.remove(0));
		testItem("...then John...",testList.remove(0));			
		testItem("...then Testing...",testList.remove(0));
		testItem("...and 31.24...",testList.remove(0));
		testItem("...and finally an Empty Structure error.",testList.remove(0));	
	}
	
	public void testItem(String outcome, ReturnObject result) {
		System.out.println(outcome);
 		System.out.println(result.getReturnValue());
		System.out.println(" ");
	}
}