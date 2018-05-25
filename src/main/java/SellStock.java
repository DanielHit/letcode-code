/**
 * @author Daniel
 * @date 25/05/2018
 */
public class SellStock {

    public static void main(String[] args) {
        int[] price = new int[]{7, 1, 5, 3, 6, 4};
        int[] price2 = new int[]{7, 6, 4, 3, 2};
        System.out.println(maxProfit(price));
        System.out.println(maxProfit(price2));
    }

    // 卖出股票最好的时间
    // 时间复杂度 o(nlogn)
    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        if (prices.length == 2) {
            if (prices[1] - prices[0] >= 0) {
                return prices[1] - prices[0];
            } else {
                return 0;
            }
        }

        int mid = prices.length / 2;
        int[] left = new int[prices.length / 2];

        int[] right = new int[prices.length - prices.length / 2];

        for (int i = 0; i < prices.length; i++) {
            if (i < mid) {
                left[i] = prices[i];
            } else {
                right[i - mid] = prices[i];
            }
        }

        int leftPrice = maxProfit(left);
        int rightPrice = maxProfit(right);

        int leftMin = left[0];
        int rightMax = right[0];

        for (int i = 0; i < left.length; i++) {
            if (leftMin > left[i]) {
                leftMin = left[i];
            }
        }

        for (int i = 0; i < right.length; i++) {
            if (rightMax < right[i]) {
                rightMax = right[i];
            }
        }

        int midPrice = rightMax - leftMin;

        if (midPrice > Math.max(leftPrice, rightPrice) && midPrice > 0) {
            return midPrice;
        }

        if (Math.max(leftPrice, rightPrice) > 0) {
            return Math.max(leftPrice, rightPrice);
        }

        return 0;
    }

}
