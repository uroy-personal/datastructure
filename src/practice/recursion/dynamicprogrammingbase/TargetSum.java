package practice.recursion.dynamicprogrammingbase;

class TargetSum {

	  public int findTargetSubsets(int[] num, int s) {
	    // TODO: Write your code here
	    return -1;
	  }
	  
	  public int findTargetSubsetsRecursive(int[] num, int sum, int currentIndex) {
		    // TODO: Write your code here
		  // Add base case
		  if(sum==0) {
			  return 1;
		  }
		  if(currentIndex>=num.length) {
			  return 0;
		  }
		  
		    return -1;
		  }
	  
	  public static void main(String[] args) {
	    TargetSum ts = new TargetSum();
	    int[] num = {1, 1, 2, 3};
	    System.out.println(ts.findTargetSubsets(num, 1));
	    num = new int[]{1, 2, 7, 1};
	    System.out.println(ts.findTargetSubsets(num, 9));
	  }
	}
