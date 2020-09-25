import utils.TreeNode;

public class SymmetricTree {

  public static void main(String[] args) {
    System.out.println(new SymmetricTree().isSymmetric(new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
  }

  public boolean isSymmetric(TreeNode root) {
    return ans(root, root);
  }

  private boolean ans(TreeNode left, TreeNode right) {
    if(left == null && right == null) {
      return true;
    }

    if(left == null || right == null) {
      return false;
    }

    return left.val == right.val && ans(left.left, right.right) && ans(left.right, right.left);
  }

}
