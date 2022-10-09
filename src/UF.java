public interface UF {
    //设计两个接口 主要对其下标进行比较
    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);

}
