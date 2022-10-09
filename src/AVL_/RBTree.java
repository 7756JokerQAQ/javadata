package AVL_;

@SuppressWarnings({"all"})
public class RBTree<K extends Comparable<K>, V> {
    private static final boolean BLACK = false;
    private static final boolean RED = true;

    private class Node {

        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }




    private boolean isRed(Node node) {
        if (node == null)  //主要规避null叶子节点
            return BLACK;
        return node.color;
    }

    //     node                             x
    //     /   \        左旋转              /   \
    //    T1    x       ---->           node    T3
    //         /  \                     /   \
    //          T2  T3                  T1    T2

    private Node leftRotate(Node node) {
        //左旋转
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /*           node                           x
                /    \     右旋转               /  \
               x      T2  --------->          y    node
              / \                                  /   \
             y   T1                                T1   T2
     */
    //右旋转
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //像红黑树中添加新的元素
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }

    //颜色翻转
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    //向以node为根的红黑树中插入新的元素
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);  //默认插入一个红色的节点
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        //红黑树的维护过程
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }







    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else
            return getNode(node.right, key);
    }







    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;

    }








    //删除掉以node为根的二分搜索树中键为key的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }








    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }






    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }







    public boolean contains(K key) {
        return getNode(root, key) != null;
    }






    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }






    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.value = newValue;
    }
}

