package testrpg;

import java.io.IOException;

public class Town {
	private final int GUILD = 1;
	private final int SHOP = 2;
	private final int INVEN = 3;
	private final int SAVE = 4;
	private final int LOAD = 5;

	private static Town instance = new Town();

	public static Town getInstance() {
		return instance;
	}

	private Player player = Player.getInstance();
	private Shop shop = Shop.getInstance();
	private Guild guild = Guild.getInstance();

	protected void printMenu() {
		Main.buffer.setLength(0);
		Main.buffer.append("=== 더조은마을 === \n");
		Main.buffer.append("1)길드 2)상점 3)인벤토리 4)저장 5)로드 *)뒤로가기\n");
		try {
			Main.writer.append(Main.buffer);
			Main.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int sel = Main.input("메뉴 선택: ");

		if (sel == GUILD) {
			guild.guildRun();
		} else if (sel == SHOP) {
			shop.shopRun();
		} else if (sel == INVEN) {
			player.inventory();
		} else if (sel == SAVE) {
			
		} else if (sel == LOAD) {

		}

	}

}
