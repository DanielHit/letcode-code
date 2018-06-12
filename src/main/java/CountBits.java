/**
 * @author Daniel
 * @date 12/06/2018
 */
public class CountBits {
    public static void main(String[] args) {

    }

    public static int[] countBits(int num) {

        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

}
