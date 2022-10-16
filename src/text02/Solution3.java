package text02;

public class Solution3 {
    public String complexNumberMultiply(String num1, String num2) {
        //a+bi d+fi   (ad-bf)+(af+bd)i
        int a=Integer.parseInt(num1.substring(0,num1.indexOf('+')));
        int b=Integer.parseInt(num1.substring(num1.indexOf('+')+1,num1.length()-1));
        int d=Integer.parseInt(num2.substring(0,num2.indexOf('+')));
        int f=Integer.parseInt(num2.substring(num2.indexOf('+')+1,num2.length()-1));

        return   String.format((a*d-b*f)+"+"+(a*f+b*d)+"i");
    }
}
