public class MajorityElement {

  public static void main(String[] args) {
    System.out.println(new MajorityElement().majorityElement(new int[]{-2147483648}));
  }

  public int majorityElement(int[] nums) {
    int res = 0;

    for(int i = 0; i < 32; i ++) {
      int zeroes = 0, ones = 0;

      for(int num : nums) {
        if(((num >> i) & 1) == 0) {
          zeroes ++;
        } else {
          ones ++;
        }
      }

      if(ones > zeroes) {
        res |= (1 << i);
      }
    }

    return res;
  }

}
