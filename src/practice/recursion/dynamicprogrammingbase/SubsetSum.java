package practice.recursion.dynamicprogrammingbase;

public class SubsetSum {
	static int countSubsets(int[] num, int sum) {
	    //TODO: Write - Your - Code
	    return countSubsetsRecursive(num, sum,0);
	}
	static int countSubsetsRecursive(int[] num, int sum, int currentIndex) {
	    //TODO: Write - Your - Code
		if(sum==0) {
			return 1;
		}
		if(currentIndex>=num.length) {
			return 0;
		}
		int count1=0;
		if(num[currentIndex]<=sum)
		count1 = countSubsetsRecursive(num, sum-num[currentIndex], currentIndex+1);
		
		int count2 = countSubsetsRecursive(num, sum, currentIndex+1);
	    return count1+count2;
	}
	
	public static void main(String[] args) {
	    SubsetSum ss = new SubsetSum();
	    int[] num = {1, 1, 2, 3};
	    System.out.println(ss.countSubsets(num, 4));
	    num = new int[]{1, 2, 7, 1, 5};
	    System.out.println(ss.countSubsets(num, 9));
	  }
}
