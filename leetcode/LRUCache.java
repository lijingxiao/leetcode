package leetcode;

import java.util.HashMap;

/**
 * Created by lijingxiao on 2019/1/8.
 */
public class LRUCache {
    private class Node {
        int key;
        int value;
        Node pre;
        Node next;
        Node(int k, int v) {
            this.key = k;
            this.value = v;
            this.pre = null;
            this.next = null;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int maxcap;
    int curcap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.maxcap = capacity;
        this.curcap = 0;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            delNode(node);
            addNode(node);
            return node.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            if (curcap == maxcap) {//要加新节点，且已经满了,要先把尾部节点删掉
                Node pre = tail.pre;
                delNode(pre);
                map.remove(pre.key);
            } else
                curcap ++;
            map.put(key, node);
            addNode(node);
        } else {
            Node node = map.get(key);
            node.value = value;//可能会更新值
            delNode(node);
            addNode(node);
        }
    }

    private void delNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void addNode(Node node) {
        Node next = this.head.next;
        this.head.next = node;
        node.next = next;
        node.pre = this.head;
        next.pre = node;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        System.out.println(cache.get(2));
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

        cache.put(2, 1);
        cache.put(2, 2);
//        cache.get(2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
//        cache.get(2);
        System.out.println(cache.get(2));
    }
}
