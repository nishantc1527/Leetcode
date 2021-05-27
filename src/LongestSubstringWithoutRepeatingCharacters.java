import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
  }

  public int lengthOfLongestSubstring(String s) {
    if(s.length() == 0) {
      return 0;
    }

    int[] map = new int[0xff];
    int max=0;
    int current = 0;
    char[] chars = s.toCharArray();

    Arrays.fill(map, -1);

    for(int i=0; i < s.length(); i ++){
      if(map[chars[i]] >= 0){
        current = Math.max(current, map[chars[i]] + 1);
      }

      map[chars[i]] = i;
      max = Math.max(max, i - current + 1);
    }

    return max;
  }

}
