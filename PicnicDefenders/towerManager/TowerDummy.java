package towerManager;
/**
 * This class is simply used as a basis to created a 2D-Array of 'Tower' objects for the towerMap class.
 * This class is a child of the tower class.
 * @author schmi
 *
 */
public class TowerDummy extends Tower {
	//Constructors
	/**
	 * This is a constructor that generates a tower which has all of its attributes set to 0,
	 * i.e. the tower has  a tag of 0, health of 0, cost of 0, and range of 0.
	 */
		public TowerDummy(){
				super(0,0,0,0);
			}
}
