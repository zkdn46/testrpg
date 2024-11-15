package testrpg;

import java.io.IOException;

public class Guild {
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int VIEW = 3;
	private final int PARTY = 4;

	private static Guild instance = new Guild();

	public static Guild getInstance() {
		return instance;
	}
	
	Player player = Player.getInstance();

	protected void guildRun() {
		printMenu();
	}

	protected void printMenu() {
		Main.buffer.setLength(0);
		Main.buffer.append("=== 더조은길드 === \n");
		Main.buffer.append("1)길드원가입 2)길드원추방 3)길드원목록 4)파티원구성 *)처음으로\n");
		try {
			Main.writer.append(Main.buffer);
			Main.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int sel = Main.input("메뉴 선택: ");

		if (sel == JOIN) {
			player.guilds.add(null);
		} else if (sel == LEAVE) {

		} else if (sel == VIEW) {

		} else if (sel == PARTY) {

		}
	}

}