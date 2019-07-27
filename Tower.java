
public class Tower {
	
	//Attributes
		int towerDamage = 1;
		int range = 1;
		int tag = 0;
		int cost = 0;//Obviously change this later. Perhaps 1 as a base cost.
		
	//Constructors
		Tower(int damage,int range, int tag,int cost){
			this.towerDamage = damage;
			this.range = range;
			this.tag = tag;
		}
		
	//Methods
		//DO THE "range-check" METHOD ONCE WE IMPLEMENT TOWER PLACEMENT.
		
		//getters
		private int getTag() {
			int tag = this.tag;
			return tag;
		}
}
