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

        allowedMoves.addAll(addUpwardMoves(from, board));
        allowedMoves.addAll(addDownwardMoves(from, board));
        allowedMoves.addAll(addLeftMoves(from, board));
        allowedMoves.addAll(addRightMoves(from, board));

        return allowedMoves;
    }

    public List<Move> addUpwardMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 0)
        {
            currentRow--;
            Coordinates coordinates = new Coordinates(currentRow, currentCol);
            if(board.get(coordinates) != null)
            {
                if(board.get(coordinates).getColour() != this.colour)
                    allowedMoves.add(new Move(from, coordinates));
                break;
            }
            allowedMoves.add(new Move(from, coordinates));
        }
        return allowedMoves;
    }

    public List<Move> addDownwardMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 7)
        {
            currentRow++;
            Coordinates coordinates = new Coordinates(currentRow, currentCol);
            if(board.get(coordinates) != null)
            {
                if(board.get(coordinates).getColour() != this.colour)
                    allowedMoves.add(new Move(from, coordinates));
                break;
            }
            allowedMoves.add(new Move(from, coordinates));
        }
        return allowedMoves;
    }

    public List<Move> addLeftMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentCol != 0)
        {
            currentCol--;
            Coordinates coordinates = new Coordinates(currentRow, currentCol);
            if(board.get(coordinates) != null)
            {
                if(board.get(coordinates).getColour() != this.colour)
                    allowedMoves.add(new Move(from, coordinates));
                break;
            }
            allowedMoves.add(new Move(from, coordinates));
        }
        return allowedMoves;
    }

    public List<Move> addRightMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentCol != 7)
        {
            currentCol++;
            Coordinates coordinates = new Coordinates(currentRow, currentCol);
            if(board.get(coordinates) != null)
            {
                if(board.get(coordinates).getColour() != this.colour)
                    allowedMoves.add(new Move(from, coordinates));
                break;
            }
            allowedMoves.add(new Move(from, coordinates));
        }
        return allowedMoves;
    }
}
