package testrpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public StringBuffer buffer = new StringBuffer();
	public BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private boolean isRun = true;
	
	public void run() {
		while(isRun) {
			printMenu();
			play();
		}
	}

	private void printMenu() {
		buffer.append("=== test RPG === \n");
		buffer.append("1)마을 2)던전 3)종료");
		try {
			writer.append(buffer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
