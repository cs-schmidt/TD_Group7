package enemyManager;
import java.lang.Math;
/**
 * This class is a child of the enemy class and is simply used to create a specific category of enemy with a specific set of stats.
 * @author schmi
 *
 */
public class EnemyC extends Enemy {
	
	//Constructors
		EnemyC(){
			/**
			 * This is a constructor that generates an enemy of this type, being type C.
			 * i.e. the tower has  a tag of 3, health of 5, damage of 1, and value of 1.
			 */
			super(5,1,3,1);
		}

		//Methods
		/**
		 * This method is used to calculate the amount of these enemies to spawn in a given round.
		 * @param round : takes the integer value of the current round as an argument.
		 * @return : returns an integer value for the amount of enemies to spawn.
		 */
			public static int cEnemiesForRound(int round) {
				return (int) Math.floor(round/4);
			}
}
