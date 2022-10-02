package text07;

import java.util.Arrays;


class Solution2 {
    public String[] findRelativeRanks(int[] score) {
        int max = Arrays.stream(score).max().getAsInt();
        int[] target = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            target[i] = -1;
        }
        for (int i = 0; i < score.length; i++) {
            target[score[i]] = i;
        }
        String[] res = new String[score.length];
        int count = 2;
        String m1 = "Gold Medal", s2 = "Silver Medal", s3 = "Bronze Medal";
        res[target[max]] = m1;
        int r = 4;
        for (int i = max - 1; i >= 0; i--) {
            if (target[i] != -1) {
                if (count == 0) {
                    res[target[i]] = Integer.toString(r);
                    r++;

                } else if (count == 2) {
                    res[target[i]] = s2;
                    count--;
                } else if (count == 1) {
                    res[target[i]] = s3;
                    count--;
                }
            }
        }
        return res;

    }
}
