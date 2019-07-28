import java.lang.Math;
public class TankEnemy extends Enemy {

	//Attributes
		//Accounted for in the BaseEnemy class

	//Constructor
		TankEnemy(int[][] map){
			super(5,3,1,3, map);
		}
		
	//Methods
		public static int TRoundFunction(int round) { //Determine later if round will count from 0 or from 1.***
			return (int)Math.floor(round/2); //Determine a function that is balanced.
		}
}
