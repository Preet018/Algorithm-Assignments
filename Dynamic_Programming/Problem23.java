// https://takeuforward.org/data-structure/buy-and-sell-stock-iv-dp-38/

public class Problem23 {
    public static void main(String[] args) {

    }
}

class StockBuySell {
    public static int maxProfit(int[] prices, int n, int k) {
        int[][] ahead = new int[2][k + 1];
        int[][] cur = new int[2][k + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0) {
                        cur[buy][cap] = Math.max(0 + ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    } else {
                        cur[buy][cap] = Math.max(0 + ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                System.arraycopy(cur[i], 0, ahead[i], 0, k + 1);
            }
        }

        return ahead[0][k];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int n = prices.length;
        int k = 2;

        System.out.println("The maximum profit that can be generated is " + maxProfit(prices, n, k));
    }
}
