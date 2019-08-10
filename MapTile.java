package grid;

public class MapTile extends Tile{

	/**
	 * Create new MapTile for the design Map
	 * 
	 * @param x		X-coordinate
	 * @param y		Y-coordinate
	 * @param type	Type is set as "Default"
	 */
	public MapTile(int x, int y) {
		super(x, y);
		
    	super.setType(0);
	}
}