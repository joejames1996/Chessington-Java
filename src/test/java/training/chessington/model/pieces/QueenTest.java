package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class QueenTest
{
    @Test
    public void queenCanMoveStraight()
    {
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, queen);

        List<Move> moves = queen.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
    }

    @Test
    public void queenCanMoveDiagonally()
    {
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(2, 2);
        board.placePiece(coords, queen);

        List<Move> moves = queen.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
    }

    @Test
    public void queenCannotMoveDiagonallyIfFriendlyPieceInFront() {
        Board board = Board.empty();

        Piece firstWhiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates firstWhiteCoords = new Coordinates(4, 4);
        board.placePiece(firstWhiteCoords, firstWhiteQueen);

        Piece secondWhiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates secondWhiteCoords = new Coordinates(5, 5);
        board.placePiece(secondWhiteCoords, secondWhiteQueen);

        List<Move> firstWhiteMoves = firstWhiteQueen.getAllowedMoves(firstWhiteCoords, board);
        List<Move> secondWhiteMoves = secondWhiteQueen.getAllowedMoves(secondWhiteCoords, board);

        assertThat(firstWhiteMoves).doesNotContain(new Move(firstWhiteCoords, secondWhiteCoords.plus(1, 1)));
        assertThat(secondWhiteMoves).doesNotContain(new Move(firstWhiteCoords, secondWhiteCoords.plus(-1, -1)));
    }

    @Test
    public void queenCannotMoveStraightIfFriendlyPieceInFront() {
        Board board = Board.empty();

        Piece firstWhiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates firstWhiteCoords = new Coordinates(3, 4);
        board.placePiece(firstWhiteCoords, firstWhiteQueen);

        Piece secondWhiteQueen = new Queen(PlayerColour.WHITE);
        Coordinates secondWhiteCoords = new Coordinates(4, 4);
        board.placePiece(secondWhiteCoords, secondWhiteQueen);

        List<Move> firstWhiteMoves = firstWhiteQueen.getAllowedMoves(firstWhiteCoords, board);
        List<Move> secondWhiteMoves = secondWhiteQueen.getAllowedMoves(secondWhiteCoords, board);

        assertThat(firstWhiteMoves).doesNotContain(new Move(firstWhiteCoords, secondWhiteCoords.plus(1, 0)));
        assertThat(secondWhiteMoves).doesNotContain(new Move(firstWhiteCoords, secondWhiteCoords.plus(-1, 0)));
    }

    @Test
    public void queenCannotMoveOffBoard()
    {
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, queen);

        List<Move> allowedMoves = queen.getAllowedMoves(coords, board);

        assertThat(allowedMoves).doesNotContain(new Move(coords, coords.plus(0, -1)));
        assertThat(allowedMoves).doesNotContain(new Move(coords, coords.plus(-1, -1)));
        assertThat(allowedMoves).doesNotContain(new Move(coords, coords.plus(-1, 0)));
        assertThat(allowedMoves).doesNotContain(new Move(coords, coords.plus(8, 0)));
        assertThat(allowedMoves).doesNotContain(new Move(coords, coords.plus(8, 8)));
        assertThat(allowedMoves).doesNotContain(new Move(coords, coords.plus(0, 8)));
    }
}
