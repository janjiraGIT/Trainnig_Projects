import java.util.Scanner;

public class Pizza {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		generateResult(in);
	}

	private static void generateResult(Scanner in) {
		String[] input = new String[2];
		int r = 0;
		int c = 0;
		input = in.nextLine().split(" ");
		try {
			r = Integer.parseInt(input[0]);
			c = Integer.parseInt(input[1]);
		}catch(NumberFormatException e) {
			System.err.println("Invalid input!  " + e);	
		}
		if( (c < 1)|| (r < c)|| (r > 100)){
			System.err.println("Invalid input value. Please follow the rule ( 1 ≤ C ≤ R ≤ 100 ) ");
		}else {
			double wholeArea = calTotaltArea(r);
			double cheeseArea = calCheeseArea(r,c);
			double result = cheeseArea/wholeArea;
			double resultPercentage = result * 100;
			System.out.printf("%.6f", resultPercentage);
		}	
	}

	private static double calCheeseArea(int r, int c) {
		double x = ( r - c );
		double cheese = java.lang.Math.pow(x, 2);
		return cheese;
	}
	private static double calTotaltArea(int r) {
		double wholeArea = java.lang.Math.pow(r,2);
		return wholeArea;
	}
}
