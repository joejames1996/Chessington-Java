package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest
{
    @Test
    public void whiteRookCanMove()
    {
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, rook);

        List<Move> moves = rook.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
    }

    @Test
    public void blackRookCanMove()
    {
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, rook);

        List<Move> moves = rook.getAllowedMoves(coords, board);

        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
    }

    @Test
    public void rooksCannotMoveIfFriendlyPieceInFront() {
        Board board = Board.empty();

        Piece firstWhiteRook = new Rook(PlayerColour.WHITE);
        Coordinates firstWhiteCoords = new Coordinates(3, 4);
        board.placePiece(firstWhiteCoords, firstWhiteRook);

        Piece secondWhiteRook = new Rook(PlayerColour.WHITE);
        Coordinates secondWhiteCoords = new Coordinates(4, 4);
        board.placePiece(secondWhiteCoords, secondWhiteRook);

        List<Move> firstWhiteMoves = firstWhiteRook.getAllowedMoves(firstWhiteCoords, board);
        List<Move> secondWhiteMoves = secondWhiteRook.getAllowedMoves(secondWhiteCoords, board);

        assertThat(firstWhiteMoves).doesNotContain(new Move(firstWhiteCoords, secondWhiteCoords.plus(1, 0)));
        assertThat(secondWhiteMoves).doesNotContain(new Move(firstWhiteCoords, secondWhiteCoords.plus(-1, 0)));
    }

    @Test
    public void rooksCannotMoveTwoSquaresIfPieceInFront() {
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(2, 4);
        board.placePiece(blackCoords, blackRook);

        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(4, 4);
        board.placePiece(whiteCoords, whiteRook);

        List<Move> blackMoves = blackRook.getAllowedMoves(blackCoords, board);
        List<Move> whiteMoves = whiteRook.getAllowedMoves(whiteCoords, board);

        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(3, 0)));
        assertThat(whiteMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(-3, 0)));
    }

    @Test
    public void rooksCannotMoveOutsideBoard() {
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, rook);

        List<Move> moves = rook.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(8, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 8)));
    }
}
