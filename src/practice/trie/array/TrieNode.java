package practice.trie.array;

public class TrieNode {
		boolean endOfWord=false;
		TrieNode[] children=null;
		static final int ALPHABET_SIZE=26;
		public TrieNode() {
			this.endOfWord=false;
			this.children = new TrieNode[26];
		}
		public void markAsLeaf() {
			this.endOfWord=true;
		}
		public void unMarkAsLeaf() {
			this.endOfWord=false;
		}
}
