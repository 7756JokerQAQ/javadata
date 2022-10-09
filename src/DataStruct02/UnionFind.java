package DataStruct02;

public class UnionFind {
    private int[]id;
    //数据的个数
    private int count;
    public UnionFind(int n){
        count=n;
        id=new int[n];
        //初始化让每个id指向自己
        for (int i = 0; i < n; i++) {
            id[i]=i;
        }
    }
    //查找过程查找p元素对应的集合编号
    private int find(int p){
        assert p>=0&&p<count;
        return id[p];
    }
    //查看元素p和元素q是否属于一个集合
    //O(1)复杂度
    public boolean isConnection(int p,int q){
        return find(p)==find(q);
    }
    //合并元素p和元素q的集合
    //O(n)复杂度
    public void unionElement(int p,int q){
        int pID=find(p);
        int qID=find(q);
        if(pID==qID){
            return;
        }
        for (int i = 0; i < count; i++) {
            if(id[i]==pID){
                id[i]=qID;
            }
        }
    }

}
