
public class BaseEnemy {

		//Attributes
			int enemyHP = 3;
			int enemyDamage = 1;
			int tag = 0;
		
		//Constructors
			BaseEnemy(){ //The default constructor is here to spawn just the basic enemies.
			}
			
			BaseEnemy(int enemyHealth, int enemyDamage, int enemyTag){
				this.enemyHP=enemyHealth;
				this.enemyDamage = enemyDamage;
				this.tag = enemyTag;
			}
		//Methods
			public static int bERoundFunction(int round) { //Determine later if round will count from 0 or from 1.***
				return 3 + round; //Determine a function that is balanced.
			}
			
			//Setters
				private void setEnemyHP(int modifiedBy) {
					this.enemyHP = getEnemyHP()- modifiedBy;
				}
				
			//Getters
				private int getEnemyHP() {//I believe because 'healthValue' is a primitive type it encapsulates tag.
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
