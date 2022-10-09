package Heap_;

public class ShiftDownHeap <T extends Comparable>{
    protected T[]data;
    protected int count;
    protected int capacity;
//只能取出根节点
    //第一步，我们将数组最后一位数组放到根节点，此时不满足最大堆的定义
    //调整的过程是将这个根节点 16 一步一步向下挪，16 比子节点都小，先比较子节点 52 和 30 哪个大，和大的交换位置。
    //继续比较 16 的子节点 28 和 41，41 大，所以 16 和 41 交换位置。

    public ShiftDownHeap(int capacity) {
        data=(T[])new Object[capacity+1];
        this.capacity = capacity;
        count=0;
    }
    //返回堆中的个数
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }


}
