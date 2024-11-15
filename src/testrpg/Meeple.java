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

	public String toString() {
		return String.format("이름) %s / Lv.%d / HP:%d / MP:%d / ATT:%d / DEF:%d\n무기:%s / 방어구:%s / 장신구:%s\n", name, level,
				hp, mp, att, def, weapon, armor, ring);
	}

}