
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
	public static void seeGrid(TdMap k) {
		
	for (int i = 0; i < TdMap.mapy;i++) {
		for (int j = 0; j <TdMap.mapx; j++) {
			System.out.print(k.mapGrid[i][j]+ " ");
		}
		System.out.println("");
	}
	System.out.println("");
	}

	
	public static void main(String[]args) {
		
		TdMap validMap = new TdMap(5,3);
		validMap.buildValidityMap();
		Demo1Runner.seeGrid(validMap);
		TowerMap TowerMap = new TowerMap(0,0);
		TowerMap.build_TowerMap();
		TowerMap.seeTowerMap(TowerMap.build_TowerMap());
		System.out.println("");
	}
}


	


