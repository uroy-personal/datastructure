package practice.bitwisexor;

public class SingleNumber {
	
	public static int findSingleNumber(int[] arr) {
	    int num = 0;
	    for (int i=0; i < arr.length; i++) {
	    	
	    	num = num ^ arr[i];
	    	// System.out.println(" :::: Number is :::: "+num);
	    }
	    return num;
	  }

	  public static void main( String args[] ) {
	    System.out.println(findSingleNumber(new int[]{1, 4,3, 2, 1,2}));
	  }
}
