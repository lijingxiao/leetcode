package leetcode;

/**
 * Created by lijingxiao on 2018/12/18.
 */
public class maximum_depth_of_binary_tree {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftlen = maxDepth(root.left);
        int rightlen = maxDepth(root.right);
        return leftlen > rightlen ? leftlen + 1 : rightlen + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        int len = maxDepth(root);
        System.out.println(len);
    }
}
