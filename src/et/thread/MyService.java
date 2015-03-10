package et.thread;

import java.util.concurrent.locks.ReentrantLock;;

public class MyService {

	private static ReentrantLock lock = new ReentrantLock();
	
	protected static long i;
	
	public void increment(long value) {
		lock.lock();
		try {
			Thread.sleep(123);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.i = this.i + value;
		lock.unlock();
	}
	
	public long get() {
		return this.i;
	}
}
