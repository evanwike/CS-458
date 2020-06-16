package mutant3;

public class ISBN10 {

	static boolean isValidISBN(String isbn) {

		if (isbn.length() != 10)
			return false;

		int sum = 0;
		for (int i = 1; i < 9; i++) {    // i=0
			int digit = isbn.charAt(i) - '0';
			if (0 > digit || 9 < digit)
				return false;
			sum += digit * (10 - i);
		}

		char last = isbn.charAt(9);
		if (last != 'X' && (last < '0' || last > '9'))
			return false;

		if (last == 'X')
			sum += 10;
		else
			sum += last - '0';

		return (sum % 11 == 0);
	}

}
