package practice.arrays.hackerrank;
import java.util.*;
public class CircularArray {
	 public static List<Integer> rotLeft(List<Integer> a, int d) {
		    // Write your code here
		 List<Integer> shiftedElements =  new ArrayList<Integer>();
		 	for(int i=0;i<d;i++) {
		 		shiftedElements.add(a.remove(0));
		 		 ;
		 	}
		 	// System.out.println(a);
		 	a.addAll(shiftedElements);
		 	return a;
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integerList = new ArrayList<Integer>();

		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);
		integerList.add(6);
		
		System.out.println(rotLeft(integerList,2));
	}

}
