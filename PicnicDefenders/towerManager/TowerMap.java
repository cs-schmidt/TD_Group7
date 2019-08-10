package towerManager;
import java.util.Scanner;
import mapsManager.Map;
import enemyManager.*;
/**
 * This is the class that governs both the placement of towers and how they shoot oncoming enemies.
 * <br> *It also host some methods specific only to the text-based version.
 * @author schmi
 *
 */
public class TowerMap {
	
	//Attributes
		/**
		 * This attribute serves as the 2D-array for which we place our towers inside.
		 */
		public Tower[][] towerMap;
		/**
		 * This 2D-integer array serves to keep track of where towers may be placed and where they are placed in the 'towerMap'.
		 */
		public int[][] towerTracker;
		
	//Constructor
		/**
		 * This method will take in a map object as an argument and produce a 'towerMap' full of 'TowerDummy' objects and 'towerTracker'.
		 * <br> Both of these 2D-arrays will be sized accordingly to the map object that is passed.
		 * @param map : takes a map object. 
		 */
		public TowerMap(Map map){
				this.towerMap = new Tower[map.getMapRows()][map.getMapColumns()];
					for(int row = 0; row < this.towerMap.length; row++) {
						for(int column = 0; column <  this.towerMap[0].length; column++ ) {
							TowerDummy dummyTower = new TowerDummy();
							this.towerMap[row][column] = dummyTower;
						}
					}
				this.towerTracker = new int[map.getMapRows()][map.getMapColumns()];
					for(int row = 0; row < this.towerTracker.length; row++) {
						for(int column = 0; column <  this.towerTracker[0].length; column++ ) {
							this.towerTracker[row][column] = map.getMapGrid()[row][column];
						}
					}
					for(int row = 0; row < this.towerTracker.length; row++) {
						for(int column = 0; column <  this.towerTracker[0].length; column++ ) {
							if(this.towerTracker[row][column] != 1) {
								this.towerTracker[row][column] = -1;
							}
						}
					}
					for(int row = 0; row < this.towerTracker.length; row++) {
						for(int column = 0; column <  this.towerTracker[0].length; column++ ) {
							if(this.towerTracker[row][column] == 1) {
								this.towerTracker[row][column] = 0;
							}
						}
					}
		}
		
	//Methods
		//Edit this method latter
		public void placeTowerGUI(int row, int column) {
			if(towerMap[row][column].getTowerTag() > 0) {
				//Do nothing, update for later
			}
			if(towerMap[row][column].getTowerTag() == 0) {
				TowerA towerA = new TowerA();
				towerMap[row][column] = towerA;
				towerTracker[row][column] = 1;
			}
		}
		//&&&
		
		/**
		 * This is just a method that produces a copy of the TowerMaps 'towerTracker' attribute.
		 * @return : 2D-integer array copy of 'towerTracker'.
		 */
		public int[][] copyTowerTracker(){
			int[][] copyOfGrid = new int[towerTracker.length][towerTracker[0].length];
			for(int row = 0; row < towerTracker.length; row++) {
				for(int column = 0; column < towerTracker[0].length; column++) {
					copyOfGrid[row][column] = towerTracker[row][column];
				}
			}
			return copyOfGrid;
		}
		
		/**
		 * This method will track through the 'towerMap' until it finds a tower that is not a 'TowerDummy' object.
		 * <br> Given that it finds a tower (that is not a 'TowerDummy') it will then check the 'enemyMap' object to see the following:
		 * <br> 1) Are there any enemies currently in the 'enemyMap' object.
		 * <br> 2) If there are is this tower in range to shoot them (if not keep checking).
		 * <br> 3) If this tower is in range then shoot.
		 * <br> The method will go through the 'towerMap' until each tower that can shoot gets to do so.
		 * @param enemyMap : Takes an 'enemyMap' type object.
		 */
		public void towerShoot(EnemyMap enemyMap){
			for(int row = 0; row < this.towerMap.length; row++) {
				for(int column = 0; column < this.towerMap[0].length; column++ ) {
					if(this.towerMap[row][column].getTowerTag() > 0) {
						for(int tile = enemyMap.getEnemyPathLength()- 2; tile >= 0; tile--) { 
							if(enemyMap.enemyMap[enemyMap.enemyPath[tile][0]][enemyMap.enemyPath[tile][1]].getEnemyTag() > 0) { //explore the +0.1 concept later.
								if(distance(enemyMap.enemyPath[tile][0],enemyMap.enemyPath[tile][1],row,column) <= ((double)this.towerMap[row][column].getTowerRange())*Math.pow(2.0,(1.0/2))+.01) {
									enemyMap.enemyMap[enemyMap.enemyPath[tile][0]][enemyMap.enemyPath[tile][1]].setEnemyHealth(this.towerMap[row][column].getTowerDamage());
									if(enemyMap.enemyMap[enemyMap.enemyPath[tile][0]][enemyMap.enemyPath[tile][1]].getEnemyHealth() <= 0) {
										EnemyDummy dummyEnemy = new EnemyDummy();
										enemyMap.enemyMap[enemyMap.enemyPath[tile][0]][enemyMap.enemyPath[tile][1]] = dummyEnemy;
									}
									break;
								}
							}	
						}
					}
				}
			}
		}
		
		/**
		 * This method is simply on that calculates the distance between 2 objects based on their location in a Cartesian-like coordinate system.
		 * <br> i.e like a 2D-array. It is only used for the 'towerShoot' method as a means to see if a tower is in range of an enemy.
		 * @param enemyRow : takes the row coordinate of the enemy.
		 * @param enemyColumn : takes the column coordinate of the enemy.
		 * @param towerRow : takes the row coordinate of the tower.
		 * @param towerColumn : takes the column coordinate of the tower.
		 * @return
		 */
		private double distance(double enemyRow, double enemyColumn, double towerRow, double towerColumn) {
			double distance = Math.pow((Math.pow(((double)enemyRow-(double)towerRow),2) + Math.pow(((double)enemyColumn-(double)towerColumn),2)),(((double)1)/2));
			return distance;
		}
								
		//Methods specific to the text-based version.
			//1)
			/**
			 * Just a method used to give the user some info in the 'textGameRunner' method of the 'textGameLogic' class.
			 * <br>(*Exclusively used for the text-based version)
			 */
			public static void towerMapInfo() {
				System.out.println("*HOW TO PLACE TOWERS: ");
				System.out.println(" To place towers enter the coordinates in the form '0,1', ");
				System.out.println(" where the first number represents the row and the second the column on the map.");
				System.out.println(" You may place towers on the tiles baring the symbol '#' or delete a tower on a tile that bares a letter.*(other than 's' or 'e')");
				System.out.println();
			}

			//2)
			/**
			 * This is a method used to take the ask the player whether or not a he/she wants to place or delete a tower.
			 * <br>(*Exclusively used for the text-based version)
			 */
			public boolean placeTowerTestMethod() {
				boolean aValidAnswer = false;
				boolean goAhead = false;
				System.out.println("Do you wish to place and/or delete any towers?(yes/no) ");
				Scanner input = new Scanner(System.in);
				String answer = input.nextLine();
				while(aValidAnswer == false) {
					if(answer.equals("yes") ^ answer.equals("no")) {
						aValidAnswer = true;
						if(answer.equals("yes"))
							goAhead = true;
						else
							goAhead = false;
					}
					else {
						System.out.println("Your answer must strictly be 'yes' or 'no'. Reenter 'yes' or 'no': ");
						input = new Scanner(System.in);
						answer = input.nextLine();
						if(answer.equals("yes") ^ answer.equals("no"))
							aValidAnswer = true;
						if(answer.equals("yes"))
							goAhead = true;
						else
							goAhead = false;
					}
				}
				return goAhead;
			}

			//3)
			/**
			 * When the player enters the coordinates to place or delete a tower into the console this method will take that input and put the coordinates into an array.
			 * <br>(*Exclusively used for the text-based version)
			 * @return : an integer array of size 2.
			 */
			private int[] getUserInput() {
				int[] coordinates = new int[2];
					coordinates[0] = -1;
					coordinates[1] = -1;
				boolean commaPresent = false;
				int commaIndex = 0;
				String num1 = "";
				String num2 = "";
				boolean userEnteredCorrectly = false;
				while(userEnteredCorrectly == false){
					System.out.println("Enter the coordinates where you wish to place or delete a tower: ");
					Scanner input = new Scanner(System.in);
					String coords = input.nextLine();
					for(int x = 0; x < coords.length(); x++) {
						if(coords.charAt(x) == ',') {
							commaPresent = true;
							commaIndex = x;
							break;
						}
					}
					if(commaPresent == true) {
						try {
							for(int x = 0; x < commaIndex; x++) {
								num1 += coords.charAt(x);
							}
							coordinates[0] = Integer.parseInt(num1);
						}
						catch(Exception e) {
		
						}
						try {
							for(int x = commaIndex + 1; x < coords.length(); x++) {
								num2 += coords.charAt(x);
							}
							coordinates[1] = Integer.parseInt(num2);
							}
						catch(Exception e) {
							
						}
					}
					else
						System.out.println("Your input is not what is expected. enter something like '0,0' as an input");
					if( (coordinates[0] >= 0 && coordinates[0] < towerMap.length) && (coordinates[1] >= 0 && coordinates[1] < towerMap[0].length)) {
						userEnteredCorrectly = onRoad(coordinates);
					}
				}
				return coordinates;
			}
			
			//4)
			/**
			 * This method is used in the 'placeTower' method. Its function is to take an integer array of size 2 and check its elements,
			 * <br> it treats these elements as a coordinates where the first element is the row and the second the column for the 'towerTracker'.
			 * <br> basically if we entered coordinates into the console to place a tower this method would tell us if we tried to place them on the
			 * <br> road or not.
			 * <br>(*Exclusively used for the text-based version)
			 * @param coordinates : takes a integer array of size 2.
			 * @return : this returns a boolean indicating whether or not we tried to place a tower on the road of the map.
			 */
			private boolean onRoad(int[] coordinates) {
				boolean notOnRoad = true;
				if(towerTracker[coordinates[0]][coordinates[1]] == -1) {
					System.out.println("It appears you've placed a tower on the road, reenter valid coordinates.");
					notOnRoad = false;
				}
				else
					notOnRoad = true;
				return notOnRoad;
			}

			//5)
			private int typeValid() {
				boolean validInput = false;
				int towerType = 0;
				while(validInput == false) {
					System.out.println("Place a tower of type 1, 2, or 3");
					Scanner input = new Scanner(System.in);
					String answer = input.nextLine();
					try {
						towerType = Integer.parseInt(answer);
						if(towerType == 1 ^ towerType == 2 ^ towerType == 3) {
							validInput = true;
						}
					}
					catch(Exception NumberFormatException) {
						System.out.println("You may only enter a single digit.");
					}
				}
				return towerType;
			}
			
			//6)
			/**
			 * This method uses a combination of the other methods in this class to allow the user to place tower.
			 * <br>(*Exclusively used for the text-based version)
			 */
			public void placeTower() { 
				if(placeTowerTestMethod() == true) {
					boolean areYouDone = false;
					System.out.println("you may pick rows between 0 and "+(towerMap.length - 1)+".");
					System.out.println("you may pick columns between 0 and "+(towerMap[0].length -1)+".");
					do {
						int[] coordinates = getUserInput();//Here***
						if(towerTracker[coordinates[0]][coordinates[1]] > 0) {
							TowerDummy dummyTower = new TowerDummy();
							towerMap[coordinates[0]][coordinates[1]] = dummyTower;
							towerTracker[coordinates[0]][coordinates[1]] = 0;
							System.out.println("Tower has succesfully been deleted.");
						}
						else {
							int towerType = typeValid();
							if(towerType == 1) {
								TowerA towerA = new TowerA();
								towerMap[coordinates[0]][coordinates[1]] = towerA;
							    towerTracker[coordinates[0]][coordinates[1]] = towerA.getTowerTag();
								System.out.println("Tower type A succesfully placed!");
							}
							if(towerType == 2) {
								TowerB towerB = new TowerB();
								towerMap[coordinates[0]][coordinates[1]] = towerB;
							    towerTracker[coordinates[0]][coordinates[1]] = towerB.getTowerTag();
							    System.out.println("Tower type B succesfully placed!");
							}
							if(towerType == 3) {
								TowerC towerC = new TowerC();
								towerMap[coordinates[0]][coordinates[1]] = towerC;
							    towerTracker[coordinates[0]][coordinates[1]] = towerC.getTowerTag();
							    System.out.println("Tower type C succesfully placed!");
							}
						}
						areYouDone = placeTowerTestMethod();
					}while(areYouDone == true);
				}
			}

}
