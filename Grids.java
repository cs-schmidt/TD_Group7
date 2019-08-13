package map;

import java.util.ArrayList;

public class Grids {
	//Attributes
		protected ArrayList<int[][]> listOfGrids = new ArrayList<int[][]>();
	//Constructors
		protected Grids(){//Just add all of the grids under this.
				listOfGrids.add(grid0());
				listOfGrids.add(grid1());
				listOfGrids.add(grid2());
			}
	//Methods
		//Getters
			public int[][] getGrid(int gridAtIndex){//Returns a copy of a grid at an index in 'listOfGrids'.
				if((gridAtIndex >= 0) && (gridAtIndex <= listOfGrids.size())) {
					int [][] copyOfGridAtIndex = getGridCopy(listOfGrids.get(gridAtIndex));
					return copyOfGridAtIndex;
				}
				else {//Just here to check for errors.
					System.out.println("The number entered into the 'getGrid' method is out of the index.");
					return null;
				}
			}
			public static int[][] getGridCopy(int[][] gridToCopy){//Copies a 2D-integer array.
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
			private int[][] grid0{
				int[][] someMap = new int[20][20];
					for(int i =0;i<someMap.length;i++) {
						for(int j =0;j<someMap[0].length;j++) {
							someMap[i][j] = 1;
						}
					}
					for(int i = 3;i==3;i++) {
						for(int j =1;j<4;j++) {
							someMap[i][j] = 0;
						}
					}
					for(int i = 3;i<15;i++) {
						for(int j =4;j==4;j++) {
							someMap[i][j] = 0;
						}
					}
					for(int i = 15;i==15;i++) {
						for(int j =4;j<14;j++) {
							someMap[i][j] = 0;
						}
					}
					for(int i = 15; i > 4; i--){
						for(int j = 14; j==14; j++) {
							someMap[i][j] = 0;
						}
					}
					for(int i = 5;i==5;i++) {
						for(int j =15;j<19;j++) {
							someMap[i][j] = 0;
						}
					}
					someMap[3][0] = 2;
					someMap[5][19] = 3;
				return someMap;
		}
			private int[][] grid1(){
				int[][] someMap = new int[20][20];
					for(int i =0;i < someMap.length;i++) {
						for(int j =0;j < someMap[0].length;j++) {
							someMap[i][j] = 1;
						}
					}
					for(int i = 18;i>14;i--) {
						for(int j =2;j==2;j++) {
							someMap[i][j] = 0;
						}
					}	
					for(int i = 15;i==15;i++) {
						for(int j =2;j<15;j++) {
							someMap[i][j] = 0;
						}
					}
					for(int i = 14;i>10;i--) {
						for(int j =14;j==14;j++) {
							someMap[i][j] = 0;
						}
					}
					for(int i = 11;i==11;i++) {
						for(int j =13;j>5;j--) {
							someMap[i][j] = 0;
						}
					}
					for(int i = 11;i>2;i--) {
						for(int j =6;j==6;j++) {
							someMap[i][j] = 0;
						}
					}
					for(int i = 3;i==3;i++) {
						for(int j =7;j<19;j++) {
							someMap[i][j] = 0;
						}
					}
					someMap[19][2]=2;
					someMap[3][19]=3;
				return someMap;
		}
			private int[][] grid2(){
			int[][] someMap = new int[20][20];
			for(int i = 0;i < someMap.length; i++) {
				for(int j = 0;j < someMap[0].length; j++) {
					someMap[i][j] = 1;
				}
			}
			for(int i = 3;i==3;i++) {
				for(int j =0;j<16;j++) {
					someMap[i][j] = 0;
				}
			}
			for(int i = 4;i<11;i++) {
				for(int j =15;j==15;j++) {
					someMap[i][j] = 0;
				}
			}
			for(int i = 10;i==10;i++) {
				for(int j =14;j>4;j--) {
					someMap[i][j] = 0;
				}
			}
			for(int i = 11;i<16;i++) {
				for(int j =5;j==5;j++) {
					someMap[i][j] = 0;
				}
			}
			for(int i = 15;i==15;i++) {
				for(int j =6;j<19;j++) {
					someMap[i][j] = 0;
				}
			}
			someMap[3][0] = 2;
			someMap[15][19] = 3;
			return someMap;
		}
		//See Grid method
			public static void see2DArray(int[][] x) {
				for(int row = 0;row < x.length; row++) {
					for(int column = 0; column < x[row].length; column++) {
						System.out.print(x[row][column]+" ");
					}
					System.out.println();
				}
			}
}