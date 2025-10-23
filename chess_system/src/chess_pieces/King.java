package chess_pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    //Sempre usa no toString, esta subescrevendo
    @Override
    public String toString(){
        return "K";
    }
}
