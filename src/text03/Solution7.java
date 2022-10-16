package text03;

public class Solution7 {
    public int compareVersion(String version1, String version2) {
        String[] res1 = version1.split("\\.");
        String[] res2 = version2.split("\\.");
        int n = Math.max(res1.length, res2.length);
        String[] temp1 = new String[n];
        String[] temp2 = new String[n];
        for (int i = 0; i < n; i++) {
            if (i < res1.length) {
                temp1[i] = res1[i];
            }else {
                temp1[i]="0";
            }
            if (i < res2.length) {
                temp2[i] = res2[i];
            }else {
                temp2[i]="0";
            }
        }
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(temp1[i])==Integer.parseInt(temp2[i])){
                continue;
            }else if (Integer.parseInt(temp1[i]) > Integer.parseInt(temp2[i])) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        String s1 = "1.0";
        String s2 = "1.0.0";
        Solution7 solution7 = new Solution7();
        solution7.compareVersion(s1, s2);

    }
}
