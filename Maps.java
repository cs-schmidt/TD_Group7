import java.util.ArrayList;
public class Maps {
	//Attributes
		ArrayList<int[][]> Maps = new ArrayList<int[][]>();
		
	//Constructor
		Maps(){//Just the default constructors.
		}
		
	//Methods
		//Getters
			private int[][] getMap(int x){ //perhaps this is a privacy leak
				return this.Maps.get(x);
			}
			
		//Setters
			//Add some method here to add maps.
}
