import java.util.Arrays;

public class MinimumNumberOfOperationsToReinitalizeAPermutation {

  public static void main(String[] args) {
    System.out.println(new MinimumNumberOfOperationsToReinitalizeAPermutation().reinitializePermutation(4));
  }

  public int reinitializePermutation(int n) {
    int[] perm = new int[n];

    for (int i = 0; i < n; i++) {
      perm[i] = i;
    }

    int[] arr = perm.clone();
    int[] orig = perm.clone();
    int count = 0;

    do {
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          arr[i] = perm[i / 2];
        } else {
          arr[i] = perm[n / 2 + (i - 1) / 2];
        }
      }

      perm = arr.clone();
      count ++;
    } while(!Arrays.equals(arr, orig));

    return count;
  }

}
