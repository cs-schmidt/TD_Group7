package enemyManager;
/**
 * This class is a child of the enemy class and is simply used to create a specific category of enemy with a specific set of stats.
 * @author schmi
 *
 */
public class EnemyA extends Enemy{
	
	//Constructors
		/**
		 * This is a constructor that generates an enemy of this type, being type A.
		 * i.e. the tower has  a tag of 1, health of 3, damage of 1, and value of 1.
		 */
		EnemyA(){
			super(3,1,1,1);
		}
		
		//Methods
		/**
		 * This method is used to calculate the amount of these enemies to spawn in a given round.
		 * @param round : takes the integer value of the current round as an argument.
		 * @return : returns an integer value for the amount of enemies to spawn.
		 */
			public static int aEnemiesForRound(int round) {
				return 3 + round;
			}

}
