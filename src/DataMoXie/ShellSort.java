package DataMoXie;

public class ShellSort {
    public static void sort(Comparable[] arr) {
        for (int gap=arr.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if(arr[j].compareTo(arr[j+gap])>0){
                        Object temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]= (Comparable) temp;
                    }
                }
            }
        }

    }
}
