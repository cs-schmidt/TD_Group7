//not the most accurate name for the purpose of this class at the current time, however perhaps we will modify it for junit later.
public class JunitTesting {
	public static void main(String[]args) {
		int[][] someMap = new int[4][5];
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
		someMap[1][0]=2;
		someMap[3][4]=3;
		for(int row = 0;row < someMap.length; row++) {
			for(int column = 0; column < someMap[row].length; column++) {
				System.out.print(someMap[row][column]+" ");
			}
			System.out.println();
		}
		
		Road road = new Road(someMap);
		int[][] road1 = road.roadCoordinates;
		
		for(int row = 0;row < road1.length; row++) {
			for(int column = 0; column < road1[row].length; column++) {
				System.out.print(road1[row][column]+" ");
			}
			System.out.println();
		}
		
	}
}

	

