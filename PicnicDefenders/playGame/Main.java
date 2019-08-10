package playGame;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import enemyManager.EnemyBag;
import enemyManager.EnemyMap;
import mapsManager.*;
import towerManager.TowerMap;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.TimeUnit;

public abstract class Main extends Application{
	
	public static final int tileSize = 30;
	public static final int tileWidth = 20;
	public static final int tileHeight = 20;
	
	private static Group mapUnderlier = new Group();
	private static Group towerUnderlier = new Group();
	private static Group enemySeer = new Group();
	
	static Button roundButton;
	int starter = 1;		
	//This will take in an event to select a grid.
	private static Pane createMapUnderlier(int[][] validityGrid) {
		Pane root = new Pane();
		root.setPrefSize(tileWidth*tileSize,tileHeight*tileSize);
		root.getChildren().add(mapUnderlier);
		for(int row = 0; row < tileHeight; row++) {
			for(int column = 0; column < tileWidth; column++) {
				TileBackground tile = new TileBackground(column,row);
				tile.distinguish(validityGrid,row,column);
				mapUnderlier.getChildren().addAll(tile);
			}
		}
		return root; 
	}
	
	private static Pane createTowerMap(TowerMap towerMap) {
		Pane root = new Pane();
		root.setPrefSize(tileWidth*tileSize,tileHeight*tileSize);
		root.getChildren().add(towerUnderlier);
		for(int row = 0; row < tileHeight; row++) {
			for(int column = 0; column < tileWidth; column++) {
				if(towerMap.copyTowerTracker()[column][row] == 0) {
					TowerTiles towerTile = new TowerTiles(towerMap,row, column);
					towerUnderlier.getChildren().add(towerTile);
				}
				else {
					//Do nothing.
				}	
			}
		}
		return root; 
	}
	
	private Pane createEnemyMap(EnemyMap enemyMap) {
		Pane enemyDisplay = new Pane();
		enemyDisplay.setPrefSize(tileWidth*tileSize,tileHeight*tileSize);
		enemyDisplay.getChildren().add(enemySeer);
		for(int row = 0; row < tileHeight; row++) {
			for(int column = 0; column < tileWidth; column++) {
				if(enemyMap.enemyMap[column][row].getEnemyTag() > 0) {
					EnemyTiles enemy = new EnemyTiles (row,column,0);
					enemySeer.getChildren().add(enemy);
				}
				else {
					//Do nothing.
				}
			}
		}
		return enemyDisplay;
	}
	
	private static void enemyTrackerMethod(EnemyMap enemyMap) {
		for(int row = 0; row < tileHeight; row++) {
			for(int column = 0; column < tileWidth; column++) {
				if(enemyMap.enemyMap[column][row].getEnemyTag() > 0) {
					EnemyTiles  enemy = new EnemyTiles (row,column,0);
					enemySeer.getChildren().add(enemy);
				}
				else {
					EnemyTiles  enemy = new EnemyTiles (row,column,1);
					enemySeer.getChildren().add(enemy);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	public static void start(Stage primaryStage, int map_num) throws Exception{
		
		
		//Game set
		//logic 1
		Player you = new Player(); // add an in-game window to enter your name.
		Maps maps = new Maps();
		Map mapPicked = maps.getMap(map_num);//The button they pick will set the integer value here. 0,1,2,3,etc.
		TowerMap towerMap = new TowerMap(mapPicked);
		EnemyMap enemyMap = new EnemyMap(mapPicked);
		int round = 0;
		//logic 1
	
		
		//GUI setup.
		BorderPane masterPane = new BorderPane();
		Pane topPane = new Pane();
		topPane.setPrefHeight(100);
		topPane.setPrefWidth(600);
		
		StackPane sideBox = new StackPane();
		sideBox.setPrefHeight(600);
		sideBox.setPrefWidth(200);
		
		HBox goldb = new HBox();
		Image gold = new Image("gold.png", 70, 70, false, true);
		ImageView node_gold = new ImageView(gold);
		Label gold_num = new Label("some fucking method that ethan makes"); //ETHAN MAKE THIS
		goldb.getChildren().addAll(node_gold,gold_num);
	
		
		HBox livesb = new HBox();
		Image lives = new Image("heart.png", 70, 70,false,true);
		ImageView node_lives = new ImageView(lives);
		Label lives_left = new Label(Integer.toString(you.getPlayerHealth()));
		livesb.getChildren().addAll(node_lives, lives_left);

		
		HBox round_numberb = new HBox();
		Image round_pic = new Image("bell.png",70, 70,false,true);
		ImageView node_round = new ImageView(round_pic);
		Label num_round = new Label("some other method ethan fucking makes"); //ETHAN MAKE THIS
		round_numberb.getChildren().addAll(node_round,num_round);

		
		HBox enemies_killedb = new HBox();
		Image enemies_pic = new Image("enemies_killed.png",70, 70,false,true);
		ImageView node_enemies = new ImageView(enemies_pic);
		Label enemies_ded_num = new Label("some other funciton, ehtan impleiment this"); //ETHAN MAKE THIS
		enemies_killedb.getChildren().addAll(node_enemies,enemies_ded_num);

		
		VBox side_vbox = new VBox();
		side_vbox.getChildren().addAll(round_numberb, enemies_killedb,goldb,livesb);
		side_vbox.setSpacing(100);
		Rectangle sideBoxBacking = new Rectangle(); // planning to change to an image
		sideBoxBacking.setFill(Color.PURPLE);
		sideBoxBacking.setWidth(200);
		sideBoxBacking.setHeight(600);
		sideBox.getChildren().addAll(sideBoxBacking, side_vbox);

		
		roundButton = new Button();//come back to this later.
		roundButton.setText("Start Round");
		topPane.getChildren().add(roundButton);
		//roundButton.setOnAction(this);
		masterPane.setTop(topPane);
		masterPane.setRight(sideBox);
		StackPane gamePane = new StackPane();
		masterPane.setCenter(gamePane);
		//GUI end.
		
		
		//Initial display
		Pane mapUnderlier = createMapUnderlier(mapPicked.getMapGrid());
		gamePane.getChildren().add(mapUnderlier);
		Scene scene = new Scene(masterPane,800,700);
		primaryStage.setScene(scene);
		primaryStage.show();
		//Initial display

		Pane enemyDisplay = new Pane();
		enemyDisplay.setPrefSize(tileWidth*tileSize,tileHeight*tileSize);
		enemyDisplay.getChildren().add(enemySeer);
		enemyTrackerMethod(enemyMap);
		gamePane.getChildren().add(enemyDisplay);
		

		
		Pane towerPicker = createTowerMap(towerMap);
		gamePane.getChildren().add(towerPicker);
		
		roundButton.setOnAction(er -> {
			EnemyBag bagOfEnemies = new EnemyBag(round);
			int x = 0;
			do{
				//Spawner
				PauseTransition pause = new PauseTransition(Duration.seconds(0+x));
				pause.setOnFinished(e -> {
					if(bagOfEnemies.getBag().size() > 0) {
						enemySeer.getChildren().clear();
						enemyMap.spawnEnemy(bagOfEnemies);
					}
					enemyTrackerMethod(enemyMap);
				});
				pause.play();
				
				//Shooter
				PauseTransition pause1 = new PauseTransition(Duration.seconds(1+x));
				pause1.setOnFinished(e -> {
					enemySeer.getChildren().clear();
					towerMap.towerShoot(enemyMap);
					enemyTrackerMethod(enemyMap);
				});
				pause1.play();
				
				//Mover
				PauseTransition pause2 = new PauseTransition(Duration.seconds(1+x));
				pause2.setOnFinished(e -> {
					enemySeer.getChildren().clear();
					enemyMap.moveEnemies(you);
					enemyTrackerMethod(enemyMap);
					lives_left.setText(Integer.toString(you.getPlayerHealth()));
				});
				pause2.play();
				x++;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
				
			}while(x < 30);

				
			
		});
		

		
	

	}
}