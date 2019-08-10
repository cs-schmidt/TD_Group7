package enemyManager;
import java.util.ArrayList;
import java.util.Collections;
/**
 * The principle reason for this class lies in creating an object that holds an ArrayList of dynamically spawned enemies.
 * @author ethan.schmidt1
 *
 */
public class EnemyBag {
	
	//Attributes
	/**
	 * This attribute is the ArrayList that serves to hold the enemies we spawn in a given round.
	 */
		ArrayList<Enemy> bagOfEnemies = new ArrayList<Enemy>();
		
	//Constructors
		/**
		 * This constructor will produce an 'EnemyBag' object and based on the integer we pass it will setup the enemies in its attribute 'bagOfEnemies'. 
		 * @param round : takes the round as a argument, which is simply an integer that represents the round.
		 */
		public EnemyBag(int round){
				this.bagOfEnemies = createBag(round);
			}
		
	//Methods
		/**
		 * This will create an ArrayList of enemies based on the round value passed.
		 * @param round : takes the value of the round as an argument.
		 * @return : return an ArrayList of type 'Enemy'.
		 */
		private ArrayList<Enemy> createBag(int round){
			ArrayList<Enemy> bagOfEnemies = new ArrayList<Enemy>();
		
			for(int a = 0; a < EnemyA.aEnemiesForRound(round); a++) {
				Enemy enemyA = new EnemyA();
				bagOfEnemies.add(enemyA);
			}
			for(int b = 0; b < EnemyB.bEnemiesForRound(round); b++) {
				Enemy enemyB = new EnemyB();
				bagOfEnemies.add(enemyB);
			}
			for(int c = 0; c < EnemyC.cEnemiesForRound(round); c++) {
				Enemy enemyC = new EnemyC();
				bagOfEnemies.add(enemyC);
			}
			Collections.shuffle(bagOfEnemies); //this scrambles the array-list.
			return bagOfEnemies;
		}
		
		//Getters
			/**
			 * This method will get the 'bagOfEnemies' attribute.
			 * @return : return the ArrayList 'bagOfEnemies'.
			 */
			public ArrayList<Enemy> getBag(){
				return this.bagOfEnemies;
			}
}
