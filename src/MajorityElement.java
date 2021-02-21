public class MajorityElement {

  public static void main(String[] args) {
    System.out.println(new MajorityElement().majorityElement(new int[]{-2147483648}));
  }

  public int majorityElement(int[] nums) {
    int count = 0;
    int candidate = 0;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }

      if(num == candidate) {
        count ++;
      } else {
        count --;
      }
    }

    return candidate;
  }

}
