package pkglab1;

import java.util.Scanner;
import java.text.*;

public class cMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Set up the scanner function so that the user can input data
		//Get the data from the user
		System.out.print("How many years you plan to work: ");
		double Timetowork = input.nextDouble();
		System.out.print("What is the annual return percentage: ");
		double AnualInv = input.nextDouble();
		// Set the range for both of the annual return
		// give them unlimited times of chance to retype in the data
		while(AnualInv < 0 || AnualInv > 20){
			System.out.print("Sorry, please type in rate between 0% and 20%.");
			AnualInv = input.nextDouble();
			}
		System.out.print("How many years do you want to draw: ");
		double Retireyear = input.nextDouble();
		System.out.print("What is the annual return rate at this time: ");
		double Anualreturn = input.nextDouble();
		while (Anualreturn < 0 || Anualreturn > 3){
			System.out.print("Sorry, please type in rate between 0% and 3%.");
			Anualreturn = input.nextDouble();
		}
		System.out.print("How much money do you want to have per month after retire: ");
		double MoneyEveryMonth = input.nextDouble();
		System.out.print("What is your expected monthly SSI income: ");
		double MonthlySSI = input.nextDouble();
		//Calculate the two results though the two finance functions
		double NeedToSaveTotal = (MoneyEveryMonth - MonthlySSI)*((1-1/(Math.pow(1+Anualreturn/100/12,Retireyear*12)))/(Anualreturn/100/12));
		double NeedToSaveEveryMonth = (NeedToSaveTotal*(AnualInv/100/12))/(Math.pow((1+(AnualInv/100/12)),Timetowork*12)-1);
		//keep two decimal places.
		DecimalFormat df = new DecimalFormat(".##");
		String NeedToSaveTotaldf = df.format(NeedToSaveTotal);
		String NeedToSaveEveryMonthdf = df.format(NeedToSaveEveryMonth);
		//print them out in the right order
		System.out.println("You need to save totally $"+NeedToSaveEveryMonthdf+" monthly.");
		System.out.print("You need to save totally $"+NeedToSaveTotaldf);
		input.close();
		
	}
}