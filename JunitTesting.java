//not the most accurate name for the purpose of this class at the current time, however perhaps we will modify it for junit later.
public class JunitTesting {
	
	
	
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
	
	
	public static void main(String[]args) {
		int round = 0;
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
		
		Road road = new Road(someMap);
		int[][] road1 = road.roadCoordinates;
		
		for(int row = 0;row < road1.length; row++) {
			for(int column = 0; column < road1[row].length; column++) {
				System.out.print(road1[row][column]+" ");
			}
			System.out.println();
		}
		//Put some stuff here	
		EnemyBag enemyBag = new EnemyBag(round);
		TowersPlacable towerMap = new TowersPlacable(someMap);
		EnemyMap enemyMap = new EnemyMap(someMap, road.roadCoordinates);
		do {
			//for(int row = 0;row < towerMap.getTowerMap().length; row++) {
				//for(int column = 0; column < towerMap.getTowerMap()[0].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
					//if(towerMap.getTowerMap()[row][column].getTag()==0)
						//System.out.print(0+" ");
				//}
				//System.out.println();
			//}
			//
			towerMap.placeTower();
			enemyMap.spawnEnemy(enemyBag);
			//for(int row = 0;row < enemyMap.getEnemyMap().length; row++) {
				//for(int column = 0; column < enemyMap.getEnemyMap()[0].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
					//if(enemyMap.getEnemyMap()[row][column].getEnemyTag()==0)
						//System.out.print(0+" ");
					//else if(enemyMap.getEnemyMap()[row][column].getEnemyTag() == 1)
						//System.out.print(1+" ");
				//}
				//System.out.println();
			//}
			towerMap.towersShoot(enemyMap);
			seeDisplay(towerMap.getTowerMap(),enemyMap.getEnemyMap(),someMap);
			System.out.println("");
			enemyMap.enemiesMove();
			seeDisplay(towerMap.getTowerMap(),enemyMap.getEnemyMap(),someMap);
			
			System.out.println(enemyMap.getEnemyMap()[1][1].getEnemyHP());
			
		}while(enemyBag.getBag().size() > 0);
		round++;
		//End loop
		
	}
}

	

