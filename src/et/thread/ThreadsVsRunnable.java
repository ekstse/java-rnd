package et.thread;

//Use above classes here in main to understand the differences more clearly...
public class ThreadsVsRunnable {

	public static void main(String args[]) throws Exception {

//		for (int i = 0; i < 10; i++) {
//			new Thread(new ImplementsRunnable(), i+"").start();
//		}

		for (int i = 0; i < 100; i++) {
			new ExtendsThread().start();
		}
	}
	
//	public class ImplementsRunnable2 implements Runnable {
//
//		private int counter = 0;
//
//		public void run() {
//			counter++;
//			System.out.println("ImplementsRunnable : Counter : " + counter);
//		}
//	}
	
}