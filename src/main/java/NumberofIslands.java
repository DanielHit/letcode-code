/**
 * @author Daniel
 * @date 05/06/2018
 */
public class NumberofIslands {

    public static void main(String[] args) {
        char[][] charList = new char[][]{
//                {1, 1, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 1, 1}
                {'0', '1'},
                {'1', '0'},
                {'0', '1'}

        };


        int[][] nums = new int[charList.length][charList[0].length];

        for (int i = 0; i < charList.length; i++) {
            for (int j = 0; j < charList[0].length; j++) {
                nums[i][j] = charList[i][j] - '0';
            }
        }

        System.out.println(numIslands(nums));
    }


    public static int numIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 0 && n == 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            if (grid[0][0] == 1) {
                return 1;
            }

            return 0;
        }

        return numIslands(grid, m, n);
    }

    public static int numIslands(int[][] grid, int i, int j) {
        int[][] temp = new int[i][j];

        temp[0][0] = grid[0][0] * 1;

        for (int k = 1; k < j; k++) {
            if (grid[0][k] == 1 && grid[0][k - 1] == 0) {
                temp[0][k] = temp[0][k - 1] + 1;
            } else {
                temp[0][k] = temp[0][k - 1];
            }
        }

//        temp[1][0] = grid[0][0] * 1;
//
//        for (int k = 1; k < i; k++) {
//            if (grid[k][0] == 1 && grid[k - 1][0] == 0) {
//                temp[k][0] = temp[k - 1][0] + 1;
//            } else {
//                temp[k][0] = temp[k - 1][0];
//            }
//        }

        for (int k = 1; k < i; k++) {
            for (int l = 0; l < j; l++) {
                if (l == 0) {
                    if (temp[k][l] == 1 && temp[k - 1][l] == 0) {
                        temp[k][l] = temp[k - 1][j - 1] + 1;
                    } else {
                        temp[k][l] = temp[k - 1][j - 1];
                    }

                    continue;
                }

                if (grid[k][l] == 1 && grid[k - 1][l] == 0 && grid[k][l - 1] == 0) {
                    temp[k][l] = temp[k][l - 1] + 1;
                } else {
                    temp[k][l] = temp[k][l - 1];
                }
            }
        }

        return temp[i - 1][j - 1];
    }


}
