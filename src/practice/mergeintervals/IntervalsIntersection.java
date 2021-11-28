package practice.mergeintervals;

import java.util.*;

class IntervalIntersection {
  int start;
  int end;

  public IntervalIntersection(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class IntervalsIntersection {

  public static IntervalIntersection[] merge(IntervalIntersection[] arr1, IntervalIntersection[] arr2) {
    List<IntervalIntersection> result = new ArrayList<IntervalIntersection>();
    int i = 0, j = 0;
    while (i < arr1.length && j < arr2.length) {
      // check if the interval arr[i] intersects with arr2[j]
      // check if one of the interval's start time lies within the other interval
      if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
          || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
        // store the intersection part
        result.add(new IntervalIntersection(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
      }

      // move next from the interval which is finishing first
      if (arr1[i].end < arr2[j].end)
        i++;
      else
        j++;
    }

    return result.toArray(new IntervalIntersection[result.size()]);
  }

  public static void main(String[] args) {
	  IntervalIntersection[] input1 = new IntervalIntersection[] { new IntervalIntersection(1, 3), new IntervalIntersection(5, 6), new IntervalIntersection(7, 9) };
	  IntervalIntersection[] input2 = new IntervalIntersection[] { new IntervalIntersection(2, 3), new IntervalIntersection(5, 7) };
	  IntervalIntersection[] result = IntervalsIntersection.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (IntervalIntersection interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input1 = new IntervalIntersection[] { new IntervalIntersection(1, 3), new IntervalIntersection(5, 7), new IntervalIntersection(9, 12) };
    input2 = new IntervalIntersection[] { new IntervalIntersection(5, 10) };
    result = IntervalsIntersection.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (IntervalIntersection interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
  }
}
