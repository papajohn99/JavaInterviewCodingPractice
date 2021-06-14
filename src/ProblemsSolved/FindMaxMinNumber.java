package ProblemsSolved;

public class FindMaxMinNumber {

    public static void main(String[] args) {
        FindMaxMinNumber s = new FindMaxMinNumber();
        int ans2 = s.max(new int[]{7, 1, 5, 3, 6, 4}); // 7
        System.out.println("The answer is " + ans2);
    }

    /**
     * Buy stock at min number and sell at max number.
     *
     * @param prices
     * @return
     */
    public int max(int[] prices) {
        int maxNum = prices[0];
        int minNum = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxNum) {
                maxNum = prices[i];
            } else if (prices[i] < minNum) {
                minNum = prices[i];
            }
        }
        return minNum;
    }
}
