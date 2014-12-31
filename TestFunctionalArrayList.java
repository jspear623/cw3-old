public class TestFunctionalArrayList extends TestArrayList {
	FunctionalArrayList testList;
	ReturnObject result;
	public TestFunctionalArrayList() {
		//Constructor
		this.testList = new FunctionalArrayList(0);
		this.result = new ReturnObjectImpl();
	}
	
	public static void main(String[] args) {
		TestFunctionalArrayList tester = new TestFunctionalArrayList();
		tester.launch();

	}
	public void launch() {
		System.out.println("I have created a new FunctionalArrayList which is empty.\n");
		
		super.runTests();
		//All standard functionality checked. Now test extended functionality
		System.out.print("**************************\n STANDARD TESTING COMPLETE. EXTENDED TESTING STARTING \n**************************\n");
		testItem("Adding the number 36.",this.testList.add(36));	
		testItem("Adding the number 37.",this.testList.add(37));
		testItem("Adding the string 'thirty eight'.",this.testList.add("thirty eight"));	
		testItem("Adding at index 1 the double 36.34.",this.testList.add(1,(double) 36.34));	
		testItem("Adding at index 0 the number 35.",this.testList.add(0,35));
		testItem("The head should currently be 35. Let's test that by getting the head.",this.testList.head());
		//Now creating a new FunctionalArrayList using the rest function to get all items except for the head.
		FunctionalList restList = this.testList.rest();
		testItem("The head for the list without the old head should be 36. Let's test that by getting the head.",restList.head());
		testItem("And check that hasn't affected the original list. Should be 35.",this.testList.head());
		testItem("Now emptying out the rest list 1 by 1. First item should be 36.",restList.remove(0));
		testItem("....Then 36.34",restList.remove(0));
		testItem("....Then 37",restList.remove(0));
		testItem("....Then 'thirty eight'",restList.remove(0));
		testItem("It should now be empty.",restList.remove(0));
		testItem("Let's try to get the head. Should return an empty error.",restList.head());
		
		
		
			
		
	//	testItem("I am now going to return the head node using the head function. This should be John.",this.testList.head());	

	}

}