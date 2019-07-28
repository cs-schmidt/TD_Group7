import java.util.ArrayList;
public class EnemyMap {
	//Attributes
		private BaseEnemy[][] enemyMap;
		private int[][] enemyPath;
		
	//Constructors
		EnemyMap(int[][] validityMap,int[][] road){
			int rows = 0;
			int columns = 0;
			for(int i = 0; i < validityMap.length; i++) {
				rows++;
				for(int j = 0; j < validityMap[i].length; j++) {
					columns++;
				}
			}
			this.enemyMap = new BaseEnemy[rows][columns];
			for(int i = 0; i < this.enemyMap.length; i++) {
				for(int j = 0; j < this.enemyMap[i].length; j++) {
					BaseEnemy dummyEnemy = new BaseEnemy(0,0,0);
					this.enemyMap[i][j] = dummyEnemy;
				}
			}
			this.enemyPath = road;
		}
	//Methods
		
		//getter
		public BaseEnemy[][] getEnemyMap(){
			return this.enemyMap;
		}
		
		private void spawnEnemy(EnemyBag EnemyBag) {//We'll do a counting system.
			int tradCoordX = this.enemyPath[0][0];
			int tradCoordY = this.enemyPath[0][1];
			this.enemyMap[tradCoordX][tradCoordY] = EnemyBag.enemiesAvailable.get(0);
			EnemyBag.enemiesAvailable.remove(0);
		}
		
		private void enemiesMove() {
			for(int i = this.enemyPath.length-1; i >= 0; i--) {
				if(this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]].getEnemyTag() > 0) {
					if (i==this.enemyPath.length-1) {
						BaseEnemy dummyEnemy = new BaseEnemy(0,0,0);
						this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]] = dummyEnemy;
						continue;
						}
					BaseEnemy copyEnemy = new BaseEnemy(this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]]); 
					this.enemyMap[this.enemyPath[i+1][0]][this.enemyPath[i+1][1]] = copyEnemy;
				}
			}
			
		}
		
		
}
