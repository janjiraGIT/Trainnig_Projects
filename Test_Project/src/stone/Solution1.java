package stone;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if ((n >= 1) && (n <= 10000000)) {
			if ((n % 2) == 0) {
				System.out.println("Bob");
			} else {
				System.out.println("Alice");
			}
		} else {
			System.err.println("Fel input");
		}
	}
}
