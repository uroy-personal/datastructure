package practice.walmartlabs;

import java.util.*;
class Train{
	int arrival;
	int departure;
	
	public Train(int arrival, int depature) {
		this.arrival=arrival;
		this.departure = depature;
	}
	
}
public class MinimumPlatforms {
	
	
	static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
		
		List<Train> trainList = new ArrayList<Train>();
		int minPlatformCount =0;
		for(int i=0;i<n;i++) {
			trainList.add(new Train(arr[i], dep[i]));
		}
		if (trainList == null || trainList.size() == 0)
		      return 0;
		Collections.sort(trainList,(a,b)->Integer.compare(a.arrival, b.arrival));
		PriorityQueue<Train> minHeap = new PriorityQueue<Train>((a,b)->Integer.compare(a.departure, b.departure));
		
		for(Train t:trainList) {
			while(!minHeap.isEmpty() && t.arrival>=minHeap.peek().departure) 
				minHeap.poll();
			minHeap.offer(t);
			minPlatformCount = Math.max(minPlatformCount, minHeap.size());
		}
	
        return minPlatformCount;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{900, 940, 950, 1100, 1500, 1800};
		int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};
		System.out.println(findPlatform(arr, dep, 6));
		
		int[] arr2 = new int[]{900, 1100, 1235};
		int[] dep2 = new int[]{1000, 1200, 1240};
		System.out.println(findPlatform(arr2, dep2, 3));
	}

}
