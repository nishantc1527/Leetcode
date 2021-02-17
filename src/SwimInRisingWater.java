import utils.Pair;

import java.util.*;

public class SwimInRisingWater {

  public static void main(String[] args) {
    System.out.println(new SwimInRisingWater().swimInWater(new int[][]{{0, 2},{1, 3}}));
  }

  public int swimInWater(int[][] grid) {
    PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a.getKey()][a.getValue()]));
    priorityQueue.offer(new Pair<>(0, 0));
    boolean[][] visited = new boolean[grid.length][grid.length];
    int max = -1;

    while(!priorityQueue.isEmpty()) {
      Pair<Integer, Integer> top = priorityQueue.poll();
      max = Math.max(max, grid[top.getKey()][top.getValue()]);
      visited[top.getKey()][top.getValue()] = true;

      if(top.getKey() == grid.length - 1 && top.getValue() == grid.length - 1) {
        return max;
      }

      if (top.getKey() != 0 && !visited[top.getKey() - 1][top.getValue()]) {
        priorityQueue.offer(new Pair<>(top.getKey() - 1, top.getValue()));
      }

      if (top.getValue() != 0 && !visited[top.getKey()][top.getValue() - 1]) {
        priorityQueue.offer(new Pair<>(top.getKey(), top.getValue() - 1));
      }

      if (top.getKey() != grid.length - 1 && !visited[top.getKey() + 1][top.getValue()]) {
        priorityQueue.offer(new Pair<>(top.getKey() + 1, top.getValue()));
      }

      if (top.getValue() != grid.length - 1 && !visited[top.getKey()][top.getValue() + 1]) {
        priorityQueue.offer(new Pair<>(top.getKey(), top.getValue() + 1));
      }
    }

    return -1;
  }

}
