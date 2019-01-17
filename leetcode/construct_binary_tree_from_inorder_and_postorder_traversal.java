package leetcode;


/**
 * Created by lijingxiao on 2018/12/10.
 *
 * 从后序序列中取出最后一个为root，对中序序列进行分割，左边为左子树，右边为右子树
 *
 * 例如，给出
 中序遍历 inorder = [9,3,15,20,7]
 后序遍历 postorder = [9,15,7,20,3]
 返回如下的二叉树：
 3
 / \
 9  20
 /  \
 15   7
 */

public class construct_binary_tree_from_inorder_and_postorder_traversal {
    private static TreeNode build(int[] inorder, int[] postorder, int li, int ri, int lp, int rp) {
        if (lp > rp)
            return null;
        TreeNode root = new TreeNode(postorder[rp]);
        for (int i = li; i <= ri; i++) {
            if (inorder[i] == postorder[rp]) {
                root.left = build(inorder, postorder, li, i - 1, lp, lp + i-li - 1);
                root.right = build(inorder, postorder, i + 1, ri, lp + i - li, rp - 1);
            }
        }
        return root;
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || (inorder.length != postorder.length))
            return null;

        TreeNode root = build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        TreeNode root = buildTree(in, post);
        TreeNode.printFromTopToBottom(root);
    }
}
