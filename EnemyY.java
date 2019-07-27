
public class EnemyY extends BaseEnemy {

	//Attributes
		//Accounted for in the BaseEnemy class

	//Constructor
		EnemyY(){
			super(5,3,2);
		}
		
	//Methods
		public static int eYRoundFunction(int round) { //Determine later if round will count from 0 or from 1.***
			return (int)Math.floor(round/3); //Determine a function that is balanced.
		}
}
