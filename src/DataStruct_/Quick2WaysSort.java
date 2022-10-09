package DataStruct_;

public class Quick2WaysSort {
    public static void sort(Comparable[]arr){
        sort(arr,0,arr.length-1);
    }
    private static void sort(Comparable[]arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int mid=partition(arr,l,r);
        sort(arr,l,mid-1);
        sort(arr,mid+1,r);

    }
    private static int partition(Comparable[]arr,int l,int r){
        //接着首先选择一个随机点作为标记值
        swap(arr,l,(int)(Math.random()*(r-l+1)+l));
        Comparable v=arr[l];
        //双路快速排序
        int i=l+1,j=r;
        while (true){
            //对左边开始寻找只要出现当前的值大于v 就记录 将v作为一个分界线
            while (i<=r&&arr[i].compareTo(v)<0){
                i++;
            }
            //对右边开始寻找只要出现当前的值小于v 就记录
            while (j>=l+1&&arr[j].compareTo(v)>0){
                j--;
            }
            if(i>j){
                break;
            }
            //直接对记录的两个值进行交换
            swap(arr,i,j);
            i++;
            j--;
        }
        //最后进行一次交换
        swap(arr,l,j);
        return j;

    }
    private static void swap(Object[]arr,int i,int j){
        Object temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
