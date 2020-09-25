public class RemoveElement {

  public static void main(String[] args) {
    System.out.println(new RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3));
  }

  public int removeElement(int[] nums, int val) {
    int last = nums.length - 1;

    while(last >= 0 && nums[last] == val) {
      last --;
    }

    for(int i = 0; i < last; i ++) {
      if(nums[i] == val) {
        int temp = nums[i];
        nums[i] = nums[last];
        nums[last] = temp;

        while(last >= 0 && nums[last] == val) {
          last --;
        }
      }
    }

    return last + 1;
  }

}
