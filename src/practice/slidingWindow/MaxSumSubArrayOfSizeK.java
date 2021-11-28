package practice.slidingWindow;

class MaxSumSubArrayOfSizeK {
	  public static int findMaxSumSubArray(int k, int[] arr) {
	    // TODO: Write your code here
	    int windowSum=0;
	    int maxSum=0;
	    int windowStart=0;
	    for(int windowEnd=0;windowEnd<arr.length;windowEnd++){
	      windowSum+=arr[windowEnd];
	      if(windowEnd >=k-1){
	        if(windowSum>maxSum){
	            maxSum=windowSum;
	        }
	        windowSum-=arr[windowStart];
	        windowStart++;
	      }
	      System.out.println("Window start --> "+windowStart);
	    }
	    return maxSum;
	  }
	  public static void main(String[] args) {
		 //  System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
		 //  System.out.println(findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5}));
		  int t = 9/10;
		  System.out.println(t);
	  }
	}