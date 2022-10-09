package SubStringMatch;

public class SubstringMatch {
    private SubstringMatch() {
    }

    //在s中寻找t并返回匹配的第一个索引i如果没有找到返回-1
    public static int bruteforce(String s, String t) {
        for (int i = 0; i + t.length() - 1 < s.length(); i++) {
            int j = 0;
            for (; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1="hello, this is liuyubobobo";
        String t1="bo";
        System.out.println(SubstringMatch.bruteforce(s1,t1));
    }
}
