package text03;


import java.util.Vector;

public class Solution2 {
        public int compress(char[] chars) {     // 数组大小范围： 1 <= chars.length <= 1000
            int left = 0;
            int size = 0;
            //滑动窗口双指针
            //因为最后一位也需要判断所以需要将右指针放在数组外
            for (int right = 0; right <= chars.length; right++) {
                if(right==chars.length||chars[right]!=chars[left]){
                    //更新字符
                    chars[size++]=chars[left];
                    //更新计数器如果小于一则直接跳过
                    if(right-left>1){
                        for (char c :
                                String.valueOf(right - left).toCharArray()) {
                            chars[size++] = c;
                        }
                    }
                    left=right;
                }

            }
            return size;
        }
    public static void main(String[] args) {
        char[]temp={'a','a','b','b','c','c','c'};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.compress(temp));
    }
}
