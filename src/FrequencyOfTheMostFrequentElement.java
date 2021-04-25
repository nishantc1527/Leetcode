import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

  public static void main(String[] args) {
    System.out.println(new FrequencyOfTheMostFrequentElement().maxFrequency(new int[]{1, 2, 4}, 5));
  }

  public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int ans = 0;
    double previousNums = 0;
    long currentSum = 0;

    for (int i = 0; i < nums.length; ++i) {
      while ((currentSum + k) / previousNums < nums[i]) {
        currentSum -= nums[(int) (i - previousNums)];
        previousNums--;
      }

      ans = (int) Math.max(ans, previousNums + 1);
      currentSum += nums[i];
      previousNums++;
    }

    return ans;
  }

}
