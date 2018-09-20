package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece
{
    public Rook(PlayerColour colour)
    {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();

        allowedMoves = addUpwardMoves(allowedMoves, from);
        allowedMoves = addDownwardMoves(allowedMoves, from);
        allowedMoves = addLeftMoves(allowedMoves, from);
        allowedMoves = addRightMoves(allowedMoves, from);

        return allowedMoves;
    }

    public List<Move> addUpwardMoves(List<Move> allowedMoves, Coordinates from)
    {
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 0)
        {
            currentRow--;
            allowedMoves.add(new Move(from, new Coordinates(currentRow, currentCol)));
        }
        return allowedMoves;
    }

    public List<Move> addDownwardMoves(List<Move> allowedMoves, Coordinates from)
    {
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 7)
        {
            currentRow++;
            allowedMoves.add(new Move(from, new Coordinates(currentRow, currentCol)));
        }
        return allowedMoves;
    }

    public List<Move> addLeftMoves(List<Move> allowedMoves, Coordinates from)
    {
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentCol != 0)
        {
            currentCol--;
            allowedMoves.add(new Move(from, new Coordinates(currentRow, currentCol)));
        }
        return allowedMoves;
    }

    public List<Move> addRightMoves(List<Move> allowedMoves, Coordinates from)
    {
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentCol != 7)
        {
            currentCol++;
            allowedMoves.add(new Move(from, new Coordinates(currentRow, currentCol)));
        }
        return allowedMoves;
    }
}
