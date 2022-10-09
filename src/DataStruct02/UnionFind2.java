package DataStruct02;

public class UnionFind2 {
    private int parent[];
    private int count;
    public UnionFind2(int count){
        parent=new int[count];
        this.count=count;
        //初始化让自己指向自己
        for (int i = 0; i < count; i++) {
            parent[i]=i;
        }
    }
    //查找过程，查找元素p所对应的集合编号
    //O（h）复杂度h为树的高度
    private int find(int p){
        assert (p>=0&&p<count);
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while(p!=parent[p]){
            p=parent[p];
        }
        return p;
    }
    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }
    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    public void unionElements(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot){
            return;
        }
        parent[pRoot]=qRoot;
    }
}