import java.util.*;

public class SwimInRisingWater {

  public static void main(String[] args) {
    System.out.println(new SwimInRisingWater().swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
  }

  public int swimInWater(int[][] grid) {
    PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
    heap.offer(new int[]{0, 0});
    int max = 0;
    boolean[] visited = new boolean[grid.length * grid.length];

    while (!heap.isEmpty()) {
      int[] index = heap.poll();
      max = Math.max(max, grid[index[0]][index[1]]);

      visited[grid[index[0]][index[1]]] = true;

      if (index[0] == grid.length - 1 && index[1] == grid.length - 1) {
        return max;
      }

      if (index[0] != grid.length - 1) {
        if(!visited[grid[index[0] + 1][index[1]]]) {
          heap.offer(new int[]{index[0] + 1, index[1]});
        }
      }

      if (index[1] != grid.length - 1) {
        if (!visited[grid[index[0]][index[1] + 1]]) {
          heap.offer(new int[]{index[0], index[1] + 1});
        }
      }

      if (index[0] != 0) {
        if(!visited[grid[index[0] - 1][index[1]]]) {
          heap.offer(new int[]{index[0] - 1, index[1]});
        }
      }

      if (index[1] != 0) {
        if (!visited[grid[index[0]][index[1] - 1]]) {
          heap.offer(new int[]{index[0], index[1] - 1});
        }
      }
    }

    return -1;
  }

}
