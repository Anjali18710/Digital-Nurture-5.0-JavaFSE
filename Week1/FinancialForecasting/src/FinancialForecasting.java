public class FinancialForecasting {

    // Recursive method — calls itself to calculate future value
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        
        // Base case — stop recursion when no years are left
        if (years == 0) {
            return currentValue;
        }

        // Recursive case — grow by one year, then recurse for remaining years
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Iterative method — same result, using a loop instead
    public static double calculateFutureValueIterative(double currentValue, double growthRate, int years) {
        double result = currentValue;
        for (int i = 0; i < years; i++) {
            result = result * (1 + growthRate);
        }
        return result;
    }
}