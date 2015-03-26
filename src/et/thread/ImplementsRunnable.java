package et.thread;

public class ImplementsRunnable implements Runnable {

	private static int counter = 0;

	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter++;
		System.out.println("ImplementsRunnable : Counter : " + counter);
	}
}