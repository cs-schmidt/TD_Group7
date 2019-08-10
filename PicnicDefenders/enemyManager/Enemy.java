package enemyManager;
/**
 * This class is the basis for creating enemy objects to put in a map.
 * @author ethan.schmidt1
 *
 */
public class Enemy {
	
	//Attributes
		/**
		 * This attribute represents an enemies health.
		 */
		private int enemyHealth;
		/**
		 * This attribute represents an enemies damage.
		 */
		private int enemyDamage;
		/**
		 * This attribute represents an enemies tag.
		 */
		private int enemyTag;
		/**
		 * This attribute represents an enemies value.
		 */
		private int enemyValue;
		
	//Constructors
		/**
		 * This constructor will serve to initialize all of an enemy objects attributes.
		 * @param health : takes an integer to set the attribute health.
		 * @param damage : takes an integer to set the attribute damage.
		 * @param tag : takes an integer to set the attribute tag.
		 * @param value : takes an integer to set the attribute value.
		 */
		protected Enemy(int health, int damage, int tag, int value) {
			this.enemyHealth = health;
			this.enemyDamage = damage;
			this.enemyTag = tag;
			this.enemyValue = value;
			
		}	
		/**
		 * A copy constructor for an enemy object.
		 * @param toCopy : takes an enemy type object as an argument.
		 */
		public Enemy(Enemy toCopy) {
			this.enemyHealth = toCopy.enemyHealth;
			this.enemyDamage = toCopy.enemyDamage;
			this.enemyTag = toCopy.enemyTag;
			this.enemyValue = toCopy.enemyValue;
		}
		
	//Methods
		//Other methods
		
		//Getters
			//All of these are primitive types so they are encapsulated.
			/**
			 * This gets the enemies health.
			 * @return : returns a copy of the enemies health as a integer value.
			 */
			public int getEnemyHealth() {
				int health = this.enemyHealth;
				return health;
			}
			/**
			 * This gets the enemies damage.
			 * @return : returns a copy of the enemies damage as a integer value.
			 */
			public int getEnemyDamage() {
				int damage = this.enemyDamage;
				return damage;
			}
			/**
			 * This gets the enemies tag.
			 * @return : returns a copy of the enemies tag as a integer value.
			 */
			public int getEnemyTag() {
				int tag = this.enemyTag;
				return tag;
			}
			/**
			 * This gets the enemies value.
			 * @return : returns a copy of the enemies value as a integer value.
			 */
			public int getEnemyValue() {
				int value = this.enemyValue;
				return value;
			}
			
		//Setters
			/**
			 * This is setter method that will set the enemies health based on an integer input,
			 * <br> so it will take the health and minus the integer passed.
			 * @param damageRecieved : takes an integer as an argument.
			 */
			public void setEnemyHealth(int damageRecieved) {
				this.enemyHealth = this.enemyHealth - damageRecieved;
			}
}
