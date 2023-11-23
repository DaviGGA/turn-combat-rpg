package av3;

public class Main {

	public static void main(String[] args) {
		
		Warrior p1 = new Warrior();
		Warrior p2 = new Warrior();
			
		while (true) {
			int p1Initiative = Dice.roll(5, p1.getSpeed());
			int p2Initiative = Dice.roll(5, p2.getSpeed());
			
			Turn.playerStatus(p1, p2);
			
			if (p1Initiative > p2Initiative) {
				System.out.println("JOGADOR 1 - O que deseja fazer?");
				Turn.playerAction(p1, p2);
				
				System.out.println("JOGADOR 2 - O que deseja fazer?");
				Turn.playerAction(p2, p1);
			} else {
				System.out.println("JOGADOR 2 - O que deseja fazer?");
				Turn.playerAction(p2, p1);
				
				System.out.println("JOGADOR 1 - O que deseja fazer?");
				Turn.playerAction(p1, p2);
			}
				
		}


	}

}