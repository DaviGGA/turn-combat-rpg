package av3;

public class Warrior extends Entity {
	int flameBladeCD = 0;
	int secondWindCD = 0;
	
	public Warrior() {
		super(16, 16, 16, 2, 2, 1);
	}
	
	// Causa +2 de dano e tem +2 de acerto no ataque
	public void flameBlade(Entity enemy) {
		System.out.println("Você utilizou espada flamejante.");
		this.attack(enemy, 6, this.damage, this.hit + 2);
		this.secondWindCD = 3;
	}
	
	// Cura 1d4 de vida e concede +1 de armadura durante 2 turnos;
	public void secondWind() {
		System.out.println("Você utilizou ventos revigorantes");
		
		int healRoll = Dice.roll(4, 0);
		this.healDamage(healRoll);
		
		Effect effect = new Effect(2,1,0,0,0);
		this.effects.add(effect);
		
		this.secondWindCD = 15;
		
		System.out.println("Você curou " + healRoll + " de vida.");
	}


	public void decreaseFlameBladeCooldown() {
		this.flameBladeCD--;
	}
	
	public void decreaseSecondWindCooldown() {
		this.secondWindCD--;
	}


	

}
