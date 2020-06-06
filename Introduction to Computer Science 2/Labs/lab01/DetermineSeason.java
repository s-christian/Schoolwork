import java.util.Scanner;

public class DetermineSeason {

	public static void main(String[] args) {
		
		int day, month;
		String season;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Day (1-31): ");
		day = input.nextInt();
		System.out.print("Month (1-12): ");
		month = input.nextInt();
		
		if		((month == 12 && day >= 16 && day <= 31) || (month >= 1 && month < 3 && day <= 31 && day >= 1) || (month == 3 && day <= 15 && day >= 1)) { season = "winter"; }
		else if ((month == 3 && day >= 16 && day <= 31) || (month > 3 && month < 6 && day <= 31 && day >= 1) || (month == 6 && day <= 15 && day >= 1)) { season = "spring"; }
		else if ((month == 6 && day >= 16 && day <= 31) || (month > 6 && month < 9 && day <= 31 && day >= 1) || (month == 9 && day <= 15 && day >= 1)) { season = "summer"; }
		else if ((month == 9 && day >= 16 && day <= 31) || (month > 9 && month < 12 && day <= 31 && day >= 1) || (month == 12 && day <= 15 && day >= 1)) { season = "fall"; }
		else { season = "ERROR"; }
		
		System.out.println("The current season is " + season);
		
		input.close();
		
	}

}