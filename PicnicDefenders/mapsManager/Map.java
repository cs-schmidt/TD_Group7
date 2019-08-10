package mapsManager;
/**
 * The methodology behind this class stems from taking a grid and further extracting and then defining its properties.
 * @author ethan.schmidt1
 *
 */
public class Map {
	//Attributes
		/**
		 * A 2D-integer array that serves to be exactly like a grid.
		 */
		private int[][] grid;
		/**
		 * A 2D-integer array that stores the coordinates of a grids road.
		 */
		private int[][] roadCoordinates;
		/**
		 * Just the number of rows of a 2D-array.
		 */
		private int rows;
		/**
		 * Just the number of columns of a 2D-array.
		 */
		private int columns;
		
	//Constructors
		/**
		 * This constructor will take an integer as an argument. 
		 * <br>Then it will go into the Grids class and initialize its attributes based on the the grid at the index of the integer in 'listOfGrids'. 
		 * @param gridInListOfGridsAtIndex : takes an integer that represents an index of 'listOfGrids' in a Grids object.
		 */
		protected Map(int gridInListOfGridsAtIndex){
			Grids grids = new Grids();
			this.grid = grids.getGrid(gridInListOfGridsAtIndex);
			this.roadCoordinates = getRoadCoords(grids.getGrid(gridInListOfGridsAtIndex));
			this.rows = grids.getGrid(gridInListOfGridsAtIndex).length;
			this.columns = grids.getGrid(gridInListOfGridsAtIndex)[0].length;
			}
		/**
		 * This is a copy constructor.
		 * @param toCopy : takes a Map object.
		 */
		protected Map(Map toCopy) {
			this.grid = Grids.copyGrid(toCopy.grid);
			this.roadCoordinates = Grids.copyGrid(toCopy.roadCoordinates);
			this.rows = toCopy.rows;
			this.columns = toCopy.columns;
		}
		
	//Methods
		//Getters
		/**
		 * This method will just tells us the number of columns in the 'grid' attribute.
		 * @return : returns a integer value equivalent to the number of columns in the 'grid' attribute.
		 */
			public int getMapColumns() {
				int columns = this.columns;
				return columns;
			}
			/**
			 * This method will just tells us the number of rows in the 'grid' attribute.
			 * @return : returns a integer value equivalent to the number of rows in the 'grid' attribute.
			 */
			public int getMapRows() {
				int rows = this.rows;
				return rows;
			}
			
			public int[][] getMapRoad(){
				int[][] road = new int[findRoadLength(this.grid)][2];
				for(int row = 0; row < road.length; row++) {
					for(int column = 0; column < road[row].length; column++) {
						road[row][column] =this.roadCoordinates[row][column];
					}
				}
				return road;
			}
			
			public int[][] getMapGrid(){
				int[][] grid = new int[this.rows][this.columns];
				for(int row = 0; row < this.grid.length; row++) {
					for(int column = 0; column < this.grid[row].length; column++) {
						grid[row][column] =this.grid[row][column];
					}
				}
				return grid;
			}
		
		
		//See map and road methods
			//these 2 methods below were specifically used only for testing.
			public void seeMap() {
				for(int row = 0;row < this.grid.length; row++) {
					for(int column = 0; column < this.grid[row].length; column++) {
						System.out.print(this.grid[row][column]+" ");
					}
					System.out.println();
				}
			}
			
			public void seeRoad() {
				for(int row = 0; row <this.roadCoordinates.length; row++) {
					for(int column = 0; column < this.roadCoordinates[row].length; column++) {
						System.out.print(this.roadCoordinates[row][column]+" ");
					}
					System.out.println();
				}
			}
		
		/**
		 * This method finds the length where we have a 2D-integer array with a 2 indicating the start of a road, a 3 for the end, and a connecting string of 0's for the path between.
		 * @param x : takes a 2D-integer array as an argument.
		 * @return : returns an integer that represents how many unique coordinates are in the road.
		 */
		private int findRoadLength(int[][] x){
			int numOfElements = 0;
			for(int i = 0; i < x.length; i++) {
				for(int j = 0; j < x[i].length; j++) {
					if(x[i][j]==2)
						numOfElements++;
					if(x[i][j]==0)
						numOfElements++;
					if(x[i][j]==3)
						numOfElements++;
				}
			}
			return numOfElements;
		}
		/**
		 * Unlike the 'findRoadLength' method, this method will store each coordinate of the road in a 2D-integer array. 
		 * <br> This later serves in other processes to track enemy movement in maps.
		 * @param x : takes a 2D-integer array as an argument.
		 * @return : returns a 2D integer array in a form where we can track all the coordinate
		 */
		private int[][] getRoadCoords(int[][] x){
			int[][] roadCoords = new int[findRoadLength(x)][2];
			boolean accounted = false;
			for(int i = 0; i < x.length; i++) {
				for(int j = 0; j < x[i].length; j++) {
					if(x[i][j]==2) {
						roadCoords[0][0]= i;
						roadCoords[0][1]= j;
						accounted = true;
						break;
					}
				}
				if(accounted==true)
					break;
			}
			int lengthOfRoad = findRoadLength(x);
			int i = roadCoords[0][0];
			int j = roadCoords[0][1];
			int row = 1;
			for(int num = 0; num < lengthOfRoad;num++) {
				try {
					if(x[i][j+1] == 0) {
						x[i][j+1] = -1;
						roadCoords[row][0] = i;
						roadCoords[row][1] = j+1;
						row++;
						j=j+1;
					}
				}
				catch(Exception ArrayIndexOutOfBoundsException){}
				try {
					if(x[i][j-1] == 0){
						x[i][j-1] = -1;
						roadCoords[row][0]= i;
						roadCoords[row][1]= j-1;
						row++;
						j=j-1;
					}
				}
				catch(Exception ArrayIndexOutOfBoundsException){}
				try {
					if(x[i+1][j] == 0){
						x[i+1][j] = -1;
						roadCoords[row][0]= i+1;
						roadCoords[row][1]= j;
						row++;
						i=i+1;
					}
				}
				catch(Exception ArrayIndexOutOfBoundsException){}
				try {
					if(x[i-1][j] == 0){
						x[i-1][j] = -1;
						roadCoords[row][0]= i-1;
						roadCoords[row][1]= j;
						row++;
						i=i-1;
					}
				}
				catch(Exception ArrayIndexOutOfBoundsException){}
			}
			accounted = false;
			for(int p = 0; p < x.length; p ++) {
				for(int q = 0; q < x[p].length; q++) {
					if(x[p][q]==3) {
						roadCoords[lengthOfRoad-1][0]= p;
						roadCoords[lengthOfRoad-1][1]= q;
						accounted = true;
						break;
					}
				}
				if(accounted==true)
					break;
			}
		return roadCoords;
	}
}
