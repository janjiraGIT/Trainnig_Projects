package server;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int servers = calculateServer(scanner);
		System.out.println(servers);
	}

	private static int calculateServer(Scanner scanner) {
		int line = scanner.nextInt();
		int request = scanner.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		list.add(0, scanner.nextInt());
		int maxRequest = 1;
		int nrRequest = 1;
		int next = 0;
		for (int i = 1; i < line; i++) {
			list.add(scanner.nextInt());
			nrRequest++;
			while (list.get(i) >= list.get(next) + 1000) {
				next++;
				nrRequest--;
			}
			 maxRequest = Math.max(maxRequest, nrRequest);
		}
		int servers = (int) Math.ceil((double)maxRequest / request);
		return servers;
	}
}
