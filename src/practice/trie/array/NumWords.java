package practice.trie.array;

import java.util.Arrays;

public class NumWords {
	public static int numberOfWords(TrieNode node) {
		int totalWords=0;
		if(node.endOfWord) {
			totalWords++;
		}
		for(int index=0;index<26;index++) {
			if(node.children[index]!=null) {
				totalWords+=numberOfWords(node.children[index]);
			}
		}
		return totalWords==0?-1:totalWords;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Input keys (use only 'a' through 'z' and lower case)
	    String keys[] = {"the", "a", "there", "answer", "any",
	                     "by", "bye", "their","abc"};

	    System.out.println("Keys: "+ Arrays.toString(keys));
	    
	    TrieDataStructure trie = new TrieDataStructure();
	    for(String key:keys) {
	    	trie.insert(key);
	    }
	    System.out.println("Trie formed");
	    System.out.println(numberOfWords(trie.getRoot()));
	}

}
