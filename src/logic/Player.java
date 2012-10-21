package logic;
import model.ReadOnlyBoard;



public interface Player {

	void makeMove(ReadOnlyBoard board, PlayerColor color, MoveListener moveListener);
	// aq boardi maqvs shemidzlia pailshi sheviaxo color anu motamshec makvs da shevinaxavt da ai ve vxvdebi ra mov e airchia eg rogor gavadzrot ? 
	// anu make movit svla rogor amovigo ? 
}