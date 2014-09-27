package hanto.student_TCA_KLB.common;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;




public class HantoPieceFactory {
	
	private static final HantoPieceFactory instance = new HantoPieceFactory();

	/**
	 * default private constructor
	 */
	private HantoPieceFactory() {
	}
	
	/**
	 * @return the instance
	 */
	public static HantoPieceFactory getInstance()
	{
		return instance;
	}
	
	/**
	 * Factory method that returns the appropriately configured Hanto game.
	 * @param gameId the version desired.
	 * @param movesFirst the player color that moves first
	 * @return the game instance
	 */
	public HantoPiece makeHantoPiece(HantoPieceType pieceId, HantoPlayerColor color) {
		HantoPiece piece = null;
		switch (pieceId) {
		case BUTTERFLY:
			piece = new Butterfly(color);
			break;
		case CRAB:
			break;
		case CRANE:
			break;
		case DOVE:
			break;
		case HORSE:
			break;
		case SPARROW:
			piece = new Sparrow(color);
			break;
		default:
			break;
		}
		return piece;
	}

}
