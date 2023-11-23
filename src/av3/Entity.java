package av3;

import java.util.ArrayList;

public abstract class Entity {
	protected int health;
	protected int maxHealth;
	protected int armor;
	protected int damage;
	protected int hit;
	protected int speed;
	
	protected ArrayList<Effect> effects;
	
	public Entity(int health,int maxHealth, int armor, int damage, int hit, int speed) {
		this.health = health;
		this.maxHealth = maxHealth;
		this.armor = armor;
		this.damage = damage;
		this.hit = hit;
		this.speed = speed;	
		effects = new ArrayList<Effect>();
	}
	
	public void normalAttack(Entity enemy) {
		System.out.println("Você utilizou um ataque normal.");
		
		int totalDamage = this.getTotalDamage();
		int totalHit = this.getTotalHit();
		
		this.attack(
			enemy,
			4,
			totalDamage,
			totalHit
		);
	}

	public void attack(Entity enemy, int maxDamage, int damage, int hitChance) {
		if (this.hasHit(enemy, hitChance)) {
			int damageRoll = Dice.roll(maxDamage, damage);	
			enemy.takeDamage(damageRoll);
			
			System.out.println("Seu golpe causou " + damageRoll + " de dano.");
		} else {
			System.out.println("Você errou seu ataque!");			
		}
	}
	
	public boolean hasHit(Entity enemy, int hit) {
		int hitRoll = Dice.roll(20, hit);
		
		int totalArmor = this.getTotalArmor();
		if (hitRoll > totalArmor) {
			return true;
		}
		
		return false;
	}
	
	public int getTotalArmor() {
		int totalArmor = this.armor;
		
		for (Effect e : effects) {
			int armorEffect = e.getArmorEffect();
			totalArmor += armorEffect;
		}
		
		return totalArmor;
	}
	
	public int getTotalDamage() {
		int totalDamage = this.damage;
		
		for (Effect e : effects) {
			int damageEffect = e.getDamageEffect();
			totalDamage += damageEffect;
		}
		
		return totalDamage;
	}
	
	public int getTotalHit() {
		int totalHit = this.hit;
		
		for (Effect e : effects) {
			int hitEffect = e.getHitEffect();
			totalHit += hitEffect;
		}
		
		return totalHit;
	}
	
	public int getTotalSpeed() {
		int totalSpeed = this.speed;
		
		for (Effect e : effects) {
			int hitSpeed = e.getSpeedEffect();
			totalSpeed += hitSpeed;
		}
		
		return totalSpeed;
	}
	
	
	
	public void takeDamage(int damage) {
		this.health -= damage;
		
		if(this.health < 0) {
			this.health = 0;
		}
	}
	
	public void healDamage(int heal) {
		this.health += heal;
		
		if (this.health > this.maxHealth) {
			this.health = this.maxHealth;
		}
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ArrayList<Effect> getEffects() {
		return effects;
	}

	public void setEffects(ArrayList<Effect> effects) {
		this.effects = effects;
	}
}
