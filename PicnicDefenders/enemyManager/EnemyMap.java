package enemyManager;
import mapsManager.Map;
import playGame.Player;
/**
 * This is the class that governs movement and spawning of enemies.<br> *It also host some methods specific only to the text-based version.
 * @author schmi
 *
 */
public class EnemyMap {
	
	//Attributes
		/**
		 * This attribute serves as the 2D-array for which enemies can spawn and move inside.
		 */
		public Enemy[][] enemyMap;
		/**
		 * This attribute serves as the 2D-integer array for which we can use other methods to control there movement.
		 */
		public int[][] enemyPath;
		
	//Constructor
		/**
		/**
		 * This method will take in a map object as an argument and produce a 'enemyMap' full of 'EnemyDummy' objects.
		 * <br> In addition the method will copy the 'Map' objects 'roadCoordinates' attribute and set it equal to its own attribute 'enemyPath'.
		 * <br> Both of these 2D-arrays will be sized accordingly to the map object that is passed.
		 * @param map : takes a map object. 
		 */
		public EnemyMap(Map map){
			this.enemyMap = new Enemy[map.getMapRows()][map.getMapColumns()];
			for(int row = 0; row < this.enemyMap.length; row++) {
				for(int column = 0; column <  this.enemyMap[0].length; column++ ) {
					EnemyDummy dummyEnemy = new EnemyDummy();
					this.enemyMap[row][column] = dummyEnemy;
				}
			}
			this.enemyPath = map.getMapRoad();
		}
		
	//Methods
		//Other methods
				/**
				 * This method will check through the 'enemyMap' attribute for any enemy objects that have a tag greater than 0.
				 * <br> If the method finds one then it will return true.
				 * @return : returns a boolean with value true or false.
				 */
				public boolean checkForEnemiesPresent() {
					boolean enemiesPresent = false;
					for(int i = 0; i < this.enemyMap.length; i++) {
						for(int j = 0; j < this.enemyMap[i].length; j++) {
							if(this.enemyMap[i][j].getEnemyTag() > 0) {
								enemiesPresent = true;
								break;
							}
						}
						if(enemiesPresent == true) {
							break;
						}
					}
					return enemiesPresent;
				}
		
		//Basically setters.
			/**
			 * This method controls the function to spawn enemies into the 'enemyMap' attribute.
			 * <br> It will take a 'EnemyBag' object as an argument and look in its attribute 'bagOfEnemies'.
			 * <br> This all serves to spawn the enemies dynamically.
			 * @param EnemyBag : takes an 'EnemyBag' object as an argument.
			 */
			public void spawnEnemy(EnemyBag EnemyBag) {
				int row = this.enemyPath[0][0];
				int column = this.enemyPath[0][1];
				this.enemyMap[row][column] = EnemyBag.getBag().get(0);
				EnemyBag.getBag().remove(0);
			}
			
			/**
			 * This method is responsible for moving the enemies in the 'enemyMap' attribute.
			 * <br> It takes a 'Player' object as an argument so that when an enemy moves to the end of the path, the player receives damage.  
			 * @param player : takes a 'Player' object as an argument.
			 */
			public void moveEnemies(Player player) {
				for(int row = this.enemyPath.length - 2; row >= 0; row--) {
					if(this.enemyMap[this.enemyPath[row][0]][this.enemyPath[row][1]].getEnemyTag() > 0) {
						Enemy enemyCopied = new Enemy(this.enemyMap[this.enemyPath[row][0]][this.enemyPath[row][1]]);
						this.enemyMap[this.enemyPath[row + 1][0]][this.enemyPath[row + 1][1]] = enemyCopied;
						EnemyDummy dummyEnemy = new EnemyDummy();
						this.enemyMap[this.enemyPath[row][0]][this.enemyPath[row][1]] = dummyEnemy;
						if(this.enemyMap[this.enemyPath[this.enemyPath.length-1][0]][this.enemyPath[this.enemyPath.length-1][1]].getEnemyTag() > 0){
							player.setPlayerHealth(this.enemyMap[this.enemyPath[this.enemyPath.length-1][0]][this.enemyPath[this.enemyPath.length-1][1]].getEnemyDamage());
							EnemyDummy dummyEnemyP = new EnemyDummy();
							this.enemyMap[this.enemyPath[this.enemyPath.length-1][0]][this.enemyPath[this.enemyPath.length-1][1]] = dummyEnemyP;
						}
					}
				}
			}
			
		//Getters
			/**
			 * This method will get the length of the attribute 'enemyPath'(which is a 2D-array).
			 * <br> i.e. it returns an integer value for the number of rows.
			 * @return
			 */
			public int getEnemyPathLength(){
				return this.enemyPath.length;
			}	
			
			/**
			 * This method will print the health of all the enemies in the 'enemyMap' attribute.
			 * <br>(Exclusively used in the text-based version).
			 */
			public void enemyHealthDisplay() {
				System.out.print("Enemy health: ");
				for(int row = 0; row <  this.enemyPath.length - 1; row++) {
					if(this.enemyMap[this.enemyPath[row][0]][this.enemyPath[row][1]].getEnemyTag() > 0) {
						System.out.print(this.enemyMap[this.enemyPath[row][0]][this.enemyPath[row][1]].getEnemyHealth() + " ");
					}
				}
			}
}
