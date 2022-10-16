package text04;

public class Solution3 {
    public boolean isSubsequence(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        if(n1==0){
            return true;
        }
        if(n1>n2){
            return false;
        }
        boolean result=false;
        int pre=0,cur=0;
        while (pre<n1&&cur<n2){
            if(s.charAt(pre)==t.charAt(cur)){
                pre++;
               // cur++;
            }
            if(pre==n1){
                result=true;
            }
            cur++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s1="bcd";
        String  s2="aabcd";
        Solution3 solution3 = new Solution3();
        System.out.println( solution3.isSubsequence(s1,s2));
    }
}
