package practice.slidingWindow;

class MinSizeSubArraySum {
	  public static int findMinSubArray(int S, int[] arr) {
	    // TODO: Write your code here
	    int windowStart=0;
	    int subArrayLength=Integer.MAX_VALUE;
	    int minSum=0;
	    for(int windowEnd=0;windowEnd<arr.length;windowEnd++){
	      minSum+=arr[windowEnd];
	      while(minSum>=S){
	          int localSubArrayLength = windowEnd-windowStart+1;
	          minSum-=arr[windowStart];
	          windowStart++;
	          subArrayLength = Math.min(subArrayLength,localSubArrayLength);
	      }

	    }
	    return subArrayLength;
	  }
	}