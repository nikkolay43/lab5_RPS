package pars;

public class Pars_str_2 extends Exception {
    private static final long serialVersionUID = 1L;
    private String error_string;  //  Описание ошибки

    public Pars_str_2(String error_string) {
        super();
        this.error_string = error_string;
    }
}