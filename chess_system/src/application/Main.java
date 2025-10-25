package application;


import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            UI.printBoard(chessMatch.getPieces());

            // Lê posição de origem
            String sourceInput = JOptionPane.showInputDialog("Origem (Ex: e2):");
            ChessPosition source = new ChessPosition(sourceInput.charAt(0), Integer.parseInt(sourceInput.substring(1)));

            // Lê posição de destino
            String targetInput = JOptionPane.showInputDialog("Destino (Ex: e4):");
            ChessPosition target = new ChessPosition(targetInput.charAt(0), Integer.parseInt(targetInput.substring(1)));

            chessMatch.performChessMove(source, target);
        }

        //User interface para imprimir as pecas da partida

        }
    }
