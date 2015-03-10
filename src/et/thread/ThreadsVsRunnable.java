package et.thread;

//Use above classes here in main to understand the differences more clearly...
public class ThreadsVsRunnable {

	public static void main(String args[]) throws Exception {
		// Multiple threads share the same object.
		ImplementsRunnable rc = new ImplementsRunnable();
		ImplementsRunnable rc2 = new ImplementsRunnable();
		ImplementsRunnable rc3 = new ImplementsRunnable();
		Thread t1 = new Thread(rc);
		t1.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		Thread t2 = new Thread(rc2);
		t2.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		Thread t3 = new Thread(rc3);
		t3.start();

		// Creating new instance for every thread access.
		ExtendsThread tc1 = new ExtendsThread();
		tc1.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		ExtendsThread tc2 = new ExtendsThread();
		tc2.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		ExtendsThread tc3 = new ExtendsThread();
		tc3.start();
	}
}