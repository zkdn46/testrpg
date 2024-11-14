package testrpg;

import java.io.IOException;

public class Town {
	
	protected void printMenu() {
		Main.buffer.setLength(0);
		Main.buffer.append("=== 더조은마을 === \n");
		Main.buffer.append("1)길드 2)상점 3)인벤토리 4)저장 5)로드 6)뒤로가기\n");
		try {
			Main.writer.append(Main.buffer);
			Main.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Main.input("메뉴 선택");
	}

}
