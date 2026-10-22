/**
* This program calculates the Greatest Common Divisor (GCD) of two numbers using recursion.
* This function repeatedly divides by the remainder until one of the numbers becomes zero while the other one is count as GCD.
*
* Reference: https://www.w3resource.com/java-exercises/recursive/java-recursive-exercise-7.php
* 
* Example:
* Input: 18, 12
* Operations:
* GCD(18, 12) -- GCD(12, 18 % 12) -- GCD(12, 6)
* GCD(12, 6) -- GCD(6, 12 % 6) -- GCD(6, 0)
* Output: GCD is 18 and 12 is 6.
**/

import java.util.*;

public class GCDCalculator {

	// Greatest Common Divisor (GCD) Calculator

	// Calculate the GCD using the recursive Euclidean algorithm
	public static int calcGCD(int num1, int num2) {
		int gCD;

		// Base case: when the second number becomes 0 or less
		if (num2 <= 0) {
			gCD = num1;
		}

		// Recursive step: reduce the problem size
		else {
			gCD = calcGCD(num2, num1 % num2);
		}
		return gCD;
	}

	// Main

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;

		// Input validation loop
		while (true) {
			try {
				System.out.println("Greatest Common Divisor Calculator\n");
				System.out.print("Enter number 1: ");
				num1 = sc.nextInt();
				System.out.print("Enter number 2: ");
				num2 = sc.nextInt();
				break; // Exit loop when valid input is received
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter integers only.\n");
				sc.next(); // Clear invalid input
			}
		}

		// Perform GCD calculation
		try {
			int result = calcGCD(num1, num2);
			System.out.println("\nGCD of " + num1 + " and " + num2 + " is " + result + ".");
		} catch (StackOverflowError e) {
			System.out.println("Error: Stack overflow occurred.");
		}
		sc.close(); // Close scanner
	}
}