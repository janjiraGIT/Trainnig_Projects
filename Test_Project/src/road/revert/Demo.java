package road.revert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
	private static List<Integer> listNumbers = new ArrayList<Integer>();
	static List<Integer> numbersRevert = new ArrayList<Integer>();
	
	public static void main(final String args[]) {
		Scanner input = new Scanner(System.in);
	    List<Integer> listNumbers = new ArrayList<Integer>();	
		RevertRoad revertRoad = new RevertRoad();
		listNumbers = revertRoad.addNumbersFromKeybordToList(input);
		RevertRoad.seperateCases(listNumbers);
	}
}


		