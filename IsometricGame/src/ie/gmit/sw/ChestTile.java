package ie.gmit.sw;

import java.awt.image.BufferedImage;

public class ChestTile extends Tile{

	public ChestTile(int id) {
		super(Assets.chest, id);
		
	}
	
	// Player is not allowed to walk on the tile
	@Override
	public boolean isSolid() {
		return true;

	}

}
