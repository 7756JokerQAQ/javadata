package DataStruct_;

import com.sun.javafx.sg.prism.NodeEffectInput;

public class BinarySearchTreeInsert<Key extends Comparable<Key>, Value> {
    //首先定义私有的树的节点
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            left = right = null;
        }
    }

    //定义根节点
    private Node root;
    //定义树的节点个数
    private int count;
    //构造函数实现一个默认的二叉树


    public BinarySearchTreeInsert() {
        root = null;
        count = 0;
    }

    //返回二叉树的大小
    public int size() {
        return count;
    }

    //判断树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向二分搜索树中插入一个新的(key, value)数据对
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    //核心代码---开始
    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    public Node insert(Node node, Key key, Value value) {
        //如果树为空 直接在根节点插入
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0) {
            node.val = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;

    }

}
