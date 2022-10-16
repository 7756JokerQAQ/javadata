package text03;

public class Solution6 {
    public String intToRoman(int num) {
        //想法很重要 可以向将他们一一对应起来
        int [] IntNum={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] SrIndex={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String res="";
        for (int i = 0; i < 13; i++) {
            while (num>=IntNum[i]){
                num-=IntNum[i];
                res+=SrIndex[i];
            }
        }
         return res;

    }

    public static void main(String[] args) {
        int num=9;
        Solution6 solution6 = new Solution6();
        solution6.intToRoman(num);

    }
}
