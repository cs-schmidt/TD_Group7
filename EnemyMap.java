import java.util.ArrayList;
public class EnemyMap {
	//Attributes
		private Enemy[][] enemyMap;
		
		
	//Constructors
		EnemyMap(int[][] validityMap){
			int rows = 0;
			int columns = 0;
			for(int i = 0; i < validityMap.length; i++) {
				rows++;
				for(int j = 0; j < validityMap[i].length; j++) {
					columns++;
				}
			}
			this.enemyMap = new Enemy[rows][columns];
			for(int i = 0; i < this.enemyMap.length; i++) {
				for(int j = 0; j < this.enemyMap[i].length; j++) {
					Enemy dummyEnemy = new Enemy(0);
					this.enemyMap[i][j] = dummyEnemy;
				}
			}
			
		}
	//Methods
		
		//getter
		public Enemy[][] getEnemyMap(){
			return this.enemyMap;
		}
		
		public void spawnEnemy(int[][] validityMap) {
			Enemy map = new Enemy(validityMap);
			int xcoord = map.getRoadCoords(validityMap)[0][0];
			int ycoord = map.getRoadCoords(validityMap)[0][1];
			this.enemyMap[xcoord][ycoord] = new TankEnemy(validityMap); //spawning test enemy change later
		}
		
		
		


		public Enemy updateMove(int x, int y, int health, int tag, int[][] validityMap) {
			
			if (tag == 1) {
				enemyMap[x][y] = new BasicEnemy(health,validityMap);
				return enemyMap[x][y];
			}
			else if(tag == 2) {
				enemyMap[x][y] = new TankEnemy(health, validityMap);
				return enemyMap[x][y];
			}
			else if(tag == 3) {
				enemyMap[x][y] = new DamageEnemy(health, validityMap);
				return enemyMap[x][y];
			}else
				return null;
			
		}
}
/*		
		public void spawnEnemy(EnemyBag EnemyBag, int[][] validityMap) {//We'll do a counting system.
			Enemy map = new Enemy(validityMap);
			int tradCoordX = map.getRoadCoords(validityMap)[0][0];
			int tradCoordY = map.getRoadCoords(validityMap)[0][1];
			this.enemyMap[tradCoordX][tradCoordY] = EnemyBag.enemiesAvailable.get(0);
			EnemyBag.enemiesAvailable.remove(0);
		}
		
}
		
		private void enemiesMove(int[][] validityMap) {
			for(int i = this.enemyPath.length-1; i >= 0; i--) {
				if(this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]].getEnemyTag() > 0) {
					if (i==this.enemyPath.length-1) {
						Enemy dummyEnemy = new Enemy(0,0,0,0, validityMap);
						this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]] = dummyEnemy;
						continue;
						}
					Enemy copyEnemy = new Enemy(this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]]); 
					this.enemyMap[this.enemyPath[i+1][0]][this.enemyPath[i+1][1]] = copyEnemy;
				}
			}
			
		}
		
		
}
*/