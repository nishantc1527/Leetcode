public class SumOfDigitsInBaseK {

  public static void main(String[] args) {
    System.out.println(new SumOfDigitsInBaseK().sumBase(34, 6));
  }

  public int sumBase(int n, int k) {
    int sum = 0;

    while(n > 0) {
      int digit = n % k;

      sum += digit;
      n /= k;
    }

    return sum;
  }

}
