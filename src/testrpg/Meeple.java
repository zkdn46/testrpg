package testrpg;

public class Meeple extends Unit {
	protected int exp;
	protected boolean isParty;
	protected Item weapon;
	protected Item armor;
	protected Item ring;

	protected Meeple(String name, int level, int hp, int mp, int att, int def) {
		super(name, level, hp, mp, att, def);
	}

	protected Meeple() {

	}

	protected void printStatus() {
		System.out.print("[이름: " + name + "] ");
		System.out.print("Lv." + level + "] ");

		if (ring != null) {
			System.out.print(" [HP: " + hp + " + " + ring.getPower());
		} else {
			System.out.print(" [HP: " + hp);
		}
		if (ring != null) {
			System.out.print(" / " + maxHp + " + " + ring.getPower() + "] ");
		} else {
			System.out.print(" / " + maxHp + "] ");
		}
		if (weapon != null) {
			System.out.print("[ATT: " + att + " + " + weapon.getPower() + "] ");
		} else {
			System.out.print("[ATT: " + att + "] ");
		}
		if (armor != null) {
			System.out.print(" [DEF: " + def + " + " + armor.getPower() + "] ");
		} else {
			System.out.print(" [DEF: " + def + "] ");
		}
		System.out.println();
	}

	protected void printEquitedItem() {
		if (weapon == null) {
			System.out.print("[무기: 없음] ");
		} else {
			System.out.print("[무기: " + weapon.getName() + "] ");
		}
		if (armor == null) {
			System.out.print("[방어구: 없음] ");
		} else {
			System.out.print("[방어구: " + armor.getName() + "] ");
		}
		if (ring == null) {
			System.out.print("[반지: 없음] ");
		} else {
			System.out.print("[반지: " + ring.getName() + "] ");
		}
		System.out.println();
	}

}