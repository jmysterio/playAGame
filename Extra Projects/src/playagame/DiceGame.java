package playagame;

public class DiceGame {

	int dieForComputer;
	int dieForUser;
 
	public void diceRoll() {

		dieForComputer = (int) (Math.random() * 6 + 1);
		dieForUser = (int) (Math.random() * 6 + 1);

		dieForComputer += (int) (Math.random() * 6 + 1);
		dieForUser += (int) (Math.random() * 6 + 1);

	}
 
 
	public boolean isUserWinner() {

		if (dieForUser>=dieForComputer) {
			return true;
		} else {
			return false;
		}  

	}

	public int getComputerScore() {
		return dieForComputer;
	}

	public int getUserScore() {
		return dieForUser;
	}
}
