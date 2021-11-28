package practice.recursion.dynamicprogrammingbase;

public class LongestPalindromicSubsequence {
   
	static int findLPSLength(String palindromicString) {
		return findLPSLengthRecursive(palindromicString,0,palindromicString.length()-1);
	}
	
	static int findLPSLengthRecursive(String palindromicString, int startIndex, int endIndex) {
		
		if(startIndex> endIndex) {
			return 0;
		}
		
		if(startIndex==endIndex) {
			return 1;
		}
		int count1=0;
		if(palindromicString.charAt(startIndex)==palindromicString.charAt(endIndex)) {
			count1 = 2+findLPSLengthRecursive(palindromicString, startIndex+1, endIndex-1);
		}
		int count2 = findLPSLengthRecursive(palindromicString, startIndex+1, endIndex);
		
		int count3 = findLPSLengthRecursive(palindromicString, startIndex, endIndex-1);
		
		return Math.max(count1, Math.max(count2, count3));
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence lps =  new LongestPalindromicSubsequence();
		System.out.println(lps.findLPSLength("abdbca"));
	    System.out.println(lps.findLPSLength("cddpd"));
	    System.out.println(lps.findLPSLength("pqr"));
	}

}
