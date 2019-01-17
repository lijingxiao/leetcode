package leetcode;

/**
 * Created by lijingxiao on 2018/12/18.
 *
 * 二叉搜索树中的两个节点被错误地交换。
 请在不改变其结构的情况下，恢复这棵树。
 */
public class recover_binary_search_tree {
    private static TreeNode first;
    private static TreeNode second;
    private static TreeNode pre;
    private static int last;

    /**
     * 找到两个被交换的节点，会出现两个反序
     * INT_MIN, 4, 2, 3, 1, 5

     第一次出现反序，是前面的节点有问题，第二次出现反序是后面的节点有问题
     有可能会出现只有两个节点的情况，所以第一次就记录second的值，后面不断更新

     * @param root
     */
    private static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (root.val < last) {
            if (first == null)
                first = pre;
            second = root;
        }
        pre = root; //记录当前节点的前一个节点，为了出现反序的时候能够找到前面的值
        last = root.val;//记录当前节点的前一个节点的值
        inorder(root.right);
    }
    public static void recoverTree(TreeNode root) {
        first = null;
        second = null;
        pre = null;
        last = Integer.MIN_VALUE;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        TreeNode.printFromTopToBottom(root);
        System.out.println("----------------------------------------");
        recoverTree(root);
        TreeNode.printFromTopToBottom(root);
    }

}
