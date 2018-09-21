package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece {
    public Queen(PlayerColour colour) {
        super(PieceType.QUEEN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();

        Piece rookMoves = new Rook(this.colour);
        Piece bishopMoves = new Bishop(this.colour);

        allowedMoves.addAll(rookMoves.getAllowedMoves(from, board));
        allowedMoves.addAll(bishopMoves.getAllowedMoves(from, board));

        return allowedMoves;
    }
}
