package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess_pieces.King;
import chess_pieces.Pawn;
import chess_pieces.Rook;


//Regras do jogo de xadrez
public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Board board;
    private boolean gameOver = false;


    public ChessMatch(){
        board = new Board(8,8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validadeSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validadeSourcePosition(source);
        validadeTargetPosition(source, target);
        Piece movedPiece = makeMove(source, target); //Faz o movimento

        if (allPawnsMeet()) {
            gameOver = true;
            System.out.println("Todos os peões do jogo se encontraram");
        }

        nextTurn();
        return (ChessPiece)movedPiece;
    }
    public boolean isGameOver() {
        return gameOver;

    }

    private void validadeSourcePosition(Position position){
        if (!board.thereIsAPiece(position)){
            throw new ChessException("Não existe peça na posição de origem");
        }
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
            throw new ChessException("Essa peça não é sua");
        }
        if (!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("Não existe movimento possível para a peça escolhida");
        }
    }

    private void validadeTargetPosition(Position source, Position target){
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("A peça escolhida não pode se mexer para a posição de destino");
        }
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.remocePiece(source);
        board.placePiece(p, target);
        return p;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private boolean allPawnsMeet() {
        int whiteCount = 0;
        int whiteWithEnemyInFront = 0;

        for (int col = 0; col < board.getColumns(); col++) {
            Pawn whitePawn = findPawnInColumn(col, Color.WHITE);
            Pawn blackPawn = findPawnInColumn(col, Color.BLACK);

            if (whitePawn != null) {
                whiteCount++;

                if (blackPawn != null) {
                    int diff = whitePawn.getPosition().getRow() - blackPawn.getPosition().getRow();


                    if (diff == 1) {
                        whiteWithEnemyInFront++;
                    }
                }
            }
        }


        return whiteCount > 0 && whiteCount == whiteWithEnemyInFront;
    }

    private Pawn findPawnInColumn(int col, Color color) {
        for (int row = 0; row < board.getRows(); row++) {
            if (board.piece(row, col) instanceof Pawn) {
                Pawn p = (Pawn) board.piece(row, col);
                if (p.getColor() == color) return p;
            }
        }
        return null;
    }

    //Esse metodo é responsável por iniciar a partida de xadrez
    private void initialSetup() {

        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));

        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));


    }
}
