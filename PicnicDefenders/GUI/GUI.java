package GUI;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import playGame.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


//THIS IS A GUI BASIC DEMO 


public class GUI extends Application{
	Button start_button, Map1,Map2,Map3, info_button, back_button;
	Scene mainMenu, mapChooser, youLose;
	
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	
	public void start(Stage window) {
		window.setTitle("Picnic Defence Ver. 0.7.0"); 
		//SCENE1 CREATION
		//STARTBUTTON CREATION
		Image start_pic = new Image("start_b.png",300,100,false,true);
		ImageView start_node = new ImageView();
		start_node.setImage(start_pic);
		start_button = new Button();
		start_button.setPadding(Insets.EMPTY);
		start_button.setGraphic(start_node);
		start_button.setOnAction(e -> window.setScene(mapChooser));
		
		//INFOBUTTON ACTIVATION
		Image info_b = new Image("info_button.png", 100, 20, false, true);
		ImageView info_node = new ImageView();
		info_node.setImage(info_b);
		info_button = new Button();
		info_button.setGraphic(info_node);
		info_button.setOnAction(e -> InfoPopUp.display());
		
		//BACKGROUND IMAGE
		Image background1 = new Image("mainMenu.png", true);
		ImageView background_image1 = new ImageView(background1);
		
		//SCENE1 CREATION
		StackPane layout1 = new StackPane(); 
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(20);
		vbox.getChildren().addAll(start_button, info_button);
		layout1.getChildren().addAll(background_image1, vbox);
		mainMenu = new Scene(layout1, 800,700);
		
		//BACKGROUND
		Image background2 = new Image("map_background.png", true);
		ImageView background_image2 = new ImageView();
		background_image2.setImage(background2);
		
		//MAP SPRITES
		Image map1 = new Image("Map1.png", 150,150,false, true);
		ImageView map1_node = new ImageView(map1);
		Image map2 = new Image("Map2.png", 150,150,false, true);
		ImageView map2_node = new ImageView(map2);
		Image map3 = new Image("Map3.png", 150,150,false, true);
		ImageView map3_node = new ImageView(map3);
		
		//BUTTON FUNCTIONALITY

		Map1 = new Button();
		Map1.setGraphic(map1_node);
		Map1.setOnAction(e -> {
			try {
				Main.start(window, 0);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Map2 = new Button();
		Map2.setGraphic(map2_node);
		Map2.setOnAction(e -> {
			try {
				Main.start(window, 1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Map3 = new Button();
		Map3.setGraphic(map3_node);
		Map3.setOnAction(e -> {
			try {
				Main.start(window, 2);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		//gotta set up pathing to envoke ethan's runner class
		
		back_button = new Button("Back");
		back_button.setOnAction(e -> window.setScene(mainMenu));
		//back from map choosing screen
		
		//SCENE2 CREATION
		StackPane layout2 = new StackPane();
		HBox hbox = new HBox();
		VBox vbox2 = new VBox();
		
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setSpacing(30);
		vbox2.getChildren().addAll(hbox, back_button);
		
		hbox.setSpacing(60);
		hbox.getChildren().addAll(Map1,Map2,Map3);
		hbox.setAlignment(Pos.CENTER);
		
		layout2.getChildren().addAll(background_image2,vbox2);
		mapChooser = new Scene(layout2,800,700);
		
		//loser screen
		Image loser = new Image("Loser.png");
		ImageView node_loser = new ImageView();
		node_loser.setImage(loser);
		StackPane lose = new StackPane();
		lose.getChildren().addAll(node_loser, back_button);
		youLose = new Scene(lose,800,700);
		
		
		//sets first scene as mainMenu
		window.setScene(mainMenu);
		window.show();
		
		//need to make, map envokes runner and creates gui
		// ethan's runner will return a true of false for game end
		// get a win or lose screen ex. boolean result = main.start(primaryStage);
		
		
			
		}
	
	}
	
	
	
