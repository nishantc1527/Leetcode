public class EditDistance {

  public static void main(String[] args) {
    System.out.println(new EditDistance().minDistance("horse", "ros"));
  }

  public int minDistance(String word1, String word2) {
    return minDistance(word1, word2, new int[word1.length()][word2.length()], 0, 0);
  }

  private int minDistance(String word1, String word2, int[][] memo, int curr1, int curr2) {
    if(curr1 >= word1.length() && curr2 >= word2.length()) {
      return 0;
    }

    if(curr1 >= word1.length()) {
      return word2.length() - curr2;
    }

    if(curr2 >= word2.length()) {
      return word1.length() - curr1;
    }

    if (memo[curr1][curr2] != 0) {
      return memo[curr1][curr2];
    }

    if(word1.charAt(curr1) == word2.charAt(curr2)) {
      return memo[curr1][curr2] = minDistance(word1, word2, memo, curr1 + 1, curr2 + 1);
    }

    return memo[curr1][curr2] = 1 + Math.min(minDistance(word1, word2, memo, curr1 + 1, curr2),
            Math.min(minDistance(word1, word2, memo, curr1, curr2 + 1), minDistance(word1, word2, memo, curr1 + 1, curr2 + 1)));
  }

}
