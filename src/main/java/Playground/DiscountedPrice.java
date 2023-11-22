package Playground;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DiscountedPrice {

    public static int getDiscountedPrice(String barcode) {
        try {
            // Construct the API URL with the provided barcode
            String apiUrl = "https://jsonmock.hackerrank.com/api/inventory?barcode=" + barcode;

            // Create a URL object from the API URL string
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Check if the request was successful (HTTP status code 200)
            if (responseCode == 200) {
                // Read the response body using a Scanner
                try (Scanner scanner = new Scanner(connection.getInputStream())) {
                    StringBuilder responseBody = new StringBuilder();
                    while (scanner.hasNextLine()) {
                        responseBody.append(scanner.nextLine());
                    }

                    // Parse the JSON response
                    int discountedPrice = parseJsonResponse(responseBody.toString());

                    // Return the discounted price
                    return discountedPrice;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return -1 if there was an error or if the barcode was not found
        return -1;
    }

    private static int parseJsonResponse(String jsonResponse) {
        // Parse the JSON response and extract the discounted price
        // (Assuming the JSON response structure as mentioned in the problem statement)
        try (Scanner scanner = new Scanner(jsonResponse)) {
            while (scanner.hasNext()) {
                if (scanner.next().equals("\"data\":")) {
                    if (scanner.hasNext() && scanner.next().equals("[")) {
                        // Move to the next token, which should be the start of the object
                        scanner.next();

                        // Find the "price" and "discount" fields in the object
                        while (scanner.hasNext()) {
                            if (scanner.next().equals("\"price\":")) {
                                int price = scanner.nextInt();

                                // Find the "discount" field
                                while (scanner.hasNext()) {
                                    if (scanner.next().equals("\"discount\":")) {
                                        int discount = scanner.nextInt();

                                        // Calculate the discounted price and round to the nearest integer
                                        double discountedPrice = price - (price * discount / 100.0);
                                        return (int) Math.round(discountedPrice);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Return -1 if the barcode was not found or if there was an issue parsing the JSON
        return -1;
    }

    public static void main(String[] args) {
        String barcode = "74001755";
        int discountedPrice = getDiscountedPrice(barcode);

        if (discountedPrice != -1) {
            System.out.println("Discounted Price for Barcode " + barcode + ": " + discountedPrice);
        } else {
            System.out.println("Barcode not found or error occurred.");
        }
    }
}

/*
SELECT
    mon,
    ROUND(SUM(amount) * 100.0 / SUM(SUM(amount)) OVER (), 0) AS sales_percent
FROM
    your_sales_table
GROUP BY
    mon
HAVING
    sales_percent > 20;
 */
