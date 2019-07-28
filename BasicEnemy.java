
public class BasicEnemy extends Enemy {

	//Attributes
		//Accounted for in BaseEnemy class but modified here.
	
	//Constructor
	BasicEnemy(int[][] map){
		super(3,1,0,1, map);
	}
		//Methods
	public static int BRoundFunction(int round) { //Determine later if round will count from 0 or from 1.***
		return 3 + round; //Determine a function that is balanced.
	}
}
