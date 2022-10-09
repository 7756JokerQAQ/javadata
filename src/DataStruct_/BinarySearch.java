package DataStruct_;

public class BinarySearch {
    //二分查找法
    public static int find(Comparable[]arr,Comparable target){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid].compareTo(target)<0){
                l=mid+1;
            }else if(arr[mid].compareTo(target)>0){
                r=mid-1;
            }
        }
        return -1;
    }
}
