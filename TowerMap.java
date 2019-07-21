
import java.util.Scanner;

public class TowerMap extends TdMap{

	public int[][] towersMap;
	private int towerType;
	private static int towerEmpty = 0;
	private static int towerInvalid = 9;
	
	public TowerMap(int x, int y) {
		super(mapx, mapy);
	}
	
	// makes tower map array and checks for road and ending and replaces them as invalid positions 0 = valid/empty 9 = placed
	public int[][] build_TowerMap() {
		int[][] map = super.buildValidityMap();
		towersMap = new int[mapy][mapx];
		for (int i = 0; i < mapy; i++) {
			for (int j = 0; j < mapx; j++) {
				if (map[i][j] != 0 && map[i][j] != 2 && map[i][j] != 3) {
					towersMap[i][j] = towerEmpty;
				}else {
					towersMap[i][j] = towerInvalid;
				}
			}
		}
		return towersMap;
		}
	public int place_where(char XorY) {
		int num = 0;
		Scanner input = new Scanner(System.in);
		if (XorY == 'Y') {
			System.out.println("Please Choose the Y Coordinate of your Tower "); //it goes from top left down
			num = input.nextInt();
		}
		if (XorY == 'X') {
			System.out.println("Please Choose the X Coordinate of your Tower "); //goes from left to right
			num = input.nextInt();
			
		}
		return num;
	}
	
	public int[][] build_basicTower(int x, int y){ //chooses the coords
		if (towersMap[y][x] != 9) {
			towersMap[y][x] = 1;
		}else {
			System.out.println("Invalid Placement, Try again");
		}
		return towersMap;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	public static void seeTowerMap(int[][] x) {
		for(int row = 0; row <x.length;row++) {
			for(int column = 0; column <x[0].length;column++) {
				if (x[row][column]== towerEmpty)
					System.out.print(towerEmpty + " ");
				else
					System.out.print(towerInvalid + " ");
			}
			System.out.println();
		}
		
	}
	
*/	
	
	

// Scanner input = new Scanner(System.in)
// String inputput = input.nextLine():
//Towers will have X
/*
	public TowerMap[][] establishTowers() {
		this.towers = new int[mapy][mapx];
		for (int i = 0; i < mapy; i++) {
			for (int j = 0; j < mapx; j++) {
				towers[i][j] = new DummyTower();
			}
		}
		*/
