package text02;


import java.util.HashSet;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count=0;
        boolean doors=false;
       //可以利用开关门
        while (head!=null){
            if(set.contains(head.val)){
                if(!doors){
                    doors=true;
                    count++;
                }
            }else {
                doors=false;
            }
            head=head.next;
        }
        return count;
    }
}
