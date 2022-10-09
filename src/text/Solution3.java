package text;

import java.util.Arrays;
import java.util.Comparator;

class Solution3 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int len = nums2.length;
        Integer[] index = new Integer [len];
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            index[i] = i;
        }
        Arrays.sort(index , (a, b) -> (nums2[a] - nums2[b]));
        int l=0,r=len-1;

        for (int j = 0; j < len; j++) {
            if(nums1[j]>nums2[index[l]]){
                res[index[l]]=nums1[j];
                l++;
        }else{
                res[index[r]]=nums1[j];
                r--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //[12,24,8,32]
        //[13,25,32,11]
        int nums1[] = {12,24,8,32};
        int nums2[] = {13,25,32,11};
        //

        Solution3 solution3 = new Solution3();
       solution3.advantageCount(nums1,nums2);

    }
}
