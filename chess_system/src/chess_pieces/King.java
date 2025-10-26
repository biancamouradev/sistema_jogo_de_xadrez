package chess_pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    //Vai falar se o rei pode mover para alguma posição
    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];


        Position p = new Position(0, 0);

        //Acima
        p.setValues(position.getRow() - 1, position.getColumm());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        p.setValues(position.getRow() + 1, position.getColumm());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        //Esquerda
        p.setValues(position.getRow(), position.getColumm() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        p.setValues(position.getRow(), position.getColumm() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        //Diagonais

        // Noroeste
        p.setValues(position.getRow() - 1, position.getColumm() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        // Nordeste
        p.setValues(position.getRow() - 1, position.getColumm() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        // Sudoeste
        p.setValues(position.getRow() + 1, position.getColumm() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        // Sudeste
        p.setValues(position.getRow() + 1, position.getColumm() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        return mat;
    }

}