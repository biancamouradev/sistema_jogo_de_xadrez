package boardgame;

public class Board {

    private int rows;
    private int columns;
    //Matriz de pecas
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar o tabuleiro: Deve ter ao menos 1 linha e 1 coluna");
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
            throw new BoardException("Posição não está no tabuleiro");
        }
        return pieces[row][column];
    }

    //Para retornar pela posicao
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumm()];
    }

    //Metodo para colocar uma peca numa dada posicao
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)){
            throw new BoardException("Já existe uma peça nessa posição" + position);
        }
        pieces[position.getRow()][position.getColumm()] = piece;
        piece.position = position;
    }

    public Piece remocePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Posição não existe no tabuleiro");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumm()] = null;
        return aux;
    }


    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumm());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return piece(position) != null;
    }


}




























