package practice.cyclicsort;

import java.util.Arrays;

public class FindCorruptNumbers {
	public static int[] findNumbers(int[] nums) {
		// TODO: Write your code here
		System.out.println(" Before swap ==> " + Arrays.toString(nums));
		int i = 0;
		
		while (i < nums.length) {
			if (nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}
		for(int k=0;k<nums.length;k++) {
			if(nums[k]!=k+1) {
				return new int[] { nums[k], k + 1 };
			}
		}
		System.out.println(" after swap ==> " + Arrays.toString(nums));
		return new int[] { -1, -1 };
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = FindCorruptNumbers.findNumbers(new int[] { 3, 1, 2, 5, 2 });
		
		  System.out.println(nums[0] + ", " + nums[1]); 
		  nums =
		  FindCorruptNumbers.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
		  System.out.println(nums[0] + ", " + nums[1]);
		 
	}
}
