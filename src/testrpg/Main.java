package testrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private final int TOWN = 1;
	private final int DUNGEON = 2;
	private final int EXIT = 3;

	public static StringBuffer buffer = new StringBuffer();
	public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private boolean isRun = true;
	private Town town = Town.getInstance();
	private Dungeon dungeon = Dungeon.getInstance();
	
	private static Main instance = new Main();

	public static Main getInstance() {
		return instance;
	}

	public void run() {
		while (isRun) {
			printMenu();
			play();
		}
	}

	private void printMenu() {
		buffer.setLength(0);
		buffer.append("=== test RPG ===\n");
		buffer.append("1)마을 2)던전 3)종료\n");
		try {
			writer.append(buffer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void play() {
		int sel = input("메뉴 선택: ");
		if (sel == TOWN) {
			town();
		} else if (sel == DUNGEON) {
			dungeon();
		} else if (sel == EXIT) {
			exit();
		}
	}

	private void town() {
		town.printMenu();
	}

	private void dungeon() {
		dungeon.printMenu();
	}

	private void exit() {
		buffer.setLength(0);
		buffer.append("게임 종료.");
		try {
			writer.append(buffer);
			writer.flush();
			isRun = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected static int input(String msg) {
		int num = -1;
		try {
			writer.append(msg);
			writer.flush();
			num = Integer.parseInt(reader.readLine());
			return num;
		} catch (Exception e) {
			System.err.println("숫자 입력!");
			return num;
		}
	}

}
