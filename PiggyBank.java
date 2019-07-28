
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
		this.gold = this.getGold() + enemy_gold;
	}
	private void towerBought(int tower_price) {
		this.gold = this.getGold() - tower_price;
	}
	
}
