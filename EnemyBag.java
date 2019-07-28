import java.util.ArrayList;
import java.util.Collections;
public class EnemyBag {
	
	//Attributes
		ArrayList<Enemy> enemiesAvailable = new ArrayList<Enemy>();
		private int[][] map;
	//Constructors
		 EnemyBag(int round,int[][] map ){//Creates our scrambled bag of enemies.
			enemiesAvailable = enemiesForRound(round);
			this.map = map;
		}
		 
		 EnemyBag(EnemyBag toCopy){
			 this.enemiesAvailable = toCopy.enemiesAvailable;
		 }
	//Methods
		private ArrayList<Enemy> enemiesForRound(int round){
			ArrayList<Enemy> bagOfEnemies = new ArrayList<Enemy>();
			
			for(int x = 0; x < BasicEnemy.BRoundFunction(round) ;x++) {
				Enemy eBasic = new BasicEnemy(map);
				 bagOfEnemies.add(eBasic);
			}
			
			for(int x = 0; x < TankEnemy.TRoundFunction(round) ;x++) {
				TankEnemy eTank = new TankEnemy(map);
				 bagOfEnemies.add(eTank);
			}

			for(int x = 0; x < DamageEnemy.DRoundFunction(round) ;x++) {
				DamageEnemy eDamage = new DamageEnemy(map);
				 bagOfEnemies.add(eDamage);
			}
			
			Collections.shuffle(bagOfEnemies); //this scrambles the array-list.
			return bagOfEnemies;
		}
		
		//Getter
			public ArrayList<Enemy> getBag() { //Potential privacy leak. ALSO WHY DOES IT SAY IT IS NOT VISIBLE WHEN I MAKE IT PRIVATE AND APPLY IT TO AN INSTANCE OF THE CLASS???***
				return enemiesAvailable;
			}

}
