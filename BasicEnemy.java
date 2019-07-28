import java.lang.Math;
public class BasicEnemy extends Enemy {

	//Attributes
		//Accounted for in BaseEnemy class but modified here.
	
	//Constructor
	BasicEnemy(){
		super(3,1,0,1);
	}
		//Methods
	public static int bERoundFunction(int round) { //Determine later if round will count from 0 or from 1.***
		return 3 + round; //Determine a function that is balanced.
	}
}
