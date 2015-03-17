package et.thread;

public class GenericsTest<A extends MyService> {

	private A testItem;
	
	public void setTestItem(A testItem) {
		this.testItem = testItem;
	}
	
	public A getTestItem() {
		return testItem;
	}
}
