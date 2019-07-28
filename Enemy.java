
public class Enemy {

		//Attributes
			private int enemyHP;
			private int enemyDamage;
			private int tag;
			private int gold;
			private int speed; // May or may not be used
			private int xcoord;
			private int ycoord;
		
		//Constructors
			Enemy(){ //The default constructor is here to spawn just the basic enemies.
			}
			
			Enemy(int enemyHealth, int enemyDamage, int enemyTag, int gold){
				this.enemyHP=enemyHealth;
				this.enemyDamage = enemyDamage;
				this.tag = enemyTag;
				this.gold = gold;
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
				
				private int getEnemyTag() {//I believe because 'tagValue' is a primitive type it encapsulates tag. Also is public so it can be used later (perhaps I should make it static too?)
					int tagValue = this.tag;
					return tagValue;
				}
				
				private int getEnemyDamage() {//I believe because 'damageValue' is a primitive type it encapsulates tag.
					int damageValue = this.enemyDamage;
					return damageValue;
				}
				private int getEnemyGold() {
					int nGold = this.gold;
					return nGold;
				}
				
				
				
}
