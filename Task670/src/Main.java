import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {

			int n = Integer.parseInt(sc.nextLine());

			int i = 1;
			int number = 1;

			byte[] numeralArray = new byte[10];

			while (i <= n) {
				if (i == n) {
					out.println(number);
					return;
				}

				++number;

				int tempNumber = number;

				for (int j = 0; j < 10; ++j) {
					numeralArray[j] = 0;
				}

				boolean isSkipNumber = false;

				while (tempNumber != 0) {
					int numeral = tempNumber % 10;

					if (numeralArray[numeral] > 0) {
						isSkipNumber = true;
						break;
					}

					numeralArray[numeral] = 1;

					tempNumber = tempNumber / 10;
				}

				if (!isSkipNumber) {
					++i;
				}
			}

		}
	}

}
