package practice.modifiedbinarysearch;

class NextLetter {

	  public static char searchNextLetter(char[] letters, char key) {
	    int n = letters.length;

	    int start = 0, end = n - 1;
	    while (start <= end) {
	      int mid = start + (end - start) / 2;
	      if (key < letters[mid]) {
	        end = mid - 1;
	      } else { 
	        start = mid + 1;
	      }
	    }
	    // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
	    return letters[start % n];
	  }

	  public static void main(String[] args) {
	    //System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
	    //System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
	    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'z' }, 'm'));
	    //System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	    System.out.println(8%7);
	  }
	}
