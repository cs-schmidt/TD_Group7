
public class BaseEnemy {

		//Attributes
			private int enemyHP = 3;
			private int enemyDamage = 1;
			private int tag = 0;
		
		//Constructors
			BaseEnemy(){ //The default constructor is here to spawn just the basic enemies.
			}
			
			BaseEnemy(int enemyHealth, int enemyDamage, int enemyTag){
				this.enemyHP=enemyHealth;
				this.enemyDamage = enemyDamage;
				this.tag = enemyTag;
			}
			BaseEnemy(BaseEnemy toCopy){
				this.enemyHP = toCopy.enemyHP;
				this.enemyDamage = toCopy.enemyDamage;
				this.tag = toCopy.tag;
			}
		//Methods
			public static int bERoundFunction(int round) { //Determine later if round will count from 0 or from 1.***
				return 3 + round; //Determine a function that is balanced.
			}
			
			//Setters
				public void setEnemyHP(int modifiedBy) {
					this.enemyHP = getEnemyHP()- modifiedBy;
				}
				
			//Getters
				public int getEnemyHP() {//I believe because 'healthValue' is a primitive type it encapsulates tag.
					int healthValue = this.enemyHP;				 
					return healthValue;
				}
				
				public int getEnemyTag() {//I believe because 'tagValue' is a primitive type it encapsulates tag. Also is public so it can be used later (perhaps I should make it static too?)
					int tagValue = this.tag;
					return tagValue;
				}
				
				private int getEnemyDamage() {//I believe because 'damageValue' is a primitive type it encapsulates tag.
					int damageValue = this.enemyDamage;
					return damageValue;
				}
				
}
