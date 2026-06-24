public class SearchTest {
    public static void main(String[] args) {

        // Array for linear search (order doesn't matter)
        Product[] products = {
            new Product(103, "Laptop", "Electronics"),
            new Product(101, "Shoes", "Fashion"),
            new Product(105, "Mixer", "Appliances"),
            new Product(102, "Phone", "Electronics"),
            new Product(104, "Shirt", "Fashion")
        };

        // Array for binary search (MUST be sorted by productId)
        Product[] sortedProducts = {
            new Product(101, "Shoes", "Fashion"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Laptop", "Electronics"),
            new Product(104, "Shirt", "Fashion"),
            new Product(105, "Mixer", "Appliances")
        };

        // Test Linear Search
        System.out.println("=== Linear Search ===");
        Product result1 = SearchAlgorithms.linearSearch(products, 104);
        System.out.println(result1 != null ? "Found: " + result1 : "Not found");

        Product result2 = SearchAlgorithms.linearSearch(products, 999);
        System.out.println(result2 != null ? "Found: " + result2 : "Not found");

        // Test Binary Search
        System.out.println("\n=== Binary Search ===");
        Product result3 = SearchAlgorithms.binarySearch(sortedProducts, 102);
        System.out.println(result3 != null ? "Found: " + result3 : "Not found");

        Product result4 = SearchAlgorithms.binarySearch(sortedProducts, 999);
        System.out.println(result4 != null ? "Found: " + result4 : "Not found");
    }
}