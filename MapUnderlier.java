
public class MapUnderlier {
	
	public int[][] validityMap;
	
	
	//Constructors
	MapUnderlier(){
	}
	
	MapUnderlier(int mapx, int mapy){
		MapUnderlier map = new MapUnderlier();
		this.validityMap = map.establishValidityMap(mapx, mapy);
	}
	
	//Methods
	//This Method creates a 2D array to see valid and invalid tower areas.
	private int[][] establishValidityMap(int mapx,int mapy){
		int[][] validityMap = new int[mapy][mapx];
		for(int row = 0; row < mapy; row++) {
			for(int column = 0; column < mapx; column++) {
					validityMap[row][column] = 1;
			}
		}
		for(int column = 0; column < mapx; column++) {
			validityMap[1][column] = 0;
		}
		
		for(int row = 0; row < mapy; row++) {
			if(validityMap[row][0] == 0)
				validityMap[row][0] = 2;
		}
		for(int row = 0; row < mapy; row++) {
			if(validityMap[row][mapx-1] == 0)
				validityMap[row][mapx-1] = 3;
		}
		
		return validityMap;
	}
	
	//Method to display validityMap of object.
	public void seeValidityMap() {
		for(int row = 0;row < this.validityMap.length; row++) {
			for(int column = 0; column < this.validityMap[row].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
				System.out.print(this.validityMap[row][column]+" ");
			}
			System.out.println();//functions as a way to space the lines I guess.
		}
	}
}
