public class SwimInRisingWater {

  public static void main(String[] args) {
    System.out.println(new SwimInRisingWater().swimInWater(new int[][]{{0, 2}, {1, 3}}));
  }

  private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

  public int swimInWater(int[][] grid) {
    int N = grid.length;
    int lo = 0;
    int hi = N * N - 1;

    while (lo < hi) {
      int middle = (lo + hi) / 2;
      boolean[][] visited = new boolean[N][N];
      
      if (hasPath(grid, 0, 0, middle, visited)) {
        hi = middle;
      } else {
        lo = middle + 1;
      }
    }

    return lo;
  }

  private boolean hasPath(int[][] grid, int i, int j, int time, boolean[][] visited) {
    int N = grid.length;
    
    if (i == N - 1 && j == N - 1) {
      return true;
    }
    
    visited[i][j] = true;

    for (int[] dir : dirs) {
      int newI = i + dir[0];
      int newJ = j + dir[1];

      if (newI >= 0 && newJ >= 0 && newI < N && newJ < N && !visited[newI][newJ] && grid[i][j] <= time && grid[newI][newJ] <= time && hasPath(grid, newI, newJ, time, visited)) {
        return true;
      }
    }

    return false;
  }

}
