import java.util.Scanner;
public class Tower {
	private final int damageInflictable = 1;//can change later
	private int towerType;//This is just a band-aid to make what is to come work.
	
	//Constructors
	Tower(){//so this default constructor has towerType 0, indicating "passive-type". 
	}
	
	Tower(int activeType){//this will have active-type indicated by value 1.
		this.towerType = 1;
	}
	
	//Type getter
	public int getType() {
		int type = this.towerType;
		return type;
	}
	
	//Sizes the tower grid
	private static Tower[][] establishTowerGrid(MapUnderlier x){//MapUnderlier is an object that represents a map. REMEMBER THIS.
		Tower[][] tGridSetter = new Tower[x.validityMap.length][x.validityMap[0].length];
		Tower passiveTypeTower = new Tower();//this will make a grid of pointers to one passive-type tower object.
		for(int row = 0; row < x.validityMap.length; row++) {
			for(int column = 0; column < x.validityMap[row].length; column++) {
				tGridSetter[row][column] = passiveTypeTower;
			}
		}
		return tGridSetter;
	}
	//places towers
	public static Tower[][] towersPlacable(MapUnderlier x){
		Tower[][] frameworkPlacer = Tower.establishTowerGrid(x);
		System.out.println("Enter the coordinates for the towers you wish to place.");
		String explain = "11,12,13";
		explain = "\"" + explain + "\""; //Try to understand this later.
		System.out.println("Valid entry example is:"+ " "+ explain + ".");
		System.out.println("The first digit denotes an x-coordinate and the second a y-coordinate");
		System.out.println("You may place *3*");
		System.out.print("Place your towers: ");
		Scanner input = new Scanner(System.in);
		String inputPut = input.nextLine();
		boolean entry = false;
		do {
			if(inputPut.length() == 2 ^ inputPut.length() == 5 ^ inputPut.length() == 8) 
				entry=true;
			else {
				System.out.println("Your entry is invalid");
				System.out.print("Place your towers again: ");
				input = new Scanner(System.in);
				inputPut = input.nextLine();
			}	
		} while (entry == false);
		int[][] inputGrid = inputInterpreter(inputPut); // not to be confused with input grid in input Interpreter.
		//This do-while loop checks our input.
		entry = false;
		do {
			for(int row = 0; row < inputGrid.length; row++) {
						if (inputGrid[row][0] > frameworkPlacer[0].length) {//This one takes the x-coordinate.***// check > or >=
							entry = false;
							System.out.println("Seems one of the entries is out of range");
							System.out.print("Place your towers again: ");
							input = new Scanner(System.in);
							inputPut = input.nextLine();
							inputGrid = inputInterpreter(inputPut);
						}
						else if (inputGrid[row][1] > frameworkPlacer.length) {//This one takes the y-coordinate.***// check > or >=
							entry = false;
							System.out.println("Seems one of the entries is out of range");
							System.out.print("Place your towers again: ");
							input = new Scanner(System.in);
							inputPut = input.nextLine();
							inputGrid = inputInterpreter(inputPut);
						}
						else
							entry = true;
			}
		} while (entry == false);
		//placement occurs now.
		entry = false;//just a band-aid right now.
		for(int row = 0; row < inputGrid.length; row++) {
				if(x.validityMap[inputGrid[row][1]][inputGrid[row][0]] == 1)//** 
					frameworkPlacer[inputGrid[row][1]][inputGrid[row][0]] =new Tower(1) ;
			}
		
		return frameworkPlacer;
	}

	//Tower checker method
	public static void rangeChecker(Enemy[][] x,Tower[][] y,Enemy z) {
		//Tower checks = new Tower(1);
			int tracking = z.getEnemyHealth();
			for(int row = 0; row <= y.length; row += 2) {
				for(int column = 0; column < y[0].length; column++) {
						//add separate conditions for the top corners perhaps y[0][y.length]
					if(y[row][column].getType()==1 && row == 0 && column ==0) {
						//down flow top-left corner //HERE*****
							if (x[1][1].getType()==1) {
								x[1][1].enemyHealth -= 1;
								if(x[1][1].enemyHealth == 0) {
									Enemy passiveTypeEnemy = new Enemy();
									x[1][1] = passiveTypeEnemy;
									z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
								}
							}
							else if (x[1][0].getType()==1) {
								x[1][0].enemyHealth -= 1;
								if(x[1][0].enemyHealth == 0) {
									Enemy passiveTypeEnemy = new Enemy();
									x[1][0] = passiveTypeEnemy;
									z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
								}
							}
					}
					else if(y[row][column].getType()==1 && row == 0 && column == y[0].length - 1) {
						//down flow top-right corner
						if (x[1][y[0].length - 1].getType()==1) {
							x[1][y[0].length - 1].enemyHealth -= 1;
							if(x[1][y[0].length - 1].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][y[0].length - 1] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
							}
						}
						else if (x[1][y[0].length - 2].getType()==1) {
							x[1][y[0].length - 2].enemyHealth -= 1;
							if(x[1][y[0].length - 2].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][y[0].length - 2] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
							}
						}	
					}
					else if(y[row][column].getType()==1 &&(row == 0 && column != 0 && column != y[0].length-1)) {//-1 guy.
						//down flow middle
							if (x[1][column+1].getType()==1) {
								x[1][column+1].enemyHealth -= 1;
								if(x[1][column+1].enemyHealth == 0) {
									Enemy passiveTypeEnemy = new Enemy();
									x[1][column+1] = passiveTypeEnemy;
									z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
								}
							}
							else if (x[1][column].getType()==1) {
								x[1][column].enemyHealth -= 1;
								if(x[1][column].enemyHealth == 0) {
									Enemy passiveTypeEnemy = new Enemy();
									x[1][column] = passiveTypeEnemy;
									z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
								}
							}
							else if (x[1][column-1].getType()==1) {
								x[1][column-1].enemyHealth -= 1;
								if(x[1][column-1].enemyHealth == 0) {
									Enemy passiveTypeEnemy = new Enemy();
									x[1][column-1] = passiveTypeEnemy;
									z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
								}
							}
					}
					if(y[row][column].getType()==1 && row == 2 && column == 0) {
						//up flow bottom-left corner //check later I think this will work though.
						if (x[1][1].getType()==1) {
							x[1][1].enemyHealth -= 1;
							if(x[1][1].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][1] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
							}
						}
						else if (x[1][0].getType()==1) {
							x[1][0].enemyHealth -= 1;
							if(x[1][0].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][0] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
							}
						}
					}
					else if(y[row][column].getType()==1 && row == 2 && column == y[0].length - 1) {
						//up flow bottom-right corner
						if (x[1][y[0].length - 1].getType()==1) {
							x[1][y[0].length - 1].enemyHealth -= 1;
							if(x[1][y[0].length - 1].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][y[0].length - 1] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
							}
						}
						
						else if (x[1][y[0].length - 2].getType()==1) {
							x[1][y[0].length - 2].enemyHealth -= 1;
							if(x[1][y[0].length - 2].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][y[0].length - 2] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
							}
						}
					}
					else if(y[row][column].getType()==1 && row == 2 && column != 0 && column != y[0].length - 1) {
						//up flow middle
						if (x[1][column+1].getType()==1) {
							x[1][column+1].enemyHealth -= 1;
							if(x[1][column+1].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][column+1] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
							}
						}
						else if (x[1][column].getType()==1) {
							x[1][column].enemyHealth -= 1;
							if(x[1][column].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][column] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
							}
						}
						else if (x[1][column-1].getType()==1) {
							x[1][column-1].enemyHealth -= 1;
							if(x[1][column-1].enemyHealth == 0) {
								Enemy passiveTypeEnemy = new Enemy();
								x[1][column-1] = passiveTypeEnemy;
								z.enemyHealth = z.getEnemyHealth() - 1;//*****ADJASFOAFOAJFOB
								
							}
						}
					}
					}	
				}
			}
	
		
		
	
	//Lets you see where you placed towers
	public static void seeTowerMap(Tower[][] x) {
		for(int row = 0;row < x.length; row++) {
			for(int column = 0; column < x[row].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
				if(x[row][column].getType() == 1)
				System.out.print("A"+" ");
				
				else
					System.out.print("P"+" ");
			}
			System.out.println();//functions as a way to space the lines I guess.
		}
	}
	
	public static int getDigitFromChar(char x) {
		if (x == 48) {return 0;}
		if (x == 49) {return 1;}
		if (x == 50) {return 2;}
		if (x == 51) {return 3;}
		if (x == 52) {return 4;}
		if (x == 53) {return 5;}
		if (x == 54) {return 6;}
		if (x == 55) {return 7;}
		if (x == 56) {return 8;}
		if (x == 57) {return 9;}
		else  {return 0;}
	}
		
	public static int[][] inputInterpreter(String input){ //Works
		int tracker = 0;
		if (input.length()==2) {
			tracker = 0;
		}
		else if (input.length()==5) {
			tracker = 1;
		}
		else if (input.length()==8) {
			tracker = 2;
		}
		int[][] inputGrid = new int[tracker +1][2];
		for(int row = 0;row <= tracker; row++) {
			for(int column = 0;column < 2; column++) {
				if(row == 0)
					inputGrid[row][column]=getDigitFromChar(input.charAt(column));
				else if (row > 0)
					inputGrid[row][column]=getDigitFromChar(input.charAt(3*(row)+column));
				}	
			}
		return inputGrid;
		}
	}
	
	

