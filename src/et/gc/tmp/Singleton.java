package et.gc.tmp;

public class Singleton {

	private String a;
	
	private Singleton() {
		if (a == null) {
			a = "testing";
		}
	}
	
	public static void main(String[] args) {
		Object A = new Object();
		Object B = new Object();
		//Object B = A;
		System.out.println(A.equals(B));
		System.out.println(A == B);
		System.out.println(A.hashCode() == B.hashCode());
	}
}
