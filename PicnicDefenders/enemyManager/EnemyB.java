package enemyManager;

import java.lang.Math;
/**
 * This class is a child of the enemy class and is simply used to create a specific category of enemy with a specific set of stats.
 * @author schmi
 *
 */
public class EnemyB extends Enemy {
	
	//Constructors
		EnemyB(){
			/**
			 * This is a constructor that generates an enemy of this type, being type B.
			 * i.e. the tower has  a tag of 2, health of 4, damage of 1, and value of 1.
			 */
			super(4,1,2,1);
		}
		
		//Methods
		/**
		 * This method is used to calculate the amount of these enemies to spawn in a given round.
		 * @param round : takes the integer value of the current round as an argument.
		 * @return : returns an integer value for the amount of enemies to spawn.
		 */
			public static int bEnemiesForRound(int round) {
				return (int) Math.floor(round/2);
			}

}
