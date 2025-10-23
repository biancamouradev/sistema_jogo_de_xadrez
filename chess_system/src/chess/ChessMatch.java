package chess;

import boardgame.Board;
import boardgame.Position;
import chess_pieces.Rook;

//Regras do jogo de xadrez
public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i< board.getRows(); i++){
            for (int j=0; j< board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
    //Esse metodo é responsável por iniciar a partida de xadrez
    private void initialSetup() {
        placeNewPiece('h', 6, new Rook(board, Color.WHITE));

    }

}
