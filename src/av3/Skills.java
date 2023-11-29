package av3;

import java.io.IOException;

public interface Skills {
	public abstract void firstSkill(Entity enemy) throws IOException;
	public abstract void secondSkill(Entity enemy) throws IOException;
	public abstract void decreaseS1Cooldown();
	public abstract void decreaseS2Cooldown();
}
