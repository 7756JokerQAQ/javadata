package text04;

class Solution {

    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] array = new int[n];
        // 设置初值
        array[0] = 1;array[1] = 2;array[2] = 2;
        // 统计 1 的个数，前三个字符中有 1 个 1
        int count = 1;
      /*  // index 表示字符串 A 的索引，length 表示字符串有效字符的个数， value 表示下次生成的字符
        int index = 2, length = 3, value = 1;
        while (length < n) {
            // 根据 array[index] 的值决定生成几个 value
            for (int i = 0; i < array[index] && length < n; i++) {
                array[length++] = value;
                // 统计 1 的个数
                if (value == 1) {
                    count++;
                 }
            }
             // 更换生成的字符，3-1=2，3-2=1，实现 1 和 2 的交替
            value = 3 - value;
            index++;
        }
        return count;*/
        int index=2,length=3,value=1;
        while (length<n){
            for (int i = 0; i < array[index]&&length<n; i++) {
                array[length++]=value;
                if(value==1){
                    count++;
                }
            }
            value=3-value;
            index++;
        }


        return count;
    }

    public static void main(String[] args) {
        int n=6;
        Solution solution = new Solution();
        solution.magicalString(n);
    }
    // 6
    // 1 2 2 11 2 1 2 2 1 2 2 1 1 2
    // 1 2 2 1 1 2 1 2 2 1
}

