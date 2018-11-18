package playagame;

import java.util.Random;
import java.util.Scanner;

public class PickANumber {
	Scanner input = new Scanner(System.in);

	public int userGuess;

	public int computerGuess;
 
	public void getUserInput() {
		System.out.println("Pick a Number between 1 and 10. "
				+ "\nTry to pick the number that I am thinking of");
		try {
			userGuess = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Thats not a number!");
			getUserInput();
		}
	}

	public void play() {
		Random r = new Random();
		computerGuess = (r.nextInt(10) + 1);

	}

	public boolean isUserWinner() {

		if (computerGuess == userGuess) {
			return true;
		} else if (computerGuess != userGuess) {

		}
		return false;
	}

	public int getComputerGuess() {
		return computerGuess;
	}

}
