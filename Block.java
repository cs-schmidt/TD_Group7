import java.awt.*;

public class Block extends Rectangle {
	public int groundID;
	public int airID;
	
	public Block(int x, int y, int width, int height, int groundID, int airID) {
		setBounds(x, y, width, height );
			this.groundID = groundID;
			this.airID = airID;

		
	}

	public void draw(Graphics g) {
		g.drawImage(GUI.tileast_ground[groundID], x, y, width, height, null);
		// i assume we have a GUI class
		if(airID !=Value.airAir) {
			g.drawImage(GUI.tileast_ground[airID], x, y, width, height, null);
			// i assume we have a GUI class
		}
	}

}
