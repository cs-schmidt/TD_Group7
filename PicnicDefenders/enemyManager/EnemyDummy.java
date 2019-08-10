package enemyManager;
/**
 * This class is simply used as a basis to created a 2D-Array of 'Enemy' objects for the enemyMap class.
 * This class is a child of the enemy class.
 * @author schmi
 *
 */
public class EnemyDummy extends Enemy {
	//Constructor
	/**
	 * This is a constructor that generates an enemy with all of its stats set to 0.
	 * i.e. the tower has  a tag of 0, health of 0, damage of 0, and value of 0.
	 */
		public EnemyDummy(){
				super(0,0,0,0);
			}
}
