package application;


import chess.ChessMatch;

public class Main {
    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();
        //User interface para imprimir as pecas da partida
        UI.printBoard(chessMatch.getPieces());

        }
    }
