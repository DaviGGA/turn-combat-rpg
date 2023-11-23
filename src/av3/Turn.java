package av3;
import java.util.Scanner;

public class Turn {
	public static Scanner sc = new Scanner(System.in);

	public static void passTurn(Entity p) {
		for (Effect e: p.getEffects()) {
			int newDuration = e.getDuration() - 1;
			e.setDuration(newDuration);
		}
		
		p.getEffects().removeIf(e -> e.getDuration() <= 0);
		
		
	}
	
	public static void decreaseSkillCDR(Entity p) {
		if (p instanceof Warrior) {
			Warrior warrior = (Warrior)p;
			
			warrior.decreaseFlameBladeCooldown();
			warrior.decreaseSecondWindCooldown();
		}
	}
	
	public static void playerStatus(Entity p1, Entity p2) {
		System.out.println("========================");
		System.out.println("JOGADOR 1: " + p1.getHealth() + '/' + p1.getMaxHealth());
		System.out.println("JOGADOR 2: " + p2.getHealth() + '/' + p2.getMaxHealth());
		System.out.println("========================");
	}
	
	public static void playerAction(Entity attacker, Entity defender) {
		System.out.println("1 - Atacar");
		System.out.println("2 - " + getFirstSkillName(attacker));
		System.out.println("3 - " + getSecondSkillName(attacker));
		
		int choice = sc.nextInt();
		 	
		switch (choice) {
			case 1:
				attacker.normalAttack(defender);
				break;
			case 2:
				useFirstSkill(attacker, defender);
				break;
			case 3:
				useSecondSkill(attacker, defender);
				break;
		}
	}
	
	private static void useFirstSkill(Entity attacker, Entity defender) {
		if (attacker instanceof Warrior) {
			Warrior warrior = (Warrior) attacker;
			warrior.flameBlade(defender);
		}
	}
	
	private static void useSecondSkill(Entity attacker, Entity defender) {
		if (attacker instanceof Warrior) {
			Warrior warrior = (Warrior) attacker;
			warrior.secondWind();
		}
	}
	
	private static String getFirstSkillName(Entity e) {
		if (e instanceof Warrior) {
			return "Espada flamejante";
		} else {
			return "";
		}
	}
	
	private static String getSecondSkillName(Entity e) {
		if (e instanceof Warrior) {
			return "Ventos Revigorantes";
		} else {
			return "";
		}
	}
	
	
}
