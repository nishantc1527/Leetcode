public class FindTheDuplicateNumber {

  public static void main(String[] args) {
    System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18}));
  }

  public int findDuplicate(int[] nums) {
    for(int i = 0; i < nums.length; i ++) {
      while(i != nums[i] - 1) {
        if (nums[nums[i] - 1] == nums[i]) {
          return nums[i];
        }

        swap(nums, i, nums[i] - 1);
      }
    }

    return -1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
