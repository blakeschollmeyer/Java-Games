//Name Blake Schollmeyer
//Username: bas76530
//700No: 700517653
//Assignment Number: a7
//Folder Name: Spinout
//Due:4/5/16

import java.util.InputMismatchException;
import java.util.Scanner;


public class Spinout {
    private static int n = 1;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner INPUT = new Scanner(System.in);
	boolean badData = true;
	do {
		try {
			System.out.print("Input number of spinners: ");
			n = INPUT.nextInt();
			if (n <= 0) throw new LEZeroIntegerException();
			if (n >= 20) throw new GETwentyIntegerException();
			badData = false;
		} catch (InputMismatchException e) {
			System.out.println("Bad data. Try again. ");
			INPUT.nextLine();
		} catch (LEZeroIntegerException e) {
			System.out.println("Non-positive integer. Try again. ");
		} catch (GETwentyIntegerException e) {
			System.out.println("Integer >= 20. Try again. ");
		}
	} while (badData);
	unlock(n);
	System.out.println();
	System.out.println("Number of moves: " + count);
    }
    
    public static void lock(int n) {
	if (n == 0) {
		System.out.print("");
	} else if (n == 1) {
		System.out.print("l");
		count++;
	} else if (n >= 2) {
		lock(n - 1);
		unlock(n - 2);
		System.out.print("," + n + ",");
		lock(n - 2);
		count++;
		}
    }
    
	public static void unlock(int n) {
		if (n == 0) {
			System.out.print("");
	} else if (n == 1) {
		System.out.print("l");
		count++;
	} else if (n >= 2) {
		unlock(n - 2);
		System.out.print("," + n + ",");
		lock(n - 2);
		unlock(n - 1);
		count++;
	}
    }
  
}

