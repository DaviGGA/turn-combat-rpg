package av3;

public class Warrior extends Entity implements Skills {
	

	
	public Warrior() {
		super(16, 16, 16, 2, 2, 1);
		s1Name = "Espada flamejante";
		s2Name = "Revigorar";
		s1CD = 0;
		s2CD = 0;
	}
	
	@Override // Causa +2 de dano e tem +2 de acerto no ataque
	public void firstSkill(Entity enemy) {
		if (s1CD > 0) {
			System.out.println("Essa habilidade ainda está em recarga.\n");
			return;
		}
		
		System.out.println("Você utilizou espada flamejante.\n");
		this.attack(enemy, 6, this.damage, this.hit + 2);
		this.s1CD = 3;
	}

	@Override // Cura 1d4 de vida e concede +1 de armadura durante 2 turnos;
	public void secondSkill(Entity enemy) {
		if (s2CD > 0) {
			System.out.println("Essa habilidade ainda está em recarga.\n");
			return;
		}
		
		System.out.println("Você utilizou ventos revigorantes.\n");
		
		int healRoll = Dice.roll(4, 0);
		this.healDamage(healRoll);
		
		Effect effect = new Effect(2,1,0,0,0);
		this.effects.add(effect);
		
		this.s2CD = 15;
		
		System.out.println("Você curou " + healRoll + " de vida.\n");
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
