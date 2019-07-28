import java.util.Scanner;
import java.lang.Math;
public class TowersPlacable {
	
	//Attributes
	
		/*Attributes:"towerMap" and "mapTracker"
		 *Description:
		 *	Basically towerMap is a 2D-Array for which we place our towers, mapTracker on the other-hand
		 * 	will store where that location was in a 2D-Integer Array as well as what type it was, this
		 * 	essentially functions for later use when we want to replace a tower or destroy one.
		 */
		private BasicTower[][] towerMap; //TowerMap
		private int[][] mapTracker;
		
	//Constructors
		
		/*Constructors:"TowersPlacable(int[][] x)"
		 *Description:
		 *	The game will start and we will load a map. Then this map (which is a 2D-Integer Array) will
		 *	be used to establish both the "towerMap" and the "mapTracker" attributes.
		 */
		TowersPlacable(int[][] x){//Load one of the maps as an argument.
			
			//Makes a Tower map of the same size as the map we load.
			int rows = 0;
			int columns = x[0].length;
			for(int i = 0; i < x.length; i++) {
				rows++;
				for(int j = 0; j < x[i].length; j++) {
				}
			}
			this.towerMap = new BasicTower[rows][columns];
			for(int i = 0; i < this.towerMap.length; i++) {
				for(int j = 0; j < this.towerMap[i].length; j++) {
					BasicTower dummyTower = new BasicTower(0,0,0,0);
					this.towerMap[i][j] = dummyTower;
				}
			}
			
			//This sets up the mapTracker. It is initially set up to perfectly copy the map we pass as an argument.
			rows = 0;
			for(int i = 0; i < x.length; i++) {
				rows++;
				for(int j = 0; j < x[i].length; j++) {
				}
			}
			this.mapTracker = new int[rows][columns];
			for(int i = 0; i < x.length; i++) {
				for(int j = 0; j < x[i].length; j++) {
					this.mapTracker[i][j] = x[i][j];
				}
			}
			
		}
		
	//Methods
		//Getters
		public BasicTower[][] getTowerMap(){
			return this.towerMap;
		}
		
		/*Method:"placeTower"
		 *Description:
		 *	Basically this method will provide the player with a prompt in which he/she will be able to place towers on the map where they choose.
		 *
		 *Improvements:
		 *	We need to be more thorough in checking valid tower placement, account for players "Piggy-bank" funds, implement a better system for 
		 *	placing various tower types, etc. Needs some work but the foundational ideas are there.
		 *
		 *Also be sure to fix up so tower delete and replace work.
		 */
		public void placeTower() {
			//Part just explains input.
			System.out.println("Enter the coordinates for the towers you wish to place.");//Perhaps make a prompt function.
			String explain = "11";
			explain = "\"" + explain + "\""; //Try to understand this later.
			System.out.println("Valid entry example is:"+ " "+ explain + ".");
			System.out.println("The first digit denotes an x-coordinate and the second a y-coordinate");
			System.out.println("You may place 1 tower at a time");
			System.out.print("Place your towers: ");
			//This part scans.
			Scanner input = new Scanner(System.in);//Later put in a system of verification.
			String coords = input.nextLine();
			//
			int coordX = getDigitFromChar(coords.charAt(0));
			int coordY = getDigitFromChar(coords.charAt(1));
			if(this.mapTracker[this.mapTracker.length - coordY][coordX-1] == 1) {//This coordinate system is in classical Cartesian, account for this later.
				System.out.println("This spot is valid, what tower do you desire to place here? ");
				input = new Scanner(System.in);//Later put in a system of verification.
				coords = input.nextLine();
				if(Integer.parseInt(coords) == 1) {//Put in a verification system here for valid tower types and invalid ones.
					BasicTower towerType1 = new BasicTower(1,1,4,0);
					this.towerMap[this.mapTracker.length - coordY][coordX-1] = towerType1;
					this.mapTracker[this.mapTracker.length - coordY][coordX-1] = towerType1.getTag();
				}
				else if(Integer.parseInt(coords) == 2) {
					BasicTower towerType2 = new BasicTower(1,1,5,0);
					this.towerMap[this.mapTracker.length - coordY][coordX-1] = towerType2;
					this.mapTracker[this.mapTracker.length - coordY][coordX-1] = towerType2.getTag();
				}
				else if(Integer.parseInt(coords) == 3) {
					BasicTower towerType3 = new BasicTower(1,1,6,0);
					this.towerMap[this.mapTracker.length - coordY][coordX-1] = towerType3;
					this.mapTracker[this.mapTracker.length - coordY][coordX-1] = towerType3.getTag();
				}
			}
			else if(this.mapTracker[this.mapTracker.length - coordY][coordX] > 3) {
				System.out.println("It appears a Tower is already present here it is of type: ");
				System.out.print(this.towerMap[this.mapTracker.length - coordY][coordX-1].getTag());
				if(this.towerMap[this.mapTracker.length - coordY][coordX-1].getTag() <= 6 && this.towerMap[this.mapTracker.length - coordY][coordX-1].getTag() > 0 ) {
					System.out.println("Do you wish to replace it? or destroy it? ('r' for replace, 'd' for destroy, and 'p' for pass ");
					input = new Scanner(System.in);//Later put in a system of verification.
					coords = input.nextLine();
					if(coords.charAt(0)=='r') {
						System.out.println("What type do you desire to place? ");
						input = new Scanner(System.in);//Later put in a system of verification.
						coords = input.nextLine();
						if(Integer.parseInt(coords) == 1) {//Put in a verification system here for valid tower types and invalid ones.
							BasicTower towerType1 = new BasicTower(1,1,4,0);
							this.towerMap[this.mapTracker.length - coordY][coordX-1] = towerType1;
							this.mapTracker[this.mapTracker.length - coordY][coordX-1] = towerType1.getTag();
						}
						else if(Integer.parseInt(coords) == 2) {
							BasicTower towerType2 = new BasicTower(1,1,5,0);
							this.towerMap[this.mapTracker.length - coordY][coordX-1] = towerType2;
							this.mapTracker[this.mapTracker.length - coordY][coordX-1] = towerType2.getTag();
						}
						else if(Integer.parseInt(coords) == 3) {
							BasicTower towerType3 = new BasicTower(1,1,6,0);
							this.towerMap[this.mapTracker.length - coordY][coordX-1] = towerType3;
							this.mapTracker[this.mapTracker.length - coordY][coordX-1] = towerType3.getTag();
						}
					}
					else if(coords.charAt(0)=='d') {
						System.out.println("");//replaces tower with a dummy.
						BasicTower dummyTower = new BasicTower(0,0,0,0);
						this.towerMap[this.mapTracker.length - coordY][coordX-1] = dummyTower;
						this.mapTracker[this.mapTracker.length - coordY][coordX-1] = 1;
						input = new Scanner(System.in);//Later put in a system of verification.
						coords = input.nextLine();
					}
					else if(coords.charAt(0)=='p')
						//do nothing.
						;
				}	
			}
			else {
				System.out.println("You cant place your tower on the road");
			}
		}
		
		/*Method:"towersShoot(EnemyMap EnemyMap)"
		 *Description:
		 *	This method will pass the "EnemyMap" as an argument and compare each tower and any enemies on the road in terms of distance.
		 *	Towers will shoot those enemies in their range and of highest priority.
		 *
		 *Improvements:
		 *	Not sure if it is good as is, but we should conduct further testing on this method.
		 */
		public void towersShoot(EnemyMap EnemyMap) {
			for(int i = 0; i < this.towerMap.length; i++) {
				for(int j = 0; j < this.towerMap[i].length; j++) {
					if(this.towerMap[i][j].getTag() > 3) {
						for(int k = EnemyMap.getEnemyPath().length-2; k >= 0; k--) {
							if(EnemyMap.getEnemyMap()[EnemyMap.getEnemyPath()[k][0]][EnemyMap.getEnemyPath()[k][1]].getEnemyTag() >= 0) {
								if(distance(EnemyMap.getEnemyPath()[k][0],EnemyMap.getEnemyPath()[k][1],j+1,i+1)<= towerMap[i][j].getRange() * 1.5) {//Observe this later to adjust. I think you need a plus 1 for i and j.***
									EnemyMap.getEnemyMap()[EnemyMap.getEnemyPath()[k][0]][EnemyMap.getEnemyPath()[k][1]].setEnemyHP(towerMap[i][j].getDamage());
									if(EnemyMap.getEnemyMap()[EnemyMap.getEnemyPath()[k][0]][EnemyMap.getEnemyPath()[k][1]].getEnemyHP()<= 0) {
										BaseEnemy dummyEnemy = new BaseEnemy(0,0,-1);
										EnemyMap.getEnemyMap()[EnemyMap.getEnemyPath()[k][0]][EnemyMap.getEnemyPath()[k][1]] = dummyEnemy;
									}
								}
							}
						}
					}
			
				}
			}
		}
		
		private double distance(int xe, int ye, int tx, int ty) {
			double distance = Math.pow(Math.pow((xe-tx), 2) + Math.pow((ye-ty), 2),(1/2));
			return distance;
		}
		
		private int getDigitFromChar(char x) {
			if (x == 48) {return 0;}
			if (x == 49) {return 1;}
			if (x == 50) {return 2;}
			if (x == 51) {return 3;}
			if (x == 52) {return 4;}
			if (x == 53) {return 5;}
			if (x == 54) {return 6;}
			if (x == 55) {return 7;}
			if (x == 56) {return 8;}
			if (x == 57) {return 9;}
			else  {return 0;}
		}
}
