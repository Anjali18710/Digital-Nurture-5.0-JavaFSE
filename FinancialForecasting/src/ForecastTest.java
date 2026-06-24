public class ForecastTest {
    public static void main(String[] args) {

        double initialValue = 10000.0;  // starting amount ₹10,000
        double growthRate = 0.08;       // 8% annual growth
        int years = 5;

        // Recursive approach
        double futureValueRecursive = FinancialForecasting.calculateFutureValue(
            initialValue, growthRate, years
        );

        // Iterative approach
        double futureValueIterative = FinancialForecasting.calculateFutureValueIterative(
            initialValue, growthRate, years
        );

        System.out.println("=== Financial Forecast ===");
        System.out.println("Initial Investment : ₹" + initialValue);
        System.out.println("Annual Growth Rate : " + (growthRate * 100) + "%");
        System.out.println("Years             : " + years);
        System.out.println("--------------------------");
        System.out.printf("Future Value (Recursive)  : ₹%.2f%n", futureValueRecursive);
        System.out.printf("Future Value (Iterative)  : ₹%.2f%n", futureValueIterative);

        // Try different scenarios
        System.out.println("\n=== Different Scenarios ===");
        double[] rates = {0.05, 0.08, 0.12};
        int[] periods = {1, 3, 5, 10};

        for (double rate : rates) {
            for (int period : periods) {
                double fv = FinancialForecasting.calculateFutureValue(initialValue, rate, period);
                System.out.printf("Rate: %.0f%% | Years: %2d | Future Value: ₹%,.2f%n",
                    rate * 100, period, fv);
            }
            System.out.println();
        }
    }
}