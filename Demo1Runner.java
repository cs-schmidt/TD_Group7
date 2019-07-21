
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
	public static void seeGrid(int[][] k) {
		
	for (int i = 0; i < k.length;i++) {
		for (int j = 0; j < k[0].length; j++) {
			System.out.print(k[i][j]+ " ");
		}
		System.out.println("");
	}
	System.out.println("");
	}

	
	public static void main(String[]args) {
		
		TdMap validMap = new TdMap(5,3);
		TowerMap TowerMap = new TowerMap(0,0);
		int[][] ValidM = validMap.buildValidityMap();
		int[][] TowerM = TowerMap.build_TowerMap();
		Demo1Runner.seeGrid(ValidM);
		Demo1Runner.seeGrid(TowerM);
	
		TowerMap.build_basicTower( TowerMap.place_where('X'),TowerMap.place_where('Y'));
		Demo1Runner.seeGrid(ValidM);
		Demo1Runner.seeGrid(TowerM);
		
	}
}


	


