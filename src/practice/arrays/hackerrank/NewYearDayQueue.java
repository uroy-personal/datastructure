package practice.arrays.hackerrank;

public class NewYearDayQueue {
	public static void getSwapPositions(int[] array) {
		int noOfBribes=0;
		boolean chaos = false;
		for(int k=0;k<array.length;k++) {
			if(k!=(array[k]-1)) {
				int lesserCount = getLesserIndexCount(array,array[k], k );
				if(lesserCount>=3) {
					chaos=true;
				}else {
					noOfBribes+=lesserCount;
				}
			}
		}
		if(chaos) {
			System.out.println("Too chaotic");
		}else {
			System.out.println(noOfBribes);
		}
	}
	public static int getLesserIndexCount(int[] array, int value, int index) {
		int count=0;
		for(int i=index+1;i<array.length;i++) {
			if(value>array[i])count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int[] queuePositions =  new int[] {1,2, 3,5, 4,6,7,8};
		//System.out.println(Math.abs(-5));
		getSwapPositions(queuePositions);
	}
}
