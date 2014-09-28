/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 * @author tcarmstrong klbrann
 */

package hanto.student_TCA_KLB.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;

/**
 * @author tcarmstrong klbrann
 *
 */
public abstract class AbsHantoGame implements HantoGame {

	// Every hanto game will have a HashMap to represent the Board
	protected Map<HantoCoordinateImpl, HantoPiece> theBoard;

	protected HantoCoordinateImpl home;
	protected int turn;
	protected HantoPlayerColor movesFirst;
	protected HantoPlayerColor currentPlayer;
	protected HantoPieceFactory pieceFactory  = HantoPieceFactory.getInstance();

	/**
	 * @param color
	 *            The color of the player who moves first
	 */
	protected AbsHantoGame(HantoPlayerColor color) {
		theBoard = new HashMap<HantoCoordinateImpl, HantoPiece>();
		turn = 0;
		movesFirst = color;
	}

	/*
	 * (non-Javadoc) <!-- // $codepro.audit.disable codeInComments -->
	 * 
	 * @see hanto.common.HantoGame#getPieceAt(hanto.common.HantoCoordinate)
	 */
	public HantoPiece getPieceAt(HantoCoordinate where) {
		return theBoard.get(new HantoCoordinateImpl(where));
	}

	/*
	 * (non-Javadoc) // $codepro.audit.disable codeInComments
	 * 
	 * @see hanto.common.HantoGame#getPrintableBoard()
	 */
	public String getPrintableBoard() {
		StringBuilder output = new StringBuilder();
		for (Map.Entry<HantoCoordinateImpl, HantoPiece> entry : theBoard
				.entrySet()) {
			output.append(entry.getKey().toString());
			output.append("\t:\t");
			output.append(entry.getValue().toString());
			output.append('\n');
		}

		return output.toString();
	}

	/**
	 * @param c
	 *            The coordinate to check if at the 'home' position
	 * @return returns true if the tested coordinate is 'home' : (0,0)
	 */
	public boolean isHome(HantoCoordinate c) {
		return home.equals(c);
	}

	/**
	 * Determines if there is a piece that is adjacent to the given coordinate
	 * 
	 * @param hc
	 *            The coordinate to check adjacency
	 * @return true if there are pieces touching the given coordinate.
	 */
	public boolean hasAdjacentPiece(final HantoCoordinate hc) {
		boolean foundAdjacentPiece = false;
		for (HantoCoordinate entry : new HantoCoordinateImpl(hc)
				.getAdjacentCoordinates()) {
			if (getPieceAt(entry) != null) {
				foundAdjacentPiece = true;
				break;
			}
		}
		return foundAdjacentPiece;
	}

	@Override
	public MoveResult makeMove(final HantoPieceType pieceType,
			final HantoCoordinate from, final HantoCoordinate to)
			throws HantoException {
		
		determineColor();
		
		validateMove(pieceType, from, to);
		placePiece(pieceType, to);
		MoveResult result = determineMoveResult();
		turn++;
		return result;
	}

	/**
	 * Determines if the coordinate is surrounded by pieces
	 * 
	 * @param hc
	 *            the coordinate to test if there are adjacent pieces
	 * @return True if location is surrounded
	 */
	protected boolean isSurrounded(final HantoCoordinate hc) {
		boolean isSurrounded = true;
		for (HantoCoordinate entry : new HantoCoordinateImpl(hc)
				.getAdjacentCoordinates()) {
			if (getPieceAt(entry) == null) {
				isSurrounded = false;
				break;
			}
		}
		return isSurrounded;
	}

	/**
	 * Determines if the given move is valid
	 * 
	 * @param pieceType
	 *            The Type of Piece to be operated on the board
	 * @param from
	 *            The source destination when moving a piece, null if placing a
	 *            piece
	 * @param to
	 *            The target location to the piece is moving to
	 * @throws HantoException
	 *             Throws exceptions if an invalid move
	 */
	protected abstract void validateMove(final HantoPieceType pieceType,
			final HantoCoordinate from, final HantoCoordinate to)
			throws HantoException;

	/**
	 * Places the piece on the board
	 * 
	 * @param pieceType
	 *            Piecetype to put on the board
	 * @param to
	 *            The location to place the piece on the board
	 * @throws HantoException
	 *             Throws exception if locations are invalid
	 */
	protected void placePiece(final HantoPieceType pieceType,
			final HantoCoordinate to) throws HantoException {
		HantoPiece toPlace = pieceFactory.makeHantoPiece(pieceType, currentPlayer);
		theBoard.put(new HantoCoordinateImpl(to), toPlace);
	}

	/**
	 * @return The result state of the move
	 */
	protected abstract MoveResult determineMoveResult();

	/**
	 * @return the color of the piece to be placed
	 */
	protected void determineColor() {	
		if (turn % 2 == 0) {
			switch (movesFirst) {
			case BLUE:
				currentPlayer = HantoPlayerColor.BLUE;
				break;

			case RED:
				currentPlayer = HantoPlayerColor.RED;
				break;
			}
		} else {
			switch (movesFirst) {
			case BLUE:
				currentPlayer = HantoPlayerColor.RED;
				break;

			case RED:
				currentPlayer = HantoPlayerColor.BLUE;
				break;
			}
		}
	}
	
	private boolean boardIsContinuous() {
		Set<HantoCoordinateImpl> visited = new HashSet<HantoCoordinateImpl> ();
		
		List<HantoCoordinateImpl> fringe = new LinkedList<HantoCoordinateImpl>();
		
		fringe.add( theBoard.keySet().iterator().next() );
		
		while(!fringe.isEmpty()) {
			HantoCoordinateImpl current = fringe.remove(0);
			visited.add(current);
			
			for(HantoCoordinate adjacent : current.getAdjacentCoordinates()) {
				if(getPieceAt(adjacent) != null && !visited.contains(new HantoCoordinateImpl(adjacent))) {
					fringe.add(new HantoCoordinateImpl(adjacent));
				}
			}
		}
		
		return visited.size() == theBoard.size();
	}

}
