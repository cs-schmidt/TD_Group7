import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class QuitBox {

	static boolean quitInfo = false;
	//Methods
	
	/*
	 * 
	 */
	public static boolean comfirmQuit() {
		Stage quitWindow = new Stage();
		quitWindow.setTitle("Exit");
		
		quitWindow.initModality(Modality.APPLICATION_MODAL);
		
		Label warning = new Label();
		warning.setText("Are you sure you want to quit the game?");
		
		Button yesButton = new Button("Yes");
		yesButton.setOnAction(e -> {
			quitInfo = true;
			quitWindow.close();
		});
		
		Button noButton = new Button("No");
		noButton.setOnAction(e -> {
			quitInfo = false;
			quitWindow.close();
		});

		
		HBox buttonLayout = new HBox(50);
		buttonLayout.getChildren().addAll(yesButton, noButton);
		buttonLayout.setAlignment(Pos.CENTER);
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(warning, buttonLayout);
		layout.setAlignment(Pos.CENTER);
		
		Scene quitScene = new Scene(layout, 300, 100);
		quitWindow.setScene(quitScene);
		quitWindow.showAndWait();
		
		return quitInfo;
	}
}