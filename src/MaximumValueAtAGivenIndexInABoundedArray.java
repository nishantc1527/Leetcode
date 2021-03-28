public class MaximumValueAtAGivenIndexInABoundedArray {

  public static void main(String[] args) {
    System.out.println(new MaximumValueAtAGivenIndexInABoundedArray().maxValue(4, 2, 6));
  }

  public int maxValue(int n, int index, int maxSum) {
    index ++;

    if (index > n / 2) {
      index = n - index + 1;
    }

    long lo = 1, hi = maxSum;

    while (lo <= hi) {
      long mid = lo + (hi - lo) / 2;

      if (isInLimit(mid, n, index, maxSum)) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return (int) hi;
  }

  private boolean isInLimit(long max, int n, int index, int maxSum) {
    if (max > maxSum) {
      return false;
    }

    long sum = 0, min = 1, extra = 0;

    if (max > index) {
      min = max - index + 1;
    } else {
      extra = index - max;
    }

    sum += (max - min + 1) * (max + min) / 2;
    sum += extra;
    index = n - index + 1;

    if (max > index) {
      min = max - index + 1;
    } else {
      min = 1;
      extra = index - max;
    }

    max --;
    sum += (max - min + 1) * (max + min) / 2 + extra;

    if(sum <= maxSum) {
      return true;
    } else {
      return false;
    }
  }

}
