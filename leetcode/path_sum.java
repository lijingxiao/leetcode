package leetcode;

/**
 * Created by lijingxiao on 2018/12/19.
 *
 * 注意，树为null的时候，不管sum是不是0，都是false
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class path_sum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val)
                return true;
            else
                return false;
        }
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(5);
        root.right.left = new TreeNode(13);

        int sum = 22;
        boolean ret = hasPathSum(root, sum);
        System.out.println(ret);
    }
}
