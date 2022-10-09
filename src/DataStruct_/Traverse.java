package DataStruct_;

import java.util.LinkedList;

public class Traverse<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    //默认构造函数
    private Node root;
    private int count;

    public Traverse() {
        root=null;
        count=0;
    }
    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }
    // 向二分搜索树中插入一个新的(key, value)数据对
    public void insert(Key key,Value value){
        insert(root,key,value);
    }
    private Node insert(Node node,Key key,Value value){
        if(node==null){
            count++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key)==0){
            node.value=value;
        }else if(key.compareTo(node.key)<0){
            node.left=insert(node.left,key,value);
        }else {
            node.right=insert(node.right,key,value);
        }
        return node;
    }

    // 查看二分搜索树中是否存在键key
    public boolean contain(Key key){
        return contain(root,key);
    }
    private boolean contain(Node node,Key key){
        if(node==null){
            return false;
        }
        if(key.compareTo(node.key)==0){
            return true;
        }else if(key.compareTo(node.key)<0){
            return contain(node.left,key);
        }
        else {
            return  contain(node.right,key);
        }
    }
    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public Value search(Key key){
        return search( root , key );
    }
    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    private Value search(Node node, Key key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) == 0 )
            return node.value;
        else if( key.compareTo(node.key) < 0 )
            return search( node.left , key );
        else // key > node->key
            return search( node.right, key );
    }

    //二叉树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }
    //二叉树的中序遍历
    public  void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }
    //二叉树的后序遍历
    public void afterOrder(){
        afterOrder(root);
    }
    private void afterOrder(Node node){
        if(node==null){
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.key);
    }

    //二叉树的层序遍历
    public  void levelOrder(){
        //我们需要使用一个LinkList来作为队列
        LinkedList<Node>q =new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node node=q.remove();
            System.out.println(node.key);
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
    }

}
