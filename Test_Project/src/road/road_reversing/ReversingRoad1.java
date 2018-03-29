import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * logic fel 
 *
 */

public class ReversingRoad1 {
	static List<Integer> listOfNumbers;
	static int count = 0;
	static int m;
	static int n;
	static List<Integer> listOfReversing;
	static List<Integer> listA;
	static List<Integer> listB;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {

			m = input.nextInt();
			n = input.nextInt();
			if (((m >= 1) && (m <= 50)) && ((n >= 0) && (n <= (m * (m - 1) / 2)))) {
				listOfNumbers = new ArrayList<Integer>();
				listA = new ArrayList<Integer>();
				listB = new ArrayList<Integer>();
				listOfReversing = new ArrayList<Integer>();
				listOfNumbers.add(m);
				listOfNumbers.add(n);
				for (int i = 0; i < n; i++) {
					int a = input.nextInt();
					int b = input.nextInt();
					if (( a != b ) && ((a >= 0) && (b >=0)) && ((a < m) && (b < m)) ) {
						listOfNumbers.add(a);
						listOfNumbers.add(b);
					}else {
						System.err.println("Invalid input. Input should follow the rule  0≤a,b<m and a≠b");
						System.exit(0);
					}
				}
				listOfReversing = addReversingNumbers(listOfNumbers);
				printResult(listOfReversing);
			} else {
				System.err.println("Invalid input. Input should follow the rule 1≤m≤50 and 0≤n≤m(m−1)/2");
				System.exit(0);
			}
		}
	}

	private static void printResult(List<Integer> numbersRevert) {
		int startPoint = listOfNumbers.get(0);
		int endPoint = (startPoint * 2) + 2;
		if (numbersRevert.isEmpty() && (listOfNumbers.size() == endPoint)) {
			System.out.println(" ");
			System.out.println("Case " + count + ": valid");
		} else if (numbersRevert.isEmpty() && (listOfNumbers.size() != endPoint)) {
			System.out.println("Case " + count + ": invalid");
		} else if (!numbersRevert.isEmpty() && (numbersRevert.size() >= 2)) {
			System.out.println("Case " + count + ": " + numbersRevert.get(0) + " " + numbersRevert.get(1));
		} else if (!numbersRevert.isEmpty() && (numbersRevert.size() == 1)) {
			System.out.println("Case " + count + ": " + "invalid");
		}
	}

	private static List<Integer> addReversingNumbers(List<Integer> listNumbers) {
		count++;
		int m = listNumbers.get(0);
		int n = listNumbers.get(1);
		int a = 0;
		int b = 0;
		int lastPositionOfA = (n * 2);
		int lastPositionOfB = (n * 2) + 1;
		for (int i = 2; i <= lastPositionOfA; i = i + 2) {
			int j = i + 1;
			if (j <= lastPositionOfB) {
				a = listNumbers.get(i);
				b = listNumbers.get(j);
				listOfReversing = addIntoList(listA, listB, a, b);
			}
		}
		return listOfReversing;
	}

	public static List<Integer> addIntoList(List<Integer> listA, List<Integer> listB, int a, int b) {
		if (listA.contains(a)) {
			listOfReversing.add(a);
		}
		if (listB.contains(b)) {
			listOfReversing.add(b);
		}
		listA.add(a);
		listB.add(b);
		return listOfReversing;
	}
}
