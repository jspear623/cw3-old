public class SampleableListImpl extends LinkedList implements SampleableList {
	//using linked list rather than array list as the array list size issue causes confusion
	public SampleableList sample(){
		SampleableList sampledList = new SampleableListImpl();
		if(!(this.isEmpty())) {
			for(int i = 0; i < this.size(); i++) {
				if((i % 2) != 0) {
					sampledList.add(this.get(i));
				}
			}
		}
		return sampledList;
	};

}