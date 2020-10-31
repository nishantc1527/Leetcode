public class EditDistance {

  public static void main(String[] args) {
    System.out.println(new EditDistance().minDistance("horse", "ros"));
  }

  public int minDistance(String word1String, String word2String) {
    char[] word1 = word1String.toCharArray();
    char[] word2 = word2String.toCharArray();
    int[][] dp = new int[word1.length + 1][word2.length + 1];

    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = i;
    }

    for (int i = 1; i < dp[0].length; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (word1[i - 1] == word2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
        }
      }
    }

    return dp[dp.length - 1][dp[0].length - 1];
  }

}
