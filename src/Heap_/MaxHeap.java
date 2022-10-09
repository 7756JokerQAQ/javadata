package Heap_;

public class MaxHeap <T>{
    private T[] data;
    private int count;
    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data=(T[])new Object[capacity+1];
        count=0;
    }
    // 返回堆中的元素个数
    public int size(){
        return count;
    }
    // 返回一个布尔值, 表示堆中是否为空
    public  boolean isEmpty(){
        return count==0;
    }
}
