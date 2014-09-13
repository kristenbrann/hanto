package hanto.studentxxxx.beta;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.studentxxxx.common.AbsHantoGame;
import hanto.studentxxxx.common.Butterfly;
import hanto.studentxxxx.common.HantoCoordinateImpl;
import hanto.studentxxxx.common.Sparrow;

public class BetaHantoGame extends AbsHantoGame {
	
	private int turn;
	private final int maxTurns = 11;
	private HantoCoordinateImpl blueButterfly;
	private HantoCoordinateImpl redButterfly;
	
	public BetaHantoGame() {
		home = new HantoCoordinateImpl(0, 0);
		turn = 0;
	}

	@Override
	public MoveResult makeMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		MoveResult result = MoveResult.OK;
		HantoPlayerColor pc = determineColor();
		
		HantoCoordinateImpl hcTo = new HantoCoordinateImpl(to);

		if (theBoard.isEmpty()) {
			if (isHome(hcTo)) {
				switch (pieceType) {
				case BUTTERFLY:
					theBoard.put(to, new Butterfly(pc));
					switch (pc) {
					case BLUE:
						blueButterfly = hcTo;
						break;
					case RED:
						redButterfly = hcTo;
						break;
					default:
						break;
					}
					
					break;
				case SPARROW:
					theBoard.put(to, new Sparrow(pc));
				default:
					break;
				}
				result = MoveResult.OK;
			} else {
				throw new HantoException("First piece must be placed at "
						+ home.toString() + ".");
			}
		}
		else {
			if(hasAdjacentPiece(hcTo)){
				switch(pieceType) {
				case BUTTERFLY:
					HantoPiece bfly = new Butterfly(pc);
					if(!theBoard.containsValue(bfly)){
						theBoard.put(to, bfly);
						switch (pc) {
						case BLUE:
							blueButterfly = hcTo;
							break;
						case RED:
							redButterfly = hcTo;
							break;
						default:
							break;
						}
					} else {
						throw new HantoException("Player " + pc.name() + " has already placed a butterfly.");
					}
					break;
				case SPARROW:
					if(turn==6||turn==7){
						if(!theBoard.containsValue(new Butterfly(pc))){
							throw new HantoException("Player " + pc.name() + " must place a butterfly by the fourth turn.");
						}
					}
					theBoard.put(to, new Sparrow(pc));
				default:
					break;
				}
			}
			else {
				throw new HantoException("Piece must be placed adjacent to another piece.");
			}
		}
		
		result = resolve();
		turn++;
		return result;
	}
	
	private MoveResult resolve() {
		MoveResult result = MoveResult.OK;
		if(turn==maxTurns){
			result = MoveResult.DRAW;
		}
		else{
			if(redButterfly!=null && isSurrounded(redButterfly)){
				result = MoveResult.BLUE_WINS;
			}
			else if(blueButterfly!=null && isSurrounded(blueButterfly)){
				result = MoveResult.RED_WINS;
			}
		}
		return result;
	}

	
	private boolean isSurrounded(HantoCoordinateImpl hc){
		boolean isSurrounded = true;
		for(HantoCoordinate entry : hc.getAdjacentCoordinates()){
			if(getPieceAt(entry)==null){
				isSurrounded = false;
				break;
			}
		}
		return isSurrounded;
	}
	
	private HantoPlayerColor determineColor() {
		HantoPlayerColor result;
		if(turn % 2 == 0) {
			result = HantoPlayerColor.BLUE;
		} else {
			result = HantoPlayerColor.RED;
		}
		
		return result;
	}

	public boolean hasAdjacentPiece(HantoCoordinateImpl hc){
		boolean foundAdjacentPiece = false;
		for(HantoCoordinate entry : hc.getAdjacentCoordinates()){
			if(getPieceAt(entry)!=null){
				foundAdjacentPiece = true;
				break;
			}
		}
		return foundAdjacentPiece;
	}

}
