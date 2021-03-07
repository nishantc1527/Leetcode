import java.util.Arrays;
import java.util.HashMap;

public class ClosestDessertCost {

  public static void main(String[] args) {
    System.out.println(new ClosestDessertCost().closestCost(new int[]{3, 10}, new int[]{2, 5}, 9));
  }

  private int ans = Integer.MAX_VALUE;

  public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
    ans = Integer.MAX_VALUE;

    for (int baseCost : baseCosts) {
      int[] counts = new int[toppingCosts.length];
      Arrays.fill(counts, 2);
      checkBaseCost(toppingCosts, target, 0, counts, baseCost);
    }

    return ans;
  }

  public void checkBaseCost(int[] toppingCosts, int target, int index, int[] counts, int sum) {
    if (index >= toppingCosts.length) {
      return;
    }

    if (Math.abs(target - sum) == Math.abs(target - ans)) {
      ans = Math.min(ans, sum);
    }

    if (Math.abs(target - sum) < Math.abs(target - ans)) {
      ans = sum;
    }

    if (sum > target) {
      return;
    }

    if (counts[index] > 0) {
      counts[index] --;
      checkBaseCost(toppingCosts, target, index, counts, sum + toppingCosts[index]);
      counts[index] ++;
    }

    checkBaseCost(toppingCosts, target, index + 1, counts, sum);
  }

}
