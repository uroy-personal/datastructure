package practice.randompractice;
import java.util.*;
class ParenthesesString{
	String str;
	int openCount=0;
	int closeCount=0;
	ParenthesesString(String str, int openCount, int closeCount){
		this.str=str;
		this.openCount =openCount;
		this.closeCount=closeCount;
	}
}
public class BalancedParentheses {
	public static List<String> generateBalancedParentheses(int number) {
		List<String> result = new ArrayList<String>();
		Queue<ParenthesesString> queue = new LinkedList<ParenthesesString>();
		queue.add(new ParenthesesString("", 0,0));
		
		while(!queue.isEmpty()) {
			ParenthesesString psProcessing = queue.poll();
			if(psProcessing.openCount==number && psProcessing.closeCount ==number) {
				result.add(psProcessing.str);
			}else {
			if(psProcessing.openCount<number) {
				queue.add(new ParenthesesString(psProcessing.str+"(", psProcessing.openCount+1, psProcessing.closeCount));
			}
			 if(psProcessing.closeCount<psProcessing.openCount) {
				queue.add(new ParenthesesString(psProcessing.str+")", psProcessing.openCount, psProcessing.closeCount+1));
			}
			}
			
		}
		
		
		 while (!queue.isEmpty()) {
		      ParenthesesString ps = queue.poll();
		      // if we've reached the maximum number of open and close parentheses, add to the result
		      if (ps.openCount == number && ps.closeCount == number) {
		        result.add(ps.str);
		      } else {
		        if (ps.openCount < number) // if we can add an open parentheses, add it
		          queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));

		        if (ps.openCount > ps.closeCount) // if we can add a close parentheses, add it
		          queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
		      }
		    }
	
		return result;
		
	}
	public static void main(String []args) {
	    List<String> result = BalancedParentheses.generateBalancedParentheses(2);
	    System.out.println("All combinations of balanced parentheses are: " + result);

	    result = BalancedParentheses.generateBalancedParentheses(3);
	    System.out.println("All combinations of balanced parentheses are: " + result);
	}
}
