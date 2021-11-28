package practice.dynamicprogramming.others;

public class LongestCommonSubsequenceLengthTopDown {
	
	public int findLCSLengthTD(String s1, String s2) {
		int[][] dp = new int[s1.length()][s2.length()]; //dp table will store all the results
		for (int i = 0; i < s1.length(); i++) // initialize all values with '-1'
			for (int j = 0; j < s2.length(); j++)
				dp[i][j] = -1;
		return findLCSLengthAux(dp, s1, s2, 0, 0);
	}//end of method
 
	
	private int findLCSLengthAux(int[][] dp, String s1, String s2, int i1, int i2) {
		if (i1 == s1.length() || i2 == s2.length())//Base case
			return 0;
 
		if (dp[i1][i2] == -1) {//if we have not already solved this problem, only then solve it
			if (s1.charAt(i1) == s2.charAt(i2)) {
				dp[i1][i2] = 1 + findLCSLengthAux(dp, s1, s2, i1 + 1, i2 + 1); //If current character in both the string matches, then increase the index by 1 in both the strings.
				return dp[i1][i2];
			}else {
				int c1 = findLCSLengthAux(dp, s1, s2, i1, i2 + 1);//Increase index of 2nd String
				int c2 = findLCSLengthAux(dp, s1, s2, i1 + 1, i2);//Increase index of 1st String
				dp[i1][i2] = Math.max(c1, c2);
			}
		}
		return dp[i1][i2];
	}//end of method
}
