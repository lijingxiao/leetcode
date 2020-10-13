# leetcode
- 1、两数之和：map做辅助，实现O(N)
- 2、两数相加：注意最后一个进位
- 3、无重复字符的最长子串：滑动窗口，可以使用map记录char的位置，left可以一步直接挪到其之后
- 4、寻找两个正序数组的中位数：二分思想，要考虑奇数和偶数情况，每次在两个数组中取第k/2个数，比较大小，较小的那个可以舍弃前面k/2的数据【因为中位数一定会比这个值大】
- 5、最长回文子串：动态规划 dp[i][j] = dp[i+1][j-1] && s[i]==s[j]；解法二，中心扩展法 分别以s[i]和s[i]s[j]为中心扩散找回文子串

- 9、回文数：统计出位数，然后双指针取左右边界的数判断是否回文
- 11、盛最多水的容器：贪心算法，双指针，移动较小的一个


- 17、电话号码的字母组合：九键的数字生成的字母组合，回溯问题，用map把数字对应的字符存储起来
- 19、删除链表的倒数第N个节点：快慢指针，快指针先走N步，注意删除第一个节点的情况，苏姚一个dummy节点

- 22、括号生成：回溯，分左括号和右括号

- 31、下一个排列：找到右边的第一个大数与前边的小数交换；1）从右向左找到第一个升序对[i,j]，2）从右向左找到第一个大于i的数k，并交换[i,k]，3）将[i+1,len-1]反转为升序，因为升序更小

- 39、组合总和：回溯，在一组数据中求和为target的组合，数字可以重复使用
- 40、组合总和 II：数字不能重复使用，但是有重复数据，先排序，再回溯，剪枝的时候和有重复数据的全排列（第47题）一样，需要一个flag数组，回退到以当前值作为重复数据的起点的时候需要剪枝

- 46、全排列：回溯问题，flag数组做标记
- 47、全排列 II：有重复数据，注意要先排序，需要剪枝，重复数据为部分路径起点的时候剪枝（也就是前面的相等元素没有遍历的时候）

- 49、异位词分组，就是把字母组成相同的字符串划分到一个组里：用一个容量为26的数组记录每个字符出现的次数，然后把数组的值作为key，相同的一组字符串作为value


- 76、最小覆盖子串：滑动窗口，map记录需要的字符个数，misscount记录还差几个字符，进行窗口边界调整
- 78、子集：典型的回溯问题，注意把空集加进去
- 90、子集 II：带重复数据的子集，回溯，在78题的基础上进行剪枝

- 94、二叉树的中序遍历：递归，迭代

- 102、二叉树的层序遍历


- 131、分割回文串：回溯，判断回文进行剪枝，for循环横向找切割点，dfs纵向找切割点，所以dfs的下一个位置是i+1


- 144、二叉树的前序遍历
- 145、二叉树的后序遍历：迭代实现中，只有当前值没有子节点或者pre是当前值的子节点的时候才能出栈

- 234、回文链表：快慢指针找中点，反转后半段，对比


- 617、合并二叉树：对应值相加，没有就是0

- 647、回文子串：和第5题一样，使用动态规划或者中心扩展法
