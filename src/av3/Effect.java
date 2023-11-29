package av3;

public class Effect {
	private int duration;
	
	private int armorEffect;
	private int speedEffect;
	private int damageEffect;
	private int hitEffect;
	
	public Effect(int duration, int armorEffect, int speedEffect, int damageEffect, int hitEffect) {
		this.duration = duration;
		this.armorEffect = armorEffect;
		this.speedEffect = speedEffect;
		this.damageEffect = damageEffect;
		this.hitEffect = hitEffect;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getArmorEffect() {
		return armorEffect;
	}

	public void setArmorEffect(int armorEffect) {
		this.armorEffect = armorEffect;
	}

	public int getSpeedEffect() {
		return speedEffect;
	}

	public void setSpeedEffect(int speedEffect) {
		this.speedEffect = speedEffect;
	}

	public int getDamageEffect() {
		return damageEffect;
	}

	public void setDamageEffect(int damageEffect) {
		this.damageEffect = damageEffect;
	}

	public int getHitEffect() {
		return hitEffect;
	}

	public void setHitEffect(int hitEffect) {
		this.hitEffect = hitEffect;
	}
	
	
	
	
	
}
