package practice.miscelleneous;

class MinSizeSubArraySum {
	  public static int findMinSubArray(int S, int[] arr) {
	    // TODO: Write your code here
	     int windowStart=0;
	    int windowSum=0;
	    
	    int minWindowSize = Integer.MAX_VALUE;
	    
	    for(int windowEnd=0;windowEnd<arr.length;windowEnd++){
	      windowSum+=arr[windowEnd];
	      while(windowSum>=S){
	        
	        minWindowSize = Math.min(minWindowSize,windowEnd-windowStart+1);
	        
	        windowSum-=arr[windowStart];
	        
	        windowStart++;
	      }
	    }
	    
	    
	    // int windowSum = 0, minLength = Integer.MAX_VALUE;
	    // int windowStart = 0;
	    // for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
	      //windowSum += arr[windowEnd]; // add the next element
	      // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
	      //while (windowSum >= S) {
	    	 // minWindowSize = Math.min(minLength, windowEnd - windowStart + 1);
	        //windowSum -= arr[windowStart]; // subtract the element going out
	        //windowStart++; // slide the window ahead
	      //}
	    //}

	    return minWindowSize;
	  }
	  
	  public static void main(String []args) {
		  // System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2}));
		  // System.out.println(findMinSubArray(8, new int[] {3, 4, 1, 1, 6}));
		  System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));
		 
	  }
	}