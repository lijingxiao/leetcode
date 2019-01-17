package leetcode;

/**
 * Created by lijingxiao on 2019/1/2.
 */
public class Trie {
    private class TrieNode {
        private TrieNode[] child;
        private boolean isWord;
        public TrieNode() {
            child = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;

        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.child[index] == null)
                cur.child[index] = new TrieNode();
            cur = cur.child[index];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        int i = 0;
        for (i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.child[index] == null)
                return false;
            cur = cur.child[index];
        }
        if (i == word.length() && cur.isWord == true)
            return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        int i = 0;
        for (i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.child[index] == null)
                return false;
            cur = cur.child[index];
        }
        if (i == prefix.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}
