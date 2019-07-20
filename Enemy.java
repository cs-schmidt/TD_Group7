package demo1;

//Edrick Enemy class version
class Enemy{
	
private int health;
private int damageInflictable;


	public Enemy(int health, int damage) {
		this.health = health;
		this.damageInflictable = damage;
	}
	Enemy(){
		
	}
	public int get_health() {
		return health;
	}
	public int get_damage() {
		return damageInflictable;
	}
	

}
