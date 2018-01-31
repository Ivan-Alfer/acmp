import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void addLineValues(int[][] matrix, int matrixDimension, int rowNum, String values) {
		String[] strValues = values.split("\\s+");

		for (int i = 0; i < matrixDimension; i++) {
			matrix[rowNum][i] = Integer.parseInt(strValues[i]);
		}
	}

	public static void readMatrix(Scanner sc, int[][] matrix, int dimension) {
		for (int i = 0; i < dimension; i++) {
			addLineValues(matrix, dimension, i, sc.nextLine());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		try (Scanner sc = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
			String[] firstLineArray = sc.nextLine().split("\\s+");
			int matrixCount = Integer.parseInt(firstLineArray[0]);
			int dimension = Integer.parseInt(firstLineArray[1]);
			String[] secondLineArray = sc.nextLine().split("\\s+");
			int selectedRowNum = Integer.parseInt(secondLineArray[0]) - 1;
			int selectedColNum = Integer.parseInt(secondLineArray[1]) - 1;

			int p = Integer.parseInt(sc.nextLine());

			int[][] matrix = null;
			int[] vectorA = new int[dimension];
			int[] vectorResult = new int[dimension];

			for (int matrixNum = 0; matrixNum < matrixCount; matrixNum++) {
				sc.nextLine();
				if (matrix == null) {
					matrix = new int[dimension][dimension];
					readMatrix(sc, matrix, dimension);

					for (int k = 0; k < dimension; k++) {
						vectorResult[k] = matrix[selectedRowNum][k];
					}
					continue;
				}
				int[] tempVector = vectorA;
				vectorA = vectorResult;
				vectorResult = tempVector;

				readMatrix(sc, matrix, dimension);

				for (int j = 0; j < dimension; j++) {
					vectorResult[j] = 0;
					for (int k = 0; k < dimension; k++) {
						vectorResult[j] += vectorA[k] * matrix[k][j];
					}
					if (vectorResult[j] >= p) {
						vectorResult[j] = vectorResult[j] % p;
					}
				}
			}

			out.println(vectorResult[selectedColNum]);
		}

	}

}
