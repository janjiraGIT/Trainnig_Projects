import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * logic correct 
 *
 */

public class ReversingRoad2 {
	
	private static boolean[] isVisited;
	private static String[] roads;
	private static boolean[] isRoads;
	private static Stack<Integer> box;
	private static int nr;
	private static int[] connections;
	private static List<List<Integer>> list;
	private static List<Integer>[] locations;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int caseCount = 0;
		try {
			while (input.hasNext()) {
				caseCount++;
					int m = input.nextInt();
					int n = input.nextInt();
					validateInput(input, caseCount, m, n);
			}
		}catch (Exception e) {
			throw e;
		}	
	}

	@SuppressWarnings("unchecked")
	private static void validateInput(Scanner input, int count, int m, int n) {
		if (((m >= 1) && ( m <= 50)) && ((n >= 0) && (n<=(m*(m-1)/2)))) {
			locations = new List[m];
			roads = new String[n];
			isRoads = new boolean[n];
			createEmptyLocations();
			for (int i = 0; i < n; i++) {
				int a = input.nextInt();
				int b = input.nextInt();
				validateAb(m, i, a, b);	
			}
			if (isValidCase()==true) {
				System.out.println("Case " + count + ": valid");
			} else {
				checkOtherCases(m, n, locations, roads,count);
			}
		} else {
			System.err.printf("Invalid input( m n ), please follow the rule ( 1≤m≤50 and 0≤n≤m(m−1)/2 )");
			System.exit(0);
		}
	}

	private static void validateAb(int m, int i, int a, int b) {
		if (( a != b ) && ((a >= 0) && (b >=0)) && ((a < m) && (b < m)) ) {
			locations[a].add(b);
			roads[i] = a+" "+b;
		}else {
			System.err.println("Invalid input( a b ), please follow the rule ( 0≤a,b<m and a≠b )");
			System.exit(0);
		}
	}

	private static void createEmptyLocations() {
		for (int i = 0; i < locations.length; i++) {
			locations[i] = new ArrayList<>();
		}
	}

	private static void checkOtherCases(int m, int n, List<Integer>[] locations, String[] roads,int count) {
		int a, b;
		boolean isInvalidCase = true;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < locations[i].size(); j++) {
				a = i;
				b = locations[a].remove(0);
				locations[b].add(a);
				if (isValidCase() == true) {
					isInvalidCase = false;
					for(int k=0;k<n;k++) {
						if(roads[k].equals(a+" "+b)) {
							isRoads[k]=true;
						}
					}
				}
				locations[a].add(b);
				locations[b].remove(locations[b].size() - 1);
			}
		}
		if (isInvalidCase == true) {
			System.out.println("Case " + count + ": invalid");
		} else {
			for (int i = 0; i < n; i++) {
				if (isRoads[i]) {
					System.out.println("Case " + count + ": " + roads[i]);
					break;
				}
			}
		}
	}

	private static boolean isValidCase() {
		isVisited = new boolean[locations.length];
		box = new Stack<>();
		nr = 0;
		connections = new int[locations.length];
		list = new ArrayList<>();
		for (int i = 0; i < locations.length; i++) {
			if (!isVisited[i]) {
				checkAllLocations(i);
			}
		}
		boolean valid = true;
		for (int i = 0; i < locations.length; i++) {
			if (!list.get(0).contains(i)) {
				valid = false;
			}
		}
		return valid;
	}

	private static void checkAllLocations(int i) {
		connections[i] = nr++;
		isVisited[i] = true;
		box.add(i);
		boolean isComponentRoot = true;
		for (int valueB : locations[i]) {
			if (!isVisited[valueB])
				checkAllLocations(valueB);
			if (connections[i] > connections[valueB]) {
				connections[i] = connections[valueB];
				isComponentRoot = false;
			}
		}
		if (isComponentRoot == true) {
			List<Integer> component = new ArrayList<>();
			while (true) {
				int x = box.pop();
				component.add(x);
				connections[x] = Integer.MAX_VALUE;
				if (x == i)
					break;
			}
			list.add(component);
		}
	}
}
