package testrpg;

public class Meeple extends Unit {
	protected int exp;
	protected boolean isParty;
	protected Item weapon;
	protected Item armor;
	protected Item ring;
	
	Meeple(String name, int level, int hp, int mp, int att, int def) {
		super(name, level, hp, mp, att, def);
	}
	
}