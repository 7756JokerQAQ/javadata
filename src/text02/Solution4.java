package text02;

public class Solution4 {
    public String fractionAddition(String expression) {
        long x = 0, y = 1;
        int index = 0, n = expression.length();
        while (index < n) {
            //读取分子
            long x1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                x1 = x1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            x1=sign*x1;
            index++;
            //读取分母
            long y1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                y1 = y1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            //计算两分数相加结果
            x = x * y1 + x1 * y;
            y *= y1;
        }

        //计算完成结果后
        if (x == 0) {
            return "0/1";
        }
        //求出最大公约数
        long g = gcd(Math.abs(x), y);

        return Long.toString(x / g) + "/" + Long.toString(y / g);

    }

    private long gcd(long a, long b) {
        long remember = a % b;
        while (remember != 0) {
            a = b;
            b = remember;
            remember = a % b;
        }
        return b;
    }

}
