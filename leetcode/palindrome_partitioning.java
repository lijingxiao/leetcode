package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingxiao on 2019/1/10.
 */
public class palindrome_partitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        dfs(s, lists, tmp, 0);
        return lists;
    }

    private void dfs(String s, List<List<String>> lists, ArrayList<String> tmp, int index) {
        if (index == s.length()) {
            lists.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 1; i + index <= s.length(); i++) {
            String sub = s.substring(index, i + index);
            if (isPalin(sub)) {
                tmp.add(sub);
                dfs(s, lists, tmp, i+index);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    private boolean isPalin(String s) {
        if (s.length() == 1) return true;
        int l = 0, r = s.length()-1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        palindrome_partitioning p = new palindrome_partitioning();
        String  s = "aab";
        List<List<String>> list = p.partition(s);
//        List<List<String>> list = partition(s);
        for (int i = 0; i< list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
//        System.out.println(p.isPalin(s));
    }
}
