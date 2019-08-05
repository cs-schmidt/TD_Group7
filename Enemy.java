
public class Enemy {

		//Attributes
			private int enemyHP;
			private int enemyDamage;
			private int tag;
			private int gold;
			private int speed; // May or may not be used
			private int xcoord;
			private int ycoord;
			protected int[][] roadCoordinates;
			private int counter = 0;
		
		//Constructors
			Enemy(){ //The default constructor is here to spawn just the basic enemies.
			}
			
			Enemy(int enemyHealth, int enemyDamage, int enemyTag, int gold, int[][] validityMapBase){
				this.enemyHP=enemyHealth;
				this.enemyDamage = enemyDamage;
				this.tag = enemyTag;
				this.gold = gold;
				this.roadCoordinates = getRoadCoords(validityMapBase);
			}
			
			Enemy(int[][] validityMapBase){
				this.roadCoordinates = getRoadCoords(validityMapBase);
			}
			
			Enemy(int health,int[][] validityMapBase){
				this.enemyHP = health;
				this.roadCoordinates = getRoadCoords(validityMapBase);
			}
			
			Enemy(int dummy){
				this.tag = dummy;
			}
			
			
			//Setters
				private void updateEnemyHP(int modifiedBy) {
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
				private int getEnemyGold() {
					int nGold = this.gold;
					return nGold;
				}
				public int getXcoords() {
					int xcoords = this.xcoord;
					return xcoords;
				}
				public int getYcoords() {
					int ycoords = this.ycoord;
					return ycoords;
					
				}
				private void updateCoords(int x, int y) {
					this.xcoord = x;
					this.ycoord = y;
				}
				
				private int findRoadLength(int[][] x){//perhaps change the type later.
					int numOfElements = 0;
					for(int i = 0; i < x.length; i++) {
						for(int j = 0; j < x[i].length; j++) {
							if(x[i][j]==2)
								numOfElements++;
							if(x[i][j]==0)
								numOfElements++;
							if(x[i][j]==3)
								numOfElements++;
						}
					}
					return numOfElements;
				}
				
				
				//NEVER THE LESS THE FUNCTION SEEMS TO WORK.
				//If private, says it is not visible, find out why later.
				public int[][] getRoadCoords(int[][] x){
					int[][] roadCoords = new int[findRoadLength(x)][2];
					boolean accounted = false;
					for(int i = 0; i < x.length; i++) {
						for(int j = 0; j < x[i].length; j++) {
							if(x[i][j]==2) {
								roadCoords[0][0]= i;
								roadCoords[0][1]= j;
								accounted = true;
								break;
							}
						}
						if(accounted==true)
							break;
					}
					//The above seems to work so far.
					//doesn't have to be done recursively.
					int lengthOfRoad = findRoadLength(x);
					int i = roadCoords[0][0];
					int j = roadCoords[0][1];
					int row = 1;
					for(int num = 0; num < lengthOfRoad;num++) {//This while loop will do a series of checks. You could actually condense this code.
						try {
							if(x[i][j+1] == 0) {
								x[i][j+1] = 1;
								roadCoords[row][0] = i;
								roadCoords[row][1] = j+1;
								row++;
								j=j+1;
							}
						}
						catch(Exception e){}
						try {
							if(x[i][j-1] == 0){
								x[i][j-1] = 1;
								roadCoords[row][0]= i;
								roadCoords[row][1]= j-1;
								row++;
								j=j-1;
							}
						}
						catch(Exception e){}
						try {
							if(x[i+1][j] == 0){
								x[i+1][j] = 1;
								roadCoords[row][0]= i+1;
								roadCoords[row][1]= j;
								row++;
								i=i+1;
							}
						}
						catch(Exception e){}
						try {
							if(x[i-1][j] == 0){
								x[i-1][j] = 1;
								roadCoords[row][0]= i-1;
								roadCoords[row][1]= j;
								row++;
								i=i-1;
							}
						}
						catch(Exception e){}
					}
					accounted = false;
					for(int p = 0; p < x.length; p ++) {
						for(int q = 0; q < x[p].length; q++) {
							if(x[p][q]==3) {
								roadCoords[lengthOfRoad-1][0]= p;
								roadCoords[lengthOfRoad-1][1]= q;
								accounted = true;
								break;
							}
						}
						if(accounted==true)
							break;
					}
				return roadCoords;
			}
				
				
				
			public void move() {
				this.getRoadCoords(roadCoordinates);
				this.updateCoords(roadCoordinates[counter + 1][0], roadCoordinates[counter + 1][1]);
				this.counter++;
			}
			public void delete() {
				this.tag = 0;
			}
	}

				
				

