package programs;

public class PrimeNumber {

	public static void isPrimeNumber(int number) {
		if (number > 1) {
			boolean isPrimeNumber = true;
			int i = 2;
			while (isPrimeNumber && i < number) {
				if (number % i == 0)
					isPrimeNumber = false;
				else
					i++;
			}
			if (isPrimeNumber)
				System.out.println(number + " is a prime number.");
			else
				System.out.println(number + " is not a prime number.");
		} else {
			System.out.println("Please input a number greater than 1.");
		}
	}

}
