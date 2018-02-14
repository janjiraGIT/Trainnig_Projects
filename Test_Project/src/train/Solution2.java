package train;
import java.util.Scanner;

public class Solution2 {
	private static double s;
	private static double m;
	private static double result;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int obsNumber = Integer.parseInt(input.nextLine());
			result = provideResult(input, obsNumber);
			printResult();
	}

	private static void printResult() {
		if (result <= 1) {
			System.out.println("Measurement error");

		} else {
			System.out.printf("%.9f", result);
		}
	}

	private static double provideResult(Scanner input, int obsNumber) {
		for (int i = 0; i < obsNumber; i++) {
			String[] records = input.nextLine().split(" ");
			m += Long.parseLong(records[0]);
			s += Long.parseLong(records[1]);
				result = calculateAvg(m, s);
		}
		return result;

	}

	private static double calculateAvg(double m, double s) {
		result = 0;
		result = s / (m * 60);
		return result;
	}
}
