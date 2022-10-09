package DataStruct_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Josephus {

  public  int Josp(int N,int M){
      if(M==0){
          return N;
      }
      HashSet<Integer> temp = new HashSet<>();
        int count=N;

        while(count>1){
            int k=M%count;
            int clr=0;
            for (int i = 1; i < N+1; i++) {
                if(temp.contains(i)){
                    continue;
                }
                if(k-clr>0){
                    clr++;
                }
                if(k==clr){
                    clr=0;
                    temp.add(i);
                    break;
                }
            }
            count--;
        }
      for (int i = 1; i < N+1; i++) {
          if(!temp.contains(i)){
             return i;
          }
      }
        return 0;
  }

    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        System.out.println(josephus.Josp(3,33));
    }


}
