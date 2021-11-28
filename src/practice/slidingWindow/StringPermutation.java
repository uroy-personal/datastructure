package practice.slidingWindow;

import java.util.*;

/*
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * String="oidbcaf", Pattern="abc" returns true
 * 
 */
class StringPermutation {
	  public static boolean findPermutation(String str, String pattern) {
	    // TODO: Write your code here
	    int windowStart=0;
	    int matched=0;
	    Map<Character, Integer> charFrequencyMap = new HashMap<Character,Integer>();
	    for(Character c : pattern.toCharArray()){
	      charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c,0)+1);
	    }
	    System.out.println(charFrequencyMap);
	    for(int windowEnd=0; windowEnd<str.length(); windowEnd++){
	      char rightChar = str.charAt(windowEnd);
	      if(charFrequencyMap.containsKey(rightChar)){
	        charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar)-1);
	        if(charFrequencyMap.get(rightChar)==0){
	          matched++;
	        }
	      }
	      if(matched==charFrequencyMap.size()){
	        return true;
	      }
	      while(windowEnd-windowStart+1> pattern.length()-1){
	        char leftChar = str.charAt(windowStart++);
	        if(charFrequencyMap.containsKey(leftChar)){
	          matched--;
	          charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)+1);
	        }
	        
	      }

	    }
	    return false;
	  }
	  
	  public static void main(String [] args) {
		  System.out.println(findPermutation("oidbcaf", "abc"));
	  }
	}
