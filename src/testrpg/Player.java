package testrpg;

import java.util.ArrayList;

public class Player {
	
	private static Player instance = new Player();

	public static Player getInstance() {
		return instance;
	}
	
	protected int money;
	protected ArrayList<Item> items = new ArrayList<>();
	protected ArrayList<Meeple> guilds = new ArrayList<>();
	protected ArrayList<Meeple> partys = new ArrayList<>();
	
	protected void inventory(){
		printItemList();
	}
	
	private void printItemList() {
	    int i = 1;
		for (Item item : items) {
			System.out.print(i++ + ".");
			System.out.println(item);
		}
	  }
}
