package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece
{
    int allowedColMovement = this.colour == PlayerColour.BLACK ? 1 : -1;
    int allowedFirstColMovement = this.colour == PlayerColour.BLACK ? 2 : -2;
    int startingRow = this.colour == PlayerColour.BLACK ? 1 : 6;

    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();

        allowedMoves = addNewMove(allowedMoves, from, from.plus(allowedColMovement, 0));
        if(!hasPawnMoved(from)) allowedMoves.add(new Move(from, from.plus(allowedFirstColMovement, 0)));

        allowedMoves = checkMoveListValidity(allowedMoves, board);
        return allowedMoves;
    }

    public boolean hasPawnMoved(Coordinates pos)
    {
        return pos.getRow() == startingRow ? false : true;
    }

    public List<Move> addNewMove(List<Move> moveList, Coordinates from, Coordinates to)
    {
        if(!(to.getRow() < 0 || to.getRow() > 7 || to.getCol() < 0 || to.getCol() > 7))
        {
            moveList.add(new Move(from, to));
        }
        return moveList;
    }

    public List<Move> checkMoveListValidity(List<Move> moveList, Board board)
    {
        moveList = checkPiecesAreNotInFront(moveList, board);
        return moveList;
    }

    public List<Move> checkPiecesAreNotInFront(List<Move> moveList, Board board)
    {
        moveList.removeIf(m -> board.get(m.getTo()) != null);
        return moveList;
    }
}
