package playGame;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;


public class TileBackground extends Rectangle {
	Image grass = new Image("grassLand.png",Main.tileSize, Main.tileSize, false , true);
	Image road = new Image("road_2.png", Main.tileSize, Main.tileSize, false, true);
	Image end_road = new Image("endOfRoad.png", Main.tileSize, Main.tileSize, false , true);
	Image grass2 = new Image("grassLand02.png",Main.tileSize, Main.tileSize, false, true);
	Image road2 = new Image("road_2_02.png" , Main.tileSize, Main.tileSize, false, true);
	
	
	
	
	public TileBackground(int rows, int columns) {
		setWidth(Main.tileSize);
		setHeight(Main.tileSize);
		relocate(rows*Main.tileSize, columns*Main.tileSize);
	}


	public void distinguish(int[][] validiyMapUnderlier,int column,int row) {
		
		
		if((column + row) % 2 == 1 && validiyMapUnderlier[column][row] == 1 ) {
			setFill(new ImagePattern(grass));
		}
		else if((column + row) % 2 == 0 && validiyMapUnderlier[column][row] == 1 ) {
			setFill(new ImagePattern(grass2));
		}
		else if(validiyMapUnderlier[column][row] == 2 ) {
			setFill(new ImagePattern(road));
		}
		else if(validiyMapUnderlier[column][row] == 3 ) {
			setFill(new ImagePattern(end_road));
		}
		else if((column + row) % 2 == 0 && validiyMapUnderlier[column][row] == 0 ) {
			setFill(new ImagePattern(road));
		}
		else if((column + row) % 2 == 1 && validiyMapUnderlier[column][row] == 0 ) {
			setFill(new ImagePattern(road2));
		}
	}
}
