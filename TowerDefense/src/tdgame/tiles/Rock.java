package tdgame.tiles;

import tdgame.gfx.Assets;

public class Rock extends Tile{

	public Rock( int id) {
		super(Assets.stone, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}
