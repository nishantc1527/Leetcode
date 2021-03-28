import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EvaluateTheBracketPairsOfAString {

  public static void main(String[] args) {
    System.out.println(new EvaluateTheBracketPairsOfAString().evaluate("(name)is(age)yearsold", Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"))));
  }

  public String evaluate(String s, List<List<String>> knowledge) {
    HashMap<String, String> map = new HashMap<>();

    for (List<String> pair : knowledge) {
      map.put(pair.get(0), pair.get(1));
    }

    char[] chars = s.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '(') {
        StringBuilder key = new StringBuilder();

        for (++i; chars[i] != ')'; i ++) {
          key.append(chars[i]);
        }

        stringBuilder.append(map.getOrDefault(key.toString(), "?"));
      } else {
        stringBuilder.append(chars[i]);
      }
    }

    return stringBuilder.toString();
  }

}
