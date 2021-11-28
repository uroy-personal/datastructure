package practice.twoheaps;

public class IntervalHeap {
		  public int start = 0;
		  public int end = 0;

		  public IntervalHeap(int start, int end) {
		    this.start = start;
		    this.end = end;
		  }
		  
		  public String toString() {
			  return "Interval["+start+","+end+"]";
		  }
		  
}
