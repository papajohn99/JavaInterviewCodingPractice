package ProblemsSolved;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        BestTimeToBuySellStock s = new BestTimeToBuySellStock();

        //Best time to Buy stock and sell with max profit.
        int ans = s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // 7 doesn't count because first we have to buy at minimum 1-6 = 5

        //Buy stock at min number and sell at max number.
        int ans1 = s.totalProfit(new int[]{500, 100, 180, 260, 310, 40, 535, 695, 30, 500, 700, 10}); // 1535
        int ans2 = s.totalProfit(new int[]{7, 1, 5, 3, 6, 4}); // 5

        System.out.println("The answer is " + ans);
        System.out.println("The answer is " + ans1);
        System.out.println("The answer is " + ans2);
    }

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    /**
     * Buy stock at min number and sell at max number.
     *
     * @param prices
     * @return
     */
    public int totalProfit(int[] prices) {

        int profit = 0;

        if (prices.length >= 2) {
            int min = prices[0];
            int max = prices[0];
            int firstMinimumNumber = 0;

            // find first minimum number to buy a stock.
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    firstMinimumNumber = i;
                    min = prices[i];
                    max = prices[i];
                    break;
                }
            }

            // since we already checked first minimum number. we will start from next number.
            for (int j = firstMinimumNumber + 1; j < prices.length; j++) {
                int previousNumber = prices[j - 1];
                if (prices[j] < previousNumber) {
                    profit += max - min;
                    min = prices[j];
                } else {
                    max = prices[j];
                }

                if (j == prices.length - 1 && prices[prices.length - 1] == max) {
                    profit += max - min;
                }
            }

        }

        return profit;
    }
}

