package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest
{
    @Test
    public void bishopsCanMoveDiagonally()
    {
        Board board = Board.empty();

        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(2, 2);
        board.placePiece(coords, bishop);

        List<Move> bishopMoves = bishop.getAllowedMoves(coords, board);

        assertThat(bishopMoves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(bishopMoves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(bishopMoves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(bishopMoves).contains(new Move(coords, coords.plus(-1, -1)));
    }

    @Test
    public void bishopsCannotMoveIfFriendlyPieceInFront() {
        Board board = Board.empty();

        Piece firstWhiteBishop = new Bishop(PlayerColour.WHITE);
        Coordinates firstWhiteCoords = new Coordinates(4, 4);
        board.placePiece(firstWhiteCoords, firstWhiteBishop);

        Piece secondWhiteBishop = new Bishop(PlayerColour.WHITE);
        Coordinates secondWhiteCoords = new Coordinates(5, 5);
        board.placePiece(secondWhiteCoords, secondWhiteBishop);

        List<Move> firstWhiteMoves = firstWhiteBishop.getAllowedMoves(firstWhiteCoords, board);
        List<Move> secondWhiteMoves = secondWhiteBishop.getAllowedMoves(secondWhiteCoords, board);

        assertThat(firstWhiteMoves).doesNotContain(new Move(firstWhiteCoords, secondWhiteCoords.plus(1, 1)));
        assertThat(secondWhiteMoves).doesNotContain(new Move(firstWhiteCoords, secondWhiteCoords.plus(-1, -1)));
    }

    @Test
    public void bishopsCannotMoveTwoSquaresIfPieceInFront() {
        Board board = Board.empty();

        Piece blackBishop = new Bishop(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(2, 2);
        board.placePiece(blackCoords, blackBishop);

        Piece whiteBishop= new Bishop(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(3, 3);
        board.placePiece(whiteCoords, whiteBishop);

        List<Move> blackMoves = blackBishop.getAllowedMoves(blackCoords, board);
        List<Move> whiteMoves = whiteBishop.getAllowedMoves(whiteCoords, board);

        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(2, 2)));
        assertThat(whiteMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(-2, -2)));
    }

    @Test
    public void bishopsCannotMoveOutsideBoard() {
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, bishop);

        List<Move> moves = bishop.getAllowedMoves(coords, board);

        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(8, 8)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-8, 8)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(8, -8)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-8, -8)));
    }
}
