package towerManager;
/**
 * This class is a child of the tower class and is simply used to create a specific category of tower with a specific set of stats.
 * @author schmi
 *
 */
public class TowerB extends Tower{
	//Constructors
	/**
	 * This is a constructor that generates a tower which has all of its attributes set to 2,
	 * i.e. the tower has  a tag of 2, health of 2, cost of 2, and range of 2.
	 */
		TowerB(){
			super(2,2,2,2);
		}
}
