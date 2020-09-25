public class ClimbingStairs {

  public static void main(String[] args) {
    System.out.println(new ClimbingStairs().climbStairs(4));
  }

  public int climbStairs(int n) {
    if(n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if(n == 2) {
      return 2;
    }

    int[] dp = new int[n];
    dp[dp.length - 1] = 1;
    dp[dp.length - 2] = 2;

    for (int i = dp.length - 3; i >= 0; i --) {
      dp[i] = dp[i + 1] + dp[i + 2];
    }

    return dp[0];
  }

}
