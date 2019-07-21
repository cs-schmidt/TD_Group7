
public class TdMap{
	public static int mapx;
	public static int mapy;
	public int[][] mapGrid;
	
	/*Establishes: {1,1,1,1,1}
	 * 			   {0,0,0,0,0}
	 * 			   {1,1,1,1,1}
	 */
	//Constructors
	public TdMap(int mapx, int mapy) {
		this.mapx = mapx;
		this.mapy = mapy;
	}
	//Getters
	public int getWidth() {
		return mapx;
	}
	
	public int getHeight() {
		return mapy;
		
	}
	
	
	//BuilderMethod 
	public int[][] buildValidityMap() { // make sure it is 5x3.
		mapGrid = new int[mapy][mapx];
		for (int i = 0; i < mapy; i++) {
			for (int j = 0; j < mapx; j++) {
				mapGrid[i][j] = 1;
			}
		}
		for (int j = 0; j < mapx; j++) {//***Refer back to road building later.
			mapGrid[1][j] = 0;
		}
		for (int k = 0; k < mapy; k++) {//finds the left most 0 and makes it a 2.
			if (mapGrid[k][0] == 0) {
				mapGrid[k][0] = 2;
			}
		}
		for (int y = 0; y < mapy; y++) {//finds the right most 0 and makes it a 3.
			if (mapGrid[y][mapx -1] == 0) {
				mapGrid[y][mapx -1] = 3;
			}
		}
		
		return mapGrid;
		}

	
	}


				
			
	

