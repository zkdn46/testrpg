package testrpg;

import java.io.IOException;

public class Dungeon {
	
	private static Dungeon instance = new Dungeon();

	public static Dungeon getInstance() {
		return instance;
	}

	protected void printMenu() {
		Main.buffer.setLength(0);
		Main.buffer.append("=== 던전 입구 === \n");
		try {
			Main.writer.append(Main.buffer);
			Main.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int sel = Main.input("1~10 단계 던전 선택: ");

		if (sel < 1 || sel > 10) {
			System.err.println("1~10 선택!");
			return;
		}

		battle(sel);
	}

	private void battle(int sel) {
		
	}

}
