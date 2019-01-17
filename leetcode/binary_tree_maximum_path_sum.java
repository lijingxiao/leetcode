package leetcode;

/**
 * Created by lijingxiao on 2018/12/19.
 *
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class binary_tree_maximum_path_sum {
    private static int maxSum;
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode root) {
        if (root == null)
            return 0;
        //左右子树和0比大小，如果是负数就舍弃
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);//每轮更新maxsum的大小，不一定会经过root，可能是任意一个子树
        return root.val + Math.max(left, right);//每次只能返回左子树或者右子树中较大的一个，否则会出现岔路
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ret = maxPathSum(root);
        System.out.println(ret);
    }
}
