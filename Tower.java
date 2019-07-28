/*	Summer 2019 CPSC233 Team07, Team Project "Tower Defense"
 *	Latest edit : July 28th 2019
 */

import java.util.ArrayList;
import java.lang.Math;

public class Tower {
	private int damageInflictable;	//Damage to the enemy.
	private int towerType;	//This is just a band-aid to make what is to come work.
	private int fireRange;	//Fire range of the tower, unit: grid.
	private int fireRate;	//Going to put this variable into children classes later.
	private int Y_Coord;
	private int X_Coord;

	//TODO: After setup economy system.	private int TowerPrice;	
	
	
	/* Constructor, setup values.
	 * fireRange is default to 2.
	 * fireRate is default to 1
	 */
	public Tower(int towerType, int X_Coord, int Y_Coord){
		this.towerType = towerType;
		this.damageInflictable = 1;
		this.fireRange = 2;
		this.fireRate = 1;
		this.X_Coord = X_Coord;
		this.Y_Coord = Y_Coord;
	}
	
	
	/* Concept:
	 * 		Check the road map array from the end, if enemy exist, check range, if enemy in range, attack.
	 * 
	 * parameters:
	 * 		1. EnemyMap:
	 * 			The array that have all enemy positions.
	 * 		2. roadMap:
	 * 			The array that have all road grid positions.
	 * 
	 * Return value: 
	 * 		If there is a enemy in range, return an <<<<<< Array >>>>>> with 3 integer elements: {Damage Inflicted, enemy X coordinate, enemy y coordinate}. 
	 * 		If there is no enemy in range, return an <<<<<< Array >>>>>> with 3 integer elements: {0, 0, 0}
	 */
	
	public int[] damageEnemy(int[][] enemyMap, int[][] roadMap) {	//Need Road Obj
		
		int coordx = 0;
		int coordy = 1;
		int counter = roadMap.length; 
		int minimumArrayCount = 0; 
		
		while (counter >= minimumArrayCount) {
			
			int x = roadMap[counter][coordx];
			int y = roadMap[counter][coordy];
			
			if (enemyMap[y][x] != 0) {	//Assume 0 means "no enemy" on the enemy map
				int distanceToTower = (int) Math.sqrt(Math.pow(X_Coord - x, 2) + Math.pow(Y_Coord - y, 2));
				
				if( distanceToTower < fireRange) {
					int[] damageToEnemy = {damageInflictable, x, y};
					return damageToEnemy;
				}
				
			}
			counter--;
		}
		
		int[] noDamage = {0, 0, 0};
		return noDamage;
		
	}
	
	/* Concept:
	 * 		To get the position of this Tower Object.
	 * 
	 * Return Value:
	 * 		An <<<<<< ArrayList >>>>>> with 2 integer elements: {tower x coordinate, tower y coordinate}.
	 */
	public ArrayList<Integer> getPosition(){
		ArrayList<Integer> position = new ArrayList<Integer>();
		position.add(X_Coord);
		position.add(Y_Coord);
		return position;
	}
	
	
}