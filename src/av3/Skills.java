package av3;

public interface Skills {
	public abstract void firstSkill(Entity enemy);
	public abstract void secondSkill(Entity enemy);
	public abstract void decreaseS1Cooldown();
	public abstract void decreaseS2Cooldown();
}
