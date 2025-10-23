package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    //O tabuleiro já comeca com null
    public Piece(Board board) {
        this.board = board;
    }
    //Apenas classes do mesmo pacote e subclasses vão poder acessar
    protected Board getBoard() {
        return board;
    }


}
