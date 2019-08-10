package towerManager;
/**
 * This class is a child of the tower class and is simply used to create a specific category of tower with a specific set of stats.
 * @author schmi
 *
 */
public class TowerA extends Tower{
	//Constructors
		/**
		 * This is a constructor that generates a tower which has all of its attributes set to 1,
		 * i.e. the tower has  a tag of 1, health of 1, cost of 1, and range of 1.
		 */
		TowerA(){
			super(1,1,1,1);
		}
}
