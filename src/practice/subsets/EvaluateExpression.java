package practice.subsets;

import java.util.*;

class EvaluateExpression {
  public static List<Integer> diffWaysToEvaluateExpression(String input) {
    List<Integer> result = new ArrayList<>();
    // base case: if the input string is a number, parse and add it to output.
    if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
      result.add(Integer.parseInt(input));
    } else {
      for (int i = 0; i < input.length(); i++) {
        char chr = input.charAt(i);
        if (!Character.isDigit(chr)) {
          // break the equation here into two parts and make recursively calls
          List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
          List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
          for (int part1 : leftParts) {
            for (int part2 : rightParts) {
              if (chr == '+')
                result.add(part1 + part2);
              else if (chr == '-')
                result.add(part1 - part2);
              else if (chr == '*')
                result.add(part1 * part2);
            }
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    
	List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
    
    System.out.println("1+2*3");
    
    System.out.println("Expression evaluations: " + result);
    
    System.out.println("2*3-4-5");
    
    result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
    
    System.out.println("Expression evaluations: " + result);
  }
}
