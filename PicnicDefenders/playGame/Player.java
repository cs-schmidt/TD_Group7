package playGame;
import java.util.Scanner;
/**
 * This is the class that represents the player/user.
 * @author ethan.schmidt1
 *
 */
public class Player {
	
	//Attributes
		/**
		 * This attribute initializes the player health to 50.
		 */
		int playerHealth = 50;
		/*
		 * This is the attribute that represents the player name.
		 */
		String playerName;
	
	//Constructor
		/**
		 * This is just a here to indicate the use of only the default constructor.
		 */
		public Player(){
		}
		
	//Methods
		//Getters
		/**
		 * This method will get a copy of the players health as a integer.
		 * @return : returns an integer copy of the value of the players health
		 */
		public int getPlayerHealth() {
			int health = this.playerHealth;
			return health;
		}
		
		//Setters
		/**
		 * This method is used to inflict damage on the player objects 'health'.
		 * @param damage : takes an integer value.
		 */
		public void setPlayerHealth(int damage) {
			this.playerHealth = this.playerHealth - damage;
		}
		
		/**
		 * This method will set the players name.
		 * <br>(Exclusively used for text-based version)
		 */
		public void setPlayerName() {
			System.out.print("Enter your name: ");
			Scanner input = new Scanner(System.in);
			String name = input.nextLine();
			playerName = name;
		}

}