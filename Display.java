
public class Display {
	
	public static void seeDisplay(Tower[][] x, Enemy[][] y) {
		for(int row = 0;row < x.length; row++) {
			for(int column = 0; column < x[0].length; column++) {//perhaps a better coding practice to code the for loop this way, using "row" in the brackets
				if(x[row][column].getType() == 1)
					System.out.print("t"+" ");
				else if(x[row][column].getType() == 0 && row !=1)
					System.out.print("~"+" ");
				if(y[row][column].getType() == 1)
					System.out.print("e"+" ");
				else if (y[row][column].getType() == 0 && row == 1)
					System.out.print("="+" ");
			}
			System.out.println();//functions as a way to space the lines I guess.
		}

		for(int column = 0; column < y[0].length;column++) {
			if(y[1][column].getType() == 1)
				System.out.print(y[1][column].getEnemyHealth() + " ");
			else
				System.out.print(0 + " ");
		}
		
	}
	
	public static boolean getThatCheck(Enemy[][] x) {
		boolean confirmedDetect = false;
		for(int column = x[0].length-2; column >= 0; column--) {
			if( x[1][column].getType()==1)
				confirmedDetect=true;
		}
		return confirmedDetect;
	}

}
