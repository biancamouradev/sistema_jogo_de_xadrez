package chess_pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {

            p.setValues(position.getRow() - 1, position.getColumm());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumm()] = true;
            }

            p.setValues(position.getRow() - 2, position.getColumm());
            Position p2 = new Position(position.getRow() - 1, position.getColumm());
            if (position.getRow() == 6 && getBoard().positionExists(p)
                    && !getBoard().thereIsAPiece(p)
                    && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getColumm()] = true;
            }

        } else { // PRETO

            p.setValues(position.getRow() + 1, position.getColumm());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumm()] = true;
            }

            p.setValues(position.getRow() + 2, position.getColumm());
            Position p2 = new Position(position.getRow() + 1, position.getColumm());
            if (position.getRow() == 1 && getBoard().positionExists(p)
                    && !getBoard().thereIsAPiece(p)
                    && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getColumm()] = true;
            }


        }

        return mat;

    }
}