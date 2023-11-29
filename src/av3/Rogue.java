package av3;

import java.io.IOException;

public class Rogue extends Entity implements Skills {
	public Rogue() {
		super(14, 14, 12, 4, 4, 3);
		s1Name = "Explorar fraquezas";
		s2Name = "Concentração";
		s1CD = 0;
		s2CD = 0;
	}
	
	@Override // Maior chance de causar dano e +2 de acerto em um ataque, Diminui a armadura do alvo por certo tempo.
	public void firstSkill(Entity enemy) throws IOException {
		if (s1CD > 0) {
			System.out.println("Essa habilidade ainda está em recarga.\n");
			return;
		}
		
		
		String exploreWeaknessMessage = "Você utilizou explorar fraquezas.\n";
		System.out.println(exploreWeaknessMessage);
		Log.registerLine(exploreWeaknessMessage);
		
		if (this.hasHit(enemy, this.getTotalHit() + 2)) {
			int damageRoll = Dice.roll(10, this.getTotalDamage());	
			enemy.takeDamage(damageRoll);
			
			String damageMessage = "Seu golpe causou " + damageRoll + " de dano.\n";
			System.out.println(damageMessage);
			
			Effect effect = new Effect(3,-2,0,0,0);
			enemy.getEffects().add(effect);
		} else {
			String missAttackMessage = "Você errou seu ataque!\n";
			System.out.println(missAttackMessage);
			Log.registerLine(missAttackMessage);
		}
		
		this.s1CD = 5;
	}

	@Override // Aumenta armadura e chance de acerto
	public void secondSkill(Entity enemy) throws IOException {
		if (s2CD > 0) {
			System.out.println("Essa habilidade ainda está em recarga.\n");
			return;
		}
		
		String concentrationMessage = "Você utilizou concentração. Armadura e chance de acerto aumentada.\n";
		System.out.println(concentrationMessage);
		Log.registerLine(concentrationMessage);
			
		Effect effect = new Effect(3,2,0,0,2);
		this.effects.add(effect);
		
		this.s2CD = 10;
		
		
	}
	
	@Override
	public void decreaseS1Cooldown() {
		this.s1CD--;
		
		if (s1CD < 0) {
			s1CD = 0;
		}
	}
	
	@Override
	public void decreaseS2Cooldown() {
		this.s2CD--;
		
		if (s2CD < 0) {
			s2CD = 0;
		}
	}
}
