package av3;

import java.io.IOException;

import Entities.Entity;

public class Main {

	public static void main(String[] args) throws InvalidOptionException, IOException {
		Log.clearLog();
		
		System.out.println("J1 - Escolha sua classe");
		Entity p1 = ClassFactory.createClass();
		
		System.out.println("J2 - Escolha sua classe");
		Entity p2 = ClassFactory.createClass();
		
		String j1GameOver = "Jogador 1 está morto, fim de jogo!\n";
		String j2GameOver = "Jogador 2 está morto, fim de jogo!\n";
				
		while (true) {
			int p1Initiative = Dice.roll(5, p1.getSpeed());
			int p2Initiative = Dice.roll(5, p2.getSpeed());
			
			Turn.playerStatus(p1, p2);
			
			if (p1Initiative > p2Initiative) {
				System.out.println("JOGADOR 1 - O que deseja fazer?");
				Log.registerLine("JOGADOR 1\n");
				Turn.playerAction(p1, p2);
				
				if (p2.getHealth() <= 0) {
					System.out.println(j2GameOver);
					Log.registerLine(j2GameOver);
					break;
				}
				
				System.out.println("JOGADOR 2 - O que deseja fazer?");
				Log.registerLine("JOGADOR 2\n");
				
				Turn.playerAction(p2, p1);
				
				if (p1.getHealth() <= 0) {
					System.out.println(j1GameOver);
					Log.registerLine(j1GameOver);
					break;
				}
			
			} else {
				System.out.println("JOGADOR 2 - O que deseja fazer?");
				Log.registerLine("JOGADOR 2\n");
				Turn.playerAction(p2, p1);
				
				if (p1.getHealth() <= 0) {
					System.out.println(j1GameOver);
					Log.registerLine(j1GameOver);
					break;
				}
				
				System.out.println("JOGADOR 1 - O que deseja fazer?");
				Log.registerLine("JOGADOR 1\n");
				
				Turn.playerAction(p1, p2);
				
				if (p2.getHealth() <= 0) {
					System.out.println(j2GameOver);
					Log.registerLine(j2GameOver);
					break;
				}
			}
			
			Turn.passTurn(p1);
			Turn.passTurn(p2);
		}

	}

}
