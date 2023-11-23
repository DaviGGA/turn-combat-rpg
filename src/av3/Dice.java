package av3;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	
	
	public static int roll(int dice, int plus) {
		int randomDice = ThreadLocalRandom.current().nextInt(1, dice + 1);
		return randomDice + 1;
	}
	
}
