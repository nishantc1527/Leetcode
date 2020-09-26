import java.util.*;

public class Permutations {

  public static void main(String[] args) {
    System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
  }

  private List<List<Integer>> ans;

  public List<List<Integer>> permute(int[] nums) {
    ans = new ArrayList<>();
    ans(nums, 0, new LinkedList<>());
    return ans;
  }

  private void ans(int[] nums, int i, List<Integer> curr) {
    if(i >= nums.length) {
      ans.add(new LinkedList<>(curr));
      return;
    }

    for(int j = 0; j <= curr.size(); j ++) {
      curr.add(j, nums[i]);
      ans(nums, i + 1, curr);
      curr.remove(j);
    }
  }

}
