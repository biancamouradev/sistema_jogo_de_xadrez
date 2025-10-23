package boardgame;

public class Board {

    private int rows;
    private int columns;
    //Matriz de pecas
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }


    //Metodo para retornar uma peca
    public Piece piece(int row, int column){
        if (!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    //Para retornar pela posicao
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumm()];
    }

    //Metodo para colocar uma peca numa dada posicao
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)){
            throw new BoardException("There ir already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumm()] = piece;
        piece.position = position; //A posicao da peca é acessivel diretamente pois esta no mesmo pacote
    }

    //Metodo auxiliar para ve se uma posicao existe
    //Boolean retorna verdadeiro ou falso
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumm());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }


}




























