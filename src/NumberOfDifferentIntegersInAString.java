import java.util.HashSet;

public class NumberOfDifferentIntegersInAString {

  public static void main(String[] args) {
    System.out.println(new NumberOfDifferentIntegersInAString().numDifferentIntegers("a1b01c001"));
  }

  public int numDifferentIntegers(String word) {
    char[] chars = word.toCharArray();
    boolean digit = false;
    HashSet<String> set = new HashSet<>();
    StringBuilder number = new StringBuilder();

    for (char c : chars) {
      if (digit) {
        if (!Character.isDigit(c)) {
          digit = false;
          set.add(number.toString().replaceFirst("^0+(?!$)", ""));
          number = new StringBuilder();
        } else {
          number.append(c);
        }
      } else {
        if (Character.isDigit(c)) {
          digit = true;
          number.append(c);
        }
      }
    }

    if(digit) {
      set.add(number.toString().replaceFirst("^0+(?!$)", ""));
    }

    return set.size();
  }

}
