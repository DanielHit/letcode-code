/**
 * @author Daniel
 * @date 04/06/2018
 */
public class UniquePathsTest {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths2(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }


        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public static int uniquePaths2(int m, int n) {

        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            temp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            temp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }

        return temp[m - 1][n - 1];
    }
}
