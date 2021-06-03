public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
  }

  public String longestPalindrome(String s) {
    char[] chars = s.toCharArray();
    String max = String.valueOf(chars[0]);

    for(int i = 0; i < chars.length; i ++) {
      int j = i, k = i;

      while(j >= 0 && chars[j] == chars[i]) {
        j --;
      }

      while(k < chars.length && chars[k] == chars[i]) {
        k ++;
      }

      while(j >= 0 && k < chars.length && chars[j] == chars[k]) {
        j --;
        k ++;
      }

      j ++;
      k --;

      if(k - j + 1 > max.length()) {
        max = s.substring(j, k + 1);
      }
    }

    return max;
  }

}
