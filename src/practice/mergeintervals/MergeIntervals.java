package practice.mergeintervals;

import java.util.*;

class MergeInterval {
  int start;
  int end;

  public MergeInterval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class MergeIntervals {

  public static List<MergeInterval> merge(List<MergeInterval> intervals) {
    List<MergeInterval> mergedIntervals = new LinkedList<MergeInterval>();
    // TODO: Write your code here
    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<MergeInterval> input = new ArrayList<MergeInterval>();
    input.add(new MergeInterval(1, 4));
    input.add(new MergeInterval(2, 5));
    input.add(new MergeInterval(7, 9));
    System.out.print("Merged intervals: ");
    for (MergeInterval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<MergeInterval>();
    input.add(new MergeInterval(6, 7));
    input.add(new MergeInterval(2, 4));
    input.add(new MergeInterval(5, 9));
    System.out.print("Merged intervals: ");
    for (MergeInterval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<MergeInterval>();
    input.add(new MergeInterval(1, 4));
    input.add(new MergeInterval(2, 6));
    input.add(new MergeInterval(3, 5));
    System.out.print("Merged intervals: ");
    for (MergeInterval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}