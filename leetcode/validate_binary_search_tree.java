package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/17.
 *
 * 输入:
 5
 / \
 1   4
 / \
 3   6
 输出: false
 解释: 输入为: [5,1,4,null,null,3,6]。
 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class validate_binary_search_tree {
    /**
     * 边界检测，不使用MIN和MAX，而是在遍历的过程中记录最大最小值，没有的时候用null代替
     * @param root
     * @param left
     * @param right
     * @return
     */
    private static boolean check(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null)
            return true;

        if (left != null && root.val <= left.val)
            return false;
        if (right != null && root.val >= right.val)
            return false;
        return check(root.left, left, root) && check(root.right, root, right);
    }
    public static boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;
        return check(root, null, null);
    }

    /**
     * 中序遍历法
     * @param root
     * @param list
     * @return
     */
    private static List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return list;

        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right, list);
        }
        return list;
    }
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> inorder = inorder(root, list);
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) <= list.get(i-1))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

//        //[10,5,15,null,null,6,20]
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(20);

        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> inorder = inorder(root, list);
        System.out.println(inorder);

//        boolean ret = isValidBST(root);
        boolean ret = isValidBST2(root);
        System.out.println(ret);
    }
}
