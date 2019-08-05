
public class Road {
	//Attributes
		int[][] roadCoordinates;
	
	//Constructors
		Road(int[][] validityMapBase){
			this.roadCoordinates = getRoadCoords(validityMapBase);
		}
	
	//Methods
		private int findRoadLength(int[][] x){//perhaps change the type later.
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
		
		//NEVER THE LESS THE FUNCTION SEEMS TO WORK.
		//If private, says it is not visible, find out why later.
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
			//The above seems to work so far.
			//doesn't have to be done recursively.
			int lengthOfRoad = findRoadLength(x);
			int i = roadCoords[0][0];
			int j = roadCoords[0][1];
			int row = 1;
			for(int num = 0; num < lengthOfRoad;num++) {//This while loop will do a series of checks. You could actually condense this code.
				try {
					if(x[i][j+1] == 0) {
						x[i][j+1] = 1;
						roadCoords[row][0] = i;
						roadCoords[row][1] = j+1;
						row++;
						j=j+1;
					}
				}
				catch(Exception e){}
				try {
					if(x[i][j-1] == 0){
						x[i][j-1] = 1;
						roadCoords[row][0]= i;
						roadCoords[row][1]= j-1;
						row++;
						j=j-1;
					}
				}
				catch(Exception e){}
				try {
					if(x[i+1][j] == 0){
						x[i+1][j] = 1;
						roadCoords[row][0]= i+1;
						roadCoords[row][1]= j;
						row++;
						i=i+1;
					}
				}
				catch(Exception e){}
				try {
					if(x[i-1][j] == 0){
						x[i-1][j] = 1;
						roadCoords[row][0]= i-1;
						roadCoords[row][1]= j;
						row++;
						i=i-1;
					}
				}
				catch(Exception e){}
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
