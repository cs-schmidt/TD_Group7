import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu extends Application {
	
	Stage tdGame;
	Scene menu, chooseMap;	
	
	//Methods
	public static void main(String[] args){
		launch(args);
	}
	
	/* Description:
	 * 		Create Menu Scene and ChooseMap Scene.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		tdGame = primaryStage;
		tdGame.setTitle("TowerDefense");
		
		
		//setup the menu Scene.
		//Start button.
		Button start = new Button();
		start.setText("Start");
		start.setOnAction(e -> tdGame.setScene(chooseMap));
		
		//Quit button.
		Button quit = new Button();
		quit.setText("Quit");
		quit.setOnAction(e -> {
			boolean quitResult = QuitBox.comfirmQuit();
			if (quitResult == true) {
				tdGame.close();
			}
		});
		
		//HBox that contains start button and quit button.
		HBox menuChoice = new HBox(100);
		menuChoice.getChildren().addAll(start, quit);
		menuChoice.setAlignment(Pos.CENTER);
		menu = new Scene(menuChoice, 400, 400);
		
		
		
		//setup the chooseMap Scene.
		//Map1
		VBox map1 = new VBox();
		Button firstMap = new Button("Map1");
		map1.getChildren().add(firstMap);
		map1.setAlignment(Pos.CENTER);
		
		//Map2
		VBox map2 = new VBox();
		Button secondMap = new Button("Map2");
		map2.getChildren().add(secondMap);
		map2.setAlignment(Pos.CENTER);
		
		//Map3
		VBox map3 = new VBox();
		Button thirdMap = new Button("Map3");
		map3.getChildren().add(thirdMap);
		map3.setAlignment(Pos.CENTER);
		
		//HBox that contains all map1, map2 an map3.
		HBox mapChoice = new HBox(70);
		mapChoice.getChildren().addAll(map1, map2, map3);
		mapChoice.setAlignment(Pos.CENTER);
		
		//VBox that contains HBox above and a back button lead to main menu.
		VBox mapSceneLayout = new VBox(250);
		Button back = new Button();
		back.setText("Back");
		back.setOnAction(e -> tdGame.setScene(menu));
		mapSceneLayout.getChildren().addAll(mapChoice, back);
		mapSceneLayout.setAlignment(Pos.CENTER);
		chooseMap = new Scene(mapSceneLayout, 700, 700);
		
		//If click on top right cross.
		tdGame.setOnCloseRequest(e -> {
			e.consume();
			boolean quitgame = QuitBox.comfirmQuit();
			if (quitgame == true) {
				tdGame.close();
			}
		});
		
		//launch
		tdGame.setScene(menu);
		
		tdGame.show();
		
	}
	
}
