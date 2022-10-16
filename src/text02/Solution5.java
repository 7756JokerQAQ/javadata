package text02;

import java.util.HashMap;

public class Solution5 {
    public String solveEquation(String equation) {
        int factor = 0, val = 0;
        int index = 0, n = equation.length(), sing = 1; //等式左边为正
        while (index < n) {
            if (equation.charAt(index) == '=') { //等式的右边为负数
                sing = -1;
                index++;
                 continue;
            }
            int sign2 =  sing, number = 0;
            boolean valid = false;  //记录number是否有效
            //去掉前面的符号
            if (equation.charAt(index) == '-' || equation.charAt(index) == '+') {
                sign2 = (equation.charAt(index) == '-') ? -sing : sing;
                index++;
            }
            while (index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + equation.charAt(index) - '0';
                index++;
                valid = true;
            }
            if (index < n && equation.charAt(index) == 'x') {
                factor += valid ? sign2 * number : sign2;
                index++;
            } else {
                val += sign2 * number;
            }

        }
        if (factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-val / factor);
    }
}
