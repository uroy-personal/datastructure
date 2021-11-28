package practice.topologicalsort;

import java.util.*;

class TaskScheduling {
  public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
    // TODO: Write your code here    
    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    Map<Integer, Integer> inDegrees = new HashMap<Integer, Integer>();
    List<Integer> sortedList = new ArrayList<Integer>();
    // initialize the maps
    for(int i=0;i<tasks;i++){
      graph.put(i, new ArrayList<Integer>());
      inDegrees.put(i,0);
    }
    // build the graph
    for(int[] edge:prerequisites){
      inDegrees.put(edge[1], inDegrees.get(edge[1])+1);
      graph.get(edge[0]).add(edge[1]);
    }
    Queue<Integer> sourceQueue = new LinkedList<Integer>();
    for(Map.Entry<Integer, Integer> entry: inDegrees.entrySet()){
      if(entry.getValue()==0){
          sourceQueue.add(entry.getKey());
      }
    }
    while(!sourceQueue.isEmpty()){
      Integer tempSource = sourceQueue.poll();
      sortedList.add(tempSource);
      for(Integer child:graph.get(tempSource)){
        // reduce child indegree by 1
        inDegrees.put(child, inDegrees.get(child)-1);
        if(inDegrees.get(child)==0){
          sourceQueue.add(child);
        }
      }
    }
    System.out.println(sortedList);
    return sortedList.size()==tasks;
  }

  public static void main(String[] args) {

    boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
    System.out.println("Tasks execution possible: " + result);

    result = TaskScheduling.isSchedulingPossible(3,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
    System.out.println("Tasks execution possible: " + result);

    result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
        new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
    System.out.println("Tasks execution possible: " + result);
  }
}