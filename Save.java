import java.io.*;
import java.util.*;

public class Save {
	public void loadSave(File loadPath) {
		try {
			Scanner loadScanner = new Scanner(loadPath);
			
			while(loadScanner.hasNext()) {
				for(int y=0; y<GUI.room.block.length; y++) {
					for(int x=0; x<GUI.room.block.length; x++) {
						GUI.room.block[y][x].groundID = loadScanner.nextInt();
					}
				}
				for(int y=0; y<GUI.room.block.length; y++) {
					for(int x=0; x<GUI.room.block.[0]; x++) {
						GUI.room.block[y][x].airID = loadScanner.nextInt();
					}
					
				}
				
			}
			loadScanner.close();
		}catch(Exception e) {}
		 
	}
	
}
