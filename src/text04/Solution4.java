package text04;

import java.util.LinkedList;
import java.util.List;

public class Solution4 {
    public String findLongestWord(String s, List<String> dictionary) {
        int max = -2;
        List<String> ls = new LinkedList<>();
        int key = -9;
        for (String temp :
                dictionary) {
            max = Math.max(max, search(temp, s));
            //判断字母序是否最小
            if (max > key && max == temp.length()) {
                if (!ls.isEmpty()) {
                    ls.clear();
                }
                ls.add(temp);
                key = max;
            } else if (max == key&&max==temp.length()) {
                String q = ls.remove(0);
                boolean exchange = isExchange(q, temp);
                if (exchange) {
                    ls.add(temp);
                } else {
                    ls.add(q);
                }
            }
        }
        if (max == 0) {
            return "";
        }
        return ls.get(0);

    }

    public boolean isExchange(String s, String t) {
        int sum1=0,sum2=0;
        for (int i = 0; i < s.length(); i++) {
          sum1+= s.charAt(i)-'0';
          sum2+= t.charAt(i)-'0';
        }
        if(sum1<=sum2){
            return false;
        }else {
            return true;
        }
    }

    public int search(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if (n1 > n2) {
            return 0;
        }
        int result = 0;
        int pre = 0, cur = 0;
        while (pre < n1 && cur < n2) {
            if (s.charAt(pre) == t.charAt(cur)) {
                pre++;
            }
            if (pre == n1) {
                result = n1;
            }
            cur++;
        }
        return result;
    }
    //"aewfafwafjlwajflwajflwafj"
    //["apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"]

    public static void main(String[] args) {
        String s = "aewfafwafjlwajflwajflwafj";
        List<String> t = new LinkedList<>();
        t.add("awef");
        t.add("ewaf");
        Solution4 solution4 = new Solution4();
        solution4.findLongestWord(s, t);
    }
}
