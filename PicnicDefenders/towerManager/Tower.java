package towerManager;
/**
 * This is the tower class, it will serve as the basis to create various towers to be placed in our 'Tower Map'.
 * @author schmi
 *
 */
public class Tower {
	//Attributes
		/**
		 * Attribute representing the towers damage.
		 */
		private int towerDamage;
		/**
		 * Attribute representing the towers range.
		 */
		private int towerRange;
		/**
		 * Attribute representing the towers tag, which serves to differentiate between towers.
		 */
		private int towerTag;
		/**
		 * Attribute representing the towers cost.
		 */
		private int towerCost;
	//Constructors
		/**
		 * 
		 * @param damage : This sets the damage of the tower.
		 * @param range : This sets the range of the tower.
		 * @param tag : This sets the tag of the tower. 
		 * @param cost : This sets the cost of the tower.
		 */
		public Tower(int damage, int range, int tag, int cost){
			this.towerDamage = damage;
			this.towerRange = range;
			this.towerTag = tag;
			this.towerCost = cost;
		}
	//Methods
		//Getters
		/**
		 	* This method gets the damage of the tower.
		 * @return The value of the towers damage as a primitive copy.
		 */
			public int getTowerDamage() {
				int damage = this.towerDamage;
				return damage;
			}
			
			/**
			 * This method gets the range of the tower.
			 * @return The value of the towers range as a primitive copy.
			 */
			public int getTowerRange() {
				int range = this.towerRange;
				return range;
			}
			
			/**
			 * This method gets the tag of the tower.
			 * @return The value of the towers tag as a primitive copy.
			 */
			public int getTowerTag() {
				int tag = this.towerTag;
				return tag;
			}
			
			/**
			 * This method gets the cost of the tower.
			 * @return The value of the towers cost as a primitive copy.
			 */
			private int getTowerCost() {
				int cost = this.towerCost;
				return cost;
			}
}
