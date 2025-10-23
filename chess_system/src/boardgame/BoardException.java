package boardgame;

//Exececao opcional de ser tratada

import java.io.Serial;

public class BoardException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public BoardException(String msg){
        super(msg);
    }

}
