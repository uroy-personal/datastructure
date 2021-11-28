package practice.twoheaps;


import java.util.*;



class NextIntervalAnotherApproach {
  public static int[] findNextInterval(IntervalHeap[] intervals) {
    int n = intervals.length;
    // heap for finding the maximum start
    PriorityQueue<IntervalHeap> maxStartHeap = new PriorityQueue<>( (i1, i2) -> i2.start - i1.start);
    // heap for finding the minimum end
    PriorityQueue<IntervalHeap> maxEndHeap = new PriorityQueue<>( (i1, i2) -> i2.end - i1.end);
    int[] result = new int[n];
    for (int i = 0; i < intervals.length; i++) {
      maxStartHeap.offer(intervals[i]);
      maxEndHeap.offer(intervals[i]);
    }
    
    while(!maxEndHeap.isEmpty()) {
    	IntervalHeap lastEndInterval = maxEndHeap.poll();
    	result[getIntervalIndex(intervals,lastEndInterval)] = -1;
    	IntervalHeap topStart = null;
    	while (!maxStartHeap.isEmpty() && maxStartHeap.peek().start >= lastEndInterval.end) {
            topStart = maxStartHeap.poll();
            result[getIntervalIndex(intervals,lastEndInterval)] = getIntervalIndex(intervals,topStart);
           
          }
    	 maxStartHeap.add(topStart);
    	
    }
	

    return result;
  }
  private static int getIntervalIndex(IntervalHeap[] intervals, IntervalHeap interval ) {
	  return Arrays.asList(interval).indexOf(interval);
  }
  public static void main(String[] args) {
	  IntervalHeap[] intervals = new IntervalHeap[] { new IntervalHeap(2, 3), new IntervalHeap(3, 4), new IntervalHeap(5, 6) };
    int[] result = NextIntervalAnotherApproach.findNextInterval(intervals);
    System.out.print("Next interval indices are: ");
    for (int index : result)
      System.out.print(index + " ");
    System.out.println();

    intervals = new IntervalHeap[] { new IntervalHeap(3, 4), new IntervalHeap(1, 5), new IntervalHeap(4, 6) };
    result = NextIntervalAnotherApproach.findNextInterval(intervals);
    System.out.print("Next interval indices are: ");
    for (int index : result)
      System.out.print(index + " ");
  }
}