package text04;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Solution2 {
    private  final  static String p="Push";
    private  final  static String r="Pop";
    public List<String> buildArray(int[] target, int n) {
        int []list=new int[n];
        List<String >res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list[i]=i+1;
        }
        int count=target.length;
        int k=0;
        int j=0;
        while (k<count&&j<n){
            res.add(p);
            if(target[k]==list[j]){
                k++;
            }else {
                res.add(r);
            }
            j++;
        }
        return res;

    }
}
