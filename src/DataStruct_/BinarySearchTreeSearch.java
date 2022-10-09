package DataStruct_;

public class BinarySearchTreeSearch <Key extends Comparable<Key>,Value>{
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
    public int size(){
        return count;
    }
    private boolean isEmpty(){
        return count==0;
    }
    public boolean contain(Key key){
        //从根开始查找
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
        }else {
            return  contain(node.right,key);
        }

    }
    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public Value search(Key key){
        //从根开始查找
        return search(root,key);
    }
    private Value search(Node node,Key key){
        if(node==null){
            return null;
        }
        if(key.compareTo(node.key)==0){
            return node.value;
        }else  if(key.compareTo(node.key)<0){
            return search(node.left,key);
        }else {
            return search(node.right,key);
        }
    }

}
