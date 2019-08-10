package mapsManager;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class serves to carry all of the grids as maps in its attribute 'listOfmaps'.
 * @author ethan.schmidt1
 *
 */
public class Maps {
	//Attributes
		/**
		 * This attribute serves to carry an ArrayList of all of the loadable maps.
		 */
		private ArrayList<Map> listOfMaps = new ArrayList<Map>();
	
	//Constructors
		/**
		 * This is a constructor that produces the Maps object. Which serves to carry all of the grids as maps in its attribute 'listOfmaps'.
		 */
		public Maps(){
			Grids grids = new Grids();
				for (int index = 0 ; index < grids.listOfGrids.size(); index++ ) {
					Map map = new Map(index);
					listOfMaps.add(map);
				}
			}
	
	//Methods
		//Getters
			/**
			 * This is a getter method that will produce a copy of a Map in 'listOfmaps'.
			 * @param mapInListOfMapsAtIndex : takes an integer to get the index of 'listOfMaps'.
			 * @return : returns a copy object of the Map selected in 'listOfmaps'.
			 */
			public Map getMap(int mapInListOfMapsAtIndex) {
				return new Map(listOfMaps.get(mapInListOfMapsAtIndex));
			}

		//Display
			/**
			 * This method will display all of the grids a user is able to load a game to.
			 * <br>(Exclusively used in the text-based version)
			 */
			public void seeLoadableMaps() {
				System.out.println("Choose a map to load.");
				System.out.println("'s' represents the enemy spawn.");
				System.out.println("'~' represents enemy path.");
				System.out.println("'e' represents the end of the enemy path.");
				System.out.println("'#' represents where towers can be placed.");
				System.out.println("");
				for(int index = 0; index < listOfMaps.size(); index++) {
					System.out.println("Map "+index);
					displayMaps(listOfMaps.get(index));
					System.out.println("");
				}
			}
			/**
			 * This method will take user input and verify that the user has picked a map within the index of 'listOfMaps'.
			 * <br>(Exclusively used in the text-based version)
			 * @return : returns a number if the user picks one that is within the index of 'listOfMaps'.
			 */
			public int pickMap() {
				boolean inputIn = false;
				System.out.println("There are "+listOfMaps.size()+" maps, to pick one you must enter a number between 0 and "+(listOfMaps.size() - 1));
				Scanner input = new Scanner(System.in);
				String mapChoice = input.nextLine();
				while(inputIn == false) {
					try {
						inputIn = verifyMapExists(Integer.parseInt(mapChoice));
						while(verifyMapExists(Integer.parseInt(mapChoice)) == false) {
							System.out.println(Integer.parseInt(mapChoice)+" is a number that is out of the range, pick again.");
							input = new Scanner(System.in);
							mapChoice = input.nextLine();
						}
					}
					catch(Exception NumberFormatException){
						System.out.println("You may only enter a number!");
						System.out.println("reenter a valid number");
						input = new Scanner(System.in);
						mapChoice = input.nextLine();
					}
				}
				return Integer.parseInt(mapChoice);
			}
			/**
			 * This method is used to check if a map is in the 'listOfMaps' attribute for this class.
			 * <br>(Exclusively used for the text-based version)
			 * @param x : takes an integer to check the 'listOfMaps' index.
			 * @return : returns a boolean that indicates the map is in 'listOfMaps'.
			 */
			private boolean verifyMapExists(int x) {
				boolean verifyMapExists = false;
				for(int mapsInListOfMaps = 0; mapsInListOfMaps < listOfMaps.size(); mapsInListOfMaps++) {
					if(mapsInListOfMaps == x) {
						verifyMapExists = true;
						break;
					}
				}
				return verifyMapExists;
			}
			/**
			 * This method is used to display the grids available in the console.
			 * <br>(Exclusively used for the text-based version).
			 * @param map : takes the a map as an argument.
			 */
			private void displayMaps(Map map) {
				for(int row = 0; row < map.getMapGrid().length; row++) {
					for(int column = 0; column < map.getMapGrid()[0].length; column++) {
						if(map.getMapGrid()[row][column] == 1) 
							System.out.print("#"+" ");
		
						else if(map.getMapGrid()[row][column] == 2)
							System.out.print("s"+" ");
						
						else if(map.getMapGrid()[row][column] == 3)
							System.out.print("e"+" ");
						
						else
							System.out.print("~"+" ");
					}
					System.out.println("");
				}
			}
}
