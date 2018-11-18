package playagame;

import java.util.Map;
import java.util.Scanner;

public class PlayaGame {
// CONSTANTS FOR MENU OPTIONS
	private static final String FORTUNE_TELLER = "Fortune Teller";
	private static final String DICE_GAME = "Dice Game";
	private static final String PICK_A_NUMBER = "Pick A Number";
	private static final String EXIT = "EXIT";
	private static final String[] GAMECHOICE = { FORTUNE_TELLER, DICE_GAME, PICK_A_NUMBER };
	private Menu menu;
	Scanner gamerInput = new Scanner(System.in);
	PlayaGame PlayAGame = new PlayaGame();
	
	public PlayaGame() {

	} 

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);

		while (true) {
			System.out.println("What do you want to play?");
			String choice = (String) menu.getChoiceFromOptions(GAMECHOICE);

			if (choice.equals(FORTUNE_TELLER)) {
				FortuneTeller ft = new FortuneTeller();
				//ft.displayFortuneRules();
				ft.play();

////////////////////////////////////////////////////////////////////////////////
			} else if (choice.equals(DICE_GAME)) {
				DiceGame dg = new DiceGame();
				dg.diceRoll();
				System.out.println("\n"+
						"The computer rolled " + 
						dg.getComputerScore() + 
						" and you rolled " + 
						dg.getUserScore() + 
						".");
				System.out.println("\n***");
				if (dg.isUserWinner()) {
					System.out.println("You WIN!!"+
										"\n***"); 
				} else {
					System.out.println("YOU LOSE!!"+
										"\n***");
				}
			}
//////////////////////////////////////////////////////////////////////////////// 
			else if (choice.equals(PICK_A_NUMBER)) {

				PickANumber pan = new PickANumber();

				pan.getUserInput();

				pan.play();

				if (pan.isUserWinner()) {
					System.out.println("You Win!! I Chose..." + pan.computerGuess);
				} else {
					System.out.println("Sorry I chose " + pan.computerGuess + " Not " + pan.userGuess);
				}

////////////////////////////////////////////////////////////////////////////////				
			} else if (choice.equals(EXIT)) {
				System.out.println("Thanks for playing..Goodbye!");
				break;
			}
		}

	}

}
