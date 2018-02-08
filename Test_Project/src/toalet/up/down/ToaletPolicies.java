package toalet.up.down;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToaletPolicies {
	public static List<Character> checkInput(String input){
		char ch;
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if (ch == 'U' || ch == 'D') {
				list.add(ch);
			}else {
				System.err.println("Wrong format input");
			}
		}
		return list;
	}
	public static void countPolicies(List<Character> listOfChar) {
		char policy1 = 'U';
		char policy2 = 'D';
		char policy3 = 'X';
		int count = 0;
		if (listOfChar.get(0) != listOfChar.get(1)) {
			count = count +1;
		}
		countPolicy(listOfChar, count, policy1);
		countPolicy(listOfChar, count, policy2);
		calPolicyFlex(listOfChar, count, policy3);
	}

	public static void countPolicy(List<Character> listOfChar, int count, char policy) {
		if (listOfChar.get(1) != policy) {
			count = count +1;
		}
		for (int i = 2; i < listOfChar.size(); i++) {
			if (listOfChar.get(i) != policy) {
				count = count+2;
			}	
		}
		System.out.println(count);
	}
	
	public static void calPolicyFlex(List<Character> listOfChar, int count, char policyX) {
		for (int i = 2; i < listOfChar.size();i++) {
			char a = listOfChar.get(i);
			char b = listOfChar.get(i+-1);
			if (b != a) {
				count ++;	
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		if (!string.equals(null)) {
			List<Character> listOfChar = new ArrayList<Character>();
			listOfChar = checkInput(string);
			countPolicies(listOfChar);

		}
	}
}
