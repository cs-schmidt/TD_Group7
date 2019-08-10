package GUI;
import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class InfoPopUp {
 public static final String instuctions = 
		 "This is a TOWER DEFENCE(TD) game. \n"
		 +"You are on a nice picnic with your family, but Oh No! the Insects are attacking!"
		 + " Place towers and fight against a small variety of insects who want to steal"
		 + " your food! Defeat a multitude of increasingly difficult waves of insects "
		 + "before they reach the end and ruin your picnic. \n"
		 + "This Project was completed by: \n"
		 + "Edrick Lin. \nAlex (ZiXi Han). \nBruce(ZheZheng Wong). \nEthan Schmidt.";
	
	public static void display() {
		Stage window = new Stage();
		
		//MODALITY
		window.initModality(Modality.APPLICATION_MODAL);
		
		//SETTING UP LABEL AND BUTTON FUCTION
		Label label = new Label();
		label.setText(instuctions);
		label.setWrapText(true);
		Button closeButton = new Button("Very Interesting");
		closeButton.setOnAction(e -> window.close());
			
		//VBOX FOR BUTTON
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		//IMAGING THE BACKGROUND
		Image background = new Image("info_background.png", true);
		ImageView node_background = new ImageView();
		node_background.setImage(background);
		
		//STACKPANE TO STACK BACKGROUND
		StackPane layout_p = new StackPane();
		layout_p.getChildren().addAll(node_background, layout);
		
		//SCENE CREATION
		Scene scene = new Scene(layout_p,500,400);
		window.setTitle("PRELUDE & CREDITS");
		window.setScene(scene);
		window.showAndWait();
	}
	
}
