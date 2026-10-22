/**
* This program shows the usage of System.nanoTime() method to calculate the duration (runtime) of a function.
*
* Reference: https://www.tutorialspoint.com/java/lang/system_nanotime.htm
*
* Example of usage:
* startTime = System.nanoTime(); -- Record start time
* long factRec = calculator.calcNFactorialRecursive(n); -- Execution of function
* endTime = System.nanoTime(); -- Record end time
* duration = endTime - startTime; -- Runtime
**/

import java.util.*;

public class FactorialsFibonacciPerformanceTest {

	// Iterative Factorial

	public static long calcNFactorial(int n) {
		long nFactorial = 1;

		// Multiply numbers from n down to 2
		for (int i = n; i >= 2; i --) {
			nFactorial *= i;
		}
		return nFactorial;
	}

	// Recursive Factorial

	public static long calcNFactorialRecursive(int n) {
		long factorialRec;

		// Base case
		if (n == 0) {
			factorialRec = 1;
		}

		// Recursive case
		else {
			factorialRec = n * calcNFactorialRecursive(n - 1);
		}
		return factorialRec;
	}

	// Iterative Fibonacci

	public static int fibIterative(int n) {
		int lastVal = 0, currVal = 1, fibVal = 0;

		// Handle base cases
		if (n == 0) {
			fibVal = 0;
		}
		else if (n == 1) {
			fibVal = 1;
		}

		// Build sequence iteratively
		else {
			for (int i = 2; i <= n; i ++) {
				fibVal = lastVal + currVal;
				lastVal = currVal;
				currVal = fibVal;
			}
		}
		return fibVal;
	}

	// Recursive Fibonacci

	public static int fibRecursive(int n) {
		int fibVal = 0;

		// Base cases
		if (n == 0) {
			fibVal = 0;
		}
		else if (n == 1) {
			fibVal = 1;
		}

		// Recursive case
		else {
			fibVal = fibRecursive(n - 1) + fibRecursive(n - 2);
		}
		return fibVal;
	}

	// Main

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		// Program description
		System.out.println("Notes:");
		System.out.println("Factorials: n represents the number to compute n!.");
		System.out.println("Fibonacci: n represents the position of the Fibonacci number.");

		// Input validation loop
		while (true) {
			try {
				System.out.print("Enter value of n: ");
				n = sc.nextInt();
				if (n < 0) {
					System.out.println("Error: n must be non-negative.\n");
					continue;
				}
				break; // Valid input
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter an integer.\n");
				sc.next(); // Clear invalid input
			}
		}

		// Warn user about possible overflow
		if (n > 20) {
			System.out.println("\nWarning: Factorial may overflow a long for n > 20.");
		}
		if (n > 46) {
			System.out.println("\nWarning: Fibonacci may overflow an int for n > 46.");
		}
		long startTime, endTime, duration;
		
		// Factorial

		if (n <= 20) {

			// Iterative factorial timing
			startTime = System.nanoTime();
			long factIter = calcNFactorial(n);
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println("\nFactorial (Iterative): " + factIter);
			System.out.println("Runtime: " + duration + " ns");

			// Recursive factorial timing
			try {
				startTime = System.nanoTime();
				long factRec = calcNFactorialRecursive(n);
				endTime = System.nanoTime();
				duration = endTime - startTime;
				System.out.println("\nFactorial (Recursive): " + factRec);
				System.out.println("Runtime: " + duration + " ns");
			} catch (StackOverflowError e) {
				System.out.println("Error: Stack overflow occurred.");
			}
		}
		else {
			System.out.println("\nFactorial skipped due to overflow risk.");
		}

		// Fibonacci

		if (n <= 46) {

			// Iterative Fibonacci timing
			startTime = System.nanoTime();
			int fibIter = fibIterative(n);
			endTime = System.nanoTime();
			duration = endTime - startTime;
			System.out.println("\nFibonacci (Recursive): " + fibIter);
			System.out.println("Runtime: " + duration + " ns");

			// Recursive Fibonacci timing
			try {
				startTime = System.nanoTime();
				int fibRec = fibRecursive(n);
				endTime = System.nanoTime();
				duration = endTime - startTime;
				System.out.println("\nFibonacci (Recursive): " + fibRec);
				System.out.println("Runtime: " + duration + " ns");
			} catch (StackOverflowError e) {
				System.out.println("Error: Stack overflow occurred.");
			}
		}
		else {
			System.out.println("\nFibonacci skipped due to overflow risk.");
		}
		sc.close(); // Close scanner
	}
}