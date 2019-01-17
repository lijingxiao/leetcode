package leetcode;

/**
 * Created by lijingxiao on 2019/1/15.
 */
public class convert_sorted_array_to_binary_search_tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return dfs(nums, 0, nums.length - 1);
    }
    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l < 0 || r > nums.length-1) return null;
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid-1);
        root.right = dfs(nums, mid+1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] num = {-10,-3,0,5,9};
        convert_sorted_array_to_binary_search_tree conv = new convert_sorted_array_to_binary_search_tree();
        TreeNode root = conv.sortedArrayToBST(num);
        TreeNode.printFromTopToBottom(root);
    }
}
