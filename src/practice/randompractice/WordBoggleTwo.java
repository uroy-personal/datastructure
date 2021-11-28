package practice.randompractice;

import java.util.Arrays;

public class WordBoggleTwo {
	// Java program for Boggle game

		// Alphabet size
		static final int SIZE = 26;

		static final int M = 3;
		static final int N = 3;

		// trie Node
		static class TrieNode {
			TrieNode[] Child = new TrieNode[SIZE];

			// isLeaf is true if the node represents
			// end of a word
			boolean leaf;

			// constructor
			public TrieNode()
			{
				leaf = false;
				for (int i = 0; i < SIZE; i++)
					Child[i] = null;
			}
		}

		// If not present, inserts a key into the trie
		// If the key is a prefix of trie node, just
		// marks leaf node
		static void insert(TrieNode root, String Key)
		{
			int n = Key.length();
			TrieNode pChild = root;

			for (int i = 0; i < n; i++) {
				int index = Key.charAt(i) - 'A';

				if (pChild.Child[index] == null)
					pChild.Child[index] = new TrieNode();

				pChild = pChild.Child[index];
			}

			// make last node as leaf node
			pChild.leaf = true;
		}

		// function to check that current location
		// (i and j) is in matrix range
		static boolean isSafe(int i, int j, boolean visited[][])
		{
			return (i >= 0 && i < M && j >= 0
					&& j < N && !visited[i][j]);
		}

		// A recursive function to print
		// all words present on boggle
		static void searchWord(TrieNode root, char boggle[][], int i,
							int j, boolean visited[][], String str)
		{	// found a match
			if(root.leaf) {
				System.out.println(str);
			}
			// recursively search the next 8 adjacent cells
			visited[i][j] =true;
			// search right
			for(int k=0;k<SIZE;k++) {
				char c = (char) (k+'A');
				if(isSafe(i+1, j+1, visited) && boggle[i+1][j+1]==c) {
					
					searchWord(root.Child[k],boggle, i+1,j+1, visited,str+c  );
				}
			}
			
		}

		// Prints all words present in dictionary.
		static void findWords(char boggle[][], TrieNode root)
		{
			String str ="";
			int rowCount = boggle.length;
			int columnCount = boggle[0].length;
			
			boolean[][] visited = new boolean[rowCount][columnCount];
			for(boolean[] visitedRowIntialValues: visited) {
				Arrays.fill(visitedRowIntialValues, false);
			}
			
			for(int row=0;row<rowCount;row++) {
				for(int column=0;column<columnCount;column++) {
					if(root.Child[boggle[row][column]-'A']!=null) {
						str=str+boggle[row][column];
						searchWord(root.Child[boggle[row][column]-'A'], boggle, row, column, visited, str);
						// backtrack
						str="";
					}
				}
			}
		}

		// Driver program to test above function
		public static void main(String args[])
		{
			// Let the given dictionary be following
			String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GEE" };

			// root Node of trie
			TrieNode root = new TrieNode();

			// insert all words of dictionary into trie
			int n = dictionary.length;
			for (int i = 0; i < n; i++)
				insert(root, dictionary[i]);

			char boggle[][] = { 
								{ 'G', 'I', 'Z' },
								{ 'U', 'E', 'K' },
								{ 'Q', 'S', 'E' } 
							  };

			findWords(boggle, root);
		}
	}
	

