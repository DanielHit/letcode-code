/**
 * @author Daniel
 * @date 23/05/2018
 */
public class MathPow {

    public static void main(String[] args) {
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(0.00001, 2147483647));
    }


    // 幂指数
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = myPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half / x * half;
        }

    }

}
