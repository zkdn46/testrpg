package testrpg;

import java.io.IOException;
import java.util.ArrayList;

public class Player {

	private static Player instance = new Player();

	public static Player getInstance() {
		return instance;
	}

	private boolean isRun;
	protected int money = 10000;

	protected ArrayList<Item> items = new ArrayList<>();
	protected ArrayList<Meeple> guilds = new ArrayList<>();
	protected ArrayList<Meeple> partys = new ArrayList<>();

	protected void inventory() {
		isRun = true;
		guilds.add(new Meeple("뭐", 1, 1, 1, 1, 1));
		guildList();
	}

	private void guildList() {
		if (guilds.size() == 0) {
			Main.buffer.setLength(0);
			Main.buffer.append("길드원이 없습니다.\n");
			try {
				Main.writer.append(Main.buffer);
				Main.writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		while (isRun) {
			for (int i = 0; i < guilds.size(); i++) {
				System.out.print(i + 1 + ")");
				guilds.get(i).printStatus();
				guilds.get(i).printEquitedItem();
			}
			PrintEquip(Main.input("뒤로가기(0)번 / 길드원 선택: ") - 1);
		}
	}

	private void PrintEquip(int x) {
		if (x == -1) {
			isRun = false;
		}

		if (x < 0 || x > guilds.size()) {
			return;
		}
		guilds.get(x).printStatus();
		guilds.get(x).printEquitedItem();

		printItemList();

		equip(x, Main.input("종료(0)번 / 장착할 장비 선택: ") - 1);
	}

	private void equip(int idx, int item) {
		if (item == -1) {
			isRun = false;
		}

		if (item < 0 || item > items.size()) {
			return;
		}

		if (items.get(item).getKind() == Item.WEAPON) {
			if (guilds.get(idx).weapon == null) {
				guilds.get(idx).weapon = items.get(item);
				items.remove(item);
			} else {
				items.add(guilds.get(idx).weapon);
				guilds.get(idx).weapon = items.get(item);
				items.remove(item);
			}
		} else if (items.get(item).getKind() == Item.ARMOR) {
			if (guilds.get(idx).armor == null) {
				guilds.get(idx).armor = items.get(item);
				items.remove(item);
			} else {
				items.add(guilds.get(idx).armor);
				guilds.get(idx).armor = items.get(item);
				items.remove(item);
			}
		} else if (items.get(item).getKind() == Item.RING) {
			if (guilds.get(idx).ring == null) {
				guilds.get(idx).ring = items.get(item);
				items.remove(item);
			} else {
				items.add(guilds.get(idx).ring);
				guilds.get(idx).ring = items.get(item);
				items.remove(item);
			}
		}

		Main.buffer.setLength(0);
		Main.buffer.append("장비 장착 완료.\n");
		try {
			Main.writer.append(Main.buffer);
			Main.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void printItemList() {
		int i = 1;
		for (Item item : items) {
			Main.buffer.setLength(0);
			Main.buffer.append(i++ + "." + item + "\n");
			try {
				Main.writer.append(Main.buffer);
				Main.writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
