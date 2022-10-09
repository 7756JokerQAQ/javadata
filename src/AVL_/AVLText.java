package AVL_;

public class AVLText <K extends Comparable<K>>{
    private class Node{
        public K keys;
        public Node left,right;
        public int  height;

        public Node(K keys) {
            this.keys = keys;
            left=null;
            right=null;
            height=1;
        }
    }
    private Node root;
    private int size;

    public AVLText() {
        root=null;
        size=0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void add(K key){
        root=add(root,key);
    }
    private Node add(Node node,K key){
    if(node==null){
        size++;
        return new Node(key);
    }
    if(key.compareTo(node.keys)<0)
        node.left=add(node.left,key);
    else if(key.compareTo(node.keys)>0)
        node.right=add(node.right,key);
    return node;
    }
    private Node getNode(Node node,K key){
        if(node==null){
            return null;
        }
        if(key.compareTo(node.keys)==0){
            return node;
        }
        else if(key.compareTo(node.keys)<0){
            return getNode(node.left,key);
        }
        else
            return getNode(node.right,key);
    }

    public boolean contains(K key){
        return getNode(root,key)!=null;
    }
    private Node minimum(Node node){
    if(node.left==null){
        return node;
    }
    return minimum(node.left);
    }

    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }
    public K remove(K key){
        Node node=getNode(root,key);
        if(node!=null){
            root=remove(root,key);
            return node.keys;
        }
        return null ;
    }
private Node remove(Node node,K key){
        if(node==null){
            return null;
        }
        if(key.compareTo(node.keys)<0){
            node.left=remove(node.left,key);
            return node;
        }else if(key.compareTo(node.keys)>0){
            node.right=remove(node.right,key);
            return node;
        }else{
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //待删除节点左右均不为空的情况下
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
}
    public void set(K key){
        Node node=getNode(root,key);
        if(node==null){
            throw new IllegalArgumentException(key+"doesn't exist");
        }
        node.keys=key;
    }

}
