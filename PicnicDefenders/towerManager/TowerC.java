package towerManager;
/**
 * This class is a child of the tower class and is simply used to create a specific category of tower with a specific set of stats.
 * @author schmi
 *
 */
public class TowerC extends Tower{
	//Constructors
	/**
	 * This is a constructor that generates a tower which has all of its attributes set to 3,
	 * i.e. the tower has  a tag of 3, health of 3, cost of 3, and range of 3.
	 */
		TowerC(){
			super(3,3,3,3);
		}
}
