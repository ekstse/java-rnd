package et.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		String[] someArray = new String[99];
		String[] controlArray = new String[100];
		int t = Math.round((float) (Math.random() * 100 + 1));
		System.out.println("picked: " + t);
		int y = 0;
		for (int i=0; i < 100; i++) {
			int idx = i;
			int num = i+1;
			
			controlArray[idx] = num +"";
			if (num != t) { 
				someArray[y] = num+"";
				y++;
			} else {
				System.out.println("skipped " + num);
			}
		}
	
		Set<String> mySet = new HashSet<String>(Arrays.asList(someArray));
		Set<String> controlSet = new HashSet<String>(Arrays.asList(controlArray));
		
//		System.out.println("myset " + mySet);
//		System.out.println("controlSet " + controlSet);
		
		controlSet.removeAll(mySet);
		for (String x : controlSet) {
			System.out.println(x);
		}
		
	}
}
