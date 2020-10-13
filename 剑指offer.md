- 33、二叉搜索树的后序遍历序列：判断一个数组是不是bst的后序遍历，dfs根据left<root<right的特征判断
```java
  public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length < 2){return true;}
        return judge(postorder, 0, postorder.length-1);
    }
    private boolean judge(int[] postorder, int left, int right) {
        if (left >= right){return true;}
        int root = postorder[right];
        int pos = left;
        while (pos < right){//找到右子树起始
            if (postorder[pos] > root){break;}
            pos++;
        }
        for (int i = pos; i < right; i++) {//右子树中有比root小的节点
            if (postorder[i] < root){return false;}
        }
        return judge(postorder, left, pos-1) && judge(postorder, pos, right-1);
    }
```
