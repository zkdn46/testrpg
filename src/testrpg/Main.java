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

	public StringBuffer buffer = new StringBuffer();
	public BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private boolean isRun = true;

	public void run() {
		while (isRun) {
			printMenu();
			play();
		}
	}

	private void printMenu() {
		buffer.setLength(0);
		buffer.append("=== test RPG === \n");
		buffer.append("1)마을 2)던전 3)종료");
		try {
			writer.append(buffer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void play() {
		int sel = input();
		if (sel == TOWN) {

		} else if (sel == DUNGEON) {

		} else if (sel == EXIT) {
			exit();
		}
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

	private int input() {
		int num = -1;
		try {
			num = Integer.parseInt(reader.readLine());
			return num;
		} catch (Exception e) {
			System.err.println("숫자 입력!");
			return num;
		}
	}

}
