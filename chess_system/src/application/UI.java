package application;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import javax.swing.*;
import java.util.InputMismatchException;

public class UI {

    //Para imprimir no console com cores diferente
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    //Para o usuario digitar a posição
    public static ChessPosition readChessPosition(){
        try {
            String s = JOptionPane.showInputDialog("Digite a posição da peça (Exemplo: e2)");
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        }
        catch (RuntimeException e) {
            //Para caso de erro na entrada de dados
            throw new InputMismatchException("Erro ao ler a posição do xadrez. Valores válidos são de a1 até h8");
        }

    }
    public static void printBoard(ChessPiece[][] pieces) {
        for (int i=0; i<pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j=0; j< pieces.length; j++){
                printPiece(pieces[i][j]);
            }
            //Para fazer a quebra da primeira linha do tabuleiro
            System.out.println();
        }
        System.out.println("  a b c d e f g h");

    }


    private static void printPiece(ChessPiece piece){
        if (piece == null){
            System.out.print("-");
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");

    }

}
