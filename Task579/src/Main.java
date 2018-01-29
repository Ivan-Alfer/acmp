import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {

			int numElem = Integer.parseInt(sc.nextLine());

			String strNums = sc.nextLine();
			String[] strArrayNums = strNums.split("\\s+");

			List<String> negativeArray = new ArrayList<String>(numElem);
			int negativeSum = 0;

			List<String> positiveArray = new ArrayList<String>(numElem);

			int positiveSum = 0;

			int numberOfZero = 0;

			for (int i = 0; i < numElem; ++i) {
				int num = Integer.parseInt(strArrayNums[i]);

				if (num == 0) {
					++numberOfZero;
				} else if (num > 0) {
					positiveArray.add(String.valueOf(i + 1));
					positiveSum += num;
				} else {
					negativeArray.add(String.valueOf(i + 1));
					negativeSum -= num;
				}
			}

			if (numberOfZero == numElem) {
				out.println(numberOfZero);

				StringBuilder strBuilder = new StringBuilder();

				for (int i = 1; i <= numberOfZero; ++i) {
					if (i > 1) {
						strBuilder.append(' ');
					}

					strBuilder.append(i);
				}
				out.println(strBuilder);
			} else if (positiveSum < negativeSum) {

				out.println(negativeArray.size());

				out.println(String.join(" ", negativeArray));
			} else {
				out.println(positiveArray.size());

				out.println(String.join(" ", positiveArray));
			}
		}
	}

}
