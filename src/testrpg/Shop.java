package testrpg;

import java.io.IOException;
import java.util.ArrayList;

public class Shop {
	private static Shop instance = new Shop();
	private final int BUY =1;
	private final int SELL =2;
	
	public static Shop getInstance() {
		return instance;
	}

	private Player player = Player.getInstance();
	protected ArrayList<Item> itemList = new ArrayList<>();

	protected void shopRun() {
		setItem();
		printMenu();
	}

	protected void printMenu() {
		Main.buffer.setLength(0);
		Main.buffer.append("=== 더조은상점 === \n");
		Main.buffer.append(String.format("현재 GOLD: %d\n", player.money));
		Main.buffer.append("1)구매 2)판매 *)처음으로\n");
		try {
			Main.writer.append(Main.buffer);
			Main.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int sel = Main.input("메뉴 선택: ");

		if (sel == BUY) {
			buyMenu();
		} else if (sel == SELL) {
			sellMenu();
		}
	}

	private void buyMenu() {
		int i = 1;
		for (Item item : itemList) {
			Main.buffer.setLength(0);
			Main.buffer.append(i++ + "." + item + "\n");
			try {
				Main.writer.append(Main.buffer);
				Main.writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		buy(Main.input("구매할 상품 선택: ") - 1);
	}

	private void buy(int x) {
		if (itemList.get(x).getPrice() > player.money || x < 0 || x > 8) {
			Main.buffer.setLength(0);
			Main.buffer.append("구매실패\n");
			try {
				Main.writer.append(Main.buffer);
				Main.writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		player.items.add(itemList.get(x));
		player.money -= itemList.get(x).getPrice();
		Main.buffer.setLength(0);
		Main.buffer.append("구매완료\n");
		try {
			Main.writer.append(Main.buffer);
			Main.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void sellMenu() {
		int i = 1;
		for (Item item : player.items) {
			Main.buffer.setLength(0);
			Main.buffer.append(i++ + "." + item + "\n");
			try {
				Main.writer.append(Main.buffer);
				Main.writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sell(Main.input("판매할 상품 선택(수수료50%): ") - 1);
	}

	private void sell(int x) {
		if (x < 0 || x >= player.items.size()) {
			Main.buffer.setLength(0);
			Main.buffer.append("판매실패\n");
			try {
				Main.writer.append(Main.buffer);
				Main.writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		player.items.remove(x);
		player.money += player.items.get(x).getPrice() / 2;
		Main.buffer.setLength(0);
		Main.buffer.append("판매완료\n");
		try {
			Main.writer.append(Main.buffer);
			Main.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setItem() {
		itemList.clear();
		itemList.add(new Item(Item.WEAPON, "나뭇가지", 3, 1000));
		itemList.add(new Item(Item.WEAPON, "검", 5, 2000));
		itemList.add(new Item(Item.WEAPON, "마법검", 10, 4000));
		itemList.add(new Item(Item.ARMOR, "티셔츠", 3, 1000));
		itemList.add(new Item(Item.ARMOR, "가죽조끼", 5, 2000));
		itemList.add(new Item(Item.ARMOR, "철갑옷", 10, 4000));
		itemList.add(new Item(Item.RING, "동반지", 3, 1000));
		itemList.add(new Item(Item.RING, "은반지", 5, 2000));
		itemList.add(new Item(Item.RING, "금반지", 10, 4000));
	}
}
