public class stockBuyAndSell {
    
    public static int buyAndSell(int[] prices, int n) {
        n = prices.length;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        System.out.println("The maximum Profit is: " + buyAndSell(prices, n));
    }
}
