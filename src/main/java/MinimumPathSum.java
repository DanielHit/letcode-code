/**
 * @author Daniel
 * @date 28/05/2018
 */
public class MinimumPathSum {

    public static void main(String[] args) {

        int[][] nums = new int[][]{
                {9, 1, 8, 4}
        };
        System.out.println(minPathSum(nums));

    }


    public static int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }


        int[][] vectors = new int[grid.length][grid[0].length];
        vectors[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            vectors[i][0] = (grid[i][0] + vectors[i - 1][0]);
        }

        for (int i = 1; i < grid[0].length; i++) {
            vectors[0][i] = grid[0][i] + vectors[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                vectors[i][j] = Math.min(vectors[i - 1][j] + grid[i][j], vectors[i][j - 1] + grid[i][j]);
            }
        }

        return vectors[grid.length - 1][grid[0].length - 1];


    }

}
