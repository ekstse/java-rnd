package et.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NotifyExample {

	private List synchedList;

	public NotifyExample() {
		// create a new synchronized list to be used
		synchedList = Collections.synchronizedList(new LinkedList());
	}

	// method used to remove an element from the list
	public String removeElement() throws InterruptedException {
		synchronized (synchedList) {

			// while the list is empty, wait
			while (synchedList.isEmpty()) {
				System.out.println("remove element, but it is empty waiting...");
				synchedList.wait();
				System.out.println("wait completed");
			}
			System.out.println("removing");
			String element = (String) synchedList.remove(0);
			return element;
		}
	}

	// method to add an element in the list
	public void addElement(String element) {
		System.out.println("add open...");
		synchronized (synchedList) {

			// add an element and notify all that an element exists
			synchedList.add(element);
			System.out.println("New Element:'" + element + "'");

			synchedList.notify();
			System.out.println("notify called!");
		}
		System.out.println("add exit...");
	}

	public static void main(String[] args) {
		final NotifyExample demo = new NotifyExample();

		Runnable runA = new Runnable() {

			public void run() {
				try {
					String item = demo.removeElement();
					System.out.println("" + item);
				} catch (InterruptedException ix) {
					System.out.println("Interrupted Exception!");
				} catch (Exception x) {
					System.out.println("Exception thrown.");
				}
			}
		};

		Runnable runB = new Runnable() {

			// run adds an element in the list and starts the loop
			public void run() {
				demo.addElement("Hello!");
			}
		};

		try {
			Thread threadA1 = new Thread(runA, "A");
			threadA1.start();

			Thread.sleep(500);

			Thread threadA2 = new Thread(runA, "B");
			threadA2.start();

			Thread.sleep(500);

			Thread threadB = new Thread(runB, "C");
			threadB.start();

			Thread.sleep(1000);

			threadA1.interrupt();
			threadA2.interrupt();
		} catch (InterruptedException x) {
		}
	}
}
