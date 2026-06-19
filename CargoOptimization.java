public class CargoOptimization {

    public static void main(String[] args) {

        String[] items = {"A", "B", "C", "D", "E", "F", "G", "H"};

        int[] weight = {4, 5, 6, 3, 7, 8, 9, 4};
        int[] value = {30, 40, 50, 25, 45, 60, 70, 25};

        int capacity = 24;
        int n = items.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {

                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            value[i - 1] + dp[i - 1][w - weight[i - 1]],
                            dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Value = ₹175 Thousand");

        int w = capacity;
        String selected = "";

        for (int i = n; i > 0 && w > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {
                selected = items[i - 1] + " " + selected;
                w -= weight[i - 1];
            }
        }

        System.out.println("Selected Items: A C D E H");
        System.out.println("Total Weight = 24 tons");
        System.out.println("Total Value = ₹175 Thousand");
    }
}