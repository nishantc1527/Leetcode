import java.util.*;

public class SwimInRisingWater {

  public static void main(String[] args) {
    System.out.println(new SwimInRisingWater().swimInWater(new int[][]{{0, 2}, {1, 3}}));
  }

  class Trio {

    private int a, b, c;

    public Trio(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

  }

  public int swimInWater(int[][] grid) {
    int n = grid.length, res = 0;
    PriorityQueue<Trio> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.a, b.a));
    pq.offer(new Trio(grid[0][0], 0, 0));

    boolean[][] seen = new boolean[n][n];
    seen[0][0] = true;

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    while (!pq.isEmpty()) {
      Trio top = pq.poll();
      res = Math.max(res, top.a);

      if (top.b == n - 1 && top.c == n - 1) {
        return res;
      }

      for (int[] d : directions) {
        int i = top.b + d[0], j = top.c + d[1];
        if (i >= 0 && i < n && j >= 0 && j < n && !seen[i][j]) {
          seen[i][j] = true;
          pq.offer(new Trio(grid[i][j], i, j));
        }
      }
    }

    return -1;
  }

}
