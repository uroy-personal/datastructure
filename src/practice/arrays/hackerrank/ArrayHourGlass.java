package practice.arrays.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayHourGlass {
    public static int hourglassSum(List<List<Integer>> arr) {
    	
    	int rows = arr.size();
    	int columns = arr.get(0).size();
    	int maxHourGlassSum =Integer.MIN_VALUE;
    	for(int row=0;row<rows-2;row++) {
    		int individualMaxHourGlassSum = 0;
    		for(int column=0;column<columns-2;column++) {
    			
    				
    				individualMaxHourGlassSum	= calculateSum(arr,row, column );
    				System.out.println(" :::: Individual sum is :::: "+individualMaxHourGlassSum);
    				maxHourGlassSum = Math.max(maxHourGlassSum, individualMaxHourGlassSum);
    			
    			
    		}
    	}
    	
    	return maxHourGlassSum;

    }
    public static int calculateSum(List<List<Integer>> arr, int row, int column) {
    	return 
    			arr.get(row).get(column)
    			+arr.get(row).get(column+1)
    			+arr.get(row).get(column+2)
    			
    			+arr.get(row+1).get(column+1)
    			
    			+arr.get(row+2).get(column)
    			+arr.get(row+2).get(column+1)
    			+arr.get(row+2).get(column+2);
    			
    	
    }
    public static void main(String[] args) {
    	int[][] matrix = new int[][]{
    						{1, 1, 1, 0, 0, 0},
    						{0, 1, 0, 0, 0, 0},
    						{1, 1, 1, 0, 0, 0},
    						{0, 0, 2, 4, 4, 0},
    						{0, 0, 0, 2, 0, 0},
    						{0, 0, 1, 2, 4, 0}
    					 };
    	int[][] matrix2 = new int[][]{				 
    					 {-1, -1, 0, -9, -2, -2},
    					 {-2, -1, -6, -8, -2, -5},
    					 {-1, -1, -1, -2, -3, -4},
    					 {-1, -9, -2, -4, -4, -5},
    					 {-7, -3, -3, -2, -9, -9},
    					 {-1, -3, -1, -2, -4, -5}
    	};
    					 List arrayAsList = new ArrayList<List<Integer>>();
    					
    					 for(int row=0;row<matrix2.length;row++) {
    						 List<Integer> indivRow = new ArrayList<Integer>();
    						 for(int column=0;column<matrix2.length;column++) {
    							 indivRow.add(matrix2[row][column]);
    						 }
    						 arrayAsList.add(indivRow);
    					 }
    					 // Arrays.asList(matrix);
    					  System.out.println(arrayAsList);
    					 System.out.println(hourglassSum(arrayAsList));				 
    	}
    
}
