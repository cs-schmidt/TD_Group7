
public class Enemy {
	private final int damageInflictable = 1;
	private int enemyType;
	public int enemyHealth;
	
	Enemy(){
	}
	
	Enemy(int enemyType){
		this.enemyType = 1;
		this.enemyHealth = 3;
	}
	
	Enemy(int enemyType , int enemyHealth){//To move enemies in the grid.
		this.enemyType = 1;
		this.enemyHealth = enemyHealth;
	}
	
	public int getType() {
		int type = this.enemyType;
		return type;
	}
	
	public int getEnemyHealth() {
		return this.enemyHealth;
	}
	
	public static Enemy[][] establishEnemyGrid(MapUnderlier x){//MapUnderlier is an object that represents a map. REMEMBER THIS.
		Enemy[][] eGridSetter = new Enemy[x.validityMap.length][x.validityMap[0].length];
		Enemy passiveTypeEnemy = new Enemy();//this will make a grid of pointers to one passive-type tower object.
		for(int row = 0; row < x.validityMap.length; row++) {
			for(int column = 0; column < x.validityMap[row].length; column++) {
				eGridSetter[row][column] = passiveTypeEnemy;
			}
		}
		return eGridSetter;
	}
	
	public static Enemy[][] spawnEnemy(Enemy[][] x, MapUnderlier y){ //this takes an argument of a previous enemy map and MapUnderlier
		for(int row = 0; row < y.validityMap.length; row++) {
				if(	y.validityMap[row][0] == 2)
					x[row][0]= new Enemy(1);
	}
		return x;
}
	//Moves enemies on enemy grid.
	public static Enemy[][] moveEnemiesPresent(Enemy[][] x){//WHY DOES IT MOVE ONE EXTRA STEP??***
		for(int column = x[0].length-2; column >= 0; column--) {//because we want to move any enemies from second to last.
			if(x[1][column].getType() == 1) {
				Enemy enemyMoveCopy = new Enemy();
				Enemy enemyMoved = new Enemy(1 , x[1][column].getEnemyHealth());
				x[1][column + 1] = enemyMoved;
				x[1][column] = enemyMoveCopy;
			}
		}
		return x;
		}
	
	//Displays enemy map
	public static void seeEnemyMap(Enemy[][] x) {
		for(int row = 0;row < x.length; row++) {
			for(int column = 0; column < x[row].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
				if(x[row][column].getType() == 1)
					System.out.print("E"+" ");
				else
					System.out.print("P"+" ");
			}
			System.out.println();//functions as a way to space the lines I guess.
		}
	}
}	

