package text07;

public class Solution1 {
    //0,1,8
    //2-5  6/9
    //3 4  7
    private static int [] check={0,0,1,-1,-1,1,1,-1,0,1};
    public int rotatedDigits(int n) {
            int count=0;
        for (int i = 1; i <= n; i++) {

            String s = String.valueOf(i);
            boolean noUse=true;
            boolean yesUser=false;
            for (int j = 0; j < s.length(); j++) {
                if(check[s.charAt(j)-'0']==-1){
                    noUse=false;
                }
                if(check[s.charAt(j)-'0']==1){
                    yesUser=true;
                }
            }
            if(noUse&&yesUser){
                count++;
            }
        }
        return count;
    }


}
