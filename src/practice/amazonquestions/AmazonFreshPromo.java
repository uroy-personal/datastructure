package practice.amazonquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javafx.util.Pair;

public class AmazonFreshPromo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> codeList = new ArrayList<String>();
		codeList.add("apple apple");
		codeList.add("banana anything banana");
		
		
		
		
		List<String> shoppingcart = new ArrayList<String>(); // ,,,,,
		shoppingcart.add("orange");
		shoppingcart.add("apple");
		shoppingcart.add("apple");
		shoppingcart.add("banana");
		shoppingcart.add("orange");
		shoppingcart.add("banana");
		
		//System.out.println(findPromo(codeList, shoppingcart));
		
		// ,, ,,,,,
		
		List<String> shoppingcart2 = new ArrayList<String>(); // ,,,,,
		shoppingcart2.add("apple");
		shoppingcart2.add("apple");
		shoppingcart2.add("orange");
		shoppingcart2.add("orange");
		shoppingcart2.add("banana");
		shoppingcart2.add("apple");
		shoppingcart2.add("banana");
		shoppingcart2.add("banana");
		
		//System.out.println(findPromo(codeList, shoppingcart2));
		
		List<String> shoppingcart3 = new ArrayList<String>(); // ,,,,,
		shoppingcart3.add("banana");
		shoppingcart3.add("orange");
		shoppingcart3.add("banana");
		shoppingcart3.add("apple");
		shoppingcart3.add("apple");
		
		//System.out.println(findPromo(codeList, shoppingcart3));
		
		List<String> codeList2 = new ArrayList<String>();
		codeList2.add("apple apple");
		
		List<String> shoppingcart4 = new ArrayList<String>(); // ,,,,,
		shoppingcart4.add("apple");
		shoppingcart4.add("pear");
		shoppingcart4.add("orange");
		shoppingcart4.add("apple");
		
		System.out.println(findPromo(codeList2, shoppingcart4));
		
		/*
		 *  [apple apple, orange orange]
		 *	[apple, pear, apple, banana, orange, pear, orange]
		 */
		
		List<String> codeList3 = new ArrayList<String>();
		codeList2.add("apple apple, orange orange");
		
		List<String> shoppingcart5 = new ArrayList<String>(); // ,,,,,
		shoppingcart5.add("apple");
		shoppingcart5.add("pear");
		shoppingcart5.add("apple");
		shoppingcart5.add("banana");
		shoppingcart5.add("orange");
		shoppingcart5.add("pear");
		shoppingcart5.add("orange");
		
		System.out.println(findPromo(codeList3, shoppingcart5));
	}
	
	public static int findPromo(List<String> codeList, List<String> shoppingCart) {
	    // Write your code here
	     if(codeList==null || codeList.size()==0){
	         return 1;
	     }
	      
	     List<Pair<Integer, String>> consolidatedCodeList = new ArrayList<Pair<Integer, String>>();
	     
	     for(String code: codeList) {
	    	 
	    	 StringTokenizer tokenizer = new StringTokenizer(code, " ");
	    	    while (tokenizer.hasMoreElements()) {
	    	    	consolidatedCodeList.add(new Pair(codeList.indexOf(code), tokenizer.nextToken()));
	    	    }
	     }
	     
	     int i=0,j=0;
	     while(i<consolidatedCodeList.size() && j<shoppingCart.size()) {
	    	 
	    	 if(consolidatedCodeList.get(i).equals(shoppingCart.get(j)) || consolidatedCodeList.get(i).equals("anything")) {
	    		 // System.out.println(" Matched ::: ("+consolidatedCodeList.get(i)+","+shoppingCart.get(j)+")");
		    	 i++;
		    	 j++;
		     }else {
		    	 j++;
		     }
	    	 
	     }
	     /*
	      * If we reach the end of consolidated codelist return 1
	      */
	     if(i==consolidatedCodeList.size()) {
	    	 return 1;
	     }else {
	    	 return 0;
	     }
	     
	  
}

}
