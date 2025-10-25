package application;


import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import javax.swing.*;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try{
                UI.printBoard(chessMatch.getPieces());

                String sourceInput = JOptionPane.showInputDialog("Qual a posição de origem (Ex: e2):");
                ChessPosition source = new ChessPosition(sourceInput.charAt(0), Integer.parseInt(sourceInput.substring(1)));

                // Lê posição de destino
                String targetInput = JOptionPane.showInputDialog("Qual a posição de destino (Ex: e4):");
                ChessPosition target = new ChessPosition(targetInput.charAt(0), Integer.parseInt(targetInput.substring(1)));

                chessMatch.performChessMove(source, target);

            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

        }

        }
    }
