package text07;

import java.util.Arrays;

public class Solution {
    public int[] decrypt(int[] code, int k) {

        int n=code.length;
        int []res=new int[n];
        if(k>0){
            for (int i = 0; i < n; i++) {
                int q=0;
                int sum=0;
                while(q<k){
                    sum+=code[(i+1+q)%(n)];
                    q++;
                }
                res[i]=sum;
            }
        }

        if(k<0){
            for (int i = 0; i < n; i++) {
                int q=k;
                int sum=0;
                while(q<0){
                    //i=0  k=-2  pre=3
                    sum+=code[(i-q+1)%(n)];
                    q++;
                }
                res[i]=sum;
            }

        }
        return res;
    }
}
