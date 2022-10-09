package DataMoXie;

public class BinarySearchTree <Key extends Comparable<Key>,Value>{
    //首先定义一个私有节点
    private class Node{
       private Key key;
       private Value value;
       private Node left,right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left=right=null;
        }
    }
    private Node root;
    private int count;

    public BinarySearchTree() {
        root=null;
        count=0;
    }
    //返回大小
    public int size(){
        return count;
    }
    //判断是否为空
    public boolean isEmpty(){
        return count==0;
    }
    //插入数据
    public void insert(Key key,Value value){
        root=insert(root,key,value);
    }
    private Node insert(Node node,Key key ,Value value){
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
}
