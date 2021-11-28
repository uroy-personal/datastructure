package practice.randompractice;

import java.util.*;


public class PermutationUsingSubsets {
	
	public static List<List<Integer>> findPermutations(int[] nums){
		List<List<Integer>> permutationList =  new ArrayList<List<Integer>>();
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		
		// Add empty list to start the iteration
		queue.add(new ArrayList<Integer>());
		for(int number : nums) {
			
			int size = queue.size();
			for(int i=0;i<size;i++) {
				List<Integer> oldPermutation = queue.poll();
				
				for(int j=0;j<=oldPermutation.size();j++) {
					List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
					newPermutation.add(j, number);
					if(newPermutation.size()==nums.length) {
						permutationList.add(newPermutation);
					}else {
						queue.add(newPermutation);
					}
				}
			}
			
		}
		
		return permutationList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPermutations(new int[] {1,2,3}));
		
		List<Integer> nexList = new ArrayList<Integer>();
		// nexList.add(3,10);
		// System.out.println(nexList);

	}

}
