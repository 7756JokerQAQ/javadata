package DataStruct_;

public class QuickSort {
    public static void sort(Comparable[]arr){
        sort(arr,0,arr.length-1);
    }
    private static void sort(Comparable[]arr,int l,int r){
        if(l>=r){
            return;
        }
        int mid=partition(arr,l,r);
        sort(arr,l,mid-1);
        sort(arr,mid+1,r);

    }

    private static int partition(Comparable[]arr,int l,int r){
        //首先随机选择一个在[l,r]的范围中，选择一个数值作为标定点
        swap(arr,l,(int)(Math.random()*(r-l+1))+l);
        Comparable v=arr[l];
        int j=l;
        for (int i = l+1; i <=r ; i++) {
            if(arr[i].compareTo(v)<0){
               j++;
               swap(arr,j,i);
            }
        }
        //  v      i
        swap(arr,l,j);
        return j;
    }
    private static void swap(Object[]arr,int i,int j){
        Object temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
