package ie.gmit.sw.tiles;

import ie.gmit.sw.utils.Assets;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(Assets.water, id);

	}

	// Player is not allowed to walk on the tile
	@Override
	public boolean isSolid() {
		return true;

	}

}
