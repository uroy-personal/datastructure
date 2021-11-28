package practice.amazonquestions;

import java.util.*;

public class LargestNumberFromArray {
	 static String printLargest(String[] arr) {
	        Arrays.sort(arr,new Comparator<String>(){
	            @Override 
	            public int compare(String x, String y){
	                String xy = x+y;
	                String yx = y+x;
	                return yx.compareTo(xy);
	            }
	        });
	        String ans = "";
	        for(int i=0; i<arr.length; i++)
	            ans += arr[i];
	        return ans;
	    }
	 
	 public static void main(String[]args) {
		 System.out.println(printLargest(new String[] {"3", "30", "34", "5", "9"}));
		 System.out.println(printLargest(new String[] {"54", "546", "548", "60"}));
	 }
}
