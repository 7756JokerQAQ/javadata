package text03;

import java.util.Arrays;


public class Solution4 {
    public int romanToInt(String s) {
        //解法一
      /*  int []temp=new int[s.length()];

        for (int i = 0; i+1 < s.length(); i++) {
            if(getValue(s.charAt(i))>getValue(s.charAt(i+1))){
                temp[i]=getValue(s.charAt(i));
            }else {
                 temp[i]=-1*getValue(s.charAt(i));
            }
        }
        temp[s.length()-1]=getValue(s.charAt(s.length()-1));
        return Arrays.stream(temp).sum();*/

        //解法二
        s=s.replace("IV","a");
        s=s.replace("IX","b");
        s=s.replace("XL","c");
        s=s.replace("XC","d");
        s=s.replace("CD","e");
        s=s.replace("CM","f");
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            sum+=getValue(s.charAt(i));
        }
        return sum;
    }

    private int getValue(char s){
        switch (s){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default:  return 0;
        }
    }

    public static void main(String[] args) {
        String s="MCMXCIV";
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.romanToInt(s));
    }
}
