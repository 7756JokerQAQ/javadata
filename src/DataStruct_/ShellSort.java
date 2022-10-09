package DataStruct_;

public class ShellSort {
    public static void sort(Comparable[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                Comparable temp = arr[i];
                for (j = i; j >= gap && temp.compareTo(arr[j - gap]) < 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
