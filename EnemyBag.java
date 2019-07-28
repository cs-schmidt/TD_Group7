import java.util.ArrayList;
import java.util.Collections;
public class EnemyBag {
	
	//Attributes
		ArrayList<BaseEnemy> enemiesAvailable = new ArrayList<BaseEnemy>();
		
	//Constructors
		 EnemyBag(int round){//Creates our scrambled bag of enemies.
			enemiesAvailable = enemiesForRound(round);
		}
		 
		 EnemyBag(EnemyBag toCopy){
			 this.enemiesAvailable = toCopy.enemiesAvailable;
		 }
	//Methods
		private ArrayList<BaseEnemy> enemiesForRound(int round){
			ArrayList<BaseEnemy> bagOfEnemies = new ArrayList<BaseEnemy>();
			
			for(int x = 0; x < BaseEnemy.bERoundFunction(round) ;x++) {
				BaseEnemy enemy = new BaseEnemy();
				 bagOfEnemies.add(enemy);
			}
			
			for(int x = 0; x < EnemyX.eXRoundFunction(round) ;x++) {
				BaseEnemy enemyX = new EnemyX();
				 bagOfEnemies.add(enemyX);
			}

			for(int x = 0; x < EnemyY.eYRoundFunction(round) ;x++) {
				BaseEnemy enemyY = new EnemyY();
				 bagOfEnemies.add(enemyY);
			}
			
			Collections.shuffle(bagOfEnemies); //this scrambles the array-list.
			return bagOfEnemies;
		}
		
		//Getter
			public ArrayList<BaseEnemy> getBag() { //Potential privacy leak. ALSO WHY DOES IT SAY IT IS NOT VISIBLE WHEN I MAKE IT PRIVATE AND APPLY IT TO AN INSTANCE OF THE CLASS???***
				return enemiesAvailable;
			}

}
