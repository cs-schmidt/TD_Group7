
public class DamageEnemy extends Enemy{

	//Attributes
		//Accounted for in BaseEnemy class but modified here.
	
	//Constructor
		DamageEnemy(int[][] map){
			super(2,10,2,2, map);
		}
	//Methods
		public static int DRoundFunction(int round) { //Determine later if round will count from 0 or from 1.***
			return (int)Math.floor(round/3); //Determine a function that is balanced.
		}
}


