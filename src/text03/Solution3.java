package text03;

public class Solution3 {
    public int myAtoi(String s) {
        int sign=1;
        boolean isZero=true;
        boolean exitt=false;
        String result="";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)-'0'<=9&&s.charAt(i)-'0'>=0){
                if(isZero){
                    continue;
                }
                isZero=false;
                result+=s.charAt(i);
                exitt=true;

            }else if(s.charAt(i)=='-'){
                sign*=-1;
            }
            if(exitt){
                break;
            }
        }
      if((long)Integer.parseInt(result)*sign>Integer.MAX_VALUE){
          return Integer.MAX_VALUE;
      }else  if((long)Integer.parseInt(result)*sign<Integer.MIN_VALUE){
          return Integer.MIN_VALUE;
      }

      return Integer.parseInt(result)*sign;
    }

    public static void main(String[] args) {
String s = "42";
        Solution3 solution3 = new Solution3();
        solution3.myAtoi(s);

    }
}
