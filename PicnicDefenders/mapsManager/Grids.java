package mapsManager;
import java.util.ArrayList;
/**
 * This class serves to be a holder of all the 2D-integer arrays that represent maps that a player can pick from.
 * @author ethan.schmidt1
 *
 */
public class Grids {
	
	//Attributes
		/**
		 * This attribute is an ArrayList of the grids(which are 2D-integer arrays of a particular form). 
		 */
		protected ArrayList<int[][]> listOfGrids = new ArrayList<int[][]>();
		
	//Constructors
		/**
		 * This constructor will create a 'Grids' object and initialize all of the grids in its attribute 'listOfGrids'.
		 */
		public Grids(){
				listOfGrids.add(grid0());
				listOfGrids.add(grid1());
				listOfGrids.add(grid2());
			}
		
	//Methods
		//Getters
			/**
			 * This method is a getter which serves to get a grid at a particular index in 'listOfGrids',
			 * <br> then it will make a copy of it.
			 * @param gridAtIndex : takes an integer that will serve as the index you wish to access in 'listOfGrids'.
			 * @return : returns a copy of a grid(a 2D-integer array) at the index choosen in 'listOfGrids'.
			 */
			public int[][] getGrid(int gridAtIndex){
				int [][] copyOfGridAtIndex = copyGrid(listOfGrids.get(gridAtIndex));
				return copyOfGridAtIndex;
			}
		//Copiers
			/**
			 * This is a method used in the 'getGrid' method which is the functionality behind copying a grid.
			 * @param gridToCopy : takes a 2D-integer array as an argument. 
			 * @return : returns a 2D integer array that is a copy of that 2D-integer array passed.
			 */
			public static int[][] copyGrid(int[][] gridToCopy){
				int[][] copyOfGrid = new int[gridToCopy.length][gridToCopy[0].length];
				for(int row = 0; row < gridToCopy.length; row++) {
					for(int column = 0; column < gridToCopy[0].length; column++) {
						copyOfGrid[row][column] = gridToCopy[row][column];
					}
				}
				return copyOfGrid;
			}
			
			
		//All grids
			//Below are just some 2D-integer arrays we call grids.
			private int[][] grid0(){
				int[][] someMap = new int[20][20];
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
					for(int i = 3; i < 20; i++){
						for(int j = 4; j==4; j++) {
							someMap[i][j] = 0;
						}
					}
					someMap[1][0] = 2;
					someMap[19][4] = 3;
				return someMap;
		}
			
			private int[][] grid1(){
				int[][] someMap = new int[20][20];
					for(int i =0;i < someMap.length;i++) {
						for(int j =0;j < someMap[0].length;j++) {
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
				return someMap;
		}
			
			private int[][] grid2(){
			int[][] someMap = new int[20][20];
			for(int i = 0;i < someMap.length; i++) {
				for(int j = 0;j < someMap[0].length; j++) {
					someMap[i][j] = 1;
				}
			}
			for(int j = 0;j < someMap[0].length; j++) {
				someMap[0][j] = 0;
			}
			someMap[0][0] = 2;
			someMap[0][19] = 3;
			return someMap;
		}
}
