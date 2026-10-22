import java.util.*;

public class TowersOfHanoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0; // Number of disks
		boolean validInput = false; // Controls input loop

		// Input validation loop
		while(!validInput) {
			try {
				System.out.print("Enter number of disks: ");
				n = sc.nextInt();
				if (n <= 0) {
					System.out.println("Invalid input. Number of disks must be greater than 0.\n");
				}
				else {
					validInput = true; // Exit loop when input is valid
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Please enter a valid integer.\n");
				sc.next(); // Clear invalid input
			}
		}

		// Start Towers of Hanoi process
		int totalMoves = towers(n, 1, 3, 1);
		System.out.println("\nTotal moves = " + totalMoves);
		sc.close();
	}


	//Recursice Towers of Hanoi solution
	// n = number of disks
	// src = source rod, dest = destination rod
	// level = recursion depth (for display formatting)
	public static int towers(int n, int src, int dest, int level) {
		int moves = 0;
		int tmp;

		// Base case: only one disk to move
		if (n == 1) {
			moveDisk(src, dest, n, level);
			moves = 1;
		}
		else {

			// Determine temporary rod (since rods are 1, 2, 3 and sum = 6)
			tmp = 6 - src - dest;

			// Step 1: Move n-1 disks to temporary rod
			moves += towers(n - 1, src, tmp, level + 1);

			// Step 2: Move largest disk to destination
			moveDisk(src, dest, n, level);
			moves ++;

			// Step 3: Move n-1 disks from temporary to destination
			moves += towers(n - 1, tmp, dest, level + 1);
		}
		return moves;
	}

	// Displays a single disk movement with indentation based on recursion level
	public static void moveDisk(int src, int dest, int n, int level) {
		String lvlSpace = indentRec(level);
		System.out.println("\n" + lvlSpace + "Recursion Level = " + level);
		System.out.println(lvlSpace + "Moving Disk " + n + " from Source " + src + " to Destination " + dest);
		System.out.println(lvlSpace + "n = " + n + ", src = " + src + ", dest = " + dest);
	}

	// Generates indentation for visualising recursion depth
	public static String indentRec(int level) {
		String indent = "	";
		String spacing = "";
		if (level > 1) {
			spacing += indent;
			level --;
			spacing += indentRec(level); // Recursive indentation
		}
		return spacing;
	}
}