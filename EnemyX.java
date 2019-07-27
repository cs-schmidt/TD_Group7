import java.lang.Math;
public class EnemyX extends BaseEnemy {

	//Attributes
		//Accounted for in BaseEnemy class but modified here.
	
	//Constructor
		EnemyX(){
			super(4,2,1);
		}
	//Methods
		public static int eXRoundFunction(int round) { //Determine later if round will count from 0 or from 1.***
			return (int)Math.floor(round/2); //Determine a function that is balanced.
		}
}
