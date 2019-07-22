import java.util.ArrayList;
public class DemoRunner {
	
	//IMPORTANT: I've discovered that due to the utilization of many return types one should NEVER, put a 2D array modifying method as an argument for another method.
	//it will change the outcome in confusing ways.
	
	public static void main(String[]args) {
		System.out.println("Player your health is set to 3"); //make a player class*****
		int playerHealth = 3;
		MapUnderlier validityMap = new MapUnderlier(5,3);
		validityMap.seeValidityMap();//sees map
		System.out.println();
		
		Tower[][] TowerMap = Tower.towersPlacable(validityMap);
		Tower.seeTowerMap(TowerMap);//sees map
		System.out.println();
		
		Enemy[][] EnemyMap = Enemy.establishEnemyGrid(validityMap);//Establishes enemy grid.
						//Enemy.seeEnemyMap(EnemyMap);//sees map
						//System.out.println();
		
		int enenmycounter = 3;
		boolean altCaseAccounter = false;
		Enemy counterEnemy = new Enemy(3);
		
		do{ 
			if(enenmycounter > 0) {
				Enemy.spawnEnemy(EnemyMap,validityMap);
								//Enemy.seeEnemyMap(EnemyMap);//sees map
				enenmycounter--;
			}
			//####
			Display.seeDisplay(TowerMap, EnemyMap);

		Tower.rangeChecker(EnemyMap,TowerMap,counterEnemy);

		Enemy.moveEnemiesPresent(EnemyMap);
		if(EnemyMap[1][EnemyMap[0].length-1].getType()==1) {//check back in on this part.(this is the portion in which enemies can inflict damage on us)
			Enemy passiveTypeEnemy = new Enemy();
			EnemyMap[1][EnemyMap[0].length-1] = passiveTypeEnemy;
			playerHealth -= 1;
		}
		
		System.out.println(counterEnemy.enemyHealth);
		System.out.println();
		System.out.println();
		if(playerHealth == 0)
			System.out.println("You lose");
		if(enenmycounter == 0)
			altCaseAccounter = true;

	} while (counterEnemy.enemyHealth > 0 && playerHealth > 0 && altCaseAccounter==false);
		
		if(altCaseAccounter == true && Display.getThatCheck(EnemyMap)==true) {
			while( Display.getThatCheck(EnemyMap)==true) {
				Display.seeDisplay(TowerMap, EnemyMap);

				Tower.rangeChecker(EnemyMap,TowerMap,counterEnemy);

				Enemy.moveEnemiesPresent(EnemyMap);
				if(EnemyMap[1][EnemyMap[0].length-1].getType()==1) {//check back in on this part.(this is the portion in which enemies can inflict damage on us)
					Enemy passiveTypeEnemy = new Enemy();
					EnemyMap[1][EnemyMap[0].length-1] = passiveTypeEnemy;
					playerHealth -= 1;
				}
				
				System.out.println(counterEnemy.enemyHealth);
				System.out.println();
				System.out.println();
		}
		
		Display.seeDisplay(TowerMap, EnemyMap);
		System.out.print(counterEnemy.enemyHealth);
		System.out.println();
		System.out.println();
		System.out.println("your health is "+ playerHealth);
		
		if(counterEnemy.enemyHealth == 0)
			System.out.println("All enemies have been defeated");
		else
			System.out.println("Enemies undefeated this round "+counterEnemy.enemyHealth);
	}
		

	}
}


