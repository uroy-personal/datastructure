package practice.walmartlabs;

import java.util.*;

public class WordBreak {
	
	static boolean wordBreakPossible(String mainString, List<String> dictionary) {
		
		if(mainString.length()==0) return true;
		
		for(String word: dictionary) {
			if(mainString.startsWith(word)) {
				String subString = mainString.substring(word.length());
				if (wordBreakPossible(subString,dictionary)) {
					return true;
				}
			
		}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dictionary = new ArrayList<String>();
		dictionary = Arrays.asList(new String[]{ "ab", "bcd", "b",
				"a"});
		String mainString="abcd";
		
		System.out.println(wordBreakPossible(mainString, dictionary));
	}

}
