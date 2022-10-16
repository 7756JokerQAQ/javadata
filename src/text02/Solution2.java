package text02;

public class Solution2 {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        }
        int n = nums.length;
        String s1 = String.valueOf(nums[0]);
        s1 += "/(";
        for (int i = 1; i < n - 1; i++) {
            String s = String.valueOf(nums[i]);
            s1 += s + "/";
        }
        s1 += String.valueOf(nums[n-1]);
        s1 += ")";
        return s1;
    }

}
