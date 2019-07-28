
public class BasicTower {
	
	//Attributes
		int towerDamage = 1;
		int range = 1;
		int tag = 4;//Perhaps tag 4 should be the tag value as for Vm we use 0,1,2,3.
		int cost = 0;//Obviously change this later. Perhaps 1 as a base cost.
		
	//Constructors
		BasicTower(int damage,int range, int tag,int cost){
			this.towerDamage = damage;
			this.range = range;
			this.tag = tag;
		}
		
	//Methods
		//DO THE "range-check" METHOD ONCE WE IMPLEMENT TOWER PLACEMENT.
		
		//getters
		public int getTag() {
			int tag = this.tag;
			return tag;
		}
		
		public int getRange() {
			int range = this.range;
			return range;
		}
		
		public int getDamage() {
			int damage = this.towerDamage;
			return damage;
		}
		
}
