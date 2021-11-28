package practice.amazonquestions;

import java.util.ArrayList;
import java.util.List;

public class PythagorianTriplet {
	static boolean checkTriplet(int[] arr, int n) {
		// code here
		int[] sqrArray = new int[arr.length];
		
		List<Integer> sqrArrayList = new ArrayList<Integer>();

		for (int i=0;i< arr.length;i++) {
			sqrArray[i] = arr[i] * arr[i];
		}

		for (int k : sqrArray) {
			sqrArrayList.add(k);
		}
		for(int j=0;j<sqrArray.length;j++) {
			for(int l=0;l<sqrArray.length;l++) {
				if(j==l) {
					continue;
				}
				if(sqrArrayList.contains(sqrArray[j]+sqrArray[l])) {
					return true;
				}
			}
		}
		return false;

	}
	
	public static void main(String[]args) {
		System.out.println(checkTriplet(new int[] {3, 2, 4, 6, 5},5));
	}
}
