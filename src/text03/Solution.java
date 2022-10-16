package text03;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        //本题因为数字各不相同所以对于0~n-1的数字 因为长度为n
        //所以对于下标为i处的元素如果其前面的i个元素的最大值就是自己本身这就可以划分为一个块
        //否则无论怎么排序都不能划分为一个块 因为它的下标和值有很好的对应关系
        //就拿1，0，2，3，4举例 当遍历到0也就是下标为1而前面的最大值为1故这里可以划分为一个块
        //接着继续遍历i=2对应的值也为2所以它可以单独划分为一个块
        int res=0,max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            if(max==i)res++;
        }
        // 0,2,1
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        Solution solution = new Solution();
        solution.maxChunksToSorted(arr);
    }


}
