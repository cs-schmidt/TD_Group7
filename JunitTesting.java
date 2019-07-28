//not the most accurate name for the purpose of this class at the current time, however perhaps we will modify it for junit later.
public class JunitTesting {
	
	public static void main(String[]args) {
		
		//Build some map here for testing, in the actual code we will have an ArrayList of 2D-Arrays for which we will load (call) a map at the start.
		int[][] someMap = new int[4][5];
		for(int i =0;i<someMap.length;i++) {
			for(int j =0;j<someMap[0].length;j++) {
				someMap[i][j] = 1;
			}
		}
		for(int i = 1;i==1;i++) {
			for(int j =0;j<3;j++) {
				someMap[i][j] = 0;
			}
		}
		for(int i = 1;i<4;i++) {
			for(int j =2;j==2;j++) {
				someMap[i][j] = 0;
			}
		}
		for(int i = 3;i==3;i++) {
			for(int j =2;j<5;j++) {
				someMap[i][j] = 0;
			}
		}
		someMap[1][0]=2;
		someMap[3][4]=3;
		for(int row = 0;row < someMap.length; row++) {
			for(int column = 0; column < someMap[row].length; column++) {
				System.out.print(someMap[row][column]+" ");
			}
			System.out.println();
		}
		
		//Game initialized, we will add a prompt for loading a map.
		boolean gameOn = false;
		Road road = new Road(someMap);
		TowersPlacable towerMap = new TowersPlacable(someMap);
		int round = 0;
		//
		
		do {
			EnemyBag enemyBag = new EnemyBag(round);
			EnemyMap enemyMap = new EnemyMap(someMap, road.roadCoordinates);
			do {
				towerMap.placeTower();
				enemyMap.spawnEnemy(enemyBag);
				seeDisplay(towerMap.getTowerMap(),enemyMap.getEnemyMap(),someMap);
				System.out.println("");
				towerMap.towersShoot(enemyMap);
				seeDisplay(towerMap.getTowerMap(),enemyMap.getEnemyMap(),someMap);
				System.out.println("");
				enemyMap.enemiesMove();
				seeDisplay(towerMap.getTowerMap(),enemyMap.getEnemyMap(),someMap);
				System.out.println("");
			}while(enemyBag.getBag().size() > 0);
			round++;
		}while(gameOn == true);
		//End loop
		
	}
	
	
	public static void seeDisplay(BasicTower[][] x, BaseEnemy[][] y,int[][] validityMap) {
		String[][] display = new String[x.length][x[0].length];
		for(int row = 0;row < x.length; row++) {
			for(int column = 0; column < x[0].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
				if(x[row][column].getTag() > 0)
					display[row][column]="t";
				else if(x[row][column].getTag() == 0)
					display[row][column]="~";
			}
		}
		
		for(int row = 0;row < validityMap.length; row++) {
			for(int column = 0; column < validityMap[0].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
				if(validityMap[row][column]==-1)
					display[row][column]= "=";
				else if(validityMap[row][column]==2)
						display[row][column]= "=";
				else if(validityMap[row][column]==3)
						display[row][column]= "=";
			}
		}
		
		for(int row = 0;row < y.length; row++) {
			for(int column = 0; column < y[0].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
				if(y[row][column].getEnemyTag() >= 0)
					display[row][column]="e";
			}
		}
		
		for(int row = 0;row < display.length; row++) {
			for(int column = 0; column < display[0].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
				System.out.print(display[row][column]+" ");
			}
			System.out.println("");
		}
	}
}

	

