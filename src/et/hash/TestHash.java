package et.hash;

import java.util.HashMap;

public class TestHash {

	public static void main(String[] args) {
		HashMap<Integer, String> test = new HashMap<Integer, String>();
		Integer aaa = new Integer(1);
		test.put(aaa, "test1");
		test.put(new Integer(1), "test2");
		test.put(new Integer(1), "test3");
		System.out.println(test.get(aaa));
		
//		HashMap<String, String> test = new HashMap<String, String>();
//		String aaa = new String("testing123");
//		System.out.println(aaa.hashCode());
//		test.put(aaa, "test1");
//		test.put(new String("testing123"), "test2");
//		test.put(new String("testing123"), "test3");
//		System.out.println(test.get(aaa));
		
	}
	
}
