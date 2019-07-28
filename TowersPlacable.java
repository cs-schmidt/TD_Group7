import java.util.Scanner;
import java.lang.Math;
public class TowersPlacable {
	//Attributes
		private BasicTower[][] towerMap; //TowerMap
		private int[][] mapTracker;//I'm thinking this one will be where we are able to place the towers.
	//Constructors
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
			
			//This sets up the mapTracker.
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
		public BasicTower[][] getTowerMap(){
			return this.towerMap;
		}
		
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
			if(this.mapTracker[this.mapTracker.length - coordY][coordX-1] == 1) {//This coord system is in classical cartesian, account for this later.
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
				//else if(this.towerMap[this.mapTracker.length - coordY][coordX-1].getTag() < 6) {
					//System.out.println("Do you wish to replace it, or destroy it? ");
				//}
				
			}
			else {
				System.out.println("You cant place your tower on the road");
			}
		}
		
		//PROBLEM HERE
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
