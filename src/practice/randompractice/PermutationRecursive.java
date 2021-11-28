package practice.randompractice;
import java.util.*;
public class PermutationRecursive {
	static List<List<Integer>> generatePermutations(int []nums){
		List<List<Integer>>  result = new ArrayList<List<Integer>>();
		generatePermutationsGeneric(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}
	
	static void generatePermutationsGeneric(int []nums, int index, List<Integer> currentPermutation, List<List<Integer>> result){
		
		if(index == nums.length) {
			result.add(currentPermutation);
		}else {
			for(int i=0;i<=currentPermutation.size();i++) {
				List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
				newPermutation.add(i,nums[index]);
				generatePermutationsGeneric(nums, index+1,newPermutation, result );
			}
		}
		
	}
	
	public static void main(String[]args) {
			System.out.println(generatePermutations(new int[] {1,2,3}));
	}
}
