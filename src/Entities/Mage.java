package Entities;

import java.io.IOException;

import av3.Effect;
import av3.Log;
import av3.Skills;

public class Mage extends Entity implements Skills {
	public Mage() {
		super(12, 12, 11, 4, 6, 2);
		s1Name = "Mísseis mágicos";
		s2Name = "Maldição";
		s1CD = 0;
		s2CD = 0;
	}
	
	@Override // Causa uma grande quantidade de dano
	public void firstSkill(Entity enemy) throws IOException {
		if (s1CD > 0) {
			System.out.println("Essa habilidade ainda está em recarga.\n");
			return;
		}
		
		String magicMissileMessage = "Você utilizou mísseis mágicos.\n";
		System.out.println(magicMissileMessage);
		Log.registerLine(magicMissileMessage);
		
		this.attack(enemy, 10, this.getTotalDamage() + 2, this.getTotalHit() + 2);
		this.s1CD = 8;
	}

	@Override // Cura 1d4 de vida e concede +1 de armadura durante 2 turnos;
	public void secondSkill(Entity enemy) throws IOException {
		if (s2CD > 0) {
			System.out.println("Essa habilidade ainda está em recarga.\n");
			return;
		}
		
		String hexMessage = "Você utilizou maldição\n";
		System.out.println(hexMessage);
		Log.registerLine(hexMessage);
		
		Effect effect = new Effect(3,-1,-1,-2,-2);
		enemy.getEffects().add(effect);
		
		this.s2CD = 9;
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
