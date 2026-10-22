import java.util.*;

public class NumberConverter {

	// Number Converter

	// Converts a decimal number to a given base (2-16) using recursion
	public static String fromDecimal(int num, int base) {
		String iAmString = ""; // Stores the final converted string
		String digits = "ABCDEF"; // Characters for bases > 10
		int remainder = num % base; // Get remainder
		String digitStored;

		// Convert remainder to appropriate character

		if (remainder < 10) {
			digitStored = Integer.toString(remainder);
		}
		else {
			digitStored = String.valueOf(digits.charAt(remainder - 10));
		}

		// Recursive call until num becomes 0
		if (num > 0) {
			iAmString = fromDecimal(num / base, base) + digitStored;
		}
		else {
			iAmString = "0"; // Base case
		}
		return iAmString;
	}

	// Main

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, base;

		// Input validation loop
		while (true) {
			try {
				System.out.println("Number Converter (Base 10 to Base 2-16)\n");
				System.out.print("Insert a number (Base 10): ");
				num = sc.nextInt();

				// Reject negative numbers
				if (num < 0) {
					System.out.println("Negative numbers are not allowed.\n");
					continue;
				}
				System.out.print("Base to be converted (2-16): ");
				base = sc.nextInt();

				// Ensure base is within valid range
				if (base < 2 || base > 16) {
					System.out.println("Invalid base. Please enter a base from 2 to 16.\n");
					continue;
				}
				break; // Exit loop when input is valid
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter integers only.\n");
				sc.next();
			}
		}

		// Perform conversion
		try {
			String result = fromDecimal(num, base);
			System.out.println("\nThe answer is " + result + ".");
		} catch (Exception e) {
			System.out.println("Error occurred.");
		}
		sc.close(); // Close scanner
	}
}