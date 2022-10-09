package text;

import java.util.Stack;

public class Solution4 {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        //  "(()(()))"
        //
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
       //需要谈弹两次
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='('){
                stack.push(0);
            }else{
               int k= stack.pop();
               int top=stack.pop()+Math.max(2*k,1);
               stack.push(top);
            }
        }
        return stack.peek();
    }
    public int scoreOfParentheses2(String s) {
        int bal = 0, n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << bal;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s="(()(()))";
        Solution4 solution4 = new Solution4();
        solution4.scoreOfParentheses(s);
        solution4.scoreOfParentheses2(s);
    }
}
