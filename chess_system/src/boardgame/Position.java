package boardgame;

public class Position {

    private int row;
    private int columm;

    //Criar construtores para receber os argumentos
    public Position(int row, int columm) {
        this.row = row;
        this.columm = columm;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumm() {
        return columm;
    }

    public void setColumm(int columm) {
        this.columm = columm;
    }

    //Subescreve
    @Override
    //Criar um méttodo que retorna um texto
    public String toString() {
        return row + ", " + columm;

    }



}
