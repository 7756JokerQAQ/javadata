package DataStruct_;
@SuppressWarnings({"all"})
public class Quick3WaysSort {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sort(Comparable[] arr, int l, int r) {
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];
        //三路快速排序算法
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            //小的往前面来
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
                //高的往后面去
            } else if(arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            }else{
                i++;
            }
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }
}
