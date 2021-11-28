package practice.payu;

import java.util.Stack;

public class ReverseWord {

	public static String reverseWord(String sentence) {

		StringBuilder sbSentence = new StringBuilder();

		Stack<Character> sentenceStack = new Stack<Character>();

		for (char c : sentence.toCharArray()) {
			if (c == '.') {
				while (!sentenceStack.empty()) {

					char t = sentenceStack.pop();
					// System.out.print(t);
					sbSentence.append(t);

				}
				sbSentence.append('.');

			} else {
				sentenceStack.push(c);
			}

		}

		while (!sentenceStack.empty()) {

			char t = sentenceStack.pop();
			// System.out.print(t);
			sbSentence.append(t);

		}
		sbSentence.append('.');

		if (sbSentence.length() > 0) {
			sbSentence.deleteCharAt(sbSentence.length() - 1);
		}

		return sbSentence.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseWord("pqr.mno"));
	}
}
