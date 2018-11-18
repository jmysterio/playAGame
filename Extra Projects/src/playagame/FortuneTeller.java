package playagame;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FortuneTeller {

	private Map<Integer, String> colors = new Hashtable<Integer, String>();
	private Map<Integer, String> quotes = new Hashtable<Integer, String>();
	Integer[] firstNumberChoices = new Integer[] { 1, 2, 3, 4 };
	Integer[] secondNumberChoices = new Integer[] { 5, 6, 7, 8 };
	Scanner input = new Scanner(System.in);
	private int userInput;
	private String userColorInput;

	public Map<Integer, String> getColors() {
		return colors;
	}

	public FortuneTeller() {
		populateColorMap();
		populateQuotesMap();
	}

	private void populateQuotesMap() {
		quotes.put(1, "We live in the best of all possible worlds.  \n" + "– Gottfried Wilhelm Leibniz");
		quotes.put(2, "There must be somebody there, because somebody must have said \"Nobody.” \n"
				+ "― A.A. Milne, WINNIE THE POOH");
		quotes.put(3, "“The unexamined life is not worth living” \n" + "– Socrates");
		quotes.put(4, "Wisdom begins in wonder” \n" + "― Socrates");
		quotes.put(5, "“The point is there ain't no point.” \n" + "― Cormac McCarthy, NO COUNTRY FOR OLD MEN");
		quotes.put(6,
				"“Why do we argue? Life's so fragile, a successful virus clinging to a speck of mud, suspended in endless nothing.” \n"
						+ "― Alan Moore, WATCHMEN");
		quotes.put(7,
				"If we believe in nothing, if nothing has any meaning and if we can affirm no values whatsoever, then everything is possible and nothing has any importance.” \n"
						+ "― Albert Camus, THE REBEL, AN ESSAY ON MAN IN REVOLT");
		quotes.put(8,
				"Those who believe in nothing are very, very jealous and angry at those who believe in something. \n DENNIS PRAGER");
	}

	private void populateColorMap() {
		colors.put(1, "PAPAYA"); // EVEN
		colors.put(2, "BRICK"); // ODD
		colors.put(3, "YELLOW"); // EVEN
		colors.put(4, "CRIMSON"); // ODD
		colors.put(5, "ARCTIC"); // EVEN
		colors.put(6, "JUNIPER"); // ODD
		colors.put(7, "MAROON"); // EVEN
		colors.put(8, "LAPIS"); // ODD
	}

	private void displayFortuneRules() {
		System.out.println("--------------------------- ");
		System.out.println("Welcome to Fortune Teller!!");
		System.out.println("...follow the steps to be given your fortune.");
		System.out.println("Choose your first path...");
		System.out.println("CHOOSE -- 1, 2, 3 OR 4.");
	}

	private void getUserInput() {

		try {
			userInput = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Thats not an option!");
			getUserInput();
		}

	}

	public void play() {
		displayFortuneRules();
		getUserInput();
		if (userInput >= 5 || userInput < 1) {
			System.out.println("Thats Not an Option");
			System.out.println("CHOOSE -- 1, 2, 3 OR 4.");

			getUserInput();
		}
		if (userInput % 2 == 0) {
			System.out.println("Next Step, Choose one of these colors...");

			List<String> colorOptions = colorOption(true);
			String color = getColorInput(colorOptions);
			getFinalChoice(color);
		} else if (userInput % 2 == 1) {
			System.out.println("Next Step, Choose one of these colors...");
			// give color option 2 method
			List<String> colorOptions = colorOption(false);
			String color = getColorInput(colorOptions);
			getFinalChoice(color);

		}

	}

	private List<String> colorOption(boolean userInput) {
		List<String> choices = new ArrayList<>();
		// for (String color : colors.values())
		if (userInput) {
			for (int i = 1; i <= 4; i++) {
				System.out.println(colors.get(i));
				choices.add(colors.get(i));
			}
			return choices;

		}
		for (int i = 5; i <= 8; i++) {
			System.out.println(colors.get(i));
			choices.add(colors.get(i));
		}
		return choices;

	}

	private String getColorInput(List<String> options) {

		do {
			userColorInput = input.nextLine().toUpperCase();
			for (String color : options) {
				if (color.equals(userColorInput)) {
					return color;
				}

			}

			System.out.println(userColorInput + " is not an option.");
			 colorOption(false);
		} while (true);
		
//		getColorInput(options);
//		return "Something went wrong";

	}

	private String getFinalChoice(String userColorInput) {
		System.out.println(userColorInput);
		int colorLength = userColorInput.length();
		System.out.println(colorLength);
		if (colorLength % 2 == 0) {
			System.out.println("Choose your final number..." + "1,2,3 or 4");
			getUserInput();
			if (userInput < 1 && userInput > 4) {
				System.out.println("Choose an actual option" + "1,2,3 or 4");

				getUserInput();

			}
			System.out.println(quotes.get(userInput));
			return "End";

		}

		if (colorLength % 2 != 0) {
			System.out.println("Choose an actual option" + "5,6,7 or 8");
			getUserInput();
			if (userInput < 1 && userInput > 4) {
				System.out.println("Choose an actual option" + "5,6,7 or 8");

				getUserInput();
			}
			System.out.println(quotes.get(userInput));
			return "End";
		}
		return toString();
	}
}
