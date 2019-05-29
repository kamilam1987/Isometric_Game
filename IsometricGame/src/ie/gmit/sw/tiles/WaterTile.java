package ie.gmit.sw.tiles;

import ie.gmit.sw.utils.Assets;

/**
 * Returns water tile image and number id for water tile.
 * CHecks if the tile is walkable
 * @author Kamila
 *
 */
public class WaterTile extends Tile {

	/**
	 * @param id for water tile
	 */
	public WaterTile(int id) {
		super(Assets.water, id);

	}

	@Override
	public boolean isSolid() {
		return true;

	}

}
