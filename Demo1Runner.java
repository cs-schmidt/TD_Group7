package demo1;
import java.util.Scanner; // when we prompt the user to place a tower.




//COMPONENTS

//1) Game starts and we are prompted to place a tower.
	//a) If the player places a tower on the road they are re-prompted to place it again.

//2) Once tower placement is initialized the player is prompted that the wave is starting.

//3) Enemy spawns and moves sequentially across the road on a timer.
	//a)If the enemy enters the tower objects range it takes damage.
	//b)If the enemy passes the tower we take damage when it reaches the end.

public class Demo1Runner {
	
	//Method to test validity grid
	public static void seeValidityGrid(TdMap k) {
		
	for (int i = 0; i < k.buildValidityMap().length;i++) {
		for (int j = 0; j < k.buildValidityMap()[0].length; j++) {
			System.out.print(k.buildValidityMap()[i][j]+ " ");
		}
		System.out.println("\n");
	}
	}
	
	public static void main(String[]args) {
		TdMap validMap = new TdMap(20,15);
		Demo1Runner.seeValidityGrid(validMap);
		Tower[][] TowerMap = Tower.establishTowers(validMap);
		for (int i = 0; i < TowerMap.length;i++) {
			for (int j = 0; j < TowerMap[0].length; j++) {
				if(TowerMap[i][j].getTowerDummyExist() == true)
					System.out.print(0+ " ");
				else
					System.out.print(1+ " ");
			}
			System.out.println("\n");
		}

	}
}


	


