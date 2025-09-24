public class DeliveryCostCalculator {

    private static double calculateDeliveryCost(int base_delivery_cost,
                                                int weight, int distance) {
        return base_delivery_cost + (weight * 10) + (distance * 5);
    }

    private static double calculateDiscount(double cost, int weight,
                                            int distance, String offer_code) {
        if ("OFR001".equals(offer_code)
                && distance <= 200
                && weight >= 70 && weight <= 200) {
            return (cost * 10) / 100;
        }
        if ("OFR002".equals(offer_code)
                && distance >= 50 && distance <= 150
                && weight >= 100 && weight <= 250) {
            return (cost * 7) / 100;
        }
        if ("OFR003".equals(offer_code)
                && distance >= 50 && distance <= 250
                && weight >= 10 && weight <= 150) {
            return (cost * 5) / 100;
        }
        return 0;
    }

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int base_delivery_cost = scanner.nextInt();
        int no_of_packages = scanner.nextInt();

        String[] pkg_ids = new String[no_of_packages];
        int[] weights = new int[no_of_packages];
        int[] distances = new int[no_of_packages];
        String[] offer_codes = new String[no_of_packages];


        for (int i = 0; i < no_of_packages; i++) {
            pkg_ids[i] = scanner.next();
            weights[i] = scanner.nextInt();
            distances[i] = scanner.nextInt();
            offer_codes[i] = scanner.next();
        }

        for (int i = 0; i < no_of_packages; i++) {
            double total_cost = calculateDeliveryCost(base_delivery_cost, weights[i], distances[i]);
            double discount = calculateDiscount(total_cost, weights[i], distances[i], offer_codes[i]);
            System.out.println(pkg_ids[i] + " " + (int) discount + " " + (int) (total_cost - discount));
        }

        scanner.close();
    }
}
