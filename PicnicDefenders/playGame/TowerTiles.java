package playGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import towerManager.TowerDummy;
import towerManager.TowerMap;

public class TowerTiles extends Circle {
	
	private int row;
	private int column;
	
	public TowerTiles(TowerMap towerMap,int rows, int columns) {
		setRadius(Main.tileSize/2);
		setFill(Color.BLUE);
		relocate(rows*Main.tileSize,columns*Main.tileSize);
		setOpacity(0);
		this.row = rows;
		this.column = columns;
		setOnMouseClicked(event->{
			if(event.getButton() == MouseButton.PRIMARY) {
				if(towerMap.towerTracker[column][row] == 0) {
					towerMap.placeTowerGUI(column,row);
					setOpacity(30);
							//for(int row = 0; row < towerMap.towerMap.length; row++) {
								//for(int column = 0; column <  towerMap.towerMap[0].length; column++ ) {
									//System.out.print(towerMap.towerTracker[row][column]+" ");
							//	}
								//System.out.println();
						//	}
				}
			}
			else if(event.getButton() == MouseButton.SECONDARY){
				//add other functionality here;
				
			}
		});
	}
}
