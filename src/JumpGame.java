public class JumpGame {

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 0}));
    }

    public boolean canJump(int[] nums) {
        int farthest = 0;

        for(int i = 0; i < nums.length && i <= farthest; i ++) {
            farthest = Math.max(farthest, i + nums[i]);
        }

        return farthest >= nums.length - 1;
    }

}
