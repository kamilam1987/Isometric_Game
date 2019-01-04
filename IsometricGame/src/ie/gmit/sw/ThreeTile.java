package ie.gmit.sw;

public class ThreeTile extends Tile {

	public ThreeTile(int id) {
		super(Assets.three, id);

	}

	// Player is not allowed to walk on the tile
	@Override
	public boolean isSolid() {
		return true;

	}


}
