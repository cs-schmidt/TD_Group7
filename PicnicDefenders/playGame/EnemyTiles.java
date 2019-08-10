package playGame;

import enemyManager.EnemyMap;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class EnemyTiles extends Rectangle {
	
	
	public EnemyTiles(int rows, int columns, int state){
		
		//new ImagePattern(bug)
		setWidth(25);
		setHeight(25);
		if(state == 0) {
			Image bug = new Image("bug1.png", Main.tileSize, Main.tileSize, false, true);
			setOpacity(50);
			setFill(new ImagePattern(bug));
		}
		else {
			setOpacity(0);
		}
		relocate(rows*Main.tileSize,columns*Main.tileSize);
	}
}
