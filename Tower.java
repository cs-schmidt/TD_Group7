package demo1;

import java.util.Scanner;
public class Tower{
	private final int damageInflictable = 1; //Can change this value later.
	private int towerType;
	
	//Default constructor
	Tower(){
		this.towerType = 0;
	}
	
	//True tower constructor
	Tower(int x){
		this.towerType = 1;
	}
	
	public boolean getTowerDummyExist() {
		if (this.towerType == 0)
			return true;
		else
			return false;
	}

	public static Tower[][] establishTowers(TdMap x) {
		TdMap map = new TdMap(x);
		Tower[][] towers = new Tower[map.getHeight()][map.getWidth()];
		for (int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				Tower towerTest= new Tower();
				towers[i][j] = towerTest;
			}
		}
		System.out.println("Map size is set to 5x3");
		System.out.println(" 12345");
		System.out.println("1OOOOO");
		System.out.println("2XXXXX");
		System.out.println("3OOOOO");
		System.out.println("Enter the coordinates to place your towers:");
		Scanner placetower = new Scanner(System.in);
		String coords = placetower.nextLine();
		int xcoord = Tower.getDigitFromChar(coords.charAt(0));
		int ycoord = Tower.getDigitFromChar(coords.charAt(1));
		do {
			if ((towers[ycoord][xcoord].getTowerDummyExist()== true) && (map.buildValidityMap()[ycoord][xcoord]== 1)) {
				Tower towerTest= new Tower(1);
				towers[ycoord][xcoord] = towerTest;
			}
			else {
				System.out.println("Invalid location, replace tower:");
				placetower= new Scanner(System.in); //Because they are already typed so it would duplicate if you typed it again.
				coords = placetower.nextLine();
				xcoord = Tower.getDigitFromChar(coords.charAt(0));
				ycoord = Tower.getDigitFromChar(coords.charAt(1));
			}
				
		} while (towers[ycoord][xcoord].getTowerDummyExist() == false);
			return towers;
	}
		
	public void checkRange() { //here we check if an enemy has entered our area.
		
	}
	//Method that takes char value to integer (in the context of digits).
	public static int getDigitFromChar(char x) {
		if (x == 48)
			return 0;
		if (x == 49)
			return 1;
		if (x == 50)
			return 2;
		if (x == 51)
			return 3;
		if (x == 52)
			return 4;
		if (x == 53)
			return 5;
		if (x == 54)
			return 6;
		if (x == 55)
			return 7;
		if (x == 56)
			return 8;
		if (x == 57)
			return 9;
		else 
			return 0;
		
	}
}