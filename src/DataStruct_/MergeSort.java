package DataStruct_;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }

    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        //初始化i指向左前半部分的起始索引位置l，j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - 1];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }

        }
    }

    public static void main(String[] args) {
        Comparable[] nums = {-1, 2, -8, -10};          //给定一个数组
        MergeSort.sort(nums);       //的带排序后的数组
        System.out.println(Arrays.toString(nums)); //打印输出得到数组
    }
}
