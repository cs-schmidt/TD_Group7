import java.util.ArrayList;
public class EnemyMap {
	
	//Attributes
	
		/*Attributes:"enemyMap" and "enemyPath"
		 *Description:
		 *	Basically enemyMap is a 2D-Array for which we place our towers, enemyPath on the other-hand
		 * 	will be a copy of the 2D-Integer Array representing the coordinates of the road in order.
		 */
		private BaseEnemy[][] enemyMap;
		private int[][] enemyPath;
		
	//Constructors
		/*Constructors:"EnemyMap(int[][] validityMap,int[][] road)"
		 *Description:
		 *	Passes both the map we load and the road and will establish "enemyMap" and "enemyPath"
		 */
		EnemyMap(int[][] validityMap,int[][] road){
			int rows = 0;
			int columns = validityMap[0].length;
			for(int i = 0; i < validityMap.length; i++) {
				rows++;
				for(int j = 0; j < validityMap[i].length; j++) {
				}
			}
			this.enemyMap = new BaseEnemy[rows][columns];
			for(int i = 0; i < this.enemyMap.length; i++) {
				for(int j = 0; j < this.enemyMap[i].length; j++) {
					BaseEnemy dummyEnemy = new BaseEnemy(0,0,-1);
					this.enemyMap[i][j] = dummyEnemy;
				}
			}
			this.enemyPath = road;
		}
	//Methods
		
		//getter
		public int[][] getEnemyPath(){
			return this.enemyPath;
		}
		public BaseEnemy[][] getEnemyMap(){
			return this.enemyMap;
		}
		
		/*Method:"spawnEnemy(EnemyBag EnemyBag)"
		 *Description:
		 *	This method will take an enemy out of the bag and put it at the first road coordinate (which is our spawn point),
		 *	this enemy now exists in the "enemyMap".
		 */
		public void spawnEnemy(EnemyBag EnemyBag) {//We'll do a counting system.
			int tradCoordX = this.enemyPath[0][0];
			int tradCoordY = this.enemyPath[0][1];
			this.enemyMap[tradCoordX][tradCoordY] = EnemyBag.enemiesAvailable.get(0);
			EnemyBag.enemiesAvailable.remove(0);
		}
		
		/*Method:"enemiesMove()"
		 *Description:
		 *	This will check backwards through the enemyMaps road and move any enemies it detects one space forward on the road.
		 *	If an enemy moves to the last block of the road it despawns.
		 *
		 * Improvements:
		 *	The code should eventually account for an enemy moving onto the last tile, if this happens it should do damage to 
		 *	the player object.
		 */
		public void enemiesMove() {
			for(int i = this.enemyPath.length-1; i >= 0; i--) {
				if(this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]].getEnemyTag() >= 0) {
					if (i==this.enemyPath.length-1) {
						BaseEnemy dummyEnemy = new BaseEnemy(0,0,-1);
						this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]] = dummyEnemy;//we take damage here.
						continue;
						}
					BaseEnemy copyEnemy = new BaseEnemy(this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]]); 
					this.enemyMap[this.enemyPath[i+1][0]][this.enemyPath[i+1][1]] = copyEnemy;
					BaseEnemy dummyEnemy = new BaseEnemy(0,0,-1);
					this.enemyMap[this.enemyPath[i][0]][this.enemyPath[i][1]] = dummyEnemy;
				}
			}
			
		}
		
		
}
