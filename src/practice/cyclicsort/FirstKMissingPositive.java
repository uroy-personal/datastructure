package practice.cyclicsort;
import java.util.*;
public class FirstKMissingPositive {
	public static List<Integer> findNumbers(int[] nums, int k) {
		List<Integer> missingNumbers = new ArrayList<>();
		Set<Integer> extraNumbers = new HashSet<>();
		    // TODO: Write your code here
		int i=0;
		System.out.println(" Before swap ---> "+Arrays.toString(nums));
		while(i<nums.length) {
			if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]) {
				swap(nums, i, nums[i]-1);
			}else {
				i++;
			}
		}
		System.out.println(" after swap ---> "+Arrays.toString(nums));
	    for(int l=0;l<nums.length;l++) {
	    	if(nums[l]!=l+1) {
	    		if(missingNumbers.size()<k) {
	    		missingNumbers.add(l+1);
	    		extraNumbers.add(nums[l]);
	    		}
	    	}
	    }
	    
	 // add the remaining missing numbers
	    for (i = 1; missingNumbers.size() < k; i++) {
	      int candidateNumber = i + nums.length;
	      // ignore if the array contains the candidate number
	      if (!extraNumbers.contains(candidateNumber))
	        missingNumbers.add(candidateNumber);
	    }
	    
		return missingNumbers;
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp =nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
	    System.out.println("Missing numbers: " + missingNumbers);
	}

}
