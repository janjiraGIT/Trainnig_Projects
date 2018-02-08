package road.revert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RevertRoad {

	private static List<List<Integer>> listOfCases = new ArrayList<List<Integer>>();
	private static int countCase = 0;
	static List<Integer> numbersRevert = new ArrayList<Integer>();
	
	public List<Integer> addNumbersFromKeybordToList(Scanner input) {
		List<Integer> listNumbers = new ArrayList<Integer>();
		if (!input.equals(null)) {
			for (int i = 0; i < 32; i++) {
	           int numbers = input.nextInt();
	            listNumbers.add(numbers);
	        }
		}
		return listNumbers;    
	}

	public static List<List<Integer>> seperateCases(List<Integer> listNumbers) {
		List<Integer> listCase = new ArrayList<Integer>();

		if (!listNumbers.isEmpty()) {
			
			int lines = sortNumbersInCases(listNumbers, listCase);
			
			numbersRevert = validationNumbers(countCase, listCase);
			//System.out.println(listCase.size());
			int x = listCase.get(0);
			int y = ( x * 2 ) + 2;
			if (numbersRevert.isEmpty() && ( listCase.size() == y ) ) {
				System.out.println("Case " + countCase + ": valid");
			}else if (numbersRevert.isEmpty() && ( listCase.size() != y ) ) {
				System.out.println("Case " + countCase + ": invalid");
			}
			else if (!numbersRevert.isEmpty() && (numbersRevert.size() >= 2)){
				System.out.println("Case " + countCase + ": " +  numbersRevert.get(0) +  " " + numbersRevert.get(1) );	
			} else if (!numbersRevert.isEmpty() && (numbersRevert.size()  == 1) ){
				System.out.println("Case " + countCase + ": " +  "invalid" );	
			}
			if (listCase.isEmpty()) {
				//System.out.println(listCase);
			}
			numbersRevert = new ArrayList<Integer>();
			removeNumbersFromList(lines, listNumbers);
		} else {
			//System.err.println("Empty");
		}
		if (!listCase.isEmpty()) {
			listOfCases.add(listCase);
		}

		return listOfCases;
	}

	public static int sortNumbersInCases(List<Integer> listNumbers, List<Integer> listCase) {
		int m;
		int n;
		m = listNumbers.get(0);
		n = listNumbers.get(1);
		int lines = ((n * 2) + 1);
		for (int i = 0; i <= lines; i++) {
			listCase.add(listNumbers.get(i));
		}
		countCase++;
		//System.err.println(" Case " + countCase + " : " + listCase);
		return lines;
	}

	private static List<Integer> validationNumbers(int countCase, List<Integer> listCase) {
 		List<Integer> listA = new ArrayList<Integer>();
 		List<Integer> listB = new ArrayList<Integer>();
			int m = listCase.get(0);
			int n = listCase.get(1);
			int a = 0;
			int b = 0;
			int lastPositionOfA = (n*2);
			int lastPositionOfB = (n*2)+1;
			
			if (((m >= 1) && ( m <= 50)) && ((n >= 0) && (n<=(m*(m-1)/2)))) {
				// start position 2 increate 2 and last position is 6
				for (int i = 2; i <= lastPositionOfA; i=i+2) {
					// b ( count b position a + 1 , same line but difference column )
					int j = i + 1;

					// start position 3 increate 2 and last position is 6
					if (j <= lastPositionOfB ) {
						a = listCase.get(i);
						b = listCase.get(j);
						numbersRevert = addNumbersFollowListAandListB(listA,listB, a, b);
					}
			}
			//System.out.println("List A " + listA);
			//System.out.println("List B " + listB);			
			} else {
				System.err.printf(" \nInput fel! please check input is follow the rule ( 1≤m≤50 and 0≤n≤m(m−1)/2\n )" + ".");
				System.exit(0);
			}
			
		return numbersRevert;
	}
	
	public static List<Integer> addNumbersFollowListAandListB(List<Integer> listA ,List<Integer> listB, int a, int b) {
		//List<Integer> numbersRevert = new ArrayList<Integer>();
		if (listA.contains(a)) { 
			numbersRevert.add(a);
		}
		if (listB.contains(b)) { 
			numbersRevert.add(b);
		}
		listA.add(a);
		listB.add(b);
		return numbersRevert;
	}

	private static void removeNumbersFromList(int lines, List<Integer> listNumbers) {
		if (!listNumbers.isEmpty()) {
			for (int i = 0; i < lines + 1; i++) {
				listNumbers.remove(0);
			}
			//System.err.println(" List after remove" + listNumbers);
			seperateCases(listNumbers);
		} else {
			//System.err.println("Done ");
		}
	}
}