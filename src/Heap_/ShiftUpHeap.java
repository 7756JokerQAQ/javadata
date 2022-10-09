package Heap_;

import DataStruct_.SortTestHelper;

public class ShiftUpHeap<T extends Comparable> {
    protected T[] data;
    protected int count;
    protected int capacity;

    public ShiftUpHeap(int capacity) {
        //这里加1是指原来能装的元素个数，那去掉0位，只能装capacity个元素 不包含第0号元素
        data = (T[]) new Object[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    //返回堆中的个数
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(T item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //最大堆的核心代码
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    //像堆中插入一个元素
    public void insert2(T item) {
        assert count + 1 <= capacity;
        count += 1;
        data[count] = item;
        shiftUp2(count);
    }

    private void shiftUp2(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    //从最大堆中取出栈顶元素，即堆中存储的最大值
    public T extractMax() {
        assert count > 0;
        T ret = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    public T getMax() {
        assert count > 0;
        return data[1];
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
        System.out.println("ShiftDown结束");
    }
// 再次基础上完成堆排序
    public ShiftUpHeap(T[]arr){
        int n=arr.length;
        data = (T[])new Comparable[n+1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i+1]=arr[i];
        }
        count=n;
        //从第一个不是叶子节点的元素开始
        for (int i = count/2; i >=1 ; i--) {
            shiftDown(i);
        }
    }
    public static void main(String[] args) {
        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        ShiftUpHeap<Integer> heapify = new ShiftUpHeap<>(arr);
        // 将heapify中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = heapify.extractMax();
            System.out.print(arr[i] + " ");
        }

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
    }

}
