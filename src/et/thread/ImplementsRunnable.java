package et.thread;

public class ImplementsRunnable implements Runnable {

	private int counter = 0;

	public void run() {
		counter++;
		System.out.println("ImplementsRunnable : Counter : " + counter);
	}
}