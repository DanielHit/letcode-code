/**
 * @author Daniel
 * @date 28/05/2018
 */
public class ClimbeStars {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] vector = new int[n + 1];
        vector[0] = 0;
        vector[1] = 1;
        vector[2] = 2;

        for (int i = 3; i <= n; i++) {
            vector[i] = vector[i - 1] + vector[i - 2];
        }

        return vector[n];
    }

}
