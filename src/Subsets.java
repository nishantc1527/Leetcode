import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static void main(String[] args) {
    System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < 1 << nums.length; i++) {
      List<Integer> curr = new ArrayList<>();
      int j = i;

      for (int num : nums) {
        if ((j & 1) == 1) {
          curr.add(num);
        }

        j >>= 1;
      }

      ans.add(curr);
    }

    return ans;
  }

}
