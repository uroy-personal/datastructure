package practice.randompractice;

import java.util.*;

import sun.security.util.Length;

public class UniqueGeneralizedAbbreviations {
	public static List<String> getUniqueGeneralizedAbbreviations(String word) {
		
		int wordLength = word.length();
		int decimalValue = (int)Math.pow(2, wordLength) -1;
		System.out.println(decimalValue);
		List<String> result = new ArrayList<String>();
		/*
		 * for(decimalValue) {
		 */		
		
		return result;
	}
	public static String convertToString(String binaryRepresentation, String word) {
		String returnValue ="";	
		StringBuilder sb = new StringBuilder();
		
		int length = binaryRepresentation.length();
		
		for(int k=0;k<length;k++) {
			if(binaryRepresentation.charAt(k)=='1') {
				sb.append(word.charAt(k));
			}else {
				
				sb.append(1);
			}
		}
		
		return returnValue;
		
	}
	public static void main(String[] args) {
		// getUniqueGeneralizedAbbreviations("code");
		
		System.out.println(padLeftZeros(Integer.toBinaryString(0), 4));
	}
	
	public static String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);

	    return sb.toString();
	}
}
