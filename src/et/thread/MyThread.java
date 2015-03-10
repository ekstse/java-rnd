package et.thread;

public class MyThread extends Thread {

	public MyThread(String name) {
		this.setName(name);
	}
	
	public void run() {
		MyService service = new MyService();
		service.increment(4);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(this.getName() + " result = " + service.get());
	}
}
