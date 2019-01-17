package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by lijingxiao on 2018/12/10.
 *
 * 从前序的根节点分割中序序列，左边为左子树，右边为右子树
 *
 * 例如，给出
 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：
 3
 / \
 9  20
 /  \
 15   7
 */

public class construct_binary_tree_from_preorder_and_inorder_traversal {
    private static TreeNode build(int[] preorder, int lp, int rp, int[] inorder, int li, int ri) {
        if (lp > rp)
            return null;

        TreeNode root = new TreeNode(preorder[lp]);
        for (int i = li; i <= ri; i++) {
            if (preorder[lp] == inorder[i]) {
                root.left = build(preorder, lp + 1, lp + i-li, inorder, li, i-1);
                root.right = build(preorder, lp + i - li + 1, rp, inorder, i + 1, ri);
            }
        }
        return root;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || (preorder.length != inorder.length))
            return null;

        TreeNode ret = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return ret;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] ino = {9,3,15,20,7};
        TreeNode root = buildTree(pre, ino);
        TreeNode.printFromTopToBottom(root);
    }



}
