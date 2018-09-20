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

        allowedMoves.addAll(addUpwardMoves(from));
        allowedMoves.addAll(addDownwardMoves(from));
        allowedMoves.addAll(addLeftMoves(from));
        allowedMoves.addAll(addRightMoves(from));

        return allowedMoves;
    }

    public List<Move> addUpwardMoves(Coordinates from)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 0)
        {
            currentRow--;
            allowedMoves.add(new Move(from, new Coordinates(currentRow, currentCol)));
        }
        return allowedMoves;
    }

    public List<Move> addDownwardMoves(Coordinates from)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 7)
        {
            currentRow++;
            allowedMoves.add(new Move(from, new Coordinates(currentRow, currentCol)));
        }
        return allowedMoves;
    }

    public List<Move> addLeftMoves(Coordinates from)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentCol != 0)
        {
            currentCol--;
            allowedMoves.add(new Move(from, new Coordinates(currentRow, currentCol)));
        }
        return allowedMoves;
    }

    public List<Move> addRightMoves(Coordinates from)
    {
        List<Move> allowedMoves = new ArrayList<>();
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
