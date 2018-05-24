/**
 * @author Daniel
 * @date 23/05/2018
 */
public class ReverInteger {
    public static void main(String[] args) {

        long x = -2147483648;


        if (x < 0) {
            x = x * -1;
        }

        System.out.println(Math.abs(x));

        String num = String.valueOf(x);


        int sum = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Integer.MAX_VALUE - sum < Integer.parseInt(String.valueOf(num.charAt(i))) * Math.pow(10, i)) {
                System.out.println("false");
            }
            sum += Integer.parseInt(String.valueOf(num.charAt(i))) * Math.pow(10, i);
        }

        if (x < 0) {
            sum = sum * -1;
        }


        System.out.println(sum);

    }
}
