package text07;

import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        String []temp=new String[size];
        timePoints.toArray(temp);
        int []IntRes=new int[size];
        for (int i = 0; i < size; i++) {
            String  []t=new String[2];
            t= temp[i].split(":");
            int hour =(int) Integer.valueOf(t[0]);
            int second =(int) Integer.valueOf(t[1]);
            IntRes[i]=hour*60+second;
        }
         Arrays.sort(IntRes);
        int min=100000;
        for (int i = 0; i +1 < size; i++) {
            min=Math.min(min,IntRes[i+1]-IntRes[i]);
        }
        return Math.min(min,(IntRes[0]-IntRes[size-1]+60*24));
    }

    public static void main(String[] args) {
        String a="01";
        int i = Integer.valueOf(a).intValue();
        System.out.println(i);
    }

}
