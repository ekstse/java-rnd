package et.thread;

import java.util.ArrayList;
import java.util.List;

public class MyExecutor {

	public void test1() {
		for (int i=0; i < 10; i++) {
			new MyThread(i+"").start();
		}
	}
	
	public void test2() {
		List<Thread> tlist = new ArrayList<Thread>();
		
		try {
			for (int i=0; i < 10; i++) {
				Thread t = new MyThread(i+"");
				tlist.add(t);
				t.start();
//				t.join();
			}
			
//			for (int i=0; i < 10; i++) {
//				tlist.get(i).join();
//			}

			System.out.println("completed");
			
//		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} finally {

		}
	}
	
	public static void main(String args[]) {
		MyExecutor e = new MyExecutor();
		e.test2();
		
		GenericsTest<MyService> a = new GenericsTest<MyService>();
		a.setTestItem(new MyService());
		System.out.println(a.getTestItem().get());
	}
	
}
