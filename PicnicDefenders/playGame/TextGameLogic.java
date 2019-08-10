package playGame;
import enemyManager.EnemyBag;
import enemyManager.EnemyMap;
import mapsManager.Map;
import mapsManager.Maps;
import towerManager.TowerMap;
/**
 * This class is used to efficiently pack the text-based game logic into one method.
 * @author ethan.schmidt1
 *
 */
public class TextGameLogic {
	
	/**
	 * This method is all of the cumulative steps necessary to run the test-based game.
	 */
	public static void textGameRunner() {
		Player you = new Player();
		you.setPlayerName();
		Maps maps = new Maps();
		maps.seeLoadableMaps();
		int mapPicked = maps.pickMap();
		//A map is picked.#
		
		TowerMap towerMap = new TowerMap(maps.getMap(mapPicked));
		//Tower map initialized.#
		
		TowerMap.towerMapInfo();
		//Just a method to give the user some game information
		
		int round = 0;
		//round initialized to 0.
		
		do {
			EnemyBag bagOfEnemies = new EnemyBag(round);
			EnemyMap enemyMap = new EnemyMap(maps.getMap(mapPicked));
			//Enemy bag created and enemy map initialized.
			
			towerMap.placeTower();
			displayBoard(towerMap, enemyMap, maps.getMap(mapPicked));
			System.out.println();
			//Player places towers.
			
			enemyMap.spawnEnemy(bagOfEnemies);
			System.out.println("Enemy spawned!");
			displayBoard(towerMap, enemyMap, maps.getMap(mapPicked));
			enemyMap.enemyHealthDisplay();
			//First enemy spawns
			
			do {
				towerMap.towerShoot(enemyMap);
				System.out.println();
				System.out.println();
				displayBoard(towerMap, enemyMap, maps.getMap(mapPicked));
				System.out.println("Towers shot");
				if(enemyMap.checkForEnemiesPresent() == true) {
					enemyMap.enemyHealthDisplay();
				}
				//Towers Shoot displays
				
				enemyMap.moveEnemies(you);
				System.out.println();
				System.out.println();
				displayBoard(towerMap, enemyMap, maps.getMap(mapPicked));
				System.out.println("Enemies moved!");
				if(enemyMap.checkForEnemiesPresent() == true) {
					enemyMap.enemyHealthDisplay();
				}
				//Enemies move displays
				
				if(bagOfEnemies.getBag().size() > 0) {
					enemyMap.spawnEnemy(bagOfEnemies);
					System.out.println();
					System.out.println();
					displayBoard(towerMap, enemyMap, maps.getMap(mapPicked));
					System.out.println("Enemy spawned!");
					enemyMap.enemyHealthDisplay();
				}
				//Enemy spawns displays
				
				
			}while(enemyMap.checkForEnemiesPresent() == true && you.getPlayerHealth() > 0);
			round++;
			System.out.println("Wave "+round+" is over.");
		}while(you.getPlayerHealth() > 0);
		
	}
	
	
	/**
	 * Used to display a visual representation of the map in the console.
	 * @param towerMap : takes a 'TowerMap' object as an argument.
	 * @param enemyMap : takes a 'EnemyMap' object as an argument.
	 * @param map : takes a 'Map' object as an argument.
	 */
	private static void displayBoard(TowerMap towerMap, EnemyMap enemyMap, Map map) {
		String[][] display = new String[map.getMapRows()][map.getMapColumns()];
		for(int row = 0; row < map.getMapRows(); row++) {
			for(int column = 0; column < map.getMapColumns(); column++) {
				display[row][column] = "~";
			}
		}
		for(int row = enemyMap.enemyPath.length - 1; row >= 0; row--) {
			display[enemyMap.enemyPath[row][0]][enemyMap.enemyPath[row][1]] = "=";
		}
		for(int row = 0; row < towerMap.towerMap.length; row++) {
			for(int column = 0; column < towerMap.towerMap[0].length; column++) {
				if(towerMap.towerMap[row][column].getTowerTag() > 0) {
					if(towerMap.towerMap[row][column].getTowerTag() == 1)
						display[row][column] = "1";
					if(towerMap.towerMap[row][column].getTowerTag() == 2)
						display[row][column] = "2";
					if(towerMap.towerMap[row][column].getTowerTag() == 3)
						display[row][column] = "3";
				}
			}
		}
		for(int row = 0; row < enemyMap.enemyMap.length; row++) {
			for(int column = 0; column < enemyMap.enemyMap[0].length; column++) {
				if(enemyMap.enemyMap[row][column].getEnemyTag() == 1)
					display[row][column] = "a";
				if(enemyMap.enemyMap[row][column].getEnemyTag() == 2)
					display[row][column] = "b";
				if(enemyMap.enemyMap[row][column].getEnemyTag() == 3)
					display[row][column] = "c";
			}
		}
		for(int row = 0; row < display.length; row++) {
			for(int column = 0; column < display[0].length; column++) {
				System.out.print(display[row][column] + " ");
			}
			System.out.println("");
		}
	}

}
