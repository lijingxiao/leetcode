package leetcode;

/**
 * Created by lijingxiao on 2018/12/24.
 * 1~n 可以构造几个不同的二叉搜索树
 *以根节点k为界，分成左右两个子树，那么以k为根节点的BST的数目=左子树可能的数目×右子树可能的数目
 *比如n=5，当根节点是2时，左子树只能是1，只有1种可能，而右子树包含3,4,5这3个元素，有5种可能，
 *那么n=5并且以2为根节点的BST的数目 = 1 × 5 = 5，
 *而n=5时所有的BST的数目等于各个元素为根节点时的数目之和
 * 动态规划：d[i] = sum{d[j] * d[i-j-1]}
 * d[5] = d[0]*d[4] + d[1]*d[3] + d[2]*d[2] + d[3]*d[1] + d[4]*d[0]
 */
public class unique_binary_search_trees {
    public static int numTrees(int n) {
        int[] d = new int[n+1];
        d[0] =1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                d[i] += d[j] * d[i-j-1];
            }
        }
        return d[n];
    }

    public static void main(String[] args) {
        int n = 3;
        int trees = numTrees(n);
        System.out.println(trees);
    }
}
