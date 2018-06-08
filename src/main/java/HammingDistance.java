/**
 * @author Daniel
 * @date 07/06/2018
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(4, 1));
    }

    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;

        while (true) {
            if ((z & 1) == 1) {
                count++;
            }
            z = z >> 1;
            if (z == 0) {
                break;
            }
        }
        return count;
    }
}
