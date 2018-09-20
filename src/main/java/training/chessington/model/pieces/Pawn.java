package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        int allowedColMovement = this.colour == PlayerColour.BLACK ? 1 : -1;
        int allowedFirstColMovement = this.colour == PlayerColour.BLACK ? 2 : -2;

        allowedMoves.add(new Move(from, from.plus(allowedColMovement, 0)));
        if(!hasPawnMoved(from)) allowedMoves.add(new Move(from, from.plus(allowedFirstColMovement, 0)));

        allowedMoves = checkPiecesAreNotInFront(allowedMoves, board);
        return allowedMoves;
    }

    public boolean hasPawnMoved(Coordinates pos)
    {
        int startingRow = this.colour == PlayerColour.BLACK ? 1 : 6;
        return pos.getRow() == startingRow ? false : true;
    }

    public List<Move> checkPiecesAreNotInFront(List<Move> moveList, Board board)
    {
        moveList.removeIf(m -> board.get(m.getTo()) != null);
        return moveList;
    }
}
