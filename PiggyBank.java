
public class PiggyBank {
	private int gold;
	
	PiggyBank(int starting_gold) {
		this.gold = starting_gold;
	}
	
	private void setGold(int gold_set) {
		this.gold = gold_set;
	}
	
	private int getGold() {
		return gold;
	}
	
	private void enemyKilled(int enemy_gold) {
		this.gold += enemy_gold;
	}
	private void towerBought(int tower_price) {
		this.gold -= tower_price;
	}
	
}
