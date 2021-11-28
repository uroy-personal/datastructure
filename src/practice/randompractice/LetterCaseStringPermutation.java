package practice.randompractice;

import java.util.*;

public class LetterCaseStringPermutation {
	public static List<String> findLetterCaseStringPermutations(String str) {

		List<String> results = new ArrayList<>();
		List<String> currentList = new ArrayList<>();

		currentList.add(str);

		findLetterCaseStringPermutationsRecursive(str, 0, currentList, results);

		return results;
	}

	public static void findLetterCaseStringPermutationsRecursive(String str, int index, List<String> currentList,
			List<String> result) {
		if (index == str.length() - 1) {
			return;
		}
		// List<String> newList = new ArrayList<String>(currentList);
		int n = currentList.size();
		for (int i=0;i<currentList.size();i++) {
			String permutation = currentList.get(i);
			if (Character.isLetter(permutation.charAt(index))) {
				String newPermutation = null;
				if (Character.isUpperCase(permutation.charAt(index))) {
					newPermutation = new String(permutation).replace(permutation.charAt(index),
							Character.toLowerCase(permutation.charAt(index)));
				} else {
					newPermutation = new String(permutation).replace(permutation.charAt(index),
							Character.toUpperCase(permutation.charAt(index)));
				}
				// String newPermutation = new
				// String(currentString).replace(currentString.charAt(index), Character.to
				// newChar)
				currentList.add(newPermutation);

			}
		}
		// result.addAll(newList);
		// findLetterCaseStringPermutationsRecursive(str, index + 1, newList, result);
	}

	public static void main(String[] args) {
		System.out.println(findLetterCaseStringPermutations("ad52"));
	}

}
