package practice.greedy;

import java.util.*;

import javafx.util.Pair;

public class MaximumUnitsOnATruck {

	public static int maximumUnits(int[][] boxTypes, int truckSize) {

		List<Pair<Integer, Integer>> boxTypePairs = new ArrayList<Pair<Integer, Integer>>();

		for (int[] boxType : boxTypes) {
			boxTypePairs.add(new Pair<Integer, Integer>(boxType[0], boxType[1]));
		}

		Collections.sort(boxTypePairs, new Comparator<Pair<Integer, Integer>>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return (Integer) o2.getValue() - (Integer) o1.getValue();
			}
		});

		System.out.println(boxTypePairs);

		int usedBoxes = 0;
		int totalValue = 0;

		for (Pair<Integer, Integer> boxTypePair : boxTypePairs) {

			for (int boxCount = 1; boxCount <= boxTypePair.getKey(); boxCount++) {
				if (usedBoxes + 1 <= truckSize) {
					usedBoxes++;
					totalValue += boxTypePair.getValue();
				}
				if (usedBoxes == truckSize)
					break;
			}

		}

		return totalValue;
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int[][] boxTypes = new int[][] { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } };

		System.out.println(maximumUnits(boxTypes, 10));

		int[][] boxTypes2 = new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } };

		System.out.println(maximumUnits(boxTypes2, 4));

	}

}
