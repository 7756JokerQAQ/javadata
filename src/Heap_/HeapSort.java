package Heap_;

/**
 * 原地堆排序
 * @param <T>
 */
public class HeapSort <T extends Comparable>{

    public static void sort(Comparable[]arr){
        int n=arr.length;

        //从最后一个元素-1  除2的位置开始
        for(int i=(n-2)/2;i>=0;i--){
            shiftDown(arr,n,i);
        }
        for (int i = n-1; i > 0; i--) {
            swap(arr,0,i);
            shiftDown(arr,i,0);
        }
    }
    public static void swap(Object[]arr,int i,int j){
        Object temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void shiftDown(Comparable[]arr,int n,int k){
        while(2*k+1<n){
            int j=2*k+1;
            //右孩子比左孩子大
            if(j+1<n&&arr[j+1].compareTo(arr[j])>0){
                j+=1;
            }
            //比两个孩子节点都大
            if(arr[k].compareTo(arr[j])>=0){
                break;
            }
            //交换原节点和孩子的值
            swap(arr,k,j);
            k=j;
        }
    }

    public static void main(String[] args) {
        Comparable []arr={15,17,19,13,22,16,28,30,41,62};
        HeapSort.sort(arr);

    }

}
