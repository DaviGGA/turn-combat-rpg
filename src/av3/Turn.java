package av3;
import java.io.IOException;
import java.util.Scanner;

import Entities.Entity;

public class Turn {
	public static Scanner sc = new Scanner(System.in);

	public static void passTurn(Entity p) {
		for (Effect e: p.getEffects()) {
			int newDuration = e.getDuration() - 1;
			e.setDuration(newDuration);
		}
		
		p.getEffects().removeIf(e -> e.getDuration() <= 0);
		
		decreaseSkillCDR(p);
		
	}
	
	private static void decreaseSkillCDR(Entity p) {
		p.decreaseS1Cooldown();
		p.decreaseS2Cooldown();
	}
	
	public static void playerStatus(Entity p1, Entity p2) {
		System.out.println("========================");
		System.out.println("JOGADOR 1: " + p1.getHealth() + '/' + p1.getMaxHealth());
		System.out.println("JOGADOR 2: " + p2.getHealth() + '/' + p2.getMaxHealth());
		System.out.println("========================");
	}
	
	public static void playerAction(Entity attacker, Entity defender) throws InvalidOptionException, IOException {
		System.out.println("1 - Atacar");
		System.out.println("2 - " + attacker.getS1Name() + skillReadyin(attacker.getS1CD()));
		System.out.println("3 - " + attacker.getS2Name() + skillReadyin(attacker.getS2CD()));
		
		printPlayerAttributes(attacker);
		
		chooseSkill(attacker, defender);

	}
	
	public static void chooseSkill(Entity attacker, Entity defender) throws InvalidOptionException, IOException {
		int choice = sc.nextInt();
		
		try {
			if (choice == 1) {
				attacker.normalAttack(defender);
			} else if (choice == 2) {
				attacker.firstSkill(defender);
			} else if (choice == 3) {
				attacker.secondSkill(defender);
			} else {
				throw new InvalidOptionException();
			}
			
		} catch (Exception e) {
			System.out.println("Você utilizou uma opção que não existe");
			chooseSkill(attacker, defender);
		}
	 	

		
		
	}
	
	private static void printPlayerAttributes(Entity p) {
		System.out.println("\n");
		System.out.println("Status:");
		System.out.println("Armadura: " + p.getTotalArmor());
		System.out.println("Velocidade: " + p.getTotalSpeed());
		System.out.println("Dano: " + p.getTotalDamage());
		System.out.println("Acerto: " + p.getTotalHit());
	}
	
	private static String skillReadyin(int skillCD) {
		if (skillCD == 0) {
			return " Hab. pronta";
		}
		
		return " Hab. pronta em " + skillCD + " turnos"; 
	}
	

	
	
}
