package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();

        allowedMoves.addAll(addUpLeftMoves(from, board));
        allowedMoves.addAll(addUpRightMoves(from, board));
        allowedMoves.addAll(addDownLeftMoves(from, board));
        allowedMoves.addAll(addDownRightMoves(from, board));

        return allowedMoves;
    }

    public List<Move> addUpLeftMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 0 && currentCol != 0)
        {
            currentRow--; currentCol--;
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

    public List<Move> addUpRightMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 0 && currentCol != 7)
        {
            currentRow--; currentCol++;
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

    public List<Move> addDownLeftMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 7 && currentCol != 0)
        {
            currentRow++; currentCol--;
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

    public List<Move> addDownRightMoves(Coordinates from, Board board)
    {
        List<Move> allowedMoves = new ArrayList<>();
        int currentRow = from.getRow();
        int currentCol = from.getCol();

        while(currentRow != 7 && currentCol != 7)
        {
            currentRow++; currentCol++;
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
