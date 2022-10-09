package text;

import java.util.*;

public class Solution2 {
    public int[] advantageCount(int[] nums1, int[] nums2) {

        int[] idNums2 = nums2.clone();
        int[] idNums1 = nums1.clone();
        Arrays.sort(idNums1);
        Arrays.sort(idNums2);

        LinkedList<Integer> nums11 = new LinkedList<>();
        LinkedList<Integer> nums22 = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            nums11.add(idNums1[i]);
            nums22.add(idNums2[i]);
        }
        IdentityHashMap<Integer, Integer> res = new IdentityHashMap<>();

        while (nums11.peek() != null) {
            int k;
            if (nums11.peek() > nums22.peek()) {
                k = nums22.pop();
            } else {
                k = nums22.removeLast();
            }
            res.put(k, nums11.pop());
        }


        int result[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = res.get(nums2[i]);
        }
        return result;

    }

    public static void main(String[] args) {
        //[12,24,8,32]
        //[13,25,32,11]
        int nums1[] = {2, 0, 2, 2, 4};
        int nums2[] = {2, 0, 2, 1, 4};

        Solution2 solution2 = new Solution2();
        solution2.advantageCount(nums1, nums2);

        Integer integer = new Integer(3);
        Integer integer2 = new Integer(3);
        System.out.println(integer.hashCode());
        System.out.println(integer2.hashCode());
    }


}
