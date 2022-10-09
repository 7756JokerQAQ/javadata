package CountingSort;

public class Solution {
    public int longestDecomposition(String text) {
/*
        int count = 0;
        int i = 0;
        String p = "" + text.charAt(i);
        String q = "" + text.charAt(text.length() - 1 - i);
        while (i <= text.length() - 1 - i) {
            if (p.compareTo(q) == 0) {
                count++;
                p = "";
                q = "";
            }
            i++;
            p += text.charAt(i);
            q = text.charAt(text.length() - 1 - i) + q;
        }

        return 2 * count + 1;*/

        return solve(text, 0, text.length() - 1);

    }

    private int solve(String s, int left, int right) {
        if (left > right) return 0;
        for (int i = left, j = right; i < j; i++, j--) {
            //判断s[left i]？=s[j right]
            if (equal(s, left, i, j, right)) {
                return 2 + solve(s, i + 1, j - 1);
            }
        }
        return 1;
    }

    private boolean equal(String s, int l1, int r1, int l2, int r2) {
        for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}