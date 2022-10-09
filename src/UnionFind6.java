import java.util.Arrays;

public class UnionFind6 implements UF {
    private int[] parent;
    private int[] rank;  //sz[i]表示以i为根的集合中元素的个数

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //find的递归实现
    private int find(int p) {
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");
        if (p != parent[p]) {
            //路径压缩
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    //判断p和q是否在同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        //根据两个元素所在树的rank不同判断合并的方向
        //将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }
}
