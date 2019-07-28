
public class validityMap {//Change the name of this class later so it has proper naming convention.
	
	//Attributes
		private int[][] validityMap;//Perhaps this Attribute will just be used for the under-lay.
		
	
	//Constructors
		validityMap(int[][] mapUnderlier){
			this.validityMap = interperateMap(mapUnderlier);
		}
		
	//Methods
		private int[][] interperateMap(int[][] x){//Requires a square or rectangular map.
			int[][] validityMap = new int[x.length][x[0].length];
			for(int i = 0; i < x.length; i++) {
				for(int j = 0; j < x[i].length; j++) {
					validityMap[i][j] = x[i][j];
				}
			}
			return validityMap;
		}
		
		//getters

		
		//See this later to make adjustments
		public void seeValidityMap() {
			for(int row = 0;row < this.validityMap.length; row++) {
				for(int column = 0; column < this.validityMap[row].length; column++) {
					System.out.print(this.validityMap[row][column]+" ");
				}
				System.out.println();
			}
		}
}
	
		

