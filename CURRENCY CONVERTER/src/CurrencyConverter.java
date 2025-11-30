import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class CurrencyConverter {



        // Method to fetch live exchange rate WITHOUT JSON library
        public static double getExchangeRate(String base, String target) {
            try {
                String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + base;

                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Raw JSON text
                String json = response.toString();

                // Find target currency rate manually
                String searchKey = "\"" + target + "\":";
                int index = json.indexOf(searchKey);

                if (index == -1) return -1; // currency not found

                // number starts after :
                int start = index + searchKey.length();
                int end = json.indexOf(",", start);

                if (end == -1) {
                    end = json.indexOf("}", start);
                }

                return Double.parseDouble(json.substring(start, end));

            } catch (Exception e) {
                return -1;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("===== CURRENCY CONVERTER =====");

            System.out.print("Enter base currency (USD, INR, EUR): ");
            String base = sc.next().toUpperCase();

            System.out.print("Enter target currency (USD, INR, EUR): ");
            String target = sc.next().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = sc.nextDouble();

            double rate = getExchangeRate(base, target);

            if (rate == -1) {
                System.out.println("Error: Invalid currency or network problem.");
                return;
            }

            double convertedAmount = amount * rate;

            System.out.println("\n===== RESULT =====");
            System.out.println(amount + " " + base + " = " + convertedAmount + " " + target);
        }
    }
