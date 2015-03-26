package et.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExtendsThread extends Thread  {

	private static int counter = 0;
	private static AtomicInteger counter_atomic = new AtomicInteger(0);
	private static String mutex = "";
	private static Lock lock = new ReentrantLock();
	private static List<Integer> numbers = Collections.synchronizedList(new ArrayList<Integer>());

	private void sleepFor(long v) {
		try {
			Thread.sleep(v);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void run1() {
		synchronized (this) {
			Date d1 = new Date();
			int a = (++counter);
			sleepFor(1);
			System.out.println("Counter : " + a + " ; ExtendsThread "+this.getName() + "; time spend = " + (new Date().getTime()-d1.getTime()) + "ms");
		}
	}
	
	private void run2() {
		Date d1 = new Date();
		lock.lock();
		int a=counter++;
		if (numbers.contains(a))
			System.out.println("problem.......same value");
		else
			numbers.add(a);
		lock.unlock();		
		System.out.println("Counter : " + a + "; ExtendsThread "+this.getName()+ " ; time spend = " + (new Date().getTime()-d1.getTime()) + "ms");
	}
	
	private void run3() {
		int b = counter_atomic.addAndGet(1);
		if (numbers.contains(b)){
			System.out.println("problem.......same value");
		}
		else
			numbers.add(b);
		System.out.println("Counter (atomic): " + b + "; ExtendsThread "+this.getName());
	}
	
	
	public void run() {
		for (int cn=0; cn<10; cn++) {
			run2();
		}
	}
}