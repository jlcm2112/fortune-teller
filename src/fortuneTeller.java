
// A console application that will tell the user’s fortune 
// based on data received from the user
import java.util.Scanner;

public class FortuneTeller {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // open input

		// ************* Part I *************

		boolean useFortuneTeller;
		do {
			System.out.println("What is your first name? "); // prompt user
			String test = scanner.next(); // get input
			checkForQuit(test); // test input to see if user wants to quit
			String firstName = test; // store input into variable

			System.out.println("What is your last name? ");
			test = scanner.next();
			checkForQuit(test);
			String lastName = test;

			System.out.println("How old are you? ");
			test = scanner.next();
			checkForQuit(test);
			int age = Integer.parseInt(test);

			System.out.println("In which month were you born? (please use the numerical month or I can't read your fortune)\nExample: for November, enter 11. ");
			test = scanner.next();
			checkForQuit(test);
			int month = Integer.parseInt(test);

			System.out.println(
					"Which of the ROYGBIV colors are your favorite? (If you don't know what ROYGBIV is, enter \"Help\")");
			test = scanner.next();
			checkForQuit(test);

			boolean needsHelp = false;
			String favColor = "other"; // initializing variables

			if (test.equalsIgnoreCase("help")) { // if the user typed help in
													// any case...
				needsHelp = true;
			} else {
				favColor = test;
			}

			while (needsHelp) { // ...then we need to help them until
								// they don't need help anymore.
				System.out.println(
						"Red, Orange, Yellow, Green, Blue, Indigo, Violet... \n Which of the ROYGBIV colors are your favorite?");
				test = scanner.next();

				if (test.equalsIgnoreCase("help")) { // if they still need help
					needsHelp = true; // while loop will repeat
				} else {
					checkForQuit(test);
					favColor = test;
					needsHelp = false;
				}
			}

			System.out.println("How many siblings do you have?"); // siblings
			test = scanner.next();
			checkForQuit(test);
			int siblings = Integer.parseInt(test);

			// ************* Part II *************

			int retire;
			if (age % 2 == 0) { // if age is even or odd, assign stuff
				 retire = 30;
			} else {
				 retire = 40;
			}

			String location;
			switch (siblings) { // if siblings = 0, 1, 2, 3, >3, assign
								// stuff
			case 0:
				 location = "Bacelona";
				break;

			case 1:
				 location = "Fiji";
				break;

			case 2:
				 location = "Buenos Aires";
				break;

			case 3:
				 location = "Kyoto";
				break;

			default:
				 location = "Hades";
				break;
			}

			String car;
			switch (favColor.toLowerCase()) { // for their favColor assign car
												// stuff
			case "red":
				car = "Chevy Impala";
				break;

			case "orange":
				car = "Ford Fusion";
				break;

			case "yellow":
				car = "Dodge Intrepid";
				break;

			case "green":
				car = "Chrysler 300C";
				break;

			case "blue":
				car = "Jeep Grand Cherokee";
				break;

			case "indigo":
				car = "Nissan 240SX";
				break;

			case "violet":
				car = "Honda Civic";
				break;

			default:
				car = "Toyota Prius";
				break;
			}
			
			double savings;
			if (month > 0 && month <= 4) { // for birth month, assign savings
				savings = 40000.00;
				
			} else if (month > 4 && month <= 8) {
				savings = 50000.00;

			} else if (month > 8 && month <= 12) {
				savings = 100000.00;
			} else {
				savings = 0.00;
			}

			// ************* Part III *************

			System.out.println(firstName + " " + lastName + " will retire in " + retire + " years with $" + savings
					+ " in the bank, a vacation home in " + location + ", and travel by " + car + ".\n");

			
			System.out.println("Try again? yes or no");
			test = scanner.next();
			useFortuneTeller = test.equalsIgnoreCase("yes");

		} while (useFortuneTeller); // while they type yes, keep doing
									// fortune
									// telling

		System.out.println("Goodbye"); // if not yes, we're done.
		scanner.close();
	}

	public static void checkForQuit(String input) { //a method used to check if the user wants to quit after each input
		if (input.equalsIgnoreCase("quit")) {
			System.out.println("Nobody likes a quitter...");
			System.exit(0);
		}
	}
}
