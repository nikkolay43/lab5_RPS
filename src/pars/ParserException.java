package pars;

public class ParserException extends Exception {
    private static final long serialVersionUID = 1L;
    private String error_string;  //  Описание ошибки

    public ParserException(String error_string) {
        super();
        this.error_string = error_string;
    }
}