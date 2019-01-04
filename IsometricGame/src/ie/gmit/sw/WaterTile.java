package ie.gmit.sw;

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
