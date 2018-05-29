import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @date 28/05/2018
 */
public class TrappingRainWater {
    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> subList = new ArrayList<>();
        int negativeFlag = 0;
        int postiveFlag = 0;

        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] >= height[i + 1]) {
                if (negativeFlag == -1 && postiveFlag == 1) {
                    lists.add(subList);
                    subList = new ArrayList<>();
                    subList.add(height[i]);
                    negativeFlag = 0;
                    postiveFlag = 0;
                }

                if (negativeFlag == -1 && postiveFlag == 0) {
                    subList.add(height[i]);
                }
            }

            if (height[i] < height[i + 1]) {
                if (negativeFlag == -1) {
                    lists.add(subList);
                    subList = new ArrayList<>();
                    subList.add(height[i]);
                    postiveFlag = 1;
                }
            }
        }


        return 0;
    }
}
